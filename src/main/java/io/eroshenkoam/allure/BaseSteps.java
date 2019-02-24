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
public class BaseSteps {

    @Step("Стартуем драйвер")
    public void startDriver() {
        if (new Random().nextBoolean() && new Random().nextBoolean()) {
            throw new RuntimeException("Selenium timeout: selenium unavailable now");
        }
    }

    @Step("Останавливаем драйвер")
    public void stopDriver() {
    }

    @Step("Открываем страницу заметок")
    public void openNotesPage() {
        attachPageSource();
    }

    @Step("Создаем заметку с текстом `{text}`")
    public void createNoteWithText(final String text) {
    }

    @Step("Удаляем заметку с текстом `{text}`")
    public void deleteNoteWithText(final String text) {
    }

    @Step("Проверяем наличие заметки с текстом `{text}` в списке заметок")
    public void notesShouldContainsNoteWithText(final String text) {

    }

    @Step("Проверяем отсутствие заметки с текстом `{text}` в списке заметок")
    public void notesShouldNotContainsNoteWithText(final String text) {

    }

    @Step("Открываем страницу объявления `{id}`")
    public void openAdPage(final Long id) {
    }

    @Step("Добавляем заметку с текстом `{text}` к объявлению")
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
