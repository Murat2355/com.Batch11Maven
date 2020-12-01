package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBox {
    //1. Bir class oluşturun : CheckBoxTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

   WebDriver driver;

   @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

    }
    @Test
    public void elementLocate(){
        // a. Verilen web sayfasına gidin.
        // https://the-internet.herokuapp.com/checkboxes
        driver.get(" https://the-internet.herokuapp.com/checkboxes");

        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement box1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement box2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!box1.isSelected()){
            box1.click();
        }

        // d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!box2.isSelected()) {
            box2.click();
        }

    }
        @After
        public  void tearDown() {
            driver.close();
        }




}
