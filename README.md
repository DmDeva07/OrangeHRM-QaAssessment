Absolutely, Deva 🔥
Here’s your **perfectly tailored, polished, and recruiter-ready GitHub README** — formatted cleanly for markdown, with consistent tone, spacing, and a professional finish while keeping your personal credits and assessment context.

---

# 🎓 OrangeHRM QA Automation Framework — *User Management Activities (Selenium + Java)*

### 👤 Author : **Mahadevan D (QA Test Engineer)**

### 🧩 Challenge : **AccuKnox - QA Trainee Practical Assessment**

### 🌐 Platform : [OrangeHRM Demo Site](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)

---

![Project Banner](https://via.placeholder.com/1200x300?text=OrangeHRM+Automation+Framework+%7C+Selenium+%7C+TestNG+%7C+Java)

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-blue?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Selenium-4.16.1-brightgreen?style=for-the-badge&logo=selenium" />
  <img src="https://img.shields.io/badge/TestNG-7.9.0-orange?style=for-the-badge&logo=testng" />
  <img src="https://img.shields.io/badge/Maven-Build%20Tool-red?style=for-the-badge&logo=apache-maven" />
  <img src="https://img.shields.io/badge/ExtentReports-5.0.9-purple?style=for-the-badge" />
</p>

---

## 📌 Project Overview

The **OrangeHRM QA Automation Framework** automates the **User Management module** of OrangeHRM using **Selenium WebDriver**, **TestNG**, and the **Page Object Model (POM)** design pattern.

It validates key administrative workflows — **adding**, **searching**, **editing**, **validating**, and **deleting users** — ensuring accurate and reliable functionality across multiple user roles.

---

## 🔄 Workflow Explanation

1. Login to OrangeHRM
2. Navigate to **Admin → User Management**
3. Add a new user using data from Excel
4. Search for the newly added user
5. Edit user details (role, status, etc.)
6. Validate that updates reflect correctly
7. Delete the user and confirm successful removal

Each flow is modularized through **POM**, ensuring reusability, maintainability, and scalability.

---

## 🧰 Technology & Tools Used

| Tool/Library       | Version | Purpose                         |
| ------------------ | ------- | ------------------------------- |
| Java               | 17+     | Programming language            |
| Selenium WebDriver | 4.16.1  | Browser automation              |
| TestNG             | 7.9.0   | Test execution framework        |
| WebDriverManager   | 5.6.3   | Driver management               |
| ExtentReports      | 5.0.9   | HTML reporting                  |
| Apache POI         | 5.2.3   | Excel data handling             |
| Maven              | Latest  | Build and dependency management |

---

## 📦 Framework Structure

### 🧩 Packages

* **base** → `BaseTest.java` — Handles browser setup, teardown, and report initialization
* **pages** → `LoginPage.java`, `UserFormPage.java` — Defines UI elements and actions
* **utils** → `ExtentManager.java`, `TestDataReader.java`, `WaitHelper.java` — Utility classes for waits, reporting, and data handling
* **tests** → `LoginTest.java`, `AddUserTest.java`, `ValidateActivities.java` — Contains test scripts

### 📁 Folders

* **driver/** → Contains `chromedriver.exe`
* **testdata/** → Contains `UserData.xlsx` for data-driven tests
* **test-output/** → ExtentReports, logs, and screenshots

---

## ⚙️ 1. Project Setup Steps

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/OrangeHRM-QA-Assessment.git
   cd OrangeHRM-QA-Assessment
   ```

2. **Import into IDE**

   * Open in **IntelliJ IDEA** or **Eclipse** as a **Maven Project**

3. **Install Dependencies**

   * Maven automatically downloads dependencies from `pom.xml`

4. **Configure ChromeDriver**

   * Ensure `chromedriver.exe` is present in the `driver/` folder
   * Alternatively, **WebDriverManager** can manage it automatically

---

## ▶️ 2. How to Run the Test Cases

### 🔹 Using Maven

```bash
mvn test
```

### 🔹 Using TestNG Suite

Run the `testng.xml` file directly from your IDE or terminal.

**Sample TestNG Suite:**

```xml
<suite name="OrangeHRM Suite">
  <test name="User Management Tests">
    <classes>
      <class name="tests.LoginTest"/>
      <class name="tests.AddUserTest"/>
      <class name="tests.ValidateActivities"/>
    </classes>
  </test>
</suite>
```

---

## 🌐 3. Selenium Version Used

> **Selenium WebDriver:** 4.16.1

---

## 📊 Reporting

* Generates **HTML reports** via **ExtentReports** in `test-output/`
* **Screenshots** automatically captured on test failures (`test-output/screenshots/`)
* Detailed step-wise logging and status tracking included

---

## 📁 Test Data

* `UserData.xlsx` contains user creation & validation data
* Data read using **Apache POI** in `TestDataReader.java`

---

## 💼 Business Focus & Coverage

This framework validates:
✅ Accurate user creation and role assignment
✅ Search and filtering consistency
✅ Editable user attributes (status, role, etc.)
✅ Proper UI reflection of changes
✅ Secure deletion workflows

It supports **regression**, **functional**, and **sanity testing** for the OrangeHRM Admin module.

---

## 🧠 Design Highlights

* **Page Object Model (POM)** for modular test design
* **Reusable Utilities:** WaitHelper, TestDataReader, ExtentManager
* **Data-Driven Testing** using Excel
* **Comprehensive HTML Reports** with screenshots on failure
* **Scalable Architecture** for adding more test modules easily

---

## 📄 License

This project is developed for **educational and assessment purposes only**.

---

## 👨‍💻 Author

**Mahadevan D**
*QA Automation Engineer*

📧 [dmdeva07@gmail.com](mailto:dmdeva07@gmail.com)
🔗 [LinkedIn](http://www.linkedin.com/in/mahadevan-d-6350a0205)
🌐 [Portfolio](https://mahadevanportfolio.netlify.app/)

---

## 🏁 Conclusion

This framework demonstrates my ability to **design, implement, and execute** a scalable automation suite using **Selenium + Java + TestNG**.
It emphasizes **maintainability**, **data-driven testing**, and **detailed reporting**, aligning with industry-level QA automation standards.

---

Would you like me to add a **section showing sample Extent Report output and folder structure screenshot placeholders** for GitHub visual appeal?
That can make your project look even more polished.
