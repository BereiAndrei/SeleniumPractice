package Teste;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest {

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

        WebElement AlertsSubMenu=driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
        AlertsSubMenu.click();
        driver.navigate().to("http://demo.automationtesting.in/Windows.html");

        List<WebElement>WindowsOption = driver.findElements(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li/a"));
        WindowsOption.get(0).click();

        WebElement NewTabWindow =driver.findElement(By.xpath("//button[contains(text(),'click')]"));
        NewTabWindow.click();

        //identific numarul de tab-uri/windows deschise

        List<String> OpenTabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(OpenTabs.get(1));
        System.out.println("Titlul noii pagini este "+driver.getTitle());
        driver.close();
        driver.switchTo().window(OpenTabs.get(0));
        System.out.println("Titlul noii pagini este "+driver.getTitle());


        WindowsOption.get(1).click();
        WebElement OpenNewTabWindow =driver.findElement(By.xpath("//button[@onclick='newwindow()']"));
        OpenNewTabWindow.click();

        List<String> OpenWindows=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(OpenWindows.get(1));
        System.out.println("Titlul noii pagini este "+driver.getTitle());
        driver.close();
        driver.switchTo().window(OpenWindows.get(0));
        System.out.println("Titlul noii pagini este "+driver.getTitle());



        WindowsOption.get(2).click();
        WebElement OpenMultipleTabs = driver.findElement(By.xpath("//button[@onclick='multiwindow()']"));
        OpenMultipleTabs.click();

        List<String> OpenMultiple=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(OpenMultiple.get(2));
        System.out.println("Titlul noii pagini este" +driver.getTitle());
        driver.close();
        driver.switchTo().window(OpenMultiple.get(1));
        System.out.println("Titlul noii pagini este" +driver.getTitle());
        driver.close();




    }
}
