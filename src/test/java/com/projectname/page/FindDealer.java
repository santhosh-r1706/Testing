package com.projectname.page;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class FindDealer extends BasePage {

    private static final String PageObjectRepoFileName = "FindDealer.xml";
    WebDriver driver;

    public FindDealer(WebDriver driver) {
        super(driver, PageObjectRepoFileName);
        this.driver=driver;
    }

    @Step("Find A Dealer by passing zipcode")
    public void findADealer() {
        seleniumUtils.waitForThePageLoad();
        seleniumUtils.click("shoppingTools");
        seleniumUtils.click("findADealer");
        seleniumUtils.enterText("searchByZip","75035");
        seleniumUtils.click("submitButton");
    }

    @Step("Dealer Details Page")
    public void dealerDetailsPage() {
        seleniumUtils.click("dealerDetails");
        seleniumUtils.verifyText("textDetails","Longo Toyota of Prosper");
    }

    @Step("Dealer Details Website")
    public void dealerDetailsSite() {
        seleniumUtils.click("dealerWebsite");
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        checkDealerWebsite();
    }

    @Description("Check dealer's using own site")
    public void checkDealerWebsite() {
        if(driver.getTitle().contains("Longo Toyota of Prosper"))
            System.out.println("Dealer using own site");
    }

}
