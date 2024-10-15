# Quarantine

## Create new issue

### Meta

| Attribute | Value                                  |
|-----------|----------------------------------------|
| FullName  | package.IssuesWebTest.shouldCloseIssue |
| Date      | 10/15/2024 17:06:15                    |
| Duration  | 1m 037ms                               |
| Status    | Failed                                 |

### Error

```
Element not found {By.xpath: [//div[@class='something']]}
Expected: visible or transparent: visible or have css value opacity=0
Screenshot: file:/Users/eroshenkoam/Developer/eroshenkoam/webdriver-coverage-example/build/reports/tests/1603973516437.0.png
Page source: file:/Users/eroshenkoam/Developer/eroshenkoam/webdriver-coverage-example/build/reports/tests/1603973516437.0.html
Timeout: 4 s.
```

### Scenario

 - ✅ Open issues page `allure-framework/allure2`
 - ❌ Create issue with title `Some issue title here`
