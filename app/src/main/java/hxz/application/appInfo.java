package hxz.application;

import android.graphics.drawable.Drawable;

/**
 * Created by hxz on 2017-08-16.
 */

public class appInfo {

    private String appName;
    private Drawable appIcon;
    private long lastUpdateTime;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


}
