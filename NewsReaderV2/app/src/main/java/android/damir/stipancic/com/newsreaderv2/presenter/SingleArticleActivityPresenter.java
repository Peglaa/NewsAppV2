package android.damir.stipancic.com.newsreaderv2.presenter;

import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.model.Article;
import android.damir.stipancic.com.newsreaderv2.model.ArticleListModel;
import android.damir.stipancic.com.newsreaderv2.view.SingleArticleViewHolder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SingleArticleActivityPresenter implements Contract.Presenter.SingleArticleActivityPresenter {

    private final Contract.Model mArticleListModel;
    private final List<Article> mArticleList;

    public SingleArticleActivityPresenter() {
        this.mArticleListModel = new ArticleListModel();
        this.mArticleList = new ArrayList<>();
        mArticleList.addAll(mArticleListModel.getDataFromDB());
    }

    @Override
    public void onBindSingleArticleData(SingleArticleViewHolder holder, int position) {
        Log.d("TAG", "onBindSingleArticleData: " + mArticleList);
        Article article = mArticleList.get(position);
        holder.setTitle(article.getTitle());
        holder.setDescription(article.getDescription() + "\n Read more: " + article.getSourceUrl());
        holder.setImage(article.getImageUrl(), article);
    }

    @Override
    public int getArticleCount() {
        return mArticleList.size();
    }

    @Override
    public String getArticleTitle(int position) {
        return mArticleList.get(position).getTitle();
    }
}
