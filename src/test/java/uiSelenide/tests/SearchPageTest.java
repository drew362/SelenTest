package uiSelenide.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uiSelenide.BaseTest;
import uiSelenide.pages.SearchPage;

import static com.codeborne.selenide.Condition.text;

public class SearchPageTest extends BaseTest {

    SearchPage searchPage = new SearchPage();

    @Feature("Поиск")
    @Test
    @DisplayName("Отображение элементов страницы")
    public void allThingsOnPageIsVisible() {
        Selenide.open("http://localhost:8086/search");
        searchPage.textField.shouldBe(Condition.visible);
        searchPage.searchButton.shouldBe(Condition.visible);
    }

    @Feature("Поиск")
    @Test
    @DisplayName("Проверка поиска по номеру креста")
    @Story("This is a Fail Story.")
    @Description("This is a Fail Story Description.")
    public void checkRezultInFieldText() {
        Selenide.open("http://localhost:8086/search");
        searchPage.textField.setValue("200151");
        searchPage.searchButton.click();
        searchPage.resultSearch.shouldHave(text("КЛОПКОВ Петр"));
        Selenide.sleep(2000);
    }
}