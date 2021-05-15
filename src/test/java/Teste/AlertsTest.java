package Teste;

import Base.BaseTest;
import Help.AlertMethods;
import Help.ElementMethods;
import Help.PageMethod;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AlertsTest extends BaseTest {

    public ElementMethods elementMethods;
    public PageMethod pageMethod;
    public AlertMethods alertMethods;


    @Test
    public void Alerts() {

        elementMethods=new ElementMethods(driver);
        pageMethod=new PageMethod(driver);
        alertMethods=new AlertMethods(driver);

        pageMethod.ValidateTitlePage("Register");


        WebElement SwitchToMenuWeb= driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        Actions Action=new Actions(driver);
        elementMethods.HoverElement(SwitchToMenuWeb);



        List<WebElement>AlertsOptions= driver.findElements(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li/a"));
        AlertsOptions.get(0).click();
        WebElement ClickAlertOk= driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        ClickAlertOk.click();

        alertMethods.AcceptAlert();


        AlertsOptions.get(1).click();
        WebElement AlertOkCancel = driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
        AlertOkCancel.click();
        alertMethods.DismissAlert();


        AlertsOptions.get(2).click();
        WebElement AlertTextBox= driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        AlertTextBox.click();
        alertMethods.AcceptFillAlert("Blablabla");


        AlertsOptions.get(2).click();
        WebElement AlertTextBox= driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        AlertTextBox.click();
        alertMethods.DismissFillAlert("Traieste-ti viata");


    }


}
