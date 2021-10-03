package android.damir.stipancic.com.newsreaderv2.presenter;

import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.data.model.Article;
import android.damir.stipancic.com.newsreaderv2.data.model.ArticleListModel;
import android.damir.stipancic.com.newsreaderv2.view.SingleArticleViewHolder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SingleArticleActivityPresenter implements Contract.Presenter.SingleArticleActivityPresenter {

    private final ArticleListModel mArticleListModel;
    private final List<Article> mArticleList; //List used by RecyclerView

    public SingleArticleActivityPresenter() {
        this.mArticleListModel = new ArticleListModel();
        this.mArticleList = new ArrayList<>();
        mArticleList.addAll(mArticleListModel.getDataFromDB());
    }

    @Override
    public void onBindSingleArticleData(SingleArticleViewHolder holder, int position) {
        //RecyclerView item data binding
        Log.d("TAG", "onBindSingleArticleData: " + mArticleList);
        Article article = mArticleList.get(position);
        holder.setTitle(article.getTitle());
        holder.setDescription(article.getDescription());
        holder.setLink("Read more: " + article.getSourceUrl());
        holder.setImage(article.getImageUrl());
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
