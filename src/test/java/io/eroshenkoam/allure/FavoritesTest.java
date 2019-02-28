package io.eroshenkoam.allure;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@Lead("baev")
@Owner("eroshenkoam")
@Feature("Избранное")
public class FavoritesTest {

    private static final String NOTE_TEXT = "Хорошая квартира";

    private final BaseSteps steps = new BaseSteps();

    @BeforeEach
    public void startDriver() {
        steps.startDriver();
    }

    @Test
    @JiraIssue("AE-1")
    @Story("Добавление в избранное")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("smoke")})
    @DisplayName("Добавление в избранное для авторизованного пользователя")
    public void shouldCreateUserNote() {
        steps.openNotesPage();
        steps.createNoteWithText(NOTE_TEXT);
        steps.notesShouldContainsNoteWithText(NOTE_TEXT);
    }

    @Test
    @Tag("web")
    @JiraIssue("AE-2")
    @Story("Удаление из избранного")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Удаление из избранного для авторизованного пользователя")
    public void shouldDeleteUserNote() {
        steps.openNotesPage();
        steps.createNoteWithText(NOTE_TEXT);
        steps.deleteNoteWithText(NOTE_TEXT);
        steps.notesShouldNotContainsNoteWithText(NOTE_TEXT);
    }

    @AfterEach
    public void stopDriver() {
        steps.stopDriver();
    }

}