package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {


    public static void main(String[] args) {

        //1-Test01 isimli bir class olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2- https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String actualsaveTitle = driver.getTitle();
        String arananKelime = "Save";
        if (actualsaveTitle.contains(arananKelime)){
            System.out.println("Title testi PASS");
        } else {
            System.out.println("Title testi FAILED");
            System.out.println(arananKelime + " icermiyor");
        }

        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String expectedResult = "Walmart.com | Save Money.Live Better";
        if (actualsaveTitle.equals(expectedResult)){
            System.out.println("Sayfa baslgı istenilen deger esit");
        }else{
            System.out.println("Sayfa baslıgı esit degil");
        }

        //7- URL in walmart.com icerdigini control edin
        String actualURL=driver.getCurrentUrl();
        String arananUrl="walmart.com" ;
        if (actualURL.contains(arananUrl))  {
            System.out.println("URL testi PASS");
        } else {
            System.out.println("URL testi FAILED");
            System.out.println("URL " + arananUrl + " icermiyor");
        }

        //8-”Nutella” icin arama yapiniz
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='h_a a8_b header-GlobalSearch-input mweb-Typeahead-input h_b']"));
        String istenenKelime = "Nutella";
        searchBox.sendKeys(istenenKelime+ Keys.ENTER);

        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucTexti = driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println(sonucTexti.getText());

        //10-Sayfayi kapatin
        driver.close();

    }
}
