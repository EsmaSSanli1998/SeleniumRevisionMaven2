package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

    /*
    Annotations

    Selenium'da kodlarimizi yazarken “@” işareti ile baslayan notasyonlar kullaniriz.
    Java Annotationlar ile derleyiciye (Compiler) talimatlar verebiliriz.
    Annotation, bir veri hakkında bilgi barındıran veriyi sağlayan basit bir yapıdır. Bu sağladığı
    bilgiye de "metadata" denir.
    Notasyonlar(Annotation) genellikle Java'da konfigürasyon amacıyla kullanılır. Kullanildigi bileşene
    ek özellikle katar. Bu bileşenler sınıf, metod, değişkenler, paket ya da parametreler olabilir.
    Bunların hepsinde notasyonları kullanabiliriz.

    En cok kullanilan Junit annotation'lari:
    @Test
    @Before, @After
    @BeforeClass @AfterClass
    @Ignore



    1. @Test ve @Ignore:

    Junit ile Main Method kullanma donemini bitiriyoruz.
    Junit Framework kullandigimizda yazdığımız test metodunun calismasi icin başına @Test notasyonu eklememiz yeterlidir.
    @Test notasyonu eklemedigimiz metot test sırasında çalışıtırılmaz. Ancak cagrilirsa calisir.
    Yazdığımız bazı test metotları henüz tamamlanmamış veya değişikliklere uğrayabileceğinden dolayı
    test sırasında çalıştırılmasını istemiyorsak @lgnore notasyonu eklememiz yeterlidir.



    2.@Before ve @After:

    Before notasyonu, her test method'undan önce çalışır. Örneğin bir sayfa ile test yapiyorsak ve her testten
    once o sayfaya gitmemiz gerekiyorsa @before kullanabiliriz.
    @before notasyanunun kullanildigi method'a genelde setup() ismi verilir.
    After notasyonu, her test method'undan sonra çalışmaktadır. Örneğin test sirasinda kullandigimiz sayfanin
    kapatilmasi gibi.
    @after notasyanunun kullanildigi metoda genelde teardown() ismi verilir
    Not: Test method'u ve Test farkli yapilardir.
    Test dedigimizde tek bir method veya icinde bircok class ve package barindiran bir yapi olabilir.
    Regression test, smoke test vb..
    Test method'u ise @Test notasyonu kullanilarak olusturulan ve bagimsiz olarak
    calistirabilecegimiz en kucuk test yapisidir



    3.@BeforeClass ve @AfterClass:

    BeforeClass notasyonu, bir class'daki tüm testlerden once yapılması gereken bir islem işlem varsa kullanılır (precondition).
    Örneğin test metotlarımız çalışmadan driver olusturup tum methodlarda kullanabilirim.

    AfterClass notasyonu da, bir class'daki tüm testler tamamlandıktan sonra yapılması gereken İşlemlerde kullanılır.
    Örneğin actigimiz sayfayi kapatmak veya elde ettigimiz test sonuclarini raporlamak gibi.
    @BeforeClass ve @AfterClass notasyonları test sürecinde bir kere çalışırken, @Before ve @After notasyonları
    her test method'unun başında ve sonunda çalışmaktadır.



    @BeforeClass-->@Before-->@Test-->@AfterClass-->@After

   ********** Önce hangi test methodu calissin istiyorsak ona kücük numarak veririz
     */


    @Before
    public void setUp() throws Exception {

        System.out.println("her testten önce 1 kez");
    }

    @After
    public void tearDown() throws Exception {

        System.out.println("her testten sonra 1 kez");


    }

    @Test
    public void test01() {

        System.out.println("ilk test");

    }

    @Test
    public void test02() {

        System.out.println("ikinci tets");

    }

    @Test
    public void test03() {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.techproeducation.com");

        driver.close();

    }
}
