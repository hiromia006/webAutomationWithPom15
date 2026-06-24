package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.BasePage;
import com.parabank.parasoft.pages.Page;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Page pg;
    private Properties prop;

    public BaseTest() {
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            prop = new Properties();
            FileInputStream inputStream = null;

            inputStream = new FileInputStream(path);

            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void browserSetup() {
        String browserName = prop.getProperty("browserName");

        if (Objects.equals(browserName, "firefox")) {
            if (System.getProperty("os.name").toLowerCase().contains("linux"))
                System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");
            //  Launch Firefox Browser
            driver = new FirefoxDriver();
        } else if (Objects.equals(browserName, "firefoxHeadless")) {
            if (System.getProperty("os.name").toLowerCase().contains("linux"))
                System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            //  Launch Firefox Browser
            driver = new FirefoxDriver(options);
        } else if (Objects.equals(browserName, "chrome")) {
            //  Launch Chrome Browser
            driver = new ChromeDriver();
        } else if (Objects.equals(browserName, "ChromeHealess")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            //  Launch Chrome Browser
            driver = new ChromeDriver(options);
        } else if (Objects.equals(browserName, "Edge")) {
            // Please skip below two lines if you have set the edgedriver path in your system environment variables
            //  Launch Edge Browser
            driver = new EdgeDriver();

        } else {
            throw new RuntimeException("Browser name is invalid");
        }
        driver.get(prop.getProperty("baseUrl"));
        driver.manage().window().maximize();
        pg = new BasePage(driver);

    }

    @AfterMethod
    public void browserTearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
        driver.quit();
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }

    public void takeScreenshot(String fileName) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + fileName + "_"+System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
