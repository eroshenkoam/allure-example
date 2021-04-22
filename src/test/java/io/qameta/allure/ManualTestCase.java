package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ManualTestCase {

    @Test
    @Manual
    @Story("Add to favorites")
    @Feature("Favorites")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("smoke")})
    @DisplayName("Adding to favorites for authorized user")
    public void addToFavorites() {
        step("Open notes page");
        step("Creating note with content Cool page");
        step("Check note with content Cool page exists");
    }

}
