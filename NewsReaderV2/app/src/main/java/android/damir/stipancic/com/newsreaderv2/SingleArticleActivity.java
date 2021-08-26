package android.damir.stipancic.com.newsreaderv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.damir.stipancic.com.newsreaderv2.contract.Contract;
import android.damir.stipancic.com.newsreaderv2.presenter.MainActivityPresenter;
import android.damir.stipancic.com.newsreaderv2.presenter.SingleArticleActivityPresenter;
import android.damir.stipancic.com.newsreaderv2.view.SingleArticleRecyclerAdapter;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

public class SingleArticleActivity extends AppCompatActivity implements Contract.View.SingleArticleActivityView{

    private Contract.SingleArticleActivityPresenter mPresenter;
    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_article);

        Intent intent = getIntent();
        mPosition = intent.getIntExtra("position", 0);
        mPresenter = new SingleArticleActivityPresenter(this);
        setDataToViewPager();
        setupToolbar();
    }

    @Override
    public void setDataToViewPager() {
        Log.d("TAG", "setDataToViewPager: ");
        ViewPager2 singleArticleViewPager2 = findViewById(R.id.singleArticleViewPager);
        singleArticleViewPager2.setAdapter(new SingleArticleRecyclerAdapter(mPresenter, this));
        Log.d("TAG", "AFTER_ADAPTER: ");
        singleArticleViewPager2.setCurrentItem(mPosition);
        singleArticleViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(getSupportActionBar() != null)
                    getSupportActionBar().setTitle(mPresenter.getArticleTitle(position));
            }
        });

    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.singleArticleToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(view -> SingleArticleActivity.super.onBackPressed());
        if(getSupportActionBar() != null)
            getSupportActionBar().setTitle(mPresenter.getArticleTitle(mPosition));
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
    }
}