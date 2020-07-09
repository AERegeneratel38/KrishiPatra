

package com.aelcorporation.krishipatra;

import android.app.Application;

import com.aelcorporation.krishipatra.util.PreferenceHelper;

public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();

    private static AppController mInstance;

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        // The following line triggers the initialization of ACRA for crash Log Reposrting
        if (PreferenceHelper.getPrefernceHelperInstace().getBoolean(
                this, PreferenceHelper.SUBMIT_LOGS, true)) {
        }
    }

}