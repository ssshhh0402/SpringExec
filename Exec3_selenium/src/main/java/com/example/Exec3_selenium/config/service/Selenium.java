package com.example.Exec3_selenium.config.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class Selenium {
    private WebDriver driver;
    private WebElement webElement;
    private Clipboard clipBoard;
    public Selenium(String id, String pwd){
        try {
            System.setProperty("webdriver.chrome.driver", "../../chromedriver");
            System.setProperty("java.awt.headless", "false");
            driver = new ChromeDriver();
            driver.get("http://www.naver.com");
            webElement = driver.findElement(By.className("link_login"));
            webElement.click();
            webElement = driver.findElement(By.id("id"));
            webElement.click();
            webElement.clear();
            clipBoard = makeCopy(id);
            Action actions = makeActions(driver);
            actions.perform();
            Thread.sleep(1000);
            webElement = driver.findElement(By.id("pw"));
            webElement.click();
            webElement.clear();
            clipBoard = makeCopy(pwd);
            actions = makeActions(driver);
            actions.perform();
            Thread.sleep(1000);
            webElement = driver.findElement(By.id("log.login"));
            webElement.click();
            try{
                webElement = driver.findElement(By.id("new.save"));
                webElement.click();
            }catch(Exception e){
                System.out.println(e.toString());
            }
            webElement = driver.findElement(By.className("num"));
            System.out.println("----------------");
            System.out.println(webElement.getText());
            System.out.println("----------------");
            if(webElement.getText().equals("0")){
                driver.quit();
            }else{
                webElement.click();
            }

        }catch(Exception e){
            System.out.println(e.toString());
            driver.quit();
        }
    }
    public Clipboard makeCopy(String contents){
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection strings = new StringSelection(contents);
        clipBoard.setContents(strings, null);
        return clipBoard;
    }
    public Action makeActions(WebDriver driver){
        Actions action = new Actions(driver);
        Action result = action
                .keyDown(Keys.COMMAND)
                .sendKeys("V")
                .keyUp(Keys.COMMAND)
                .build();
        return result;
    }

}
