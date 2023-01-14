package gitHubTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideTest {
    @Test
    public void githubTest() {

        SelenideLogger.addListener("Selenide", new AllureSelenide());
        open("https://github.com");
        $(".js-site-search-focus").setValue("selenide").pressEnter();
        $$(".v-align-middle").get(8).click();
        $("#issues-tab").click();
        $("#issue_2113_link").shouldHave(Condition.text("Provide more information when a file download fails"));
    }

    @Test
    public void lambdaTest() {
        SelenideLogger.addListener("Selenide", new AllureSelenide());
        step("Открываем github", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий selenide", () -> {
            $(".js-site-search-focus").setValue("selenide").pressEnter();
        });
        step("Переходим в репозиторий selenide", () -> {
            $$(".v-align-middle").get(8).click();
        });
        step("Переходим на страницу issue и ищем название 'Provide more information when a file download fails'", () -> {
            $("#issues-tab").click();
            $("#issue_2113_link").shouldHave(Condition.text("Provide more information when a file download fails"));
        });
    }

    @Test
    public void annotationTest() {
        SelenideLogger.addListener("Selenide", new AllureSelenide());
        AnnotationSteps steps = new AnnotationSteps();
        steps.openGithub();
        steps.searchRepository();
        steps.openRepository();
        steps.searchIssue();
    }

    ;
}


