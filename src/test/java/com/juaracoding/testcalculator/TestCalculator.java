package com.juaracoding.testcalculator;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCalculator {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "SM_A530F");
        desiredCapabilities.setCapability("appium:udid", "5200ee25c080c49f");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "11.0");
        desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void additionTest() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        delay(1);
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        delay(1);
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        delay(1);
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        delay(1);

        String actualVal = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(actualVal,"3");
    }

    @Test
    public void multiplicationTest() {
        delay(1);
        driver.findElement(By.id("com.google.android.calculator:id/clr")).click();
        delay(1);
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        delay(1);
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        delay(1);
        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
        delay(1);
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        delay(1);

        String actualVal = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(actualVal,"12");
    }

    @AfterClass
    public void quitTest() {
        driver.quit();
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}