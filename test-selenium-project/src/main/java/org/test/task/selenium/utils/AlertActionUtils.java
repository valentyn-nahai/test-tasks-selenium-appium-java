package org.test.task.selenium.utils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.task.selenium.driver.DriverManager;

import java.time.Duration;

public class AlertActionUtils {
    public static void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());
        DriverManager.getDriver().switchTo().alert().accept();
    }
}
