import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FindCorrectText {
    SelenideElement solutionsLink =  $x("//header[contains(@class, 'Header-old')]//nav/ul/li[2]");
    SelenideElement enterpriseLink =  $x("//header[contains(@class, 'Header-old')]//nav/ul/li[2]/div[contains(@class, 'dropdown')]/div[1]//li[1]");
    SelenideElement buildtext = $x("//div[contains(@class, 'enterprise-hero')]//h1");

    @BeforeAll
    static void setUp() {

        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void test(){

        open("https://github.com/");
        solutionsLink.click();
        enterpriseLink.click();
        buildtext.shouldHave(Condition.text("Build like the best"));

    }


}
