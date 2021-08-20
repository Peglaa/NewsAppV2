package android.damir.stipancic.com.newsreaderv2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Article {

    @SerializedName("author")
    @Expose
    private final String mAuthor;

    @SerializedName("title")
    @Expose
    private final String mTitle;

    @SerializedName("description")
    @Expose
    private final String mDescription;

    @SerializedName("publishedAt")
    @Expose
    private final String mPublishedAt;

    @SerializedName("url")
    @Expose
    @PrimaryKey
    private final String mSourceUrl;

    @SerializedName("urlToImage")
    @Expose
    private final String mImageUrl;

    private final long mAge;

    public Article(String author, String title, String sourceUrl, String imageUrl, String desc, String publishedAt){
        this.mAuthor = author;
        this.mTitle = title;
        this.mSourceUrl = sourceUrl;
        this.mImageUrl = imageUrl;
        this.mDescription = desc;
        this.mPublishedAt = publishedAt;
        this.mAge = System.currentTimeMillis();
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getPublishedAt() {
        return mPublishedAt;
    }

    public String getSourceUrl() {
        return mSourceUrl;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public long getAge(){
        return mAge;
    }
}
