# CampusQuest Application 🎓📁

Welcome to the **CampusQuest** application! This project is designed to manage and interact with exam files, handle user responses, and assist with posting and resolving doubts. The application also integrates an AI assistant for answering general questions. It provides functionalities for uploading, downloading, and managing exam-related files, posting and replying to doubts, and interacting with an AI assistant.

## Table of Contents

- [Project Overview](#project-overview-)
- [Features](#features-)
- [Running the Application](#running-the-application-)
- [Contributing](#contributing-)

## Project Overview 🏠

The **CampusQuest** application is built using **Spring Boot** and provides a web interface for users to upload, manage, and download exam files. It supports managing user responses and linking those responses to exam files. Additionally, users can interact with an AI assistant powered by **Ollama Mistral** via the home page. The application also allows users to post and resolve doubts related to exams, fostering better learning and communication.

## Features 🌟

1. **Question Paper Upload and Download**:
    - Users can upload exam files and download them by accessing the file details through the application.

2. **Ask AI**:
    - The integrated AI assistant allows users to ask questions, similar to ChatGPT, to get instant responses for better learning and problem-solving.

3. **Doubts Postings**:
    - Users can post doubts, respond to others' doubts, and manage their doubts effectively. This feature promotes collaboration and clarity among students.






### Healthcheck 🔍

The `Healthcheck` endpoint is used to monitor the health status of the application.

- **GET /health**: Returns the health status of the application.
    - **Response**: HTTP Status Code `200 OK` if the application is healthy.

## Running the Application 🚀

To run the application locally, follow these steps:

1. Clone the repository:

    ```sh
    git clone https://github.com/EminenceIsHere/PaperPal.git
    ```

2. Navigate to the project directory:

    ```sh
    cd CampusQuest
    ```

3. Build and run the application using Maven or Gradle:

    ```sh
    ./mvnw spring-boot:run
    ```

   or

    ```sh
    ./gradlew bootRun
    ```
4. Access the application(Homepage) at `http://localhost:8080`.


## Contributing 🤝

If you would like to contribute to this project, please fork the repository and submit a pull request. Make sure to include tests for any new features or bug fixes.

For any issues or feature requests, please create an issue in the GitHub repository.

---

Thank you for using **CampusQuest**! If you have any questions, feel free to reach out or open an issue on GitHub. 😊
