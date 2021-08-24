package android.damir.stipancic.com.newsreaderv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.model.Article;
import android.damir.stipancic.com.newsreaderv2.presenter.ArticlePresenter;
import android.damir.stipancic.com.newsreaderv2.view.ArticleRecyclerAdapter;
import android.graphics.Color;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private ArticlePresenter presenter;
    private RecyclerView mArticleRecycler;
    private ArticleRecyclerAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter  = new ArticlePresenter(this);
        setupToolbar();
        setupRecycler();
        presenter.requestDataFromServer();
    }

    private void setupRecycler() {

        mArticleRecycler = findViewById(R.id.rvMainArticles);
        mArticleRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.mainActivityToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToRecyclerView() {
        mRecyclerAdapter = new ArticleRecyclerAdapter(presenter, this);
        mArticleRecycler.setAdapter(mRecyclerAdapter);
    }

    @Override
    public void onResponseFailure(Throwable t) {

    }
}