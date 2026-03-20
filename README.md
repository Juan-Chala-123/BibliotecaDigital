# Digital Library

## Members

- Maicol Sánchez Castañeda

- Brayan Estiven Patiño Cabrera

- Juan Camilo Guilombo Osorio

- Juan Esteban Cortes Parra

- Juan Mauricio Suaza Solorzano

-  Merari Urbano

- Juan Pablo Chala Ramirez

## Problem

A digital library needs a console-based Java application to manage loans, returns, collection traversal, user alerts, and creation of different types of bibliographical materials. The system must allow different types of materials to be created through a specialized factory method, in addition to incorporating loan strategies, commands for actions, and event subscriptions.

## Implemented Patterns

| Pattern | Purpose |
|---------|---------|
| **Factory Method** | Create different types of materials (Book, Magazine, Thesis) |
| **Strategy** | Change loan rules based on user type (Student, Professor, Visitor) |
| **Command** | Encapsulate all actions as executable objects |
| **Iterator** | Traverse collections without exposing internal structure |
| **Singleton** | Centralize global configuration |
| **Observer** | Notify users, admins, and audit system of events |

## Project Structure

```
src/
├── main/
│   └── Main.java
│
├── model/
│   ├── Material.java        (abstract base class)
│   ├── Book.java           (extends Material)
│   ├── Magazine.java       (extends Material)
│   ├── Thesis.java         (extends Material)
│   ├── User.java
│   ├── Loan.java
│   └── Library.java
│
├── factory/                ⚑ Factory Method
│   ├── MaterialCreator.java
│   ├── BookCreator.java
│   ├── MagazineCreator.java
│   └── ThesisCreator.java
│
├── strategy/               ⚑ Strategy
│   ├── ILoanStrategy.java
│   ├── StudentLoanStrategy.java
│   ├── ProfessorLoanStrategy.java
│   └── VisitorLoanStrategy.java
│
├── command/                ⚑ Command
│   ├── Command.java
│   ├── RegisterMaterialCommand.java
│   ├── LoanMaterialCommand.java
│   ├── ReturnMaterialCommand.java
│   ├── ListMaterialsCommand.java
│   ├── DeleteMaterialCommand.java
│   ├── CheckAvailabilityCommand.java
│   ├── AddUserCommand.java
│   └── ListUsersCommand.java
│
├── iterator/               ⚑ Iterator
│   ├── Iterator.java
│   ├── MaterialIterator.java
│   └── LoanHistoryIterator.java
│
├── singleton/             ⚑ Singleton
│   └── LibraryConfig.java
│
├── observer/               ⚑ Observer
│   ├── IObserver.java
│   ├── LibraryEventPublisher.java
│   ├── LibraryEvent.java
│   ├── UserObserver.java
│   └── AdminObserver.java
│
└── ui/
    └── ConsoleUI.java
```

## Console Menu

```
1. Register Material
2. List Materials
3. Loan Material
4. Return Material
5. Delete Material
6. Check Availability
7. View Loan History
8. Change Loan Strategy
9. Show Configuration
10. Register User
11. List Users
12. View Loaned Materials
0. Exit
```
