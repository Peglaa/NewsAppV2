package android.damir.stipancic.com.newsreaderv2.data.model;

import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.data.remote.ArticleDTO;
import android.damir.stipancic.com.newsreaderv2.data.remote.ArticleListDTO;
import android.damir.stipancic.com.newsreaderv2.data.remote.ArticleApiClient;
import android.damir.stipancic.com.newsreaderv2.data.remote.ArticleApiInterface;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListModel implements Contract.Model{

    private final String TAG = "ArticleListModel";
    private Realm mRealm;
    final RealmConfiguration config = new RealmConfiguration
            .Builder()
            .deleteRealmIfMigrationNeeded()
            .build();

    @Override
    public void getArticleList(OnFinishedListener onFinishedListener) {

        ArticleApiInterface apiService = ArticleApiClient.getClient().create(ArticleApiInterface.class);

        Call<ArticleListDTO> articleListResponse = apiService.getTopArticles(ArticleApiClient.SOURCE, ArticleApiClient.SORT_BY, ArticleApiClient.API_KEY);

        articleListResponse.enqueue(new Callback<ArticleListDTO>() {
            @Override
            public void onResponse(@NonNull Call<ArticleListDTO> call, @NonNull Response<ArticleListDTO> response) {
                if(!response.isSuccessful()){
                    onFinishedListener.onFailure(new Throwable());
                    return;
                }

                if (response.body() != null) {
                    List<ArticleDTO> articleDTOs = response.body().getArticles();
                    List<Article> articles = new ArrayList<>();
                    for(ArticleDTO DTO : articleDTOs)
                        articles.add(DTO.toArticle());


                    onFinishedListener.onFinished(articles);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArticleListDTO> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

                onFinishedListener.onFailure(t);
            }
        });
    }

    @Override
    public void insertDataToDB(List<Article> articles) {
        Realm mRealm = Realm.getInstance(config);
        mRealm.beginTransaction();
        if(!mRealm.isEmpty()) mRealm.deleteAll();
        for(Article article : articles)
            mRealm.insert(article);
        mRealm.commitTransaction();
    }

    @Override
    public List<Article> getDataFromDB() {
        Realm mRealm = Realm.getInstance(config);
        return mRealm.where(Article.class).findAll();
    }

    @Override
    public boolean isDataOlderThan5Min(){
        mRealm = Realm.getInstance(config);
        mRealm.beginTransaction();
        long age = mRealm.where(Article.class).findFirst().getAge();
        mRealm.commitTransaction();
        long currentTime = System.currentTimeMillis();

        return (currentTime - age) > 300000;
    }

    public boolean isDBEmpty(){
        mRealm = Realm.getInstance(config);
        return mRealm.isEmpty();
    }
}
