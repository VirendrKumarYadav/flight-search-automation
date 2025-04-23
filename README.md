# ✈️ Flight Booking Automation Framework(AKQA)

An automated UI testing framework built for a flight search and booking platform (similar to Booking.com or Agoda). This project uses **Selenium WebDriver**, **Cucumber BDD**, and **TestNG** for behavior-driven test automation with the **Page Factory** pattern for clean and maintainable code.

## 🌍 Tech Stack

- Java 1.8
- Selenium WebDriver
- TestNG
- Cucumber (BDD)
- Maven
- Page Factory Pattern
- Extent Reports (optional)
- GitHub Actions (for CI/CD, optional)

---
## 📸 Sample Use Case

Automated testing for searching flights from a departure city to a destination on a mock or real flight booking interface.

```gherkin
Scenario: Search for flights from New York to London
  Given I launch the flight booking website
  When I enter "New York" as the departure city
  And I enter "London" as the destination city
  And I click on the search button
  Then I should see a list of available flights
```

Prerequisites
Java 17+
Maven
IntelliJ IDEA or Eclipse (recommended)
Chrome Browser

### Clone the Repository
```
git clone https://github.com/your-username/flight-booking-automation.git
cd flight-booking-automation

```

##Install Dependencies
```
mvn clean install
Run Tests
mvn test
Or with TestNG:
mvn test -DsuiteXmlFile=testng.xml
```
## 🗂️ Project Structure
```
📁 src
  ┣ 📂 main
  ┃ ┗ 📂 java
  ┃   ┗ 📂 pages           
  ┃
  ┣ 📂 test
    ┣ 📂 java
    ┃ ┣ 📂 stepdefinitions  
    ┃ ┣ 📂 runners         
    ┃        
    ┗ 📂 resources
      ┗ 📂 features       
 ┣ 📂 target
      ┗ 📂 cucumber-reports.html  

📄 pom.xml
📄 testng.xml

```
Edit locators in the pages/FlightSearchPage.java file to match your application’s DOM structure.


📜 License
This project is licensed under the MIT License - see the LICENSE file for details.

👨‍💻 Author & Maintainer
[Virendra Yadav]
Test Automation Engineer | BDD Enthusiast
Feel free to connect with me on LinkedIn


### Key Sections Explained:
- **Tech Stack**: Highlights the technologies used in the project.
- **Sample Use Case**: A brief Gherkin example for understanding the test scenarios.
- **Getting Started**: Instructions to clone the repo and set up the environment.
- **Project Structure**: Overview of the project’s folder and file organization.
- **Customize Locators**: Explanation to adjust the locators to your specific app’s structure.
- **CI/CD Integration**: How to set up automated tests on GitHub Actions or other CI tools.
- **Contributing**: Standard open-source contribution instructions.
- **License**: MIT license for open-source contribution.
- **Author Info**: Your contact details for professional connection.






