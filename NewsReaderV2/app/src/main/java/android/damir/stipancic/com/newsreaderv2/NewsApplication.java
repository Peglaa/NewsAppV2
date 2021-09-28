package android.damir.stipancic.com.newsreaderv2;

import android.app.Application;

import io.realm.Realm;

public class NewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // JUST A SIMPLE CLASS THAT INITIALIZES REALM(THIS WAY WE MAKE SURE ITS ONLY INITIALIZED ONCE, ON APP START)
        Realm.init(this);
    }
}
