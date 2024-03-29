package com.freenow.android_demo.dependencies.module;

import android.content.Context;

import com.freenow.android_demo.utils.storage.SharedPrefStorage;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefStorageModule {

    private Context mContext;

    public SharedPrefStorageModule(Context context) {
        mContext = context;
    }

    @Provides
    public SharedPrefStorage provideSharedPrefStorage() {
        return new SharedPrefStorage(mContext);
    }

}
