package com.ultimateqa.courses.testsuite;

import com.ultimateqa.courses.pages.HomePage;
import com.ultimateqa.courses.pages.SignInPage;
import com.ultimateqa.courses.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    HomePage homePage=new HomePage();
    SignInPage signInPage=new SignInPage();
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnLoginBtn();
        String actualText=homePage.verifyWelcomeText();
        String expectedText="Welcome Back!";
        Assert.assertEquals(actualText,expectedText,"Welcome Message Validation");
    }
    @Test
    public void verifyTheErrorMessage() {
        homePage.clickOnLoginBtn();
        signInPage.enterUserName("123@hgmail.com");
        signInPage.enterPassword("12345");
        signInPage.clickOnSIgnBtn();
        String actualText=signInPage.verifyErrorMessage();
        String expectedText="Invalid email or password.";
        Assert.assertEquals(actualText,expectedText,"Invalid error msg not displayed");
    }


}
