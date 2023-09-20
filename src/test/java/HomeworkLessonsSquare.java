import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HomeworkLessonsSquare {

    //Найдем элемент А на странице
    SelenideElement squareA = $x("//div[@id='column-a']");
    //Найдем элемент  на странице
    SelenideElement squareB = $x("//div[@id='column-b']");
    //В элементе А содержится текст
    SelenideElement textA = $x("//div[@id='column-a']//header");
    //В элементе В содержится текст
    SelenideElement textB = $x("//div[@id='column-b']//header");

    @BeforeEach
    static void setUp() {

        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void testSquares(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Убедимся, что элемент А на странице отображается
        squareA.shouldBe(Condition.visible);
        //Убедимся, что элемент В на странице отображается
        squareB.shouldBe(Condition.visible);
        // Поменяем местами элемент А с элементом В
        squareA.dragAndDropTo(squareB);
        //Убедимся, что в элементе А присутствует текст : "В"
        textA.shouldHave(Condition.text("B"));
        //Убедимся, что в элементе В присутствует текст : "А"
        textB.shouldHave(Condition.text("A"));
    }

}