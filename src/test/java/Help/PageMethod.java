package Help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

    public class PageMethod {

        //metode generale strict pentru interactiunea cu o pagina

        public WebDriver driver;

        public PageMethod(WebDriver driver) {
            this.driver = driver;
        }

        public void ValidateTitlePage(String ExpectedValue){

            String ActualWebTablePageTitle= driver.getTitle();
            Assert.assertEquals("Pagina Register nu are titlu corect",ExpectedValue,ActualWebTablePageTitle);

        }

        public void NavigateToURL(String URL){
            driver.navigate().to(URL);
        }
}
