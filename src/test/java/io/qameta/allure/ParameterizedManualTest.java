package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParameterizedManualTest {

    static Stream<Arguments> regions() {
        return Stream.of(
                arguments("Москва"),
                arguments("Санкт-Петербург")
        );
    }

    @Manual
    @Feature("Регионы")
    @DisplayName("Проверка товара")
    @Story("Главная страница в регионах")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("smoke")})
    @ParameterizedTest(name = "{displayName} в регионе `{0}`")
    @MethodSource("regions")
    public void addToFavorites(final String city) {
        step("Открываем сайт в регионе: " + city);
        step("Проверяем что регион опеделился как: " + city);
        step("Проверяем что на главной странице региональные товары", () -> {
            step("Проверяем что блок рекламы для региона: " + city);
            step("Проверяем что блок лучшие товары для региона: " + city);
        });
    }

}
