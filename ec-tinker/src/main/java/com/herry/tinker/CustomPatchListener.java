package com.herry.tinker;

import android.content.Context;

import com.tencent.tinker.lib.listener.DefaultPatchListener;

/**
 * @author Herry
 *
 */
public class CustomPatchListener extends DefaultPatchListener {

    public CustomPatchListener(Context context) {
        super(context);
    }

    @Override
    protected int patchCheck(String path, String patchMd5) {
        return super.patchCheck(path, patchMd5);
    }

    @Override
    public int onPatchReceived(String path) {
        return super.onPatchReceived(path);
    }
}
