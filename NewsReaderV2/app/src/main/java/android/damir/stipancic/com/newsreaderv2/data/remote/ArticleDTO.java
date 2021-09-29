package android.damir.stipancic.com.newsreaderv2.data.remote;

import android.damir.stipancic.com.newsreaderv2.data.model.Article;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class ArticleDTO {

    @SerializedName("author")
    private String mAuthor;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("publishedAt")
    private String mPublishedAt;

    @SerializedName("url")
    private String mSourceUrl;

    @SerializedName("urlToImage")
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
