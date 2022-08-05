package org.test.task.selenium;

import org.test.task.selenium.pages.CartPage;
import org.test.task.selenium.pages.HeaderPage;
import org.test.task.selenium.pages.ProductPage;
import org.test.task.selenium.pages.ProductStorePage;
import org.testng.annotations.Test;

import static org.test.task.selenium.utils.AlertActionUtils.acceptAlert;


public class BlazemeterDemoProductSiteTest extends BaseWebTest {

    @Test(description = "Add a product to the cart")
    public void addProductToTheCart() {
        ProductStorePage productStorePage = new ProductStorePage();
        ProductPage productPage = new ProductPage();
        HeaderPage headerPage = new HeaderPage();
        CartPage cartPage = new CartPage();

        productStorePage.clickOnProductCardByName("HTC One M9");
        productPage.clickOnAddToCartButton();

        acceptAlert();

        headerPage.goByHeaderLink("Home");

        productStorePage.clickOnProductCardByName("Samsung galaxy s6");
        productPage.clickOnAddToCartButton();
        acceptAlert();

        headerPage.goByHeaderLink("Cart");

        System.out.printf("Total price: %s", cartPage.getTotalPriceHeader());

        cartPage.deleteProductByName("HTC One M9");
        cartPage.deleteProductByName("Samsung galaxy s6");
    }
}
