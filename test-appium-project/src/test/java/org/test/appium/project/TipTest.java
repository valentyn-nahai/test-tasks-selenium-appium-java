package org.test.appium.project;

import org.test.appium.project.page_object.MainScreenPage;
import org.test.appium.project.test.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TipTest extends BaseTest {

    @Test
    public void testCalculateDefaultTip() {
        MainScreenPage mainScreen = new MainScreenPage(driver);

        mainScreen.fillBillAmount("100");
        mainScreen.clickCalculateTip();

        assertThat(mainScreen.getTipAmount()).isEqualTo("$15.00");
        assertThat(mainScreen.getTotalAmount()).isEqualTo("$115.00");
    }

}
