package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

public class TimeTrackPage extends TestBase {


    //Page Factory - Object Repository

    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actitimeLogo;

    @FindBy(xpath = "//*[contains(text(),'View Time-Track')]")
    WebElement viewTimeTrackButton;

    @FindBy(xpath = "//td[@class='viewTimeTrackTitle pagetitle']")
    WebElement viewTimeTrackText;

    @FindBy(xpath = "//div[@class='workingTime dl']")
    WebElement workingTimeText;

    @FindBy(xpath = "//div[@class='leaveTime dl']")
    WebElement leaveTimeText;

    @FindBy(xpath = "//*[contains(text(),'Approve Time-Track')]")
    WebElement approveTimeTrackButton;

    @FindBy(xpath = "//td[@class='pagetitle']")
    WebElement approvePageTitle;

    @FindBy(xpath = "//tr[@class='childRow notReady']/td[@class='selectionCell']/input")
    WebElement approveCheckBox;

    @FindBy(xpath = "//span[@id='approveButton']")
    WebElement approveButton;

    @FindBy(xpath = "//tr[@class='childRow operationWasApplied approved']/td[@class='statusCell']/span")
    WebElement statusText;


    //initialization

    public TimeTrackPage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods

    public Boolean validateActiTimeLogo() {
        return actitimeLogo.isDisplayed();
    }

    public Boolean gotoViewTimeTrack() {
        viewTimeTrackButton.click();
        return viewTimeTrackText.isDisplayed();
    }

    public Boolean validateEmployeeLeaveAndAttendance(){
        viewTimeTrackButton.click();
        return (workingTimeText.isDisplayed() && leaveTimeText.isDisplayed());
    }

    public Boolean validateApproveTimeTrackPage(){
        approveTimeTrackButton.click();
        return approvePageTitle.isDisplayed();
    }

    public Boolean validateApproveProcess(){
        approveTimeTrackButton.click();
        approveCheckBox.click();
        approveButton.click();
        System.out.println("Status Text: " + statusText.getText());
        return statusText.getText() == "Approved";
    }





}
