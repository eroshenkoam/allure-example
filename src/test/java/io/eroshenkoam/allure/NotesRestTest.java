package io.eroshenkoam.allure;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Layer("rest")
@Owner("baev")
@Feature("Notes")
public class NotesRestTest {

    private static final String NOTE_TEXT = "Cool place";

    private final RestSteps steps = new RestSteps();

    @Test
    @Story("Add to favorites")
    @Tags({@Tag("api"), @Tag("smoke")})
    @DisplayName("Creating note via api")
    public void shouldCreateUserNote() {
        steps.createNoteWithText(NOTE_TEXT);
        steps.notesShouldContainsNoteWithText(NOTE_TEXT);
    }

    @Test
    @Story("Delete note")
    @Tags({@Tag("web"), @Tag("regress")})
    @JiraIssues({@JiraIssue("AE-1")})
    @DisplayName("Deleting note via api")
    public void shouldDeleteUserNote() {
        steps.createNoteWithText(NOTE_TEXT);
        steps.deleteNoteWithText(NOTE_TEXT);
    }


}
