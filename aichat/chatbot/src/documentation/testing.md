This document provides an overview of the testing strategy, test cases, and instructions for running tests for the Chatbot application.

Testing Strategy
Unit Testing: Individual components (e.g., DAO, Service) are tested in isolation using JUnit and Mockito.
Integration Testing: Ensures that components work together as expected (e.g., database interactions).
Functional Testing: Validates the application's functionality through the web interface.
Manual Testing: Manual verification of user interactions and edge cases.
Test Cases
1. Unit Tests

ChatbotServiceTest

**testAddUser **: Verifies that a user is added successfully.
testAddConversation: Ensures a conversation is added to the database.
testGetConversationHistory: Validates retrieval of conversation history.
testPrintConversationHistory: Checks if conversation history is printed correctly.
ChatbotDAOTest

**testAddUser **: Ensures the DAO correctly adds a user to the database.
2. Integration Tests

Database Interaction: Tests the connection and interaction with the MySQL database.
Servlet Functionality: Validates the behavior of the User Servlet in handling user requests.
3. Functional Tests

User Management: Tests adding, viewing, and deleting users through the web interface.
Conversation History: Validates the display of conversation history for a user.
Running Tests
1. Unit Tests

Navigate to the project root directory (where pom.xml is located).
Run the following command to execute all unit tests:
bash
Insert Code
Run
Copy code
mvn test
2. Integration Tests

Ensure the MySQL database is running and configured correctly.
Run the integration tests using the same mvn test command.
3. Manual Testing

Start the application using:
bash
Insert Code
Run
Copy code
mvn exec:java -Dexec.mainClass="com.example.Main"
Access the web interface at http://localhost:8080/chatbot.
Perform manual tests by adding users, initiating conversations, and verifying the output.
Troubleshooting
Test Failures: Ensure all dependencies are correctly installed by running mvn clean install.
Database Issues: Verify that MySQL is running and the credentials in DatabaseUtil.java are correct.
Build Failures: Check for syntax errors or missing dependencies in the pom.xml file.
Test Coverage
Use tools like JaCoCo to measure test coverage:
bash
Insert Code
Run
Copy code
mvn clean test jacoco:report
View the coverage report in the target/site/jacoco directory.
This document will be updated as new test cases and strategies are implemented.