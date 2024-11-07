package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Owner("eroshenkoam")
@Feature("Auth")
@Story("External Auth")
public class AuthTest {

    @Test
    @AllureId("10799")
    @DisplayName("Авторизация через Одноклассники")
    public void testOdnoklassniki() {
        step("Открываем главную страницу");
        step("Авторизуемся через Яндекс", () -> {
            step("Вводим логин ranadom-user@yandex.ru");
            step("Вводим пароль random-pass");
            step("Нажимаем кнопку Войти");
        });
        step("Проверяем что авторизовались");
        step("Проверяем что данные пользователя обновиилсь из Яндекс", () -> {
            step("Expected Result", () -> {
                step("Имя = Mr. Random");
                step("Email = random-user@yandex.ru");
            });
        });
    }

    @Test
    @AllureId("10797")
    @DisplayName("Авторизация через Yandex")
    @Story("External Auth")
    @Owner("eroshenkoam")
    @Feature("Auth")
    public void testYandex() {
        step("Открвааем главную страницу");
        step("Авторизация через Яндекс", () -> {
            step("Вводим логин eroshenkoam@yandex.ru");
            step("Вводим пароль 1239812983123");
            step("Нажимаем кнопку Войти");
        });
        step("Проверяем что авторизовались");
        step("Проверяем что данные пользователя обновиилсь из Яндекс", () -> {
            step("Expected Result", () -> {
                step("Имя = Artem Eroshenko");
                step("Email = eroshenkoam@yandex.ru");
            });
        });
    }

}
