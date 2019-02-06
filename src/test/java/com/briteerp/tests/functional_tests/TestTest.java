package com.briteerp.tests.functional_tests;

import com.briteerp.pages.LogInPage;
import com.briteerp.tests.TestBase;
import org.testng.annotations.Test;

public class TestTest extends TestBase {

    @Test
    public void positiveLoginTest() {
        LogInPage logInPage = new LogInPage();
        logInPage.managerLogIn();
    }
    // Erpan's shit
    // yashars shit

    @Test
    public void positiveLoginTest1() {
        LogInPage logInPage = new LogInPage();
        logInPage.userLogIn();
    }
}
