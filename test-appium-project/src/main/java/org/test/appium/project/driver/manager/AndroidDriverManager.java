package org.test.appium.project.driver.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.test.appium.project.config.Configuration;
import org.test.appium.project.config.ConfigurationManager;
import org.test.appium.project.driver.IDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AndroidDriverManager implements IDriver {

    private static final Logger logger = LogManager.getLogger(AndroidDriverManager.class);
    private AppiumDriver<MobileElement> driver;

    @Override
    public AppiumDriver<MobileElement> createInstance(String udid, String platformVersion) {
        try {
            Configuration configuration = ConfigurationManager.getConfiguration();
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(UDID, udid);
            capabilities.setCapability(PLATFORM_VERSION, platformVersion);

            capabilities.setCapability(DEVICE_NAME, "Android Emulator");
            capabilities.setCapability(PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

            if (Boolean.TRUE.equals(configuration.installApp())) {
                capabilities.setCapability(APP, new File(configuration.androidAppPath()).getAbsolutePath());
            } else {
                capabilities
                    .setCapability(AndroidMobileCapabilityType.APP_PACKAGE, configuration.androidAppPackage());
                capabilities
                    .setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, configuration.androidAppActivity());
            }

            driver = new AndroidDriver<>(new URL(gridUrl()), capabilities);
        } catch (MalformedURLException e) {
            logger.error("Failed to initiate the tests for the Android device", e);
        }

        return driver;
    }
}
