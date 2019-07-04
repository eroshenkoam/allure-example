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
@Layer("web")
@Owner("eroshenkoam")
@Feature("Notes")
@Page("/user/notes")
public class NotesWebTest {

    private static final String NOTE_TEXT = "Cool place";

    private final WebSteps steps = new WebSteps();

    @BeforeEach
    public void startDriver() {
        steps.startDriver();
    }

    @Test
    @Story("Creating note")
    @JiraIssues({@JiraIssue("AE-2")})
    @Tags({@Tag("web"), @Tag("critical"), @Tag("smoke"), @Tag("regress")})
    @DisplayName("Creating note for authorized user")
    public void shouldCreateUserNote() {
        steps.openNotesPage();
        steps.createNoteWithText(NOTE_TEXT);
        steps.notesShouldContainsNoteWithText(NOTE_TEXT);
    }

    @Test
    @Story("Creating note")
    @Tags({@Tag("web"), @Tag("regress")})
    @JiraIssues({@JiraIssue("AE-1")})
    @DisplayName("Adding note to advertisement")
    public void shouldAddNoteToTheAd() {
        final Long id = 12971230L;

        steps.openAdPage(id);
        steps.addNoteToAdd(NOTE_TEXT);
        steps.openNotesPage();
        steps.notesShouldContainsNoteWithText(NOTE_TEXT);
    }

    @Test
    @Story("Delete note")
    @Tags({@Tag("web"), @Tag("regress")})
    @JiraIssues({@JiraIssue("AE-1")})
    @DisplayName("Deleting note for authorized user")
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