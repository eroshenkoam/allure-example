package io.eroshenkoam.allure;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Random;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class WebSteps {

    @Step("Starting web driver")
    public void startDriver() {
        if (new Random().nextBoolean() && new Random().nextBoolean()) {
            throw new RuntimeException("Selenium timeout: selenium unavailable now");
        }
    }

    @Step("Stopping web driver")
    public void stopDriver() {
    }

    @Step("Open notes page")
    public void openNotesPage() {
        attachPageSource();
    }

    @Step("Creating note with content `{text}`")
    public void createNoteWithText(final String text) {
    }

    @Step("Delete note with content `{text}`")
    public void deleteNoteWithText(final String text) {
    }

    @Step("Check note with content `{text}` exists")
    public void notesShouldContainsNoteWithText(final String text) {

    }

    @Step("Check note with `{text}` not exists")
    public void notesShouldNotContainsNoteWithText(final String text) {

    }

    @Step("Open advertisement page `{id}`")
    public void openAdPage(final Long id) {
    }

    @Step("Add note with content `{text}` to advertisement")
    public void addNoteToAdd(final String text) {
    }

    @Attachment(value = "Page", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        try {
            final InputStream stream = ClassLoader.getSystemResourceAsStream("index.html");
            return IOUtils.toString(stream, Charset.forName("UTF-8")).getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
