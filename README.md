# Selenium Hybrid Driven Framework with Java and TestNG
This project uses Selenium for web automation and testing. Below are the instructions on how to set up and run the project.

## Overview
This repository contains a Selenium-based test automation framework built using Java and TestNG. It follows a hybrid-driven approach, combining both Data-Driven and Keyword-Driven methodologies to ensure comprehensive test coverage and flexibility. The framework is designed to facilitate automated functional testing of web applications, promoting maintainable and reusable test scripts.

## Features
- **Hybrid Driven Approach:** Integrates Data-Driven and Keyword-Driven testing methodologies.
- **TestNG Integration:** Uses TestNG for managing and executing test cases.
- **Page Object Model (POM):** Employs POM to enhance the maintainability and readability of test scripts.
- **Reusable Keywords:** Implements reusable keywords for common test actions.
- **Data-Driven Testing:** Supports external data sources such as Excel for data-driven testing.
- **Reporting:** Generates detailed test reports using TestNG.

## Setup Instructions

### Prerequisites
- Java JDK 8 or higher
- Apache Maven
- An IDE (Eclipse, IntelliJ IDEA, etc.)

### Installation
1. **Clone the repository:**
    ```sh
    git clone https://github.com/PoojaJadhavOfficial/SeleniumFrameWork.git
    ```
2. **Navigate to the project directory:**
    ```sh
    cd SeleniumFrameWork
    ```
3. **Install dependencies:**
    ```sh
    mvn clean install
    ```

### Configuration
1. **WebDriver Configuration:**
   - Set the WebDriver executable path in config.properties file.
   - Example for ChromeDriver:
     ```java
     System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
     ```
2. **Test Data Configuration:**
   - Store your test data in an Excel file located in the `resources` folder.
   - Update the file path in `XLUtil.java`:
     ```java
     String excelFilePath = "src/main/TestData/LoginData.xlsx";
     ```

## Running Tests
- **From the Command Line:**
  ```sh
  mvn test
  ```
- **From an IDE:**
  - Right-click on the test class or method and select `Run As -> TestNG Test`.

## Test Structure

### BaseClass
`BaseTest.java` includes the setup and teardown methods executed before and after each test. It initializes the WebDriver and loads the base URL.

### Page Object Classes
Page classes (e.g., `LoginPage_PO.java`, `AddCustomerPage.java`) represent different web application pages. Each class contains methods for interacting with page elements.

### Test Classes
Test classes (e.g., `LoginTest.java`) contain the actual test methods. Each method uses page class methods and keywords to perform actions and verify results.

### Utilities
Utility classes (e.g., `XLUtil.java`, `ReadConfig.java`) provide common functions like reading from Excel files and WebDriver setup.

## Reporting
TestNG generates detailed HTML reports by default. After executing tests, the reports can be found in the `test-output` directory.
After executing tests, Extent Reports generates a detailed HTML report. The report can be found in the 'test-output' directory.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure that your code adheres to the existing style and includes appropriate tests.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For any questions or issues, please open an issue on the repository or contact Pooja Jadhav at [poojajadhavofficial11@gmail.com].

---
