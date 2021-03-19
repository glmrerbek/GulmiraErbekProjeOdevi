package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GittigidiyorTest{

    WebDriver driver;
    String url = "https://www.gittigidiyor.com/";
    ProductModel productModel;
    BasketModel basketModel;

    By logIn = By.xpath("//*[@title='Giriş Yap']");
    By giris = By.xpath("//*[@class='sc-12t95ss-3 fDarBX']");
    By email = By.id("L-UserNameField");
    By password =By.xpath("//*[@id='L-PasswordField']");
    By submit = By.id("gg-login-enter");

    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\chrome\\chromedriver.exe");
        driver = new ChromeDriver(); //chrome ayağa kalkıyor
        productModel = new ProductModel(driver);
        basketModel = new BasketModel(driver);

        driver.get(url); //belirttiğimiz adrese yönlerndirme yapılıyor
        driver.manage().window().maximize(); //tarayıcıyı maksimum ekran genişliğine ayarlıyor

    }

    public void logInPage(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/");//url karşılaştırması yapıyor
        try {
            Thread.sleep(3000);
            driver.findElement(logIn).click(); //tarayıcıdan yerini ve adını belirlediğimiz butona tıklama yapıyor
            Thread.sleep(1000);
            driver.findElement(giris).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void userInformation(){
        try {
            driver.findElement(email).sendKeys("miraerbek0502@outlook.com");
            driver.findElement(password).sendKeys("aamir9665");
            driver.findElement(submit).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void search(){
        productModel.search();
    }

    public void clickPage2(){
        productModel.clickPage2();
    }

    public void selectRandomProduct(){
        productModel.selectRandomProduct();
    }

    public void addToBasket(){
        basketModel.addToBasket();
    }

    public void clickToBasket(){
        basketModel.clickToBasket();
    }

    public void product(){
        basketModel.product();
    }

    public void deleteButton(){
        basketModel.deleteButton();
    }
    public void closes(){productModel.closes();}
}
