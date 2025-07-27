#  API Automation Framework (REST-assured| BDD | Selenium )

This project showcases a **Behavior-Driven Development (BDD)** test automation framework using Java, Selenium WebDriver, Cucumber, and REST-assured to validate both UI and API flows for an e-commerce application.

---

##  Tech Stack

- **Java** (JDK 11+)
- **Maven** (Build tool)
- **Selenium WebDriver** (UI automation)
- **Cucumber (Gherkin)** (BDD syntax for UI tests)
- **REST-assured** (API automation)
- **JUnit/TestNG** (Test runner)
- **Hamcrest** (Assertions)
- **ExtentReports** (Optional - reporting)

---

##  Project Structure
ecommerce-bdd-framework/
├── src/
│ ├── main/
│ └── test/
│ ├── java/
│ │ ├── stepdefinitions/
│ │ ├── runners/
│ │ └── api/
│ └── resources/
│ └── features/
├── pom.xml
└── README.md
## Features Automated

### API Scenarios (via REST-assured)
- **POST** `/verifyLogin` - Login with credentials (positive/negative)
- **GET** `/productsList` - Fetch product list
- **POST** `/productsList` - Add product (mocked)
- **PUT** `/brandsList` - Edit brand/product (mocked)
- **DELETE** `/items/:id` - Delete item (mocked).


###  UI Scenarios (via Selenium + Cucumber)
- Login with valid/invalid credentials
- Create a new item (Add to Cart)
- Edit item quantity in cart
- Delete an item from cart
- Assert the presence of items in cart
## How to Run Tests

### Prerequisites:
- JDK 11+
- Maven installed
- ChromeWebDriver Manager

### Run All UI Tests
```bash
mvn test -Dcucumber.options="--tags @ui"
Test Runner Class
Reporting
Cucumber HTML reports generated in target/cucumber-reports

 Continuous Integration
This framework can be easily integrated into:

GitHub Actions

Jenkins

Test Data
All test data (e.g., credentials, product names) can be managed in .properties or .json files within src/test/resources.

 Why BDD?
Improves communication between QA, Dev, and Business teams

Easy-to-read Gherkin syntax enables better test coverage

Scalable for adding more complex scenarios

Author
Sheyi Odeleye
QA Automation Engineer | Selenium + REST-assured + BDD
