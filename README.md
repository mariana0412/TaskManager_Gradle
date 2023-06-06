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
- **Combine Javadocs from three modules**: With specific command You can copy the generated Javadoc files from multiple modules to a combined directory. This allows easy access to the Javadoc documentation for all modules in a single location.
- **Check File Presence**: This Gradle task verifies the existence of a file in the project directory. By running the task with a specific command, you can check if a file, whose path is given as a parameter, exists in the project structure. If the file is present, the task prints a corresponding message; if not, it informs about the absence of the file. This is useful to validate the availability of critical configuration or resource files required by the project.
- **Build Task**: A custom build task is created to execute additional build logic specific to the project.

## Setup :wrench:

To build and run the project, you can use Gradle commands.

1. Clone the project repository to your local machine.
2. Navigate to the project root directory.
3. Run the following command to build the project:
./gradlew build
4. Run the following command to copy the generated Javadoc files from multiple modules to a combined directory (TaskManager_Gradle/build/combinedJavadoc):
./gradlew copyJavadoc
5. Run the following command to check file presence by its path:
./gradlew checkFilePresence -PfilePath="your/file/path"
6. Run the following command to execute the custom build task:
./gradlew myBuildTask

Make sure you have Gradle installed on your system or use the Gradle wrapper included in the project repository.
