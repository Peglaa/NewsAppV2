package android.damir.stipancic.com.newsreaderv2.view;

import android.content.Context;
import android.damir.stipancic.com.newsreaderv2.R;
import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class SingleArticleViewHolder extends RecyclerView.ViewHolder implements Contract.View.SingleArticleActivityView.singleItemView {

    private final TextView mArticleTitle, mArticleDescription, mArticleLink;
    private final ImageView mArticleImage;
    private final Context mContext;

    public SingleArticleViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        this.mContext = context;
        mArticleTitle = itemView.findViewById(R.id.tvSingleTitle);
        mArticleDescription = itemView.findViewById(R.id.tvSingleDescription);
        mArticleLink = itemView.findViewById(R.id.tvSingleLink);
        mArticleImage = itemView.findViewById(R.id.ivSingleArticle);
    }

    @Override
    public void setTitle(String title) {
        mArticleTitle.setText(title);
    }

    @Override
    public void setImage(String url) {
        //Should I be doing this from here?
        Picasso.with(mContext)
                .load(url)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(mArticleImage, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        //Try again online if cache failed
                        Picasso.with(mContext)
                                .load(url)
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

    @Override
    public void setDescription(String description) {
        mArticleDescription.setText(description);
    }

    @Override
    public void setLink(String link) {
        mArticleLink.setText(link);
    }
}
