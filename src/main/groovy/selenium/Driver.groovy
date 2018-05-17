package selenium

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import java.util.concurrent.TimeUnit

enum Driver implements WebDrivers {
    CHROME {
        @Override
        WebDriver getDriver() {

            WebDriver driver = new ChromeDriver()
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS)
            driver.manage().window().maximize()
            return driver
        }
    }

    abstract WebDriver getDriver()
}