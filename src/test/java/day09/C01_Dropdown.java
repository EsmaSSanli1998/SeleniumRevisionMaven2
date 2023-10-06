package daz09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {

    /*
    Adim1: Dropdown menuyu herhangi bir locator ile locate edin.
                       WebElement ddm-driver.findElement(By.id("value of id"));

    Adim 2: Yeni bir "Select" objesi olusturun ve daha once locate ettigimiz WebElement'i parametre olarak yeni objeye ekleyin
                                 Select options=new Select(ddm);

    Adim 3: Select class'indan kullanabileceginiz 3 yontemden biriyle dropdown menusundeki elemananlardan istediginizi secin
                                     options.selectByIndex(1);

    Dropdown menusundeki elementleri Select Class'indan kullanacagimiz yontemlerle 3 sekilde secebiliriz
        1. Index kullanarak-->selectByIndex();
        2.Deger kullanarak-->selectByValue();
        3.Gorunen degerini kullanarak-->selectByVisibleText();

        Istenirse getOptions(); methodu kullanilarak DropDown'daki tum elementler webelementlerden olusan
        bir listeye konabilir.-->List<WebElement>





         */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {

        System.out.println("before calisti");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @BeforeClass
    public static void beforeClass() throws Exception {

        System.out.println("beforeclass calisti");

    }

    @AfterClass
    public static void afterClass() throws Exception {

        System.out.println("afterclass calisti");


    }

    @After
    public void tearDown() throws Exception {

        System.out.println("after calisti");

        driver.quit();

    }


    @Test
    public void test01() {


        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");


        // Yıl Drodown 'undan "2020" seciniz
        WebElement ddmYil = driver.findElement(By.xpath("//select [@id='year']"));
        Select select = new Select(ddmYil);
        //select.selectByVisibleText("2020");
        // select.selectByIndex(3);-->index 0'dan baslar
        select.selectByValue("2020");


        // Ay Dropdown'undan "August" seciniz
        WebElement ddmAy = driver.findElement(By.xpath("//select [@id='month']"));
        Select select2 = new Select(ddmAy);
        select2.selectByVisibleText("August");

        // Gün Dropdown 'undan "5" seciniz
         WebElement ddmGun = driver.findElement(By.xpath("//select [@id='day']"));
         Select select3 = new Select(ddmGun);
        //select3.selectByVisibleText("5");
        // select3.selectByIndex (4);
        select3.selectByValue("5");



        String enSonSecilen = select3.getFirstSelectedOption().getText(); //dropdowndaki en son secilen opsiyonu döndürür
        System.out.println("enSonSecilen = " + enSonSecilen);


        List<WebElement> tumSecenekler = select2.getOptions(); //dropdowndaki tüm opsiyonlari döndürür
        tumSecenekler.stream().forEach(t-> System.out.println(t.getText()));

        /*
        for (WebElement each:tumSecenekler) {

            System.out.println("tumSecenekler = " + each.getText());
        }

         */

        System.out.println("**********************************************");

        List<WebElement> ikinciYol = driver.findElements(By.xpath("//select [@id='month']//option"));
        ikinciYol.stream().forEach(t-> System.out.println(t.getText()));


        System.out.println("*******************************");

        List<WebElement> tumdropdownTumOptions = driver.findElements(By.tagName("option"));
        tumdropdownTumOptions.stream().forEach(t-> System.out.println(t.getText()));


    }

















}
