package android.damir.stipancic.com.newsreaderv2.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticleApiClient {

    public static final String BASE_URL = "https://newsapi.org/v1/";

    public static Retrofit sRetrofit = null;

    public static final String API_KEY = "6946d0c07a1c4555a4186bfcade76398";
    public static final String SOURCE = "bbc-news";
    public static final String SORT_BY = "top";

    public static Retrofit getClient(){
        if(sRetrofit==null){
            sRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return sRetrofit;
    }
}
