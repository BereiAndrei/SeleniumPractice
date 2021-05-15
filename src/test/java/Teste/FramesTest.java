package Teste;

import Base.BaseTest;
import Help.ElementMethods;
import Help.FrameMethods;
import Help.PageMethod;
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

import static org.junit.Assert.assertEquals;

public class FramesTest extends BaseTest {

    public FrameMethods frameMethods;
    public ElementMethods elementMethods;
    public PageMethod pageMethod;


    @Test
    public void TestAutomat(){

        frameMethods=new FrameMethods(driver);
        elementMethods=new ElementMethods(driver);
        pageMethod=new PageMethod(driver);


       pageMethod.ValidateTitlePage("Register");

        //daca avem un text salvat in interiorul codului HTML scris cu negru la capatul liniei ><
        //putem folosi contains cand identificam dupa xpath (//a[contains(text(),'Switch')])

        WebElement SwitchToMenuWeb= driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        elementMethods.HoverElement(SwitchToMenuWeb);

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

       frameMethods.SwitchFrameById("singleframe");
        WebElement InputSingleFrame= driver.findElement(By.xpath("//input[@type='text']"));
        InputSingleFrame.sendKeys("Vreau concediu");

        //dupa ce am terminat de lucrat cu un iframe trebuie sa ne mutam pe frame-ul default
       frameMethods.SwitchFrameDefault();

        FrameButtons.get(1).click();

        frameMethods.SwitchFrameByElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        frameMethods.SwitchFrameByElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        WebElement InputMultipleFrame= driver.findElement(By.xpath("//input[@type='text']"));
        InputMultipleFrame.sendKeys("Masina din parcare");
        frameMethods.SwitchFrameDefault();
        driver.quit();






    }





}
