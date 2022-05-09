package com.projectname.basetest;

import com.impactqa.utilities.mobwebcommon.DriverManager;
import com.impactqa.utilities.mobwebcommon.DriverProvider;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;

/**
 * This class is the base com.impactqa.test for web which holds all the basic functionalities required for web testing with respect to method.
 *
 * @author Maqdoom Sharief
 * @version 1.0
 * @since 2020-11-10
 */
public class BaseTestWebMethodContext {



	/**
	 * This method initiates the web driver session.
	 *
	 * @param browser string that has the browser name.
	 * @return Web driver object.
	 * @throws MalformedURLException if any.
	 */
	@Step("Open new browser session")
	public WebDriver setupDriverInstance(String browser) {
		WebDriver driver = DriverProvider.createNewBrowserSession(browser);
		return driver;
	}
	/**
	 * This method takes a screenshot if any method fails.
	 *
	 * @param result object of ITestResult.
	 */
	@AfterMethod
	@Description("Get Screenshot for failed cases")
	public void afterMethodFailed(ITestResult result) {
		WebDriver driver = DriverManager.getWebDriver();
		if(driver!=null)
			if(ITestResult.FAILURE ==result.getStatus()){
				TakesScreenshot tk = (TakesScreenshot) driver;
				byte[] b = tk.getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(b), "png");
			}
	}
	//	Added for reference. If you don't want screenshots for passed statements, then set enabled flag as false

	/**
	 * This method takes a screenshot if any method passes.
	 *
	 * @param result object of ITestResult.
	 */
	@AfterMethod(enabled = true)
	@Description("Get Screenshot for passed cases")
	public void afterMethodPassed(ITestResult result) {
		WebDriver driver = DriverManager.getWebDriver();
		if(driver!=null)
			if(ITestResult.SUCCESS ==result.getStatus()){
				TakesScreenshot tk = (TakesScreenshot) driver;
				byte[] b = tk.getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(b), "png");
			}
	}

	/**
	 * This method closes the browser session.
	 */
	@AfterMethod(alwaysRun = true)
	@Description("close the browser session")
	public void teardownDriverInstance()
	{
		WebDriver driver = DriverManager.getWebDriver();
		if(driver!=null) {
			System.out.println("teardownDriverInstance");
			driver.quit();
		}
	}
}
