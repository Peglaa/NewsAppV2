package android.damir.stipancic.com.newsreaderv2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Article extends RealmObject {

    @PrimaryKey
    private UUID mId = UUID.randomUUID();

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

    private long mAge  = System.currentTimeMillis();

    public Article(){

    }

    public Article(String author, String title, String sourceUrl, String imageUrl, String desc, String publishedAt){
        this.mId = UUID.randomUUID();
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
