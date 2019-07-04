package io.eroshenkoam.allure;

import io.qameta.allure.Step;

import static io.qameta.allure.Allure.step;

public class RestSteps {

    @Step("Creating note with content `{text}`")
    public void createNoteWithText(final String text) {
        step("POST /api/notes");
    }

    @Step("Delete note with content `{text}`")
    public void deleteNoteWithText(final String text) {
        step("GET /api/notes?text=" + text);
        step("DELETE /api/notes/237");
    }

    @Step("Check note with content `{text}` exists")
    public void notesShouldContainsNoteWithText(final String text) {
        step("GET /api/notes?text=" + text);
        step("GET /api/notes/834");
    }

}
