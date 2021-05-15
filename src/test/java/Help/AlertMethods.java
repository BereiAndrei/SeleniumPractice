package Help;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertMethods {

    public WebDriver driver;
    public AlertMethods(WebDriver driver){
        this.driver=driver;
    }

    public void AcceptAlert(){
        new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
        Alert Alert=driver.switchTo().alert();
        System.out.println(Alert.getText());
        Alert.accept();
    }

    public void DismissAlert(){
        new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
        Alert Alert=driver.switchTo().alert();
        System.out.println(Alert.getText());
        Alert.dismiss();
    }

    public void AcceptFillAlert(String Value){
        new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
        Alert ClickAlertTextBox=driver.switchTo().alert();
        System.out.println(ClickAlertTextBox.getText());
        ClickAlertTextBox.sendKeys(Value);
        ClickAlertTextBox.accept();
    }

    public void DismissFillAlert(String Value){
        new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
        Alert ClickAlertTextBox=driver.switchTo().alert();
        System.out.println(ClickAlertTextBox.getText());
        ClickAlertTextBox.sendKeys(Value);
        ClickAlertTextBox.dismiss();
    }
}

