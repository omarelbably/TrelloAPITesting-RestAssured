🧪 Trello API Testing with RestAssured

Welcome to TrelloAPITesting-RestAssured — a comprehensive API Automation Testing Project focused on testing Trello's RESTful APIs using RestAssured and Java. 🚀

    🔍 Designed to ensure the robustness and reliability of Trello's API functionalities with structured, maintainable automated tests!

📚 About the Project

In modern development, API testing is a crucial layer for ensuring application stability.
This project demonstrates best practices in automated API testing by interacting with the Trello API — covering the full CRUD operations (Create, Read, Update, Delete) for:

    🗂️ Boards

    📝 Lists

    📋 Cards

Why this project matters:

    📈 Validate that the API behaves as expected under various conditions.

    🛠️ Catch bugs earlier in the development cycle.

    📋 Ensure data integrity and service performance.

Built for:
✔️ Learning RestAssured in real-world scenarios
✔️ Demonstrating how to automate API testing professionally
✔️ Practicing TestNG structure and reporting
🛠️ Tech Stack
Technology	Purpose
Java ☕	Programming Language
RestAssured 🔗	API Testing Framework
TestNG 🧪	Test Management and Reporting
Maven 📦	Build and Dependency Management
JSONPath 📑	Parse and Validate JSON Responses
Git/GitHub 🐙	Version Control
🔥 Project Highlights

✅ Authentication handled securely using API Key and Token 🔑
✅ Full CRUD testing for Trello objects (boards, lists, cards)
✅ Dynamic data creation — tests create, use, and clean up their own data
✅ Reusable Request Specifications — no duplicate code!
✅ Assertions on both Status Codes and Response Bodies
✅ Maven Integration for easy build and run
✅ Structured code with utilities and helpers to keep tests clean and readable
🚀 Getting Started

Spin up the project locally and run your tests easily! 🖥️
Prerequisites

    ✅ Java JDK 8 or above

    ✅ Maven installed

    ✅ IDE (like IntelliJ IDEA / Eclipse)

    ✅ Trello Account (for API key and token)

Setup Instructions

    Clone the Repository

git clone https://github.com/omarelbably/TrelloAPITesting-RestAssured.git

    Navigate into the Project

cd TrelloAPITesting-RestAssured

    Configure API Credentials

Create a config.properties file (if not already) and add your Trello API credentials:

apiKey=YOUR_API_KEY
apiToken=YOUR_API_TOKEN

    Install Dependencies

mvn clean install

    Run Tests

mvn test

✅ That's it — watch your Trello boards, lists, and cards being created and validated automatically!
📂 Project Structure

TrelloAPITesting-RestAssured/

├── src/main/java/

│   ├── utilities/        # Helper classes (e.g., config loader)

├── src/test/java/

│   ├── tests/            # Test cases (BoardTests, ListTests, CardTests)

│   ├── specifications/   # Request and Response specifications

├── config.properties     # API credentials (not committed for security)

├── pom.xml               # Maven configuration

├── README.md             # Documentation

└── testng.xml            # TestNG test suite configuration


🧪 Example Test Cases
Test Case	Description
Create a Board	Verify that a new board can be created successfully
Create a List inside a Board	Validate that lists can be created under specific boards
Add a Card to a List	Test card creation functionality
Update a Card	Verify editing of card details
Delete a Board	Confirm that a board and all its contents can be deleted
🧩 How to Contribute

We 💙 contributions! Here's how:

    Fork this repo 🍴

    Create your branch (git checkout -b feature/AmazingFeature) 🚀

    Commit your changes (git commit -m 'Add AmazingFeature') 📌

    Push to your branch (git push origin feature/AmazingFeature) 📤

    Open a Pull Request ✅

🎯 Roadmap

Implement basic CRUD API tests

Add dynamic test data creation

Reusable request/response specifications

Parallel test execution with TestNG ⚡

Integrate with Allure Reports 📊

    Add negative scenario testing 🚫

📢 Contact

Omar Elbably
📧 Email: omaroelbably@gmail.com
🌐 GitHub: omarelbably
🌟 Show Your Support

If you find this project useful, please ⭐ Star it — it motivates and helps others find it too!
Let's build better, faster, and more reliable APIs together! 🚀🎯

    Created with passion for clean code, strong testing, and automation excellence by Omar Elbably.
