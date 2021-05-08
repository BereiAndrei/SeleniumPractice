package Teste;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class AlertsTest {
    public WebDriver driver;
    @Test

    public void Alerts() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();




        WebElement SwitchToMenuWeb= driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        Actions Action=new Actions(driver);
        Action.moveToElement(SwitchToMenuWeb).build().perform();
        WebElement AlertsSubMenu=driver.findElement(By.xpath("//a[contains(text(),'Alerts')]"));
        AlertsSubMenu.click();
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");


        List<WebElement>AlertsOptions= driver.findElements(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li/a"));
        AlertsOptions.get(0).click();
        WebElement ClickAlertOk= driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        ClickAlertOk.click();

        new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
        Alert AlertWithOk=driver.switchTo().alert();
        System.out.println(AlertWithOk.getText());
        AlertWithOk.accept();


        AlertsOptions.get(1).click();
        WebElement AlertOkCancel = driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
        AlertOkCancel.click();
        new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
        Alert ClickAlertOkCancel=driver.switchTo().alert();
        System.out.println(ClickAlertOkCancel.getText());
        ClickAlertOkCancel.dismiss();


        AlertsOptions.get(2).click();
        WebElement AlertTextBox= driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        AlertTextBox.click();
        new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
        Alert ClickAlertTextBox=driver.switchTo().alert();
        System.out.println(ClickAlertTextBox.getText());
        ClickAlertTextBox.sendKeys("El patron del Gherla");
        ClickAlertTextBox.accept();






    }


}
