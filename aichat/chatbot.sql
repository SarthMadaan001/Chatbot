-- Create the database
CREATE DATABASE chatbot_db;

-- Use the database
USE chatbot_db;

-- Create the User table
CREATE TABLE User (
  id INT AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- Create the Conversation table
CREATE TABLE Conversation (
  id INT AUTO_INCREMENT,
  user_id INT NOT NULL,
  message TEXT NOT NULL,
  response TEXT NOT NULL,
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES User(id)
);

-- Create the Configuration table
CREATE TABLE Configuration (
  id INT AUTO_INCREMENT,
  response_template TEXT NOT NULL,
  knowledge_base TEXT NOT NULL,
  PRIMARY KEY (id)
);

-- Create the AlgorithmImprovement table
CREATE TABLE AlgorithmImprovement (
  id INT AUTO_INCREMENT,
  feedback TEXT NOT NULL,
  performance_data TEXT NOT NULL,
  PRIMARY KEY (id)
);

-- Create the InteractionLogs table
CREATE TABLE InteractionLogs (
  id INT AUTO_INCREMENT,
  user_id INT NOT NULL,
  interaction TEXT NOT NULL,
  timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES User(id)
);