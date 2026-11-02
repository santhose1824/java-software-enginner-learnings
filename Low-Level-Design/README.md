# Low-Level Design (LLD) in Java - Design Patterns
> My learning journey through Object-Oriented Design, SOLID principles, UML class diagrams and the Gang-of-Four design patterns. Every pattern has a **problem** version (what hurts), an **example** version (the fix), a **class diagram**, **what I learnt** and **interview questions**.

| | |
|---|---|
| **Prerequisite** | Object-Oriented Programming |
| **For whom** | SDE interview preparation |
| **Language** | Java (JDK 17+ recommended) |
| **What after this** | Design more systems on your own |

## Table of contents

- [Start here: Introduction](#start-here-introduction)
- [Progress](#progress)
- [Repository structure](#repository-structure)
- [Pattern cheat sheet](#pattern-cheat-sheet)
- [Which creational pattern when?](#which-creational-pattern-when)
- [Structural patterns that look alike](#structural-patterns-that-look-alike)
- [Class diagrams and Lucidchart](#class-diagrams-and-lucidchart)
- [How to run the examples](#how-to-run-the-examples)
- [Roadmap: behavioural patterns](#roadmap-behavioural-patterns)
- [Housekeeping tips](#housekeeping-tips)

## Start here: Introduction

Read **[introduction/README.md](src/introduction/README.md)** first. It covers LLD vs HLD, DRY / KISS / YAGNI, SOLID, UML and class-diagram notation, the six class relationships and an overview of design patterns - with my handwritten notes and interview questions.

## Progress

| Category | Patterns | Done |
|---|---|---|
| Creational | Singleton, Factory, Abstract Factory, Builder, Prototype | 5 / 5 |
| Structural | Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy | 7 / 7 |
| Behavioural | Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, Visitor | 0 / 11 |

## Repository structure

```text
Low-Level-Design/
├── README.md                     <- you are here
├── .gitignore
├── introduction/
│   ├── README.md                 <- LLD, SOLID, UML, intro to patterns + interview Q&A
│   └── notes/                    <- my handwritten notes (22 pages)
└── src/
    ├── behaviourPatterns/   <- empty for now
    ├── creationalPatterns/
    │   ├── singletonPattern/
    │   │   ├── problem/   <- the pain (without the pattern)
    │   │   ├── singletonPatternExample/   <- the fix (with the pattern)
    │   │   ├── diagrams/
    │   │   ├── notes/
    │   │   └── README.md
    │   ├── factoryPattern/
    │   │   ├── problem/   <- the pain (without the pattern)
    │   │   ├── factoryPatternExample/   <- the fix (with the pattern)
    │   │   ├── diagrams/
    │   │   ├── notes/
    │   │   └── README.md
    │   ├── builderPattern/
    │   │   ├── problem/   <- the pain (without the pattern)
    │   │   ├── builderPatternExample/   <- the fix (with the pattern)
    │   │   ├── diagrams/
    │   │   ├── notes/
    │   │   └── README.md
    │   ├── abstractFactoryPattern/
    │   │   ├── problem/   <- the pain (without the pattern)
    │   │   ├── abstractFactoryPatternExample/   <- the fix (with the pattern)
    │   │   ├── diagrams/
    │   │   ├── notes/
    │   │   └── README.md
    │   └── prototypePattern/
    │       ├── problem/   <- the pain (without the pattern)
    │       ├── prototypePatternExample/   <- the fix (with the pattern)
    │       ├── diagrams/
    │       ├── notes/
    │       └── README.md
    └── strcturedPatterns/
        ├── adapterPattern/
        │   ├── problem/   <- the pain (without the pattern)
        │   ├── adapterPatternExample/   <- the fix (with the pattern)
        │   ├── diagrams/
        │   ├── notes/
        │   └── README.md
        ├── bridgePattern/
        │   ├── problem/   <- the pain (without the pattern)
        │   ├── bridgePatternExample/   <- the fix (with the pattern)
        │   ├── diagrams/
        │   ├── notes/
        │   └── README.md
        ├── compositePattern/
        │   ├── problem/   <- the pain (without the pattern)
        │   ├── compositePatternExample/   <- the fix (with the pattern)
        │   ├── diagrams/
        │   ├── notes/
        │   └── README.md
        ├── decoratorPattern/
        │   ├── problem/   <- the pain (without the pattern)
        │   ├── decoratorPatternExample/   <- the fix (with the pattern)
        │   ├── diagrams/
        │   ├── notes/
        │   └── README.md
        ├── facadePattern/
        │   ├── problem/   <- the pain (without the pattern)
        │   ├── facadePatternExample/   <- the fix (with the pattern)
        │   ├── diagrams/
        │   ├── notes/
        │   └── README.md
        ├── flyWeightPattern/
        │   ├── problem/   <- the pain (without the pattern)
        │   ├── flyWeightPatternExample/   <- the fix (with the pattern)
        │   ├── diagrams/
        │   ├── notes/
        │   └── README.md
        └── proxyPattern/
            ├── problem/   <- the pain (without the pattern)
            ├── proxyPatternExample/   <- the fix (with the pattern)
            ├── diagrams/
            ├── notes/
            └── README.md
```

Every pattern folder follows the same layout: `problem/` -> `...Example/` -> `../README.md` (theory, class diagram, what I learnt, interview questions) -> `diagrams/` (Lucidchart-ready code) -> `notes/` (my handwritten pages).

## Pattern cheat sheet

| # | Pattern | Category | One-line intent | My example | Notes + diagram |
|---|---|---|---|---|---|
| 1 | **Singleton** | Creational | Guarantee that a class has only one instance and give everyone the same access point to it. | Online judge analytics (counting Run / Submit clicks) | [README](src/creationalPatterns/singletonPattern/README.md) |
| 2 | **Factory** | Creational | Move the decision of *which concrete class to instantiate* out of the client and into one place. | Delivery modes (Air, Road, Train) | [README](src/creationalPatterns/factoryPattern/README.md) |
| 3 | **Builder** | Creational | Build an object with many optional parts through readable, chained steps instead of giant constructors. | Food delivery app - building a Burger order | [README](src/creationalPatterns/builderPattern/README.md) |
| 4 | **Abstract Factory** | Creational | Provide an interface for creating families of dependent objects without specifying their concrete classes. | Checkout service - PaymentGateway + Invoice per country (India / US) | [README](src/creationalPatterns/abstractFactoryPattern/README.md) |
| 5 | **Prototype** | Creational | Specify the kinds of objects to create using a prototypical instance, and create new ones by copying it. | Email templates (Welcome, Forgot-password ...) | [README](src/creationalPatterns/prototypePattern/README.md) |
| 6 | **Adapter** | Structural | Convert the interface of an existing class into the interface the client expects. | Payment gateways - PayU vs the third-party RazorPay API | [README](src/strcturedPatterns/adapterPattern/README.md) |
| 7 | **Bridge** | Structural | Decouple an abstraction from its implementation so the two can vary independently. | YouTube-like video player: device x video quality | [README](src/strcturedPatterns/bridgePattern/README.md) |
| 8 | **Composite** | Structural | Compose objects into tree structures and let clients treat individual objects and compositions uniformly. | E-commerce cart: Product and ProductBundle | [README](src/strcturedPatterns/compositePattern/README.md) |
| 9 | **Decorator** | Structural | Attach additional responsibilities to an object dynamically; a flexible alternative to subclassing. | Pizza ordering - base pizzas + cheese add-ons | [README](src/strcturedPatterns/decoratorPattern/README.md) |
| 10 | **Facade** | Structural | Provide a unified, simplified interface to a set of interfaces in a subsystem. | Entertainment ticket booking (movies, stand-up, concerts) | [README](src/strcturedPatterns/facadePattern/README.md) |
| 11 | **Flyweight** | Structural | Use sharing to support large numbers of fine-grained objects efficiently. | Google-Maps-style forest with thousands of trees | [README](src/strcturedPatterns/flyWeightPattern/README.md) |
| 12 | **Proxy** | Structural | Provide a surrogate or placeholder for another object to control access to it. | Video downloader with caching | [README](src/strcturedPatterns/proxyPattern/README.md) |

## Which creational pattern when?

| If your problem is ... | Use |
|---|---|
| "I need exactly one shared instance" | Singleton |
| "The client shouldn't decide which concrete class to `new`" | Factory |
| "I need a *family* of related objects that must go together" | Abstract Factory |
| "The object has many optional parts / a long constructor" | Builder |
| "Creating the object is costly - copy an existing one" | Prototype |

## Structural patterns that look alike

Most structural patterns *wrap* something, so interviewers love asking how they differ:

| Pattern | Interface of the wrapper | Its job | In my code |
|---|---|---|---|
| Adapter | **Different** from the wrapped object | Translate so incompatible things work together | `RazorPayAdapter` |
| Decorator | **Same** as the wrapped object | Add behaviour, stackable | `ExtraCheese(new ChickenPizza())` |
| Proxy | **Same** as the wrapped object | Control access (cache, lazy, permission) | `CachedVideoDownloader` |
| Facade | **New, simpler** interface over many classes | Hide a complex subsystem | `BookingFacade` |
| Composite | **Same** for leaf and group | Treat one and many uniformly (tree) | `Product` / `ProductBundle` |
| Bridge | Abstraction **holds** an implementor | Vary two dimensions independently (M + N, not M x N) | `VideoPlayer` + `VideoQuality` |
| Flyweight | Shared object + per-object state | Save memory by sharing | `TreeType` shared by `Tree`s |

## Class diagrams and Lucidchart

Each pattern README contains a Mermaid `classDiagram` for the example code (GitHub renders it automatically), and the same code is saved as a `.mmd` file in that pattern's `diagrams/` folder.

**To get the diagram into Lucidchart**

1. Open the `.mmd` file (or copy the code block from the README).
2. In Lucidchart create a new document.
3. Open **Diagram as code** (the `</>` icon) and choose Mermaid.
4. Paste the code - Lucidchart renders the class diagram, which you can then share or export from Lucidchart.

Lucid's diagram-as-code feature supports Mermaid class diagrams, but the generated diagram is built from the code and its styling options are limited. If you want fully hand-editable shapes, recreate it on the canvas using the same boxes and arrows.

All diagrams: `abstract-factory-checkout.mmd`, `builder-burger.mmd`, `factory-delivery.mmd`, `prototype-email.mmd`, `singleton-bill-pugh.mmd`, `singleton-eager.mmd`, `singleton-lazy.mmd`, `adapter-payment.mmd`, `bridge-video-player.mmd`, `composite-cart.mmd`, `decorator-pizza.mmd`, `facade-booking.mmd`, `flyweight-forest.mmd`, `proxy-video-downloader.mmd`.

## How to run the examples

**IntelliJ IDEA:** open the folder as a project, mark `src` as *Sources Root*, open any `Main.java` and press Run.

**Command line** (JDK 17+; the Abstract Factory example uses arrow-style `switch`):

```bash
cd Low-Level-Design
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out creationalPatterns.singletonPattern.singletonPatternExample.eagerLoading.Main
java -cp out strcturedPatterns.proxyPattern.proxyPatternExample.Main
```

Each `problem/` and `...Example/` folder has its own `Main`, so you can run the "before" and "after" side by side.

## Roadmap: behavioural patterns

`src/behaviourPatterns/` is still empty. Next up (concerned with communication between objects):

- [ ] Chain of Responsibility
- [ ] Command
- [ ] Interpreter
- [ ] Iterator
- [ ] Mediator
- [ ] Memento
- [ ] Observer
- [ ] State
- [ ] Strategy
- [ ] Template Method *(the 11th GoF behavioural pattern - it was not in my handwritten list)*
- [ ] Visitor

## Housekeeping tips

- A `../.gitignore` is included so IntelliJ files (`.idea/`, `*.iml`) and compiled classes (`out/`) are not committed.
- The folder is spelled `strcturedPatterns` (a "u" is missing, and `structuralPatterns` would be the usual name). I kept it so the package names still match; in IntelliJ use *Refactor -> Rename* on the package to change it to `structuralPatterns`.
- Each pattern README has a "Things to improve in my code" section with small fixes (typos, naming, thread-safety) found while writing the docs.
