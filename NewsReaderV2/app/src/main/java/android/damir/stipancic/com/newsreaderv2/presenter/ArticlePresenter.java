package android.damir.stipancic.com.newsreaderv2.presenter;

import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.model.Article;

import java.util.List;

public class ArticlePresenter implements Contract.Presenter, Contract.Model.OnFinishedListener{

    private Contract.View mArticleListView;
    private Contract.Model mArticleListModel;

    public ArticlePresenter(Contract.View view, Contract.Model model) {
        this.mArticleListView = view;
        this.mArticleListModel = model;
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
    public void onFinished(List<Article> articles) {
        mArticleListView.setDataToRecyclerViewFromServer(articles);

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
