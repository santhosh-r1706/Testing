package com.projectname.test;

import com.projectname.basetest.BaseTestWebMethodContext;
import com.projectname.page.FindDealer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Epic("Toyota Dealer Details")
@Feature("Toyota Dealer Locator Automation")
public class TestToyota extends BaseTestWebMethodContext {

    @Test
    @Description("By using zipcode find dealer information")
    public void toyotaLocator() {
        WebDriver driver = setupDriverInstance("chrome");
        FindDealer findDealer = new FindDealer(driver);
        findDealer.findADealer();
        findDealer.dealerDetailsPage();
        findDealer.dealerDetailsSite();
    }

}
