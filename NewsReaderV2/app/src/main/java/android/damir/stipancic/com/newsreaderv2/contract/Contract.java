package android.damir.stipancic.com.newsreaderv2.contract;

import android.content.Context;
import android.damir.stipancic.com.newsreaderv2.model.Article;
import android.damir.stipancic.com.newsreaderv2.view.ArticleViewHolder;

import java.util.List;

public interface Contract {

    interface Model{
        interface OnFinishedListener{
            void onFinished(List<Article> articles);
            void onFailure(Throwable t);
        }

        void getArticleList(OnFinishedListener onFinishedListener);
    }

    interface Presenter{
        void requestDataFromServer();
        void onDestroy();
        void onBindArticleData(ArticleViewHolder holder, int position);
        int getArticleCount();
    }

    interface View{
        void showProgress();
        void hideProgress();
        void setDataToRecyclerView();
        void onResponseFailure(Throwable t);

        interface itemView{
            void setTitle(String title);
            void setImage(String imageUrl, Article article);
        }
    }
}
