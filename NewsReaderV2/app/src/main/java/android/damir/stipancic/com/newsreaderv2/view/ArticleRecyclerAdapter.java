package android.damir.stipancic.com.newsreaderv2.view;

import android.content.Context;
import android.damir.stipancic.com.newsreaderv2.R;
import android.damir.stipancic.com.newsreaderv2.presenter.MainActivityPresenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleRecyclerAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private final MainActivityPresenter mPresenter;
    private final Context mContext;
    private OnArticleClick mListener;

    public ArticleRecyclerAdapter(MainActivityPresenter presenter, Context context, OnArticleClick listener) {
        this.mPresenter = presenter;
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_recycler_item, parent, false);
        return new ArticleViewHolder(view, mContext, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        mPresenter.onBindArticleData(holder, position);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getArticleCount();
    }

    public interface OnArticleClick{
        void onClick(View v, int position);
    }
}
