package android.damir.stipancic.com.newsreaderv2.data.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Article extends RealmObject {

    @PrimaryKey
    private UUID mId;

    private String mTitle;

    private String mDescription;

    private String mSourceUrl;

    private String mImageUrl;

    private long mAge;

    public Article(UUID id, String title, String description, String sourceUrl, String imageUrl){
        this.mId = id;
        this.mTitle = title;
        this.mDescription = description;
        this.mSourceUrl = sourceUrl;
        this.mImageUrl = imageUrl;
        this.mAge = System.currentTimeMillis();
    }

    public Article(){}

    public long getAge(){return this.mAge;}
    public String getTitle(){return this.mTitle;}
    public String getDescription(){return this.mDescription;}
    public String getSourceUrl(){return this.mSourceUrl;}
    public String getImageUrl(){return this.mImageUrl;}
}
