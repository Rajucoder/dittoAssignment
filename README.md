# 🚀 Ditto Insurance – Automation Framework  
### **Care Supreme Health Plan – Premium Validation Test**
#### _Author: **Rajeshwari Nadar**_

<p align="left">
  <img src="https://img.shields.io/badge/Java-11-blue" />
  <img src="https://img.shields.io/badge/Selenium-4.20.0-brightgreen" />
  <img src="https://img.shields.io/badge/TestNG-7.10.2-orange" />
  <img src="https://img.shields.io/badge/Maven-Build Tool-red" />
  <img src="https://img.shields.io/badge/WebDriverManager-5.7.0-yellow" />
  <img src="https://img.shields.io/badge/ExtentReports-5.1.1-purple" />
  <img src="https://img.shields.io/badge/Status-Completed-success" />
</p>

---

# 📌 **Project Overview**

This project automates the **Care Supreme Health Plan** flow on  
👉 https://app.joinditto.in/fq  
as part of the **Ditto QA Automation Assignment**.

### 🔹 **Original Requirement**
Automate:
- Selecting the product **Niva Buppa (ReAssure 2.0)**
- Selecting **You**
- Filling the **"Tell us about you"** form
- Validating:
  **Total Premium = Base Premium + Riders + GST**

### ⚠️ **IMPORTANT NOTE**
The product **“Niva Buppa (ReAssure 2.0)” was NOT available** during development.  
Therefore, this framework is implemented for the **available product**:

### ✅ **Care Supreme – Health Product**

All required validations and calculations remain **100% aligned** with the assignment.

---

# 🧰 **Tech Stack**

| Component | Version |
|----------|---------|
| Java | 11+ |
| Selenium WebDriver | 4.20.0 |
| TestNG | 7.10.2 |
| WebDriverManager | 5.7.0 |
| Extent Reports | 5.1.1 |
| Log4j | Latest |
| Maven | Build Tool |
| ChromeOptions | Headless / Normal mode |

---

# 📂 **Project Structure**
📁 ditto-automation/
│
├── 📄 pom.xml
├── 📄 testng.xml
├── 📝 README.md
│
├── 📁 reports/
│ └── 📄 DittoAutomationReport.html
│
├── 📁 screenshots/
│ └── 🖼 *.png
│
└── 📁 src/
├── 📁 main/java/
│ ├── 📁 base/
│ │ └── 📄 BaseTest.java
│ │
│ ├── 📁 pages/
│ │ ├── 📄 LandingPage.java
│ │ ├── 📄 MemberPage.java
│ │ ├── 📄 PlanPage.java
│ │ ├── 📄 PolicyPage.java
│ │ └── 📄 PremiumSummaryPage.java
│ │
│ └── 📁 utils/
│ ├── 📄 WaitUtils.java
│ └── 📄 ScreenshotUtils.java
│
└── 📁 test/java/
└── 📁 tests/
└── 🧪 DittoTest.java ← Main Test Class

📘 Automated Scenario Steps
1️⃣ Landing Page

Open https://app.joinditto.in/fq

Click Care Supreme

2️⃣ Policy Page

Validate and navigate through:

Main Benefits

Waiting Periods

What’s Not Covered

Extra Benefits

Click Continue

3️⃣ Member Page

Select Self

Select Male

Proceed to next step

4️⃣ Plan Page

Validate required error messages:

"Your age is a required field"

"Spouse's age is a required field"

"Pin code is required"

Enter:

Age

Spouse age

Pincode

Click Calculate Premium

5️⃣ Premium Summary Page

Extract:
Base Premium

Riders Selected Value

Total Premium
6️⃣ Accuracy Checks

Currency cleaned using regex: [₹,]

Supports multiple selected rider values

Waits handled using custom WaitUtils

7️⃣ Reporting

✔ HTML Report → /reports/DittoAutomationReport.html
✔ Screenshots → /screenshots/
