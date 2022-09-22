package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends TestBase  {

	
	// Web Element Xpath 
    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actTimeLogo;

    @FindBy(xpath = "//td[@class='configsTableRowCell']")
    WebElement reportBlocks;

    @FindBy(xpath = "//div[@id='ext-gen128']")
    WebElement createButton;

    @FindBy(xpath = "//div[@id='createChartLightbox_commitBtn']")
    WebElement exportButton;

    @FindBy(xpath = "//div[@id='createChartLightbox_downloadPdfBtn']")
    WebElement downloadButton;

    @FindBy(xpath = "//div[@class='pdfPreviewPage']")
    WebElement printPreview;


	// Call init

    public ReportsPage() {
        PageFactory.initElements(driver, this);
    }
	
	// Method
    public Boolean validateActiTimeLogo() {
        return actTimeLogo.isDisplayed();
    }

    public Boolean validateExistingTasks(){
        return reportBlocks.isDisplayed();
    }

    public Boolean downloadReport(){
        createButton.click();
        exportButton.click();
        if(printPreview.isDisplayed() && downloadButton.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }
	
}
