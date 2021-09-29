package android.damir.stipancic.com.newsreaderv2.data.remote;

import android.damir.stipancic.com.newsreaderv2.data.model.Article;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class ArticleDTO {

    @SerializedName("author")
    @Expose
    private String mAuthor;

    @SerializedName("title")
    @Expose
    private String mTitle;

    @SerializedName("description")
    @Expose
    private String mDescription;

    @SerializedName("publishedAt")
    @Expose
    private String mPublishedAt;

    @SerializedName("url")
    @Expose
    private String mSourceUrl;

    @SerializedName("urlToImage")
    @Expose
    private String mImageUrl;

    public Article toArticle(){
        return new Article(
                UUID.randomUUID(),
                this.mTitle,
                this.mDescription,
                this.mSourceUrl,
                this.mImageUrl
        );
    }
}
