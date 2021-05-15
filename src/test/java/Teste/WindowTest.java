package Teste;

import Base.BaseTest;
import Help.ElementMethods;
import Help.PageMethod;
import Help.WindowMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WindowTest extends BaseTest {

    //declaram obiecte specifice pe care vrem sa le facem
    public PageMethod pageMethod;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;



    @Test
    public void Windows() {

        pageMethod=new PageMethod(driver);
        elementMethods=new ElementMethods(driver);
        windowMethods=new WindowMethods(driver);


        String ActualWebTablePageTitle= driver.getTitle();
        pageMethod.ValidateTitlePage(ActualWebTablePageTitle);

        WebElement SwitchToMenuWeb= driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        elementMethods.HoverElement(SwitchToMenuWeb);

        WebElement AlertsSubMenu=driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
        elementMethods.ClikcElement(AlertsSubMenu);

        pageMethod.NavigateToURL("http://demo.automationtesting.in/Windows.html");

        List<WebElement>WindowsOption = driver.findElements(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li/a"));
        WindowsOption.get(0).click();

        WebElement NewTabWindow =driver.findElement(By.xpath("//button[contains(text(),'click')]"));
        NewTabWindow.click();

        //identific numarul de tab-uri/windows deschise

        windowMethods.SwitchToSpecificTabWindow(1);
        windowMethods.CloseCurrentWindow();
        windowMethods.SwitchToSpecificTabWindow(0);



        WindowsOption.get(1).click();
        WebElement OpenNewTabWindow =driver.findElement(By.xpath("//button[@onclick='newwindow()']"));
        OpenNewTabWindow.click();

        windowMethods.SwitchToSpecificTabWindow(1);
        windowMethods.CloseCurrentWindow();
        windowMethods.SwitchToSpecificTabWindow(0);



        WindowsOption.get(2).click();
        WebElement OpenMultipleTabs = driver.findElement(By.xpath("//button[@onclick='multiwindow()']"));
        OpenMultipleTabs.click();

        windowMethods.SwitchToSpecificTabWindow(2);
        windowMethods.CloseCurrentWindow();
        windowMethods.SwitchToSpecificTabWindow(1);
        windowMethods.CloseCurrentWindow();
        windowMethods.SwitchToSpecificTabWindow(0);
        driver.quit();




    }
}
