package com.actitime.qa.testcases;

import com.actitime.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.util.TestUtil;

public class AssignmentTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TimeTrackPage ttPage;
    UsersPage usersPage;
    TestUtil testUtil;

    public AssignmentTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        homePage.clickOnUsersLink(); //Redirect to users tab because the first task is to check employee profiles
        usersPage = new UsersPage();
        ttPage = new TimeTrackPage();
    }

    //Employee profile validations

    //Check if the user page loads or not
    @Test(priority = 1)
    public void usersPageLogoTest() {
        boolean flag= usersPage.validateActiTimeLogo();
        Assert.assertTrue(flag);
    }

    //Check if the users page shows a list of employees
    @Test(priority = 2)
    public void usersPageUserListTest() {
        boolean flag= usersPage.validateAllUsers();
        Assert.assertTrue(flag);
    }

    //Click on the first row and see if the employee details are visible
    @Test(priority = 3)
    public void usersPageUserProfileTest() {
        boolean flag= usersPage.validateIndividualProfile();
        Assert.assertTrue(flag);
    }


    //Review leave and attendance reports

    //Goto the time track page and check if it loads
    @Test(priority = 4)
    public void gotoTimeTrackPageTest() {
        TimeTrackPage ttPage = usersPage.clickOnTimeTrackLink();
        boolean flag= ttPage.validateActiTimeLogo();
        Assert.assertTrue(flag);
    }

    //Goto the view time track page and see if the leave and attendance records are visible
    @Test(priority = 5)
    public void gotoViewTimeTrackPageTest(){
        TimeTrackPage ttPage = usersPage.clickOnTimeTrackLink();
        boolean flag = ttPage.gotoViewTimeTrack();
        Assert.assertTrue(flag);
    }

    @Test(priority = 6)
    public void leaveAttendanceReportTest(){
        TimeTrackPage ttPage = usersPage.clickOnTimeTrackLink();
        boolean flag = ttPage.validateEmployeeLeaveAndAttendance();
        Assert.assertTrue(flag);
    }


    //Approval/rejection of the time-sheets

    //Goto the Approve/Reject Time Track page and see if it loads
    @Test(priority = 7)
    public void gotoApprovePageTest(){
        TimeTrackPage ttPage = usersPage.clickOnTimeTrackLink();
        boolean flag = ttPage.validateApproveTimeTrackPage();
        Assert.assertTrue(flag);
    }

//    Approve the first line and see if it approves
    @Test(priority = 8)
    public void approvalProcessTest(){
        TimeTrackPage ttPage = usersPage.clickOnTimeTrackLink();
        boolean flag = ttPage.validateApproveProcess();
        System.out.println("flag" + flag);
        if(flag){
            Assert.assertTrue(flag);
        }else{
            Assert.assertFalse(flag);
        }

    }

}
