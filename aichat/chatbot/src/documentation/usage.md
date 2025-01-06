This document provides a guide on how to use the Chatbot application, including setting up the environment, running the application, and interacting with its features.

Prerequisites
Before using the Chatbot application, ensure the following are installed:

Java Development Kit (JDK) 17: The application is built using Java 17.
Apache Maven: Required for building and managing dependencies.
MySQL Database: The application uses MySQL for data storage.
Web Browser: To access the application's web interface.
Setting Up the Application
1. Clone the Repository

Clone the repository to your local machine:
bash
Insert Code
Run
Copy code
git clone https://github.com/your-repo/chatbot.git
Navigate to the project directory:
bash
Insert Code
Run
Copy code
cd chatbot
2. Set Up the Database

Log in to your MySQL server:
bash
Insert Code
Run
Copy code
mysql -u root -p
Create a new database named chatbot_db:
sql
Insert Code
Run
Copy code
CREATE DATABASE chatbot_db;
Exit the MySQL shell:
sql
Insert Code
Run
Copy code
exit;
Update the database connection details in DatabaseUtil.java:
java
Insert Code
Run
Copy code
private static final String URL = "jdbc:mysql://localhost:3306/chatbot_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
3. Build the Application

Navigate to the project root directory (where pom.xml is located).
Build the project using Maven:
bash
Insert Code
Run
Copy code
mvn clean install
Running the Application
1. Run the Main Class

Execute the Main.java class to test the application:
bash
Insert Code
Run
Copy code
mvn exec:java -Dexec.mainClass="com.example.Main"
2. Deploy to a Servlet Container

If you are using a servlet container like Apache Tomcat, deploy the generated WAR file to the server.
3. Access the Web Interface

Start your servlet container (e.g., Tomcat).
Open a web browser and navigate to:
Insert Code
Run
Copy code
http://localhost:8080/chatbot
Using the Web Interface
1. Add a New User

Fill in the "Username" and "Email" fields in the "Add New User" form.
Click the "Add User" button to submit the form.
2. View User List

The "User List" table displays all users added to the system.
Each user entry includes their ID, username, email, and actions (e.g., delete).
3. Delete a User

Click the "Delete" button next to a user in the "User List" table to remove them from the system.
Running Tests
Run the unit tests to ensure everything is working correctly:
bash
Insert Code
Run
Copy code
mvn test
Troubleshooting
Database Connection Issues: Ensure MySQL is running and the credentials in DatabaseUtil.java are correct.
Build Failures: Verify that all dependencies are correctly installed by running mvn clean install.
This document will be updated as new features and usage instructions are added.