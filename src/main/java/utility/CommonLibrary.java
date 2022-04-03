package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.anthavio.phanbedder.Phanbedder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonLibrary {
    public static WebDriver driver;//always should be static
    String filePath = new File("src/main/screenshots").getAbsolutePath();
    String propertiesFile = new File("src/main/data/testData.properties").getAbsolutePath();

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        File phantomjs = Phanbedder.unpack();
//        DesiredCapabilities dcaps = new DesiredCapabilities();
//        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());
//        driver = new PhantomJSDriver(dcaps);
        driver.manage().window().maximize();

    }

    public void closeBrowser() {
        driver.quit();
    }

    public void takeScreenshots(String fileName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File virtualFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File actualFile = new File(filePath + fileName);
        FileUtils.copyFile(virtualFile, actualFile);
    }

    public String getProperties(String key) throws IOException {
        String value;
        FileInputStream fileInputStream = new FileInputStream(propertiesFile);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        value = properties.getProperty(key);
        return  value;
    }
}
