# ParaBank / Parasoft — Selenium Web Automation Framework

A Gradle-based UI automation framework for the ParaBank (Parasoft) demo application, built with **Selenium WebDriver** and **TestNG**, and wired up with **ExtentReports** for rich, interactive HTML reporting. The suite covers core banking flows: user registration, login, opening a new account, and account overview.

## Tech Stack

| Purpose | Library | Version |
|---|---|---|
| Test framework | `org.testng:testng` | 7.12.0 |
| Browser automation | `org.seleniumhq.selenium:selenium-java` | 4.44.0 |
| Test data generation | `com.thedeanda:lorem` | 2.2 |
| File utilities | `commons-io:commons-io` | 2.15.1 |
| Reporting | `com.aventstack:extentreports` | 5.1.2 |

Build & dependency management is handled by **Gradle**.

## Prerequisites

- JDK 11+ installed and `JAVA_HOME` configured
- Gradle (or use the bundled wrapper `./gradlew`)
- A browser and matching WebDriver (Selenium 4 resolves most drivers automatically via Selenium Manager)

## Project Structure

```
.
├── gradle
├── src
│   └── test
│       ├── java
│       │   └── com.parabank.parasoft
│       │       ├── pages
│       │       │   ├── Page                  // Root page abstraction
│       │       │   ├── BasePage              // Common page behaviour + report helpers
│       │       │   ├── RegisterPage
│       │       │   ├── CustomerLoginPage
│       │       │   ├── OpenNewAccountPage
│       │       │   ├── AccountOpenedPage
│       │       │   └── OverviewPage
│       │       ├── report
│       │       │   ├── ReportManager         // Builds the ExtentReports instance
│       │       │   ├── ReportTestManager     // Thread-safe ExtentTest holder
│       │       │   └── TestListener          // TestNG ITestListener -> ExtentReports
│       │       ├── test
│       │       │   ├── BaseTest              // Driver setup/teardown, getWebDriver()
│       │       │   ├── RegisterTest
│       │       │   ├── CustomLoginTest
│       │       │   └── OpenNewAccountTest
│       │       └── util                      // Helpers / utilities
│       └── resources
│           ├── config.properties             // Environment & run configuration
│           └── regressionSuites.xml          // TestNG suite definition
├── .gitignore
└── build.gradle
```

## Page Objects

The `pages` package follows the Page Object Model. `Page` is the root abstraction and `BasePage` carries shared behaviour (including the ExtentReports logging helpers). The remaining classes map to ParaBank screens:

| Page class | Screen / responsibility |
|---|---|
| `RegisterPage` | New customer registration form |
| `CustomerLoginPage` | Customer login |
| `OpenNewAccountPage` | Open a new account |
| `AccountOpenedPage` | Confirmation after an account is opened |
| `OverviewPage` | Account overview / balances |

## Tests

The `test` package holds the TestNG classes. `BaseTest` handles WebDriver lifecycle and exposes the driver to the framework; each test class extends it:

| Test class | Flow under test |
|---|---|
| `RegisterTest` | Registering a new customer |
| `CustomLoginTest` | Logging in as a customer |
| `OpenNewAccountTest` | Opening a new account |

## Build Configuration

`build.gradle` declares the dependencies and tells Gradle to run tests with TestNG:

```gradle
dependencies {
    // Source: https://mvnrepository.com/artifact/org.testng/testng
    testImplementation 'org.testng:testng:7.12.0'
    // Source: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation 'org.seleniumhq.selenium:selenium-java:4.44.0'
    // dummy text generator
    // https://mvnrepository.com/artifact/com.thedeanda/lorem
    testImplementation 'com.thedeanda:lorem:2.2'
    // FileUtils
    implementation 'commons-io:commons-io:2.15.1'
    // https://mvnrepository.com/artifact/com.aventstack/extentreports
    // Updated ExtentReports version
    testImplementation 'com.aventstack:extentreports:5.1.2'
}

test {
    useTestNG()
}
```

Refresh dependencies after editing:

```bash
./gradlew build --refresh-dependencies
```

## ExtentReports Integration

The reporting wiring lives in the `com.parabank.parasoft.report` package, with logging helpers exposed through the page layer.

### 1. Report classes (`report` package)

- **`ReportManager`** — creates and configures the single `ExtentReports` instance and flushes it at the end of the run.
- **`ReportTestManager`** — thread-safe holder for the current `ExtentTest`, so logs land on the correct test node.
- **`TestListener`** — implements TestNG's `ITestListener` and connects each test's start / success / failure / skip events to ExtentReports.

### 2. Expose the WebDriver from `BaseTest`

`BaseTest` (in the `test` package) provides a getter so the listener can reach the active driver, e.g. for screenshots on failure:

```java
public WebDriver getWebDriver() {
    return driver;
}
```

### 3. Wire up `TestListener`

- Remove any stale `error` package reference from `TestListener`.
- Import `BaseTest` so the listener can call `getWebDriver()`:

```java
import com.parabank.parasoft.test.BaseTest;
```

### 4. Logging helpers in `BasePage`

`BasePage` (in the `pages` package) exposes helpers so any page object can log INFO and FAIL entries into the active report node:

```java
import com.aventstack.extentreports.Status;

public void addInfo(String message) {
    if (ReportTestManager.getTest() != null) {
        ReportTestManager.getTest().log(Status.INFO, message);
    }
}

public void addFailInfo(String message) {
    if (ReportTestManager.getTest() != null) {
        ReportTestManager.getTest().log(Status.FAIL, message);
    }
}
```

## Usage

Log steps from inside your page objects or tests:

```java
addInfo("Navigated to the ParaBank registration page");
addInfo("Submitted the registration form");
addFailInfo("Account overview header was not displayed");
```

Register the listener on a test class (or in `regressionSuites.xml`):

```java
@Listeners(com.parabank.parasoft.report.TestListener.class)
public class CustomLoginTest extends BaseTest {
    // ...
}
```

Or via the suite file:

```xml
<suite name="Regression Suite">
    <listeners>
        <listener class-name="com.parabank.parasoft.report.TestListener"/>
    </listeners>
    <test name="ParaBank Tests">
        <classes>
            <class name="com.parabank.parasoft.test.RegisterTest"/>
            <class name="com.parabank.parasoft.test.CustomLoginTest"/>
            <class name="com.parabank.parasoft.test.OpenNewAccountTest"/>
        </classes>
    </test>
</suite>
```

## Configuration

Runtime settings live in `src/test/resources/config.properties` (e.g. base URL, browser, timeouts). Update these to point at your target environment.

## Running the Tests

```bash
# Run the full suite
./gradlew test

# Run the TestNG suite file explicitly
./gradlew test -PsuiteXmlFile=regressionSuites.xml
```

> The exact suite-file flag depends on how `build.gradle` is configured to consume `regressionSuites.xml`. Adjust to match your setup.

## Viewing the Report

After a run, open the generated ExtentReports HTML file in a browser. The output location is whatever path is set in `ReportManager` — commonly something like:

```
test-output/ExtentReport.html
```

The report includes per-test status, your `addInfo` / `addFailInfo` entries, timestamps, and any screenshots attached on failure.

## Troubleshooting

- **`ReportTestManager.getTest()` returns null** — ensure `TestListener` is registered and creates a test node in `onTestStart`.
- **Report file not generated** — confirm `ReportManager` flushes the report in the listener's `onFinish`.
- **`Status` cannot be resolved** — add `import com.aventstack.extentreports.Status;`.
- **Dependency not found** — re-run with `--refresh-dependencies` and verify Maven Central is reachable.

## License

Add your license here (e.g. MIT).
