package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends TestBase {

    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actTimeLogo;

    @FindBy(xpath = "//tr[@class='taskRow']")
    WebElement tasksList;

    @FindBy(xpath = "//div[contains(@class, 'allCustomersNode')]")
    WebElement leftMenu;

    @FindBy(xpath = "//div[@class='selection']")
    WebElement taskCheckBox;

    @FindBy(xpath = "//div[contains(@class, 'edit_task_sliding_panel')]")
    WebElement editPanel;

    @FindBy(xpath = "//div[@class='copyTo']")
    WebElement copyButton;

    public TasksPage() {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateActiTimeLogo() {
        return actTimeLogo.isDisplayed();
    }

    public Boolean validateExistingTasks(){
        return tasksList.isDisplayed();
    }

    public Boolean validateLeftMenu(){
        return leftMenu.isDisplayed();
    }

    public Boolean validateTaskFunctionality(){
        tasksList.click();
        //Return TRUE if the edit panel appears once the task row is clicked
        return editPanel.isDisplayed();
    }


}
