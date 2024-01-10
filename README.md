
## Introduction

This project is a demonstration of a feature-based multi-module architecture, 
utilizing the principles of Clean Architecture with the MVVM design pattern. 
The project is built using Jetpack Compose for the UI and Koin for dependency injection. 
It also leverages the power of Jetpack Compose Navigation to navigate across different modules.

## Modules

The project is divided into several modules:

- **app**: This is the main application module.
- **core**: This module contains core components that are shared across different feature modules.
- **feature-home**: This module contains all components related to the home screen of the application.

Each feature module follows a layered pattern, organized into `data`, `domain`, and `presentation` packages.

### app Module

The `app` module is the entry point of the application, containing the main activity and application class.

### core Module

The `core` module houses shared components, utilities, and base classes used across the application.

### feature-home Module

The `feature-home` module is organized into `data`, `domain`, and `presentation` packages:

- **data**: Contains classes related to data handling, such as repositories and data sources.
- **domain**: Contains the business logic and use cases of the home feature.
- **presentation**: Contains the ViewModels and the UI components built using Jetpack Compose.

## Technologies Used

- **Jetpack Compose**: Used for building the UI of the application.
- **Koin**: A pragmatic lightweight dependency injection framework for Kotlin, used for managing dependencies in the project.
- **Jetpack Compose Navigation**: Used for navigating across different composables in different modules.

## Conclusion

This project is a robust example of a multi-module, feature-based architecture using modern Android development tools and patterns. It serves as a scalable and maintainable base for building complex Android applications.
