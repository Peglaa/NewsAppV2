package android.damir.stipancic.com.newsreaderv2.view;

import android.content.Context;
import android.damir.stipancic.com.newsreaderv2.R;
import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.model.Article;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class ArticleViewHolder extends RecyclerView.ViewHolder implements Contract.View.itemView{

    private final TextView mArticleTitle;
    private final ImageView mArticleImage;
    private final Context mContext;

    public ArticleViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        this.mContext = context;
        mArticleTitle = itemView.findViewById(R.id.tvArticleTitle);
        mArticleImage = itemView.findViewById(R.id.ivArticleImage);
    }

    @Override
    public void setTitle(String title) {
        mArticleTitle.setText(title);
    }

    @Override
    public void setImage(String url, Article article) {
        Picasso.with(mContext)
                .load(article.getImageUrl())
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(mArticleImage, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        //Try again online if cache failed
                        Picasso.with(mContext)
                                .load(article.getImageUrl())
                                .into(mArticleImage, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError() {
                                        Log.v("Picasso","Could not fetch image");
                                    }
                                });
                    }
                });
    }
}
