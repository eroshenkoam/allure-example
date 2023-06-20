package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AuthAppleTest {

    @Test
    @AllureId("1108")
    @DisplayName("Авторизация через Apple")
    @Story("Авторизация через внешние системы")
    @Owner("artem.eroshenko@qameta.io")
    @Feature("Авторизация")
    public void testSomething() {
        step("Открываем главную страницу");
        step("Авторизуемся как пользвоатель Artem Eroshenko", () -> {
            step("Вводим логин eroshenkoam@gmail.com");
            step("Вводим пароль 1239812938123");
            step("Нажимаем кнопку Войти");
        });
        step("Проверяем что авторизовались правильно", () -> {
            step("Имя пользователя Artem Eroshenko");
            step("Email пользователя eroshenkoam@gmail.com");
            step("Аватарку");
        });
    }

}
