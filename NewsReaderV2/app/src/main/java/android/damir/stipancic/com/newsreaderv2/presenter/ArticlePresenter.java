package android.damir.stipancic.com.newsreaderv2.presenter;

import android.content.Context;
import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.model.Article;
import android.damir.stipancic.com.newsreaderv2.model.ArticleListModel;
import android.damir.stipancic.com.newsreaderv2.view.ArticleViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ArticlePresenter implements Contract.Presenter, Contract.Model.OnFinishedListener{

    private Contract.View mArticleListView;
    private Contract.Model mArticleListModel;
    private List<Article> mArticleList;

    public ArticlePresenter(Contract.View view) {
        this.mArticleListView = view;
        this.mArticleListModel = new ArticleListModel();
        this.mArticleList = new ArrayList<>();
    }

    @Override
    public void requestDataFromServer() {
        if(mArticleListView != null)
            mArticleListView.showProgress();

        mArticleListModel.getArticleList(this);
    }

    @Override
    public void onDestroy() {
        mArticleListView = null;
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
        mArticleList.clear();
        mArticleList.addAll(articles);
        mArticleListView.setDataToRecyclerView();

        if(mArticleListView != null)
            mArticleListView.hideProgress();
    }

    @Override
    public void onFailure(Throwable t) {
        mArticleListView.onResponseFailure(t);

        if(mArticleListView != null)
            mArticleListView.hideProgress();
    }
}
