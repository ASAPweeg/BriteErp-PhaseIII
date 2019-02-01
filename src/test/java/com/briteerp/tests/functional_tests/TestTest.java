package com.briteerp.tests.functional_tests;

import com.briteerp.pages.HomeAndSignInPage;
import com.briteerp.tests.TestBase;
import org.testng.annotations.Test;

public class TestTest extends TestBase {

    @Test
    public void positiveLoginTest() {
        HomeAndSignInPage homeAndSignInPage = new HomeAndSignInPage();
        homeAndSignInPage.managerLogIn();
    }

    @Test
    public void positiveLoginTest1() {
        HomeAndSignInPage homeAndSignInPage = new HomeAndSignInPage();
        homeAndSignInPage.userLogIn();
    }
}
