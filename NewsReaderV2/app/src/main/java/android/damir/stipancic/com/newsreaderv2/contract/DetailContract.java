package android.damir.stipancic.com.newsreaderv2.contract;

import android.damir.stipancic.com.newsreaderv2.data.model.Article;
import android.damir.stipancic.com.newsreaderv2.presenter.BasePresenter;
import android.damir.stipancic.com.newsreaderv2.view.BaseView;
import android.damir.stipancic.com.newsreaderv2.view.SingleArticleViewHolder;

import java.util.List;

public interface DetailContract {
    interface Presenter extends BasePresenter{

        interface OnFinishedListener {

            void onFinished(List<Article> articles);
            void onFailure(Throwable t);
        }

        void onBindDetailData(SingleArticleViewHolder holder, int position);
        int getNewsCount();
        String getNewsTitle(int position);
    }

    interface View extends BaseView<Presenter>{

    }
}
