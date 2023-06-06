# TaskManager_Gradle :clipboard:

This project is part of the practical work for the course "Automating Software Applications in the Java Language" at NaUKMA. It is a simple console-based task manager application implemented as a multi-module Gradle project.

## Structure :open_file_folder:

The project consists of 4 modules:

1. **core**: This module contains the main business logic of the application.
2. **storage**: This module is responsible for persisting tasks to a file using Google's Gson library.
3. **ui**: This module contains the user interface logic for interacting with tasks via a command-line interface.
4. **gson-library**: GSON Java Library

## Features :gear:

- **Multi-module Gradle Project**: The project is organized into four related modules: core, storage, ui, and gson-library.
- **Gradle Dependencies**: Dependencies between the modules and with external libraries from Maven Central are managed using Gradle.
- **Custom Gradle Tasks**: Custom tasks are defined to check the existence of a specific file and perform project-specific actions.
- **Build Task**: A custom build task is created to execute additional build logic specific to the project.

## Setup :wrench:

To build and run the project, you can use Gradle commands.

1. Clone the project repository to your local machine.
2. Navigate to the project root directory.
3. Run the following command to build the project:
./gradlew build
4. Run the following command to execute the task that checks the existence of a config properties file:
./gradlew checkConfigPropertiesFile
5. Run the following command to execute the custom build task:
./gradlew myBuildTask

Make sure you have Gradle installed on your system or use the Gradle wrapper included in the project repository.
