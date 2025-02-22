/*
 * (C) Copyright 2016 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.bonigarcia.wdm.test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Test with Chrome.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class ChromeTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

//    @After
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    public void testdois() {
        // Your test code here. For example:
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        By searchInput = By.id("searchInput");
        wait.until(presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys("Software");
        By searchButton = By.id("searchButton");
        wait.until(elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();

        wait.until(textToBePresentInElementLocated(By.tagName("body"),
                "Computer software"));
    }

    @Test
    public void test() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        By viewHistory = By.cssSelector("#ca-history > a:nth-child(1)");
        driver.findElement(viewHistory).click();
        By compareButton = By.cssSelector("#mw-history-compare > div:nth-child(4) > input");
        driver.findElement(compareButton).click();
    }

    @Test
    public void testTres() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        By ca = By.id("pt-createaccount");
        driver.findElement(ca).click();
        By name = By.name("wpName");
        driver.findElement(name).sendKeys("Ismaelpucrs");
        By password = By.name("wpPassword");
        driver.findElement(password).sendKeys("ismael0123");
        By retype = By.name("retype");
        driver.findElement(retype).sendKeys("ismael0123");
        By email = By.name("email");
        driver.findElement(email).sendKeys("ismael.vargas@edu.pucrs.br");
        By create = By.name("wpCreateaccount");
        driver.findElement(create).click();
    }


}