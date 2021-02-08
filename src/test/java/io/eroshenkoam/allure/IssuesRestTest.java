package io.eroshenkoam.allure;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.parameter;

@Layer("rest")
@TA("baev")
@QA("eroshenkoam")
@Feature("Issues")
public class IssuesRestTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private final RestSteps steps = new RestSteps();

    @TM4J("AE-T1")
    @Story("Create new issue")
    @Microservice("Billing")
    @Tags({@Tag("api"), @Tag("smoke")})
    @ParameterizedTest(name = "Create issue via api")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldCreateUserNote(String title) {
        parameter("owner", OWNER);
        parameter("repo", REPO);
        parameter("title", title);

        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.shouldSeeIssueWithTitle(OWNER, REPO, title);
    }

    @TM4J("AE-T2")
    @Story("Close existing issue")
    @Microservice("Repository")
    @Tags({@Tag("web"), @Tag("regress")})
    @JiraIssues({@JiraIssue("QC3-2")})
    @ParameterizedTest(name = "Close issue via api")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldDeleteUserNote(String title) {
        parameter("owner", OWNER);
        parameter("repo", REPO);
        parameter("title", title);

        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.closeIssueWithTitle(OWNER, REPO, title);
    }


}
