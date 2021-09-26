package android.damir.stipancic.com.newsreaderv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.presenter.MainActivityPresenter;
import android.damir.stipancic.com.newsreaderv2.view.ArticleRecyclerAdapter;
import android.damir.stipancic.com.newsreaderv2.view.ErrorDialog;
import android.damir.stipancic.com.newsreaderv2.view.LoadingDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Contract.View.MainActivityView {

    private MainActivityPresenter mPresenter;
    private RecyclerView mArticleRecycler;
    private ArticleRecyclerAdapter mRecyclerAdapter;
    private LoadingDialog mLoadingScreen;
    private ArticleRecyclerAdapter.OnArticleClick mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingScreen = new LoadingDialog(MainActivity.this);
        mPresenter = new MainActivityPresenter(this);
        setOnClickListener();
        setupToolbar();
        setupRecycler();
        mPresenter.requestDataFromServer();
    }

    private void setOnClickListener() {
        mListener = (v, position) -> {
            Log.d("TAG", "setOnClickListener: ");
            Intent intent = new Intent(v.getContext(), SingleArticleActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        };
    }

    private void setupRecycler() {

        mArticleRecycler = findViewById(R.id.rvMainArticles);
        mArticleRecycler.setLayoutManager(new LinearLayoutManager(this));
        mArticleRecycler.setHasFixedSize(true);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.mainActivityToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    public void showProgress() {
        mLoadingScreen.startLoadAnimation();
    }

    @Override
    public void hideProgress() {
        mLoadingScreen.stopLoadAnimation();
    }

    @Override
    public void setDataToRecyclerView() {
        if(mRecyclerAdapter==null) {
            mRecyclerAdapter = new ArticleRecyclerAdapter(mPresenter, this, mListener);
            mArticleRecycler.setAdapter(mRecyclerAdapter);
        }
        else
            mRecyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public void onResponseFailure(Throwable t) {
        ErrorDialog errorDialog = new ErrorDialog();
        errorDialog.show(getSupportFragmentManager(), "ERROR_DIALOG");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}