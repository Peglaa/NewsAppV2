package android.damir.stipancic.com.newsreaderv2.presenter;

import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.data.model.Article;
import android.damir.stipancic.com.newsreaderv2.data.model.ArticleListModel;
import android.damir.stipancic.com.newsreaderv2.view.ArticleViewHolder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter implements Contract.Presenter.MainActivityPresenter, Contract.Model.OnFinishedListener{

    private Contract.View.MainActivityView mMainActivityView;
    private final ArticleListModel mArticleListModel;
    private final List<Article> mArticleList; //List used by RecyclerView

    public MainActivityPresenter(Contract.View.MainActivityView mainView) {
        this.mMainActivityView = mainView;
        this.mArticleListModel = new ArticleListModel();
        this.mArticleList = new ArrayList<>();
    }

    @Override
    public void requestDataFromServer() {
        if(mMainActivityView != null)
            mMainActivityView.showProgress();

        if(mArticleListModel.isDBEmpty() || mArticleListModel.isDataOlderThan5Min()) {
            Log.d("TAG", "FROM_SERVER: ");
            mArticleListModel.getArticleList(this);
        }

        else {
            Log.d("TAG", "FROM_DB: ");
            mArticleList.clear();
            mArticleList.addAll(mArticleListModel.getDataFromDB());
            mMainActivityView.setDataToRecyclerView();
            if(mMainActivityView != null)
                mMainActivityView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        mMainActivityView = null;
    }

    @Override
    public void onBindArticleData(ArticleViewHolder holder, int position) {
        //RecyclerView item data binding
        Article article = mArticleList.get(position);
        holder.setTitle(article.getTitle());
        holder.setImage(article.getImageUrl());
    }

    @Override
    public int getArticleCount() {
        return mArticleList.size();
    }

    @Override
    public void onFinished(List<Article> articles) {
        mArticleListModel.insertDataToDB(articles);
        if(mArticleList.isEmpty()){
            mArticleList.addAll(articles);
            mMainActivityView.setDataToRecyclerView();
        }
        else {
            mArticleList.clear();
            mArticleList.addAll(articles);
            mMainActivityView.updateRecyclerData();
        }

        if(mMainActivityView != null)
            mMainActivityView.hideProgress();
    }

    @Override
    public void onFailure(Throwable t) {
        mMainActivityView.onResponseFailure(t);

        if(!mArticleListModel.isDBEmpty()) {
            mArticleList.clear();
            mArticleList.addAll(mArticleListModel.getDataFromDB());
            mMainActivityView.setDataToRecyclerView();
        }

        if(mMainActivityView != null)
            mMainActivityView.hideProgress();
    }
}
