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
@Feature("Favorites")
@Page("/user/favorites")
public class FavoritesWebTest {

    private static final String NOTE_TEXT = "Cool place";

    private final WebSteps steps = new WebSteps();

    @BeforeEach
    public void startDriver() {
        steps.startDriver();
    }

    @Test
    @Story("Add to favorites")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("smoke")})
    @JiraIssues({@JiraIssue("AE-1"), @JiraIssue("AE-2")})
    @DisplayName("Adding to favorites for authorized user")
    public void shouldCreateUserNote() {
        steps.openNotesPage();
        steps.createNoteWithText(NOTE_TEXT);
        steps.notesShouldContainsNoteWithText(NOTE_TEXT);
    }

    @Test
    @JiraIssue("AE-2")
    @Story("Remove from favorites")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Removing from favorites for authorized user")
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