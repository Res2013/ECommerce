package com.herry.business.data;

import android.support.annotation.NonNull;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class HomeRepository implements HomeDataSource {

    private static volatile HomeRepository INSTANCE;

    private final HomeDataSource mHomeRemoteDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    Map<String, Object> mCachedDatas;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    private HomeRepository(@NonNull HomeDataSource homeRemoteDataSource) {
        mHomeRemoteDataSource = checkNotNull(homeRemoteDataSource);
    }

    public static HomeRepository getInstance(HomeDataSource homeRemoteDataSource) {
        // Double Check Lock
        if (INSTANCE == null) {
            synchronized (HomeRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HomeRepository(homeRemoteDataSource);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getData() {

    }

    @Override
    public void setData(List dataList) {

    }
}
