package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class UsersPage extends TestBase  {

    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actTimeLogo;

    @FindBy(xpath = "//table[@class='userNameContainer']")
    WebElement userRow;

    @FindBy(xpath = "//div[@class='components_button withPlusIcon']")
    WebElement addUserButton;

    @FindBy(xpath = "//input[@id='createUserPanel_firstNameField']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInput;

    @FindBy(xpath = "//div[@class='components_button_label']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='invitationInfoHeader']")
    WebElement successMessage;

    @FindBy(xpath = "//div[@id='editUserPanel']")
    WebElement userProfile;

    @FindBy(xpath = "//a[@class='content tt']")
    WebElement timeTrackLink;

    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateActiTimeLogo() {
        return actTimeLogo.isDisplayed();
    }

    public Boolean validateAllUsers(){
        return userRow.isDisplayed();
    }

    public Boolean validateIndividualProfile(){
        userRow.click();
        return userProfile.isDisplayed();

    }

    //TODO: Overlay preventing interaction with the input boxes
    public Boolean addUserTest(){
        addUserButton.click();
        firstNameInput.click();
        firstNameInput.sendKeys("Nandula");
        lastNameInput.sendKeys("Perera");
        emailInput.sendKeys("nandula@gmail.com");
        submitButton.click();
        return (successMessage.getText() == "Account for Nandula Perera has been created.");
    }

    public TimeTrackPage clickOnTimeTrackLink() {
        timeTrackLink.click();
        return new TimeTrackPage();
    }

}
