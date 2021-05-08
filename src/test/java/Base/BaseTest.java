package Base;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;

    @Before
    //metodele adnotate cu @Before se vor executa mereu inainte de @Test

    public void Setup(){
            System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://demo.automationtesting.in/Register.html");
            driver.manage().window().maximize();
    }


}
