package org.test.appium.project.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.test.appium.project.config.Configuration;
import org.test.appium.project.config.ConfigurationManager;

public interface IDriver {

    AppiumDriver<MobileElement> createInstance(String udid, String platformVersion);

    default String gridUrl() {
        Configuration configuration = ConfigurationManager.getConfiguration();
        return String.format("http://%s:%s/wd/hub", configuration.serverIp(), configuration.serverPort());
    }
}
