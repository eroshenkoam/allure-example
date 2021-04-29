package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SimpleManualCase {

    @Test
    @Manual
    @Feature("Избранное")
    @Story("Добавление товара в избранное")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("smoke")})
    @DisplayName("Добавление товара в избранное для авторизованного пользователя")
    public void addToFavorites() {
        step("Открываем главную страницу");
        step("Переходим в список товаров");
        step("Добавляем произвольный товар в избранное");
        step("Переходим в профиль пользователя");
        step("Открываем страницу избранные товары");
        step("Проверяем что выбранные товар находится в избранном");
    }

}
