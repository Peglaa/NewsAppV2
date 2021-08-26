package android.damir.stipancic.com.newsreaderv2.presenter;

import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.model.Article;
import android.damir.stipancic.com.newsreaderv2.model.ArticleListModel;
import android.damir.stipancic.com.newsreaderv2.view.ArticleViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter implements Contract.Presenter.MainActivityPresenter, Contract.Model.OnFinishedListener{

    private Contract.View.MainActivityView mMainActivityView;
    private final Contract.Model mArticleListModel;
    private final List<Article> mArticleList;

    public MainActivityPresenter(Contract.View.MainActivityView mainView) {
        this.mMainActivityView = mainView;
        this.mArticleListModel = new ArticleListModel();
        this.mArticleList = new ArrayList<>();
    }

    @Override
    public void requestDataFromServer() {
        if(mMainActivityView != null)
            mMainActivityView.showProgress();

        mArticleListModel.getArticleList(this);
    }

    @Override
    public void onDestroy() {
        mMainActivityView = null;
    }

    @Override
    public void onBindArticleData(ArticleViewHolder holder, int position) {
        Article article = mArticleList.get(position);
        holder.setTitle(article.getTitle());
        holder.setImage(article.getImageUrl(), article);
    }

    @Override
    public int getArticleCount() {
        return mArticleList.size();
    }

    @Override
    public void onFinished(List<Article> articles) {
        mArticleListModel.insertDataToDB(articles);
        mArticleList.clear();
        mArticleList.addAll(articles);
        mMainActivityView.setDataToRecyclerView();

        if(mMainActivityView != null)
            mMainActivityView.hideProgress();
    }

    @Override
    public void onFailure(Throwable t) {
        mMainActivityView.onResponseFailure(t);

        mArticleList.clear();
        mArticleList.addAll(mArticleListModel.getDataFromDB());
        mMainActivityView.setDataToRecyclerView();

        if(mMainActivityView != null)
            mMainActivityView.hideProgress();
    }
}
