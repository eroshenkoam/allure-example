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
        step("Авторизуемся как пользвоатель Artem Eroshenko", () -> {
            step("Вводим логин random-user@mail.ru");
            step("Вводим пароль 1231287318273");
            step("Нажимаем кнопку Войти");
        });
        step("Проверяем что авторизовались правильно", () -> {
            step("Имя пользователя Artem Eroshenko");
            step("Email пользователя eroshenkoam@gmail.com");
            step("Аватарку");
        });
    }

}
