package Teste;

import Base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FramesTest extends BaseTest {


    @Test
    public void TestAutomat(){

        //String ExpectedWebTablePageTitle="Web Table";
        //String ActualWebTablePageTitle= driver.getTitle();
        //Assert.assertEquals("Pagina Web Table nu are titlu corect",ExpectedWebTablePageTitle,ActualWebTablePageTitle);

        //daca avem un text salvat in interiorul codului HTML scris cu negru la capatul liniei ><
        //putem folosi contains cand identificam dupa xpath (//a[contains(text(),'Switch')])

        WebElement SwitchToMenuWeb= driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        Actions Action=new Actions(driver);
        Action.moveToElement(SwitchToMenuWeb).build().perform();

        WebElement FramesSubMenu=driver.findElement(By.xpath("//a[contains(text(),'Frames')]"));
        //declaram un wait explicit care sa astepte dupa element
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(FramesSubMenu));
        FramesSubMenu.click();
        //inchidem pop-ul de reclame
        driver.switchTo().frame("aswift_2");
        List<WebElement>checkPopupdisplayList =driver.findElements(By.xpath("//iframe[@id='ad_iframe']"));
        if(checkPopupdisplayList.size()>0) {
            new WebDriverWait(driver, 15).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ad_iframe"));
            WebElement ClosepopupWeb = driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
            ClosepopupWeb.click();
        }
        driver.switchTo().defaultContent();


        //ne putem muta pe un iframe dupa id,nume sau webelement
        List<WebElement> FrameButtons=driver.findElements(By.xpath("//ul[@class='nav nav-tabs ']/li/a"));
        FrameButtons.get(0).click();
        driver.switchTo().frame("singleframe");
        WebElement InputSingleFrame= driver.findElement(By.xpath("//input[@type='text']"));
        InputSingleFrame.sendKeys("Vreau concediu");
        //dupa ce am terminat de lucrat cu un iframe trebuie sa ne mutam pe frame-ul default
        driver.switchTo().defaultContent();

        FrameButtons.get(1).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
        WebElement InputMultipleFrame= driver.findElement(By.xpath("//input[@type='text']"));
        InputMultipleFrame.sendKeys("Masina din parcare");
        driver.switchTo().defaultContent();
        driver.quit();






    }





}
