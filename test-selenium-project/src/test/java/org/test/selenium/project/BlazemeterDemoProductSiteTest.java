package org.test.selenium.project;

import org.test.selenium.project.pages.CartPage;
import org.test.selenium.project.pages.HeaderPage;
import org.test.selenium.project.pages.ProductPage;
import org.test.selenium.project.pages.ProductStorePage;
import org.testng.annotations.Test;

import static org.test.selenium.project.utils.AlertActionUtils.acceptAlert;


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
