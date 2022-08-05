package org.test.appium.project.driver.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
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

public class IOSDriverManager implements IDriver {

    private static final Logger logger = LogManager.getLogger(IOSDriverManager.class);
    private AppiumDriver<MobileElement> driver;

    @Override
    public AppiumDriver<MobileElement> createInstance(String udid, String platformVersion) {
        try {
            Configuration configuration = ConfigurationManager.getConfiguration();
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(UDID, udid);
            capabilities.setCapability(PLATFORM_VERSION, platformVersion);
            capabilities.setCapability(DEVICE_NAME, "iPhone Simulator");
            capabilities.setCapability(PLATFORM_NAME, MobilePlatform.IOS);
            capabilities.setCapability(AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);

            if (Boolean.TRUE.equals(configuration.installApp())) {
                capabilities.setCapability(APP, new File(configuration.iosAppPath()).getAbsolutePath());
            } else {
                capabilities.setCapability(IOSMobileCapabilityType.APP_NAME, configuration.iosAppName());
            }

            driver = new IOSDriver<>(new URL(gridUrl()), capabilities);
        } catch (MalformedURLException e) {
            logger.error("Failed to initiate the tests for the IOS device", e);
        }

        return driver;
    }
}
