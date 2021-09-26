package android.damir.stipancic.com.newsreaderv2.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.damir.stipancic.com.newsreaderv2.R;
import android.view.LayoutInflater;

public class LoadingDialog {

    final Activity mActivity;
    AlertDialog mAlertDialog;

    public LoadingDialog(Activity activity){
        this.mActivity = activity;
    }

    public void startLoadAnimation(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);

        LayoutInflater inflater = mActivity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_loading_screen, null));
        builder.setCancelable(false);

        mAlertDialog = builder.create();
        mAlertDialog.show();

    }

    public void stopLoadAnimation(){
        mAlertDialog.dismiss();
    }
}
