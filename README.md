# 🛒 OpenCart Automation Framework

A scalable Selenium Test Automation Framework developed for the OpenCart E-commerce application using Java, TestNG, Maven, and the Page Object Model (POM). The framework supports data-driven testing, cross-browser execution, parallel execution, logging, reporting, and CI integration with Jenkins.

---

## 📌 Features

- Page Object Model (POM) Design Pattern
- Selenium WebDriver with Java
- TestNG Framework
- Maven Build Management
- Data-Driven Testing using Apache POI (Excel)
- Cross Browser Execution (Chrome, Edge, Firefox)
- Parallel Test Execution
- Log4j2 Logging
- Extent Reports
- Screenshot Capture on Test Failure
- Jenkins CI Integration
- Reusable Utility Classes
- Configurable Environment using Properties File

---

## 🛠 Tech Stack

| Technology | Version |
|------------|---------|
| Java | 17+ |
| Selenium WebDriver | 4.x |
| TestNG | 7.x |
| Maven | 3.x |
| Apache POI | 5.x |
| Log4j2 | 2.x |
| Extent Reports | Latest |
| Jenkins | Latest |
| Git | Latest |

---

## 📂 Project Structure

```
OpenCartAutomationFramework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.opencart
│   │   │       ├── base
│   │   │       ├── constants
│   │   │       ├── factory
│   │   │       ├── listeners
│   │   │       ├── pages
│   │   │       └── utilities
│   │   │
│   │   └── resources
│   │       ├── config.properties
│   │       ├── log4j2.xml
│   │       └── testdata.xlsx
│   │
│   └── test
│       └── java
│           └── com.opencart
│               ├── base
│               └── testcases
│
├── screenshots
├── Reports
├── logs
├── testng.xml
├── testng_crossbrowser.xml
├── testng_parallel.xml
└── pom.xml
```

---

## ✅ Automated Test Scenarios

- User Registration
- Valid Login
- Invalid Login
- Logout
- Product Search
- Add Product to Wishlist
- Remove Product from Wishlist
- Add Product to Cart
- Data-Driven Login using Excel

---

## ▶️ Running the Tests

### Clone Repository

```bash
git clone https://github.com/<your-username>/OpenCartAutomationFramework.git
```

### Navigate to Project

```bash
cd OpenCartAutomationFramework
```

### Execute All Tests

```bash
mvn clean test
```

### Execute Cross Browser Suite

```bash
mvn clean test -DsuiteXmlFile=testng_crossbrowser.xml
```

### Execute Parallel Suite

```bash
mvn clean test -DsuiteXmlFile=testng_parallel.xml
```

---

## 📊 Reports

After execution:

- Extent Report
- TestNG Report
- Console Logs
- Screenshots (Captured on Failure)

---

## 🔄 CI/CD

The framework supports Continuous Integration using Jenkins.

Configured Features:

- Maven Build
- Test Execution
- HTML Reports
- Console Logs

---

## 💡 Framework Highlights

- Modular and Scalable Design
- Easy Maintenance
- Reusable Components
- Clean Code Architecture
- Suitable for Enterprise Automation Projects

---

## 📚 Design Patterns Used

- Page Object Model (POM)
- Factory Design Pattern
- Utility Pattern

---

## 👩‍💻 Author

**Renuka Chowdary**

GitHub: https://github.com/<your-username>

---

## ⭐ Future Enhancements

- Docker Integration
- GitHub Actions CI/CD
- Selenium Grid
- Allure Reports
- Database Validation
- API Integration
- Email Report Automation

---

If you found this project helpful, please consider giving it a ⭐ on GitHub.