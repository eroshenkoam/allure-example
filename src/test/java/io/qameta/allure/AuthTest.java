package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("Auth")
@Story("External AUth")
@Owner("artem.eroshenko@qameta.io")
public class AuthTest {

    @Test
    @AllureId("6876")
    @DisplayName("Авторизация через Apple")
    public void testApple() {
        step("Открываем главную страницу");
        step("Авторизация через Google", () -> {
            step("Выбираем способ авторизации через Google");
            step("Вводим логин `random-user@gmail.com`");
            step("Вводим пароль `random-pass`");
            step("Нажимаем кноппку Войти");
        });
        step("Проверяем что авторизовались", () -> {
            step("Expected Result", () -> {
                step("В нижнем левом углу есть иконка пользователя");
            });
        });
        step("Проверяем что данные обновились из Google", () -> {
            step("Expected Result", () -> {
                step("Username = `mr.randon`");
                step("Email = `random-user@gmail.com`");
                step("Name = `Mr. Random`");
            });
        });
    }

    @Test
    @AllureId("6877")
    @DisplayName("Авторизация через Mircrosoft")
    public void testMicrosoft() {
        step("Открываем главную страницу");
        step("Авторизация через Google", () -> {
            step("Выбираем способ авторизации через Google");
            step("Вводим логин eroshenkoam@gmail.com");
            step("Вводим пароль 1239812391283");
            step("Нажимаем кноппку Войти");
        });
        step("Проверяем что авторизовались", () -> {
            step("Expected Result", () -> {
                step("Проверяем А");
                step("В нижнем левом углу есть иконка пользователя");
            });
        });
        step("Проверяем что данные обновились из Google", () -> {
            step("Expected Result", () -> {
                step("Username = eroshenkoam");
                step("Email = eroshenkoam@gmail.com");
                step("Name = Artem Eroshenko");
            });
        });
    }

}
