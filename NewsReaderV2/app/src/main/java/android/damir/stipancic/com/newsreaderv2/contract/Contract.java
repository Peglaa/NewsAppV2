package android.damir.stipancic.com.newsreaderv2.contract;

import android.damir.stipancic.com.newsreaderv2.model.Article;
import android.damir.stipancic.com.newsreaderv2.view.ArticleViewHolder;
import android.damir.stipancic.com.newsreaderv2.view.SingleArticleViewHolder;

import java.util.List;

public interface Contract {

    interface Model{

        interface OnFinishedListener {

            void onFinished(List<Article> articles);
            void onFailure(Throwable t);
        }

        void getArticleList(OnFinishedListener onFinishedListener);
        void insertDataToDB(List<Article> articles);
        List<Article> getDataFromDB();
        boolean isDataOlderThan5Min();
        boolean isDBEmpty();
    }

    interface Presenter {

        interface MainActivityPresenter {

            void requestDataFromServer();
            int getArticleCount();
            void onDestroy();
            void onBindArticleData(ArticleViewHolder holder, int position);
        }

        interface SingleArticleActivityPresenter {

            void onBindSingleArticleData(SingleArticleViewHolder holder, int position);
            int getArticleCount();
            String getArticleTitle(int position);
        }
    }

    interface View{

        interface MainActivityView{

            void showProgress();
            void hideProgress();
            void setDataToRecyclerView();
            void onResponseFailure(Throwable t);
            void updateRecyclerData();

            interface itemView{

                void setTitle(String title);
                void setImage(String imageUrl, Article article);
            }
        }

        interface SingleArticleActivityView{

            void setDataToViewPager();

            interface singleItemView{

                void setTitle(String title);
                void setImage(String imageUrl, Article article);
                void setDescription(String description);
                void setLink(String link);
            }
        }

    }
}
