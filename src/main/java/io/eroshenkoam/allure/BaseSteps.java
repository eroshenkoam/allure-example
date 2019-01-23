package io.eroshenkoam.allure;

import io.qameta.allure.Step;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class BaseSteps {

    @Step("Стартуем драйвер")
    public void startDriver() {
    }

    @Step("Останавливаем драйвер")
    public void stopDriver() {
    }

    @Step("Открываем страницу заметок")
    public void openNotesPage() {
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

}
