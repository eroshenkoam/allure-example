package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("Auth")
@Story("External Auth")
@Owner("artem.eroshenko@qameta.io")
public class AuthTest {

    @Test
    @Tag("web")
    @AllureId("6633")
    @DisplayName("Авторизация через Яндекс")
    public void testYandex() {
        step("Открываем главную страницу");
        step("Авторизация через Яндекс", () -> {
            step("Нажимаем кнопку Log In");
            step("Выбираем способ авторизации через Яндекс");
            step("Вводим логин random-user@yandex.ru");
            step("Вводим пароль `random-pass`");
            step("Нажимаем кнопку Войти");
        });
        step("Проверяем что данные пользователя обновились из Яндекса", () -> {
            step("Expected Result", () -> {
                step("Name = `Mr. Random`");
                step("Username = `mr-random`");
                step("Email = `random-user`@yandex.ru");
            });
        });
    }

}
