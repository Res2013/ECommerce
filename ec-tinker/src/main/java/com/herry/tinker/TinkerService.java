package com.herry.tinker;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import java.io.File;

/**
 * @author Herry
 */
public class TinkerService extends Service {

    private static final String SUFFIX = ".apk";
    private static final int DOWNLOAD_PATCH = 0x01;
    private static final int UPDATE_PATCH = 0x02;

    private String mPatchDir;
    private String mPatchPath;
    private Object mBasePatchcInfo;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_PATCH:
                    checkPatchInfo();
                    break;
                case DOWNLOAD_PATCH:
                    downloadPatch();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandler.sendEmptyMessage(UPDATE_PATCH);
        return START_NOT_STICKY;
    }

    private void init() {
        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        File patchFileDir = new File(mPatchDir);
        try {
            if (patchFileDir == null || !patchFileDir.exists()) {
                patchFileDir.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
            stopSelf();
        }
    }

    private void checkPatchInfo() {
        // if success
        if (true) {
            mHandler.sendEmptyMessage(DOWNLOAD_PATCH);
        } else {
            stopSelf();
        }
    }

    private void downloadPatch() {
        // if success
        if (true) {
            TinkerManager.loadPatch(mPatchPath);
        } else {
            stopSelf();
        }
    }
}
