package android.damir.stipancic.com.newsreaderv2.data.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleListDTO {

    @SerializedName("status")
    @Expose
    private String mStatus;
    @SerializedName("source")
    @Expose
    private String mSource;
    @SerializedName("sortBy")
    @Expose
    private String mSortBy;
    @SerializedName("articles")
    @Expose
    private List<ArticleDTO> mArticles;

    public List<ArticleDTO> getArticles() {
        return mArticles;
    }

    public ArticleListDTO(){}
}
