package android.damir.stipancic.com.newsreaderv2.data.remote;

import android.damir.stipancic.com.newsreaderv2.data.remote.ArticleListDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticleApiInterface {

    @GET("articles")
    Call<ArticleListDTO> getTopArticles(@Query("source") String source, @Query("sortBy") String sort, @Query("apiKey") String apiKey);
}
