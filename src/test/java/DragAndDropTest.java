import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DragAndDropTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void dragAndDropActions(){
        open("/drag_and_drop");

        var elementA=$("#column-a");
        var elementB=$("#column-b");

        elementA.shouldHave(Condition.text("A"));
        elementB.shouldHave(Condition.text("B"));

        Actions action = new Actions(getWebDriver());
        action.dragAndDrop(elementA, elementB).perform();

        elementA.shouldHave(Condition.text("B"));
        elementB.shouldHave(Condition.text("A"));
    }
    @Test
    void dragAndDropWithSelenideCommand() {
        open("/drag_and_drop");

        var elementA = $("#column-a");
        var elementB = $("#column-b");

        elementA.shouldHave(Condition.text("A"));
        elementB.shouldHave(Condition.text("B"));

        elementA.dragAndDropTo(elementB);

        elementA.shouldHave(Condition.text("B"));
        elementB.shouldHave(Condition.text("A"));
    }
}

