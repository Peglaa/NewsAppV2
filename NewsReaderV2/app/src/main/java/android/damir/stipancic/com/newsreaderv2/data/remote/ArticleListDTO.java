package android.damir.stipancic.com.newsreaderv2.data.remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

//Data Transfer Object class that only holds raw api data

public class ArticleListDTO {

    @SerializedName("status")
    private String mStatus;
    @SerializedName("source")
    private String mSource;
    @SerializedName("sortBy")
    private String mSortBy;
    @SerializedName("articles")
    private List<ArticleDTO> mArticles;

    public List<ArticleDTO> getArticles() {
        return mArticles;
    }
}
