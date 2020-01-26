package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class SutTest {

    @Test
    @DisplayName("Should submit request")
    void shouldSubmitRequest() {
        open("http;//localhost:9999");
        SelenideElement form = $("form form_size_m form_theme_alfa-on-white");
        form.$("[data-test-id=name] input").setValue("Александр Петров");
        form.$("[data-test-id=phone] input").setValue("+79051112233");
        form.$("[data-test-id=agreement]").click();
        form.$("button button_view_extra button_size_m button_theme_alfa-on-white").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена!"));
    }

}
