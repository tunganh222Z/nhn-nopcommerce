package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.*;

public class Level_08_Switch_Page extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private OrderPageObject orderPage;
    private RewardPointPageObject rewardPointPage;
    private AddressPageObject addressPage;
    private SiteMapPageObject siteMapPage;
    private ShoppingCartPageObject shoppingCartPage;
    private SearchPageObject searchPage;
    private WishlistPageObject wishlistPage;
    private String emailAddress = getEmailRandom();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
    }

    @Test
    public void User_02_Login_Success() {
        homePage = registerPage.clickToLogoutLink();

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox("123456");

        homePage = loginPage.clickLoginButton();

        customerPage = homePage.clickToMyAccountLink();
        
        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "John");
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Kennedy");
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);
    }

    @Test
    public void User_03_Switch_Page() {
//        // Customer Page -> Address Page
//        addressPage = customerPage.openAddressPage(driver);
//
//        // Address Page -> Order Page
//        orderPage = addressPage.openOrderPage(driver);
//
//        // Order Page -> Customer Page
//        customerPage = orderPage.openCustomerPage(driver);
//
//        // Customer Page -> Order Page
//        orderPage = customerPage.openOrderPage(driver);
//
//        // Order Page -> Address Page
//        addressPage = orderPage.openAddressPage(driver);
//
//        // Address Page -> Reward Point Page
//        rewardPointPage = addressPage.openRewardPointPage(driver);
//
//        // Reward Point Page -> Customer Page
//        customerPage = rewardPointPage.openCustomerPage(driver);
//
//        // Customer Page -> Reward Point Page
//        rewardPointPage = customerPage.openRewardPointPage(driver);

//        // Gọi sai business như 2 page này sẽ ko báo lỗi ngay trong lúc code, báo lỗi lúc chạy
//        loginPage.openAddressPage();
//        registerPage.openCustomerPage();
    }

    @Test
    public void User_04_Switch_Page_Exercise() {
//        // Reward Point Page -> Site Map Page
//        siteMapPage = rewardPointPage.openSiteMapPage(driver);
//
//        // Site Map Page -> Shopping Cart Page
//        shoppingCartPage = siteMapPage.openShoppingCartPage(driver);
//
//        // Shopping Cart Page -> Search Page
//        searchPage = shoppingCartPage.openSearchPage(driver);
//
//        // Search Page -> Wishlist Page
//        wishlistPage = searchPage.openWishlistPage(driver);
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
