package com.projectname.basetest;

import com.impactqa.utilities.mobwebcommon.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * This class is the base com.impactqa.test for web which holds all the basic functionalities required for web testing with respect to class.
 *
 * @author Maqdoom Sharief
 * @since 2020-11-10
 * @version 1.0
 */
public class BaseTestWebClassContext {

	protected WebDriver driver;
	protected String browser;

	/**
	 * This method will set the driver for the web browser.
	 *
	 * @param browser string that has the browser name.
	 */
	@BeforeClass(description = "Open new browser session")
	@Parameters({ "browser" })
	public void setupDriverInstance(String browser) {
		this.browser = browser;
		driver = DriverProvider.createNewBrowserSession(browser);
	}

	/**
	 * This method closes the browser session.
	 */
	@AfterClass(description = "close the browser session")
	public void teardownDriverInstance() {
		if (driver != null)
			driver.quit();
	}

	/**
	 * This method returns the web driver.
	 *
	 * @return Web driver object.
	 */
	public WebDriver getDriver() {
		return driver;
	}
}
