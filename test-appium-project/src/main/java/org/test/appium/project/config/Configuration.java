package org.test.appium.project.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "classpath:conf/general.properties",
    "classpath:conf/android.properties",
    "classpath:conf/ios.properties"})
public interface Configuration extends Config {

    @Key("install.app")
    Boolean installApp();

    @Key("run.ip")
    String serverIp();

    @Key("run.port")
    String serverPort();

    @Key("app.ios.path")
    String iosAppPath();

    @Key("app.ios.appName")
    String iosAppName();

    @Key("app.android.path")
    String androidAppPath();

    @Key("app.android.appPackage")
    String androidAppPackage();

    @Key("app.android.appActivity")
    String androidAppActivity();
}
