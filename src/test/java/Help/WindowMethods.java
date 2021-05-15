package Help;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {

    public WebDriver driver;
    public WindowMethods(WebDriver driver){
        this.driver=driver;

    }

    public void SwitchToSpecificTabWindow(int Valoare){
        List<String> OpenTabsWindows=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(OpenTabsWindows.get(Valoare));
        System.out.println("Titlul noii pagini este "+driver.getTitle());
        driver.close();
    }

    public void CloseCurrentWindow(){
        driver.close();
    }

}
