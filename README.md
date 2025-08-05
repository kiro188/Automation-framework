# Automation Testing Framework (Cucumber + POM + Selenium)

## 📌 Overview
This project is a **Cucumber-based BDD test automation framework** implementing the **Page Object Model (POM)** design pattern. It supports **UI and API testing**, is highly maintainable, and demonstrates best practices for interviews.

---

## ✅ Features
- BDD with **Cucumber & Gherkin**
- **Page Object Model** for maintainability
- Cross-browser support (**Chrome, Firefox**)
- **Parallel execution** with TestNG/JUnit
- **Data-driven tests** (JSON, Excel)
- **Environment configuration** (dev, qa)
- API testing with **RestAssured**
- **Detailed Reports**: Allure / ExtentReports
- CI/CD ready (**GitHub Actions**, Jenkins)
- Logging with **SLF4J + Logback**

---

## ✅ Tech Stack
- **Language:** Java 17+
- **Test Framework:** Cucumber-JVM, TestNG/JUnit
- **Automation:** Selenium WebDriver
- **API Testing:** RestAssured
- **Build Tool:** Maven
- **Reports:** Allure / ExtentReports
- **Logging:** SLF4J + Logback
- **DI:** PicoContainer

---

## ✅ Project Structure
automation-project/
├── src/main/java/
│ ├── base/ # WebDriver init, TestBase
│ ├── pages/ # Page Objects
│ ├── utils/ # Helpers: Wait, Logger, Config
│ └── managers/ # Driver & PageObject managers
├── src/test/java/
│ ├── stepDefinitions/ # Step defs + Hooks
│ ├── runners/ # Test runners
│ └── features/ # Gherkin scenarios
├── src/test/resources/
│ ├── configs/ # Environment configs
│ └── testdata/ # Test data
├── pom.xml
└── README.md

---

## ✅ Setup
### **1. Prerequisites**
- Java 17+
- Maven 3.8+
- Chrome / Firefox browsers
- Allure CLI (for report generation)

### **2. Clone the repo**
```bash
git clone https://github.com/kiro188/automation-framework.git
cd automation-framework