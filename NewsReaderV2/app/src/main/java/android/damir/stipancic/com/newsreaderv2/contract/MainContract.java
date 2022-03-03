package android.damir.stipancic.com.newsreaderv2.contract;

import android.damir.stipancic.com.newsreaderv2.data.model.Article;
import android.damir.stipancic.com.newsreaderv2.presenter.BasePresenter;
import android.damir.stipancic.com.newsreaderv2.view.ArticleViewHolder;
import android.damir.stipancic.com.newsreaderv2.view.BaseView;

import java.util.List;

public interface MainContract {
    interface Presenter extends BasePresenter{

        interface OnFinishedListener{
            void onFinished(List<Article> articles);
            void onFailure(Throwable t);
        }

        void onViewCreated();
        void fetchDataFromServer();
        void insertDataToDB();
        int getNewsCount();
        void onBindNewsData(ArticleViewHolder holder);
    }

    interface View extends BaseView<Presenter>{
        void setRecyclerData();

        interface itemView{
            void setTitle(String title);
            void setImage(String imageUrl);
        }
    }
}
