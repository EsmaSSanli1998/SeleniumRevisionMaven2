package day10;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class TestBaseDemo extends TestBase {

    @Test
    public void test01() {

        //techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");



        //Baslıgın "Bootcamp" icerdigini test ediniz
        String actuelTitle = driver.getTitle();
        String expectedTitle = "Bootcamp";

        Assert.assertTrue(actuelTitle.contains(expectedTitle));




    }


}
