package io.eroshenkoam.allure;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class WebSteps {

    @Step("Starting web driver")
    public void startDriver() {
        maybeThrowSeleniumTimeoutException();
    }

    @Step("Stopping web driver")
    public void stopDriver() {
        maybeThrowSeleniumTimeoutException();
    }

    @Step("Open notes page")
    public void openNotesPage() {
        attachPageSource();
        maybeThrowElementNotFoundException();
    }

    @Step("Creating note with content `{text}`")
    public void createNoteWithText(final String text) {
        maybeThrowElementNotFoundException();
    }

    @Step("Delete note with content `{text}`")
    public void deleteNoteWithText(final String text) {
        maybeThrowAssertionException(text);
    }

    @Step("Check note with content `{text}` exists")
    public void notesShouldContainsNoteWithText(final String text) {
        maybeThrowAssertionException(text);
    }

    @Step("Check note with `{text}` not exists")
    public void notesShouldNotContainsNoteWithText(final String text) {
        maybeThrowAssertionException(text);

    }

    @Step("Open advertisement page `{id}`")
    public void openAdPage(final Long id) {
        maybeThrowElementNotFoundException();
    }

    @Step("Add note with content `{text}` to advertisement")
    public void addNoteToAdd(final String text) {
        maybeThrowElementNotFoundException();
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

    private void maybeThrowSeleniumTimeoutException() {
        if (isTimeToThrowException()) {
            throw new RuntimeException("Selenium timeout: selenium unavailable now");
        }
    }

    private void maybeThrowElementNotFoundException() {
        if (isTimeToThrowException()) {
            throw new RuntimeException("Element not found for xpath [//div[@class='something']]");
        }
    }

    private void maybeThrowAssertionException(String text) {
        if (isTimeToThrowException()) {
            assertEquals(text, "another text");
        }
    }

    private boolean isTimeToThrowException() {
        return new Random().nextBoolean()
                && new Random().nextBoolean()
                && new Random().nextBoolean()
                && new Random().nextBoolean();
    }
}
