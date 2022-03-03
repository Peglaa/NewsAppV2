package android.damir.stipancic.com.newsreaderv2.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticleApiClient {

    public static final String BASE_URL = "https://newsapi.org/v1/";

    public static Retrofit sRetrofit = null;

    public static final String API_KEY = "390b39b88a9c4ea5a7e410de97866b61";
    public static final String SOURCE = "bbc-news";
    public static final String SORT_BY = "top";

    public static Retrofit getClient(){
        if(sRetrofit==null){
            sRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return sRetrofit;
    }
}
