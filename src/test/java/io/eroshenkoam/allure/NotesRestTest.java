package io.eroshenkoam.allure;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.parameter;

@Layer("rest")
@Owner("baev")
@Feature("Notes")
public class NotesRestTest {

    private final RestSteps steps = new RestSteps();

    @Story("Creating note")
    @Tags({@Tag("api"), @Tag("smoke")})
    @ParameterizedTest(name = "Creating note via api")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldCreateUserNote(String text) {
        parameter("note", text);
        steps.createNoteWithText(text);
        steps.notesShouldContainsNoteWithText(text);
    }

    @Story("Delete note")
    @Tags({@Tag("web"), @Tag("regress")})
    @JiraIssues({@JiraIssue("AE-1")})
    @ParameterizedTest(name = "Deleting note via api")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldDeleteUserNote(String text) {
        parameter("note", text);
        steps.createNoteWithText(text);
        steps.deleteNoteWithText(text);
    }


}
