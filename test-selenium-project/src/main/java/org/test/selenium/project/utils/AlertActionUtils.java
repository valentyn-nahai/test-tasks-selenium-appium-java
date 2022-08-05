package org.test.selenium.project.utils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.selenium.project.driver.DriverManager;

import java.time.Duration;

public class AlertActionUtils {
    public static void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        DriverManager.getDriver().switchTo().alert().accept();
    }
}
