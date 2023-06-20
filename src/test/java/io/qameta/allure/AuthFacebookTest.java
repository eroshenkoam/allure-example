package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AuthFacebookTest {

    @Test
    @AllureId("1107")
    @DisplayName("Авторизация через Facebook")
    @Story("Авторизация через внешние системы")
    @Owner("artem.eroshenko@qameta.io")
    @Feature("Авторизация")
    public void testFacebook() {
        step("Открываем главную страницу");
        step("Выбираем способ авторизации через Facebook");
        step("Авторизуемся как пользвоатель Mr. Random", () -> {
            step("Вводим логин random-user@random.org");
            step("Вводим пароль 'random-pass'");
            step("Нажимаем кнопку Войти");
        });
        step("Проверяем что авторизовались правильно", () -> {
            step("Имя пользователя Mr. Random");
            step("Email пользователя random-user@random.org");
            step("Аватарку");
        });
    }

}
