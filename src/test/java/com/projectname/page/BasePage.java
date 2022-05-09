package com.projectname.page;

import com.impactqa.utilities.web.SeleniumUtils;
import org.openqa.selenium.WebDriver;

/**
 * <p>BasePage class.</p>
 *
 * @author Maqdoom Sharief
 * @since 22020-09-12
 * @version 1.0
 */
public class BasePage {

    protected SeleniumUtils seleniumUtils;

    /**
     * <p>Constructor for BasePage.</p>
     *
     * @param driver a {@link WebDriver} object
     * @param pageObjectRepoFileName a {@link String} object
     */
    public BasePage(WebDriver driver, String pageObjectRepoFileName) {
        this.seleniumUtils = new SeleniumUtils(driver, pageObjectRepoFileName);
    }

    /**
     * <p>Getter for the field <code>seleniumUtils</code>.</p>
     *
     * @return a {@link SeleniumUtils} object
     */
    public SeleniumUtils getSeleniumUtils() {
        return seleniumUtils;
    }
}
