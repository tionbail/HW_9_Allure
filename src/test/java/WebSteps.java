import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step ("Открываем главную страницу")
    public void  openMainPage () {
        open("https://github.com");
    }

    @Step ("ищем репозиторий {repo}")
    public void searchForRepository (String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step ("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step ("ткрываем таб Issues")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step ("Проверяем наличие Issues с наименованием {issue}")
    public void shouldSeeIssueWithText(String issue) {
        $(withText(issue)).should(Condition.exist);
    }
}
