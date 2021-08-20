package android.damir.stipancic.com.newsreaderv2.contract;

import android.damir.stipancic.com.newsreaderv2.model.Article;

import java.util.List;

public interface Contract {

    interface Model{
        interface OnFinishedListener{
            void onFinished();
            void onFailure(Throwable t);
        }

        void getArticleList(OnFinishedListener onFinishedListener);
    }

    interface Presenter{
        void requestDataFromServer();
    }

    interface View{
        void showProgress();
        void hideProgress();
        void setDataToRecyclerViewFromServer(List<Article> articleList);
        void onResponseFailure(Throwable t);
    }
}
