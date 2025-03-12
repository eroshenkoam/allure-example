package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AuthTest {

    @Test
    @AllureId("32975")
    @DisplayName("Пользователь можно авторизоваться в системе через Гугол")
    @Owner("eroshenkoam")
    @Features({
        @Feature("Авторизация"),
    })
    @Stories({
        @Story("Пользователь должен иметь возможность авторизоваться через SSO"),
    })
    public void shouldTest() {
        Allure.label("tag", "to_automate");
        step("Открываем главную страницу");
        sharedStep334();
        step("Проверяем что попали на главную страницу приложения");
        step("Перходим в профиль пользователя", () -> {
            step("В правом верхнем углу нажимаем на иконку пользователя");
            step("Нажимем на кнопку профиль");
        });
        step("Проверяем что данные профиля обновились из Гугла", () -> {
            step("Attachment [2028]");
            step("Имя пользователя Artem Eroshenko");
            step("Эд. почта пользователя eroshenkoam@qatools.ru");
        });
    }

    @Step("Авторизация нового пользователя")
    public void sharedStep334() {
        step("Нажимаем кнопку Войти");
        step("Заполняем капчу");
        step("Выбираем тип авторизации Яндекс");
        step("Вводим логин eroshenkoam@qatools.ru");
        step("Вводим пароль 123123123123");
        step("Нажимаем кнопку Авторизоваться");
    }

}