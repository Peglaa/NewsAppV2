package android.damir.stipancic.com.newsreaderv2.view;

import android.content.Context;
import android.damir.stipancic.com.newsreaderv2.R;
import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SingleArticleRecyclerAdapter extends RecyclerView.Adapter<SingleArticleViewHolder>{

    private final Contract.Presenter.SingleArticleActivityPresenter mPresenter;
    private final Context mContext;

    public SingleArticleRecyclerAdapter(Contract.Presenter.SingleArticleActivityPresenter presenter, Context context){
        this.mPresenter = presenter;
        this.mContext = context;
    }

    @NonNull
    @Override
    public SingleArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_article_recycler_item, parent, false);
        return new SingleArticleViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleArticleViewHolder holder, int position) {
        mPresenter.onBindSingleArticleData(holder, position);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getArticleCount();
    }
}
