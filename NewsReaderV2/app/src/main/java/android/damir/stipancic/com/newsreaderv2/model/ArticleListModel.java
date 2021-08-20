package android.damir.stipancic.com.newsreaderv2.model;

import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.network.ArticleApiClient;
import android.damir.stipancic.com.newsreaderv2.network.ArticleApiInterface;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListModel implements Contract.Model{

    private final String TAG = "ArticleListModel";

    @Override
    public void getArticleList(OnFinishedListener onFinishedListener) {

        ArticleApiInterface apiService = ArticleApiClient.getClient().create(ArticleApiInterface.class);

        Call<ArticleApiResponse> articleListResponse = apiService.getTopArticles(ArticleApiClient.SOURCE, ArticleApiClient.SORT_BY, ArticleApiClient.API_KEY);

        articleListResponse.enqueue(new Callback<ArticleApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<ArticleApiResponse> call, @NonNull Response<ArticleApiResponse> response) {
                if(!response.isSuccessful()){
                    onFinishedListener.onFailure(new Throwable());
                    return;
                }

                if (response.body() != null) {
                    List<Article> articles = response.body().getArticles();

                    onFinishedListener.onFinished(articles);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArticleApiResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

                onFinishedListener.onFailure(t);
            }
        });
    }
}
