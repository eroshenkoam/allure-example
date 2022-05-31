package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("Auth")
@Owner("eroshenkoam")
@Microservice("Auth")
@Story("External Auth")
public class GoogleTest {

    @Test
    @Manual
    @AllureId("1528")
    @JiraIssue("AE-1")
    @DisplayName("Авторизация через Google")
    @Tags({@Tag("regress"), @Tag("api")})
    public void testAuth() {
        step("Открываем главную страницу");
        step("Атворизуемся как пользователь `Mr. Random`", () -> {
            step("Вводим логин `random-user`");
            step("Вводим пароль `random-pass`");
            step("Нажимаем кнопку Войти");
        });
        step("Проверяем что авторизовались правильно", () -> {
            step("Логин `random-user`");
        });
    }

}
