package com.example.Exec3_selenium.config.service;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;


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
                webElement = driver.findElement(By.id("new.dontsave"));
                webElement.click();
            }catch(Exception e){
                System.out.println(e.toString());
            }
            String target = "num" + " " + "MY_MAIL_COUNT";
            driver.get("https://mail.naver.com");
            webElement = driver.findElement(By.id("unreadMailCount"));
            int n = Integer.parseInt(webElement.getText());
            if(n != 0){
                webElement = driver.findElement(By.id("list_for_view"));
                webElement = driver.findElement(By.cssSelector("ol"));
                List items = webElement.findElements(By.cssSelector("strong"));
                sendKakao(items,n);
                driver.quit();
            }else{
                driver.quit();
            }
        }catch(Exception e){
            System.out.println(e.toString());
            driver.quit();
        }
    }
    public void sendKakao(List items, int n){
            for(int i = 0; i < n; i++){
                String now = ((WebElement)items.get(i)).getText();
                System.out.println(now);
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
