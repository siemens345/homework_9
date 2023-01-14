package gitHubTest;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class AnnotationSteps {
    @Step("Открываем github")
    public void openGithub() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий selenide")
    public void searchRepository() {
        $(".js-site-search-focus").setValue("selenide").pressEnter();
    }

    @Step("Переходим в репозиторий selenide")
    public void openRepository() {
        $$(".v-align-middle").get(8).click();
    }

    @Step("Переходим на страницу issue и ищем название 'Provide more information when a file download fails'")
    public void searchIssue() {
        $("#issues-tab").click();
        $("#issue_2113_link").shouldHave(Condition.text("Provide more information when a file download fails"));
    }

}
