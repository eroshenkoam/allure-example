package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("Auth")
@Story("External Auth")
@Owner("artem.eroshenko@qameta.io")
public class AuthTest {

    @Test
    @AllureId("5284")
    @DisplayName("Деавторизция через Яндекс")
    public void testYandex() {
        step("Открываем главную страницу");
        step("Авторизуемся через Яндекс", () -> {
            step("Нажиманем кнопку Войти");
            step("Выбираем авторизацию Яндекс");
            step("Вводим логин random-user@yandex.ru");
            step("Вводим пароль random-pass");
            step("Нажимаем кнопку Войти");
        });
        step("Проверяем что авторизовались");
        step("Разлогиниваемся");
        step("Проверяем что видим форму авторизации");
    }

}
