package org.test.selenium.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends AbstractPageObject {
    @FindBy(xpath = "//div[@id='navbarExample']//a[@class='nav-link']")
    private List<WebElement> headerLinkLink;

    public void goByHeaderLink(String pageName) {
        headerLinkLink.stream()
                .filter(webElement -> webElement.getText().contains(pageName))
                .findFirst()
                .get()
                .click();
    }
}
