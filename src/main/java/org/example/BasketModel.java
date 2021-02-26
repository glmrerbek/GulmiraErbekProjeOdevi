package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketModel {
    WebDriver driver;
    By addBasket= By.id("add-to-basket");
    By clickBasket= By.xpath("//*[@class='header-cart-hidden-link']");
    By increase = By.xpath("//*[@value='2']");
    By delete = By.xpath("//*[contains(@class,'update-buttons-container')]//a[@title='Sil']");

    public BasketModel(WebDriver driver){
        this.driver = driver;
    }

    public void addToBasket(){
        try {
            driver.findElement(addBasket).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickToBasket(){
        try {
            driver.findElement(clickBasket).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void product(){
        try {
            driver.findElement(increase).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void deleteButton(){
        try {
            driver.findElement(delete).click();
            Thread.sleep(5000);
            Assert.assertNotNull(delete);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
