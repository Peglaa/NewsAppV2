package android.damir.stipancic.com.newsreaderv2.network;

import android.damir.stipancic.com.newsreaderv2.model.ArticleApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticleApiInterface {

    @GET("articles")
    Call<ArticleApiResponse> getTopArticles(@Query("source") String source, @Query("sortBy") String sort, @Query("apiKey") String apiKey);
}
