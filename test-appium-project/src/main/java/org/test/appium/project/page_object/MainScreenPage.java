package org.test.appium.project.page_object;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.test.appium.project.locators.AndroidLocators;
import org.test.appium.project.locators.IOSLocators;

import java.time.temporal.ChronoUnit;

public class MainScreenPage {

    @AndroidFindBy(id = AndroidLocators.BILL_AMOUNT)
    @iOSXCUITFindBy(xpath = IOSLocators.BILL_AMOUNT)
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    MobileElement billAmount;

    @AndroidFindBy(id = AndroidLocators.CALCULATE_TIP)
    @iOSXCUITFindBy(xpath = IOSLocators.CALCULATE_TIP)
    MobileElement calculateTip;

    @AndroidFindBy(id = AndroidLocators.TIP_AMOUNT)
    @iOSXCUITFindBy(xpath = IOSLocators.TIP_AMOUNT)
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    MobileElement tipAmount;

    @AndroidFindBy(id = AndroidLocators.TOTAL_AMOUNT)
    @iOSXCUITFindBy(xpath = IOSLocators.TOTAL_AMOUNT)
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    MobileElement totalAmount;

    public MainScreenPage(AppiumDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step
    public void fillBillAmount(String amount) {
        billAmount.sendKeys(amount);
    }

    @Step
    public void clickCalculateTip() {
        calculateTip.click();
    }

    @Step
    public String getTipAmount() {
        return tipAmount.getText();
    }

    @Step
    public String getTotalAmount() {
        return totalAmount.getText();
    }

}
