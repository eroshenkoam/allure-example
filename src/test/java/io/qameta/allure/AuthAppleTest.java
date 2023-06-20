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
        step("Выбираем способ авторизации Apple");
        step("Авторизуемся как пользвоатель Mr. Random", () -> {
            step("Вводим логин random-user@random.org");
            step("Вводим пароль 1239812938123");
            step("Нажимаем кнопку Войти");
        });
        step("Проверяем что авторизовались правильно", () -> {
            step("Имя пользователя Mr. Random");
            step("Email пользователя random-user@random.org");
            step("Аватарку");
        });
    }

}
