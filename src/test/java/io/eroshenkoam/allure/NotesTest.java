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
@Feature("Заметки")
public class NotesTest {

    private static final String NOTE_TEXT = "Хорошая квартира";

    private final BaseSteps steps = new BaseSteps();

    @BeforeEach
    public void startDriver() {
        steps.startDriver();
    }

    @Test
    @Tag("web")
    @Story("Создание заметки")
    @Tags({@Tag("web"), @Tag("critical"), @Tag("smoke"), @Tag("regress")})
    @DisplayName("Создание заметки для авторизованного пользователя")
    public void shouldCreateUserNote() {
        steps.openNotesPage();
        steps.createNoteWithText(NOTE_TEXT);
        steps.notesShouldContainsNoteWithText(NOTE_TEXT);
    }

    @Test
    @Tag("web")
    @Story("Создание заметки")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Добавление заметки к существующему объявлению")
    public void shouldAddNoteToTheAd() {
        final Long id = 12971230L;

        steps.openAdPage(id);
        steps.addNoteToAdd(NOTE_TEXT);
        steps.openNotesPage();
        steps.notesShouldContainsNoteWithText(NOTE_TEXT);
    }

    @Test
    @Tag("web")
    @Story("Удаление заметки")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Удаление заметки для авторизованного пользователя")
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