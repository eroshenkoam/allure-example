package io.qameta.allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AshotTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogle() throws IOException {
        driver.get("https://google.com");
        final Screenshot screenshot = new AShot().takeScreenshot(driver);
        attachFile(screenshot);
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

    @Attachment(value = "Screenshoot", type = "image/png", fileExtension = "png")
    private byte[] attachFile(final Screenshot screenshot) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(screenshot.getImage(), "png", stream);
        return stream.toByteArray();
    }

}
