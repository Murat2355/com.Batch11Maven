package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtonTest {
    //1.Bir class oluşturun : RadioButtonTest

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void radioButtonTest(){

        //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@id='u_0_h']")).click();

        // - “Create an Account” button’una basin
        driver.findElement(By.xpath("//a[@id='u_0_2']")).click();

        //- “radio buttons” elementlerini locate edin
        WebElement femaleButton = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleButton = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement customButton = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        //- Secili degilse cinsiyet butonundan size uygun olani secin
        if (!maleButton.isSelected())
        maleButton.click();
    }
    @After
    public  void tearDown() {
        driver.close();
    }
}
