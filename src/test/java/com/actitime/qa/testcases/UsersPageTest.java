package com.actitime.qa.testcases;

import com.actitime.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.util.TestUtil;


public class UsersPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;
    String sheetName = "Users";
    TestUtil testUtil;

    public UsersPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        homePage.clickOnUsersLink();
        usersPage = new UsersPage();
    }

    @Test(priority = 1)
    public void usersPageLogoTest() {
        boolean flag= usersPage.validateActiTimeLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void usersPageUserListTest() {
        boolean flag= usersPage.validateAllUsers();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void usersPageAddUserTest() {
        boolean flag= usersPage.addUserTest();
        Assert.assertTrue(flag);
    }

}
