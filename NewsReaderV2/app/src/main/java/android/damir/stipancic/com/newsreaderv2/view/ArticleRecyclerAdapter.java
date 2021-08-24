package android.damir.stipancic.com.newsreaderv2.view;

import android.content.Context;
import android.damir.stipancic.com.newsreaderv2.R;
import android.damir.stipancic.com.newsreaderv2.presenter.ArticlePresenter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleRecyclerAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private final ArticlePresenter presenter;
    private final Context mContext;

    public ArticleRecyclerAdapter(ArticlePresenter presenter, Context context) {
        this.presenter = presenter;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.article_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        presenter.onBindArticleData(holder, position, mContext);
    }

    @Override
    public int getItemCount() {
        return presenter.getArticleCount();
    }
}
