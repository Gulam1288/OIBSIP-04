# Online Examination System

This project is a console-based Java application that simulates an online examination system. It allows users to log in, update their profiles, take exams, and practice with mock exams.

## Features

1. **User Authentication**: Secure login using user ID and password.
2. **Update Profile**: Users can update their profile information.
3. **Update Password**: Users can change their password.
4. **Start Exam**: Users can take an exam with a set of predefined questions within a time limit.
5. **Practice Exam**: Users can take practice exams without a time limit.
6. **Logout**: Users can log out of the system.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code).

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/gulam1288/OIBSIP-04.git
    ```
2. Navigate to the project directory:
    ```sh
    cd OIBSIP
    ```

## Usage

1. Compile the Java files:
    ```sh
    javac OnlineExaminationSystem.java
    ```
2. Run the application:
    ```sh
    java OnlineExaminationSystem
    ```

3. Follow the on-screen instructions to use the system functionalities.

## Code Structure

The project is divided into the following classes:

- `Account`: Represents a user's account, containing user ID, password, and profile information.
- `Exam`: Manages the exam questions, answers, and evaluation.
- `PracticeExam`: A subclass of `Exam` that provides practice questions and evaluations.
- `OnlineExaminationSystem`: The main class to run the online examination system.

## Example

Here's a simple example of how to interact with the Online Examination System:

1. **Main Menu:**

    ```
    Menu:
    1. Login
    2. Practice Exam
    3. Exit
    Enter your choice: 
    ```

2. **Login:**

    ```
    Enter user ID: 
    Enter password: 
    ```

3. **Authenticated User Main Menu:**

    ```
    Main Menu:
    1. Update Profile
    2. Update Password
    3. Start Exam
    4. Logout
    Enter your choice: 
    ```

4. **Taking an Exam:**

    ```
    Starting exam. You have 5 minutes to complete.
    ----------------------------------------------------------------------
    Q1: What is the default value of a boolean variable in Java?
    A) true
    B) false
    C) 0
    D) 1
    Enter your answer: 
    ```

## Acknowledgements

This project is part of my Java Development Internship at Oasis.
