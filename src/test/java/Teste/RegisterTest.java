package Teste;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest {


    //declaram o variabila WebDriver
    public WebDriver driver;

    @Test

    public void Register(){
        //setam driver-ul de Chrome
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        //deschidem un browser de chrome
        driver=new ChromeDriver();
        //accessam un url
        driver.get("http://demo.automationtesting.in/Register.html");
        //intra in mod maximize
        driver.manage().window().maximize();

        //ca sa identificam un web element trebuie sa ii gasim selectorul comun
        //un web element se poate identifica dupa: id,class,orice atribut unic(xpath)
        //structura xpath://prim cuvant(mov)[@selector='valoare'] => 1 of 1
        //1.identific element
        //2.specific actiunea
        WebElement FirstNameWeb= driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String FirstNameValue="Andrei";
        FirstNameWeb.sendKeys(FirstNameValue);

        WebElement LastNameWeb= driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String LastNameValue="Berei";
        LastNameWeb.sendKeys(LastNameValue);

        WebElement AdressWeb=driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        String AdressValue="Floresti strada Porii";
        AdressWeb.sendKeys(AdressValue);

        WebElement EmailWeb= driver.findElement(By.xpath("//input[@type='email']"));
        String EmailValue="berei.andrei@yahoo.com";
        EmailWeb.sendKeys(EmailValue);


        WebElement TelWeb=driver.findElement(By.xpath("//input[@type='tel']"));
        String TelValue="0725132548";
        TelWeb.sendKeys(TelValue);


        WebElement GenderWeb= driver.findElement(By.xpath("//input[@value='Male']"));
        GenderWeb.click();

        WebElement HobbyWeb=driver.findElement(By.id("checkbox1"));
        HobbyWeb.click();


        WebElement SkillWeb=driver.findElement(By.id("Skills"));
        String SkillValue="Java";
        Select SkillSelect=new Select(SkillWeb);
        SkillSelect.selectByVisibleText(SkillValue);


        WebElement CountriesWeb=driver.findElement(By.id("countries"));
        String CountriesValue="South Africa";
        Select CountriesSelect=new Select(CountriesWeb);
        CountriesSelect.selectByVisibleText(CountriesValue);


        WebElement YearWeb=driver.findElement(By.id("yearbox"));
        String YearValue="1988";
        Select YearSelect=new Select(YearWeb);
        YearSelect.selectByValue(YearValue);

        WebElement MonthWeb=driver.findElement(By.xpath("//select[@placeholder='Month']"));
        String MonthValue="October";
        Select MonthSelect=new Select(MonthWeb);
        MonthSelect.selectByValue(MonthValue);

        WebElement DayWeb=driver.findElement(By.id("daybox"));
        String DayValue="6";
        Select DaySelect=new Select(DayWeb);
        DaySelect.selectByValue(DayValue);

        WebElement PasswordWeb=driver.findElement(By.id("firstpassword"));
        String PasswordValue="Aprilie07";
        PasswordWeb.sendKeys(PasswordValue);

        WebElement ConfpassWeb=driver.findElement(By.id("secondpassword"));
        String ConfpassValue="Aprilie07";
        ConfpassWeb.sendKeys(ConfpassValue);

        GenderWeb.click();

        WebElement LanguageWeb=driver.findElement(By.id("msdd"));
        LanguageWeb.click();
        List<WebElement>LanguageOptions= driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//a"));
        for( int Index=0;Index<LanguageOptions.size();Index++){
            String CurrentElementText=LanguageOptions.get(Index).getText();
            if (CurrentElementText.equals("Arabic"));
            LanguageOptions.get(Index).click();
        }
        ConfpassWeb.click();

        WebElement SelectCountryWeb=driver.findElement(By.xpath("//span[@role='combobox']"));
        SelectCountryWeb.click();
        List<WebElement>SelectCountryWebOptionsList =driver.findElements(By.xpath("//ul[@id='select2-country-results']/li"));
        for(int Index=0;Index<SelectCountryWebOptionsList.size();Index++){
            String CurrentElementText=SelectCountryWebOptionsList.get(Index).getText();
            if(CurrentElementText.equals("Australia")){
                SelectCountryWebOptionsList.get(Index).click();
                break;
            }
        }

        WebElement SubmitWeb= driver.findElement(By.id("submitbtn"));
        SubmitWeb.click();


        //inchid browser-ul la finalul testului
        //driver.quit();
        //driver.close inchide 1 tab-ul curent
        //driver.quit inchide browser-ul cu toate tab-urile


        WebElement WebTable= driver.findElement(By.xpath("//a[@href='WebTable.html]"));
        WebTable.click();
        driver.navigate().to("http://demo.automationtesting.in/WebTable.html");

        //Validare pagina
        String ExpectedWebTablePageTitle="Web Table";
        String ActualWebTablePageTitle= driver.getTitle();
        Assert.assertEquals("Pagina Web Table nu are titlu corect",ExpectedWebTablePageTitle,ActualWebTablePageTitle);

        driver.quit();
    }



}
