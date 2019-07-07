package com.herry.tinker;

import android.content.Context;

import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

/**
 * @author Herry
 */
public class TinkerManager {

    /**
     * 是否已经安装
     */
    private static boolean sIsInstalled = false;

    /**
     * 委托类
     */
    private static ApplicationLike sAppLike;
    private static CustomPatchListener sPatchListener;

    /**
     * 完成Tinker初始化
     *
     * @param appLike 委托对象
     */
    public static void installTinker(ApplicationLike appLike) {
        sAppLike = appLike;
        if (!sIsInstalled) {
            sPatchListener = new CustomPatchListener(getApplicationContext());
            LoadReporter loadReporter = new DefaultLoadReporter(getApplicationContext());
            PatchReporter patchReporter = new DefaultPatchReporter(getApplicationContext());
            AbstractPatch upgradePatchProcessor = new UpgradePatch();
            // init tinker
            TinkerInstaller.install(sAppLike,
                    loadReporter,
                    patchReporter,
                    sPatchListener,
                    CustomResultService.class,
                    upgradePatchProcessor);
            sIsInstalled = true;
        }
    }

    /**
     * 加载补丁
     *
     * @param patchPath 补丁路径
     */
    public static void loadPatch(String patchPath) {
        if (Tinker.isTinkerInstalled()) {
            TinkerInstaller.onReceiveUpgradePatch(
                    getApplicationContext(), patchPath);
        }
    }

    private static Context getApplicationContext() {
        if (sAppLike != null) {
            return sAppLike.getApplication().getApplicationContext();
        }
        return null;
    }
}

