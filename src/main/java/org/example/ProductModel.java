package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Random;


public class ProductModel {
    WebDriver driver;
    By searchWord = By.xpath("//*[@class='sc-4995aq-0 sc-14oyvky-0 iYMTpq']");
    By down = By.linkText("2");
    By products= By.xpath("//*[@class='catalog-view clearfix products-container']/li/a");

    public ProductModel(WebDriver driver){
        this.driver = driver;
    }

    public void search(){
        driver.findElement(searchWord).sendKeys("bilgisayar");
        driver.findElement(searchWord).sendKeys(Keys.ENTER); //enter tuşu ile arama yapma
        //driver.findElement(find).click(); //bul adlı butona basarak arama yapma
    }

    public void clickPage2(){
        try {
            driver.findElement(down).click();
            Thread.sleep(5000);
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    List<WebElement> result;
    public void selectRandomProduct(){
        try {
            result = driver.findElements(products);
            Thread.sleep(2000);
            Random r = new Random();
            int linkNo= r.nextInt(result.size());
            result.get(linkNo).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
