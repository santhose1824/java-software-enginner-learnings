# Student Marks Manager (Console App)

A menu-driven Java console application that stores students and their marks for 3 subjects, then shows
grades, results, the class topper, the class average, and a ranked list.

Built using only core Java basics: `Scanner`, `ArrayList`, methods, `if / else if`, `switch`, loops,
Strings, `printf` formatting, and a hand-written bubble sort. No OOPs yet - that is the next version.

## Features

| # | Feature | What it does |
|---|---------|--------------|
| 1 | Add Student | Name + 3 marks (0-100). Rejects empty and duplicate names. |
| 2 | View All Students | Table with total, grade and result for every student. |
| 3 | Search by Name | Case-insensitive search (`anu` finds `Anu`). |
| 4 | Update Marks | Choose Mark 1 / 2 / 3 and change just that mark. Total, grade and result update automatically. |
| 5 | Delete Student | Removes the student from every list and shows who was deleted. |
| 6 | Topper & Average | Class topper, class average per subject, passed / failed count. |
| 7 | Sort By Marks | Highest total first (bubble sort). |
| 8 | Exit | Ends the program. |

### Grading

Average = total / 3

| Average | Grade | Result |
|---------|-------|--------|
| 90 and above | A | Distinction |
| 80 - 89.99 | B | First Class |
| 70 - 79.99 | C | Second Class |
| 60 - 69.99 | D | Third Class |
| below 60 | F | Failed |

## How to run

```bash
java StudentMarksManager.java        # Java 11+ runs a single file directly
```
or
```bash
javac StudentMarksManager.java
java StudentMarksManager
```

## Sample output

```
S.NO       Student Name         Mark One     Mark Two     Mark Three   Total Marks  Grade      Result
1          Anu                  80.0         80.0         80.0         240.0        B          First Class
2          Meena                70.0         70.0         70.0         210.0        C          Second Class
3          Ravi                 90.0         50.0         50.0         190.0        D          Third Class

Average Marks of the Whole Class is  : 66.7
Total no. of passed students are : 2. Total no. of failed students are : 1
```

## Java concepts used

| Concept | Where |
|---------|-------|
| `Scanner` + `nextLine()` after `nextInt()` gotcha | every input method |
| `ArrayList<String>`, `ArrayList<Double>` | the 5 parallel lists (same index = same student) |
| Methods, `static`, return types | `getGrade()`, `findStudentIndex()`, `readMark()`, ... |
| `if / else if` ladder | `getGrade()` |
| `switch` (arrow form and switch expression) | menu, `getResult()`, update |
| Loops (`do-while`, `for`, `while(true)`) | menu loop, search, validation |
| Strings: `trim`, `isEmpty`, `equalsIgnoreCase` | names |
| `printf` formatting (`%-20s`, `%.1f`) | tables |
| Pass by value / object references | lists shared via `static` fields |
| `Collections.swap` | `swapStudents()` |
| Bubble sort with early exit (`isSwap`) | `sortByMarks()` |
| Type conversion | `total / 3.0`, `char` grade in `switch` |

## Bug fix log (what was wrong in version 1, and how version 2 fixes it)

Every one of these is also commented in the source next to the fixed code ("PREVIOUS CODE / CAUSE / FIX").

| # | Bug in version 1 | Cause | Fix |
|---|------------------|-------|-----|
| 1 | **Update changed other students' totals.** Updating Ravi changed Anu from 240 to 330 and Meena from 210 to 250. | The `if (newMark > previousMark)` block was **outside** the `if (name equals)` check, so it ran for every student in the loop. | Find the student's index once, set only that mark, recompute only that student's total. |
| 2 | Update used `gradeOfEachStudent.add(...)`. | `add` appends a new entry; it does not replace the old one. `set` was needed. The lists drifted out of sync. | Grade / result lists removed. |
| 3 | Search, delete, topper and sort crashed with `IndexOutOfBoundsException` unless you pressed option 2 first. | Grade / result lists were only filled inside `viewAllStudents()`. | Grade is calculated on demand with `getGrade(total)`. |
| 4 | Topper was almost always the last student. | `if (total > topperOfClass)` compared a **total** (e.g. 240) with an **index** (e.g. 2). | Compare with the current topper's total: `totals.get(topperIndex)`. |
| 5 | `str == "Failed"` | `==` compares references, not text. It worked only because of the String pool. | Count students with `getGrade(total) == 'F'`. |
| 6 | Deleted student's grade printed as `65.0` instead of `A`. | `double grade = gradeList.remove(i)` converted the `Character` to a number. | Grade is a `char` from `getGrade()`. |
| 7 | Sort printed the table header above every row. | The header `printf` was inside the `for` loop. | Header printed once, before the loop. |
| 8 | Same grade `if / else if` code copy-pasted 8 times. | No reusable method. | One `getGrade()` method. |
| 9 | Search was case-sensitive; any number was accepted (500, -20); typing text crashed the program. | `equals()` instead of `equalsIgnoreCase()`; no validation; `nextInt()` / `nextDouble()` throw `InputMismatchException`. | `equalsIgnoreCase`, `readMark()` validation (0-100), `hasNextInt()` / `hasNextDouble()` checks. |

## What I learnt from this project

1. **Do not store what you can calculate.** Grade and result come from the total, so storing them in extra lists
   caused three separate bugs. Calculate on demand.
2. **Keep related data in sync carefully.** Parallel lists work, but every add / delete / swap must touch all of them.
   One `swapStudents()` helper means it is written once.
3. **Watch the braces.** A block that looks like part of an `if` can sit outside it, and then it runs for everything.
4. **Don't copy and paste logic.** Write a method. A change then needs one edit.
5. **`==` is for primitives and references; `.equals()` is for text.**
6. **Never trust user input.** Validate range and type before using it.
7. **Test with the right data.** The update bug only shows with 3 or more students and an update in the middle.

## Possible interview questions from this project

1. Why did you use parallel `ArrayList`s? What are the downsides? (Easy to go out of sync; a `Student` class is better.)
2. What is the difference between `list.set(i, x)` and `list.add(x)`?
3. Why did `str == "Failed"` work, and when would it fail?
4. How does bubble sort work? What does the `isSwap` flag do? (Early exit when the list is already sorted.)
5. Why call `input.nextLine()` before reading a name after `nextInt()`?
6. What does `Math.floor(x * 100) / 100` do? (Truncates to 2 decimals.)
7. What is the time complexity of bubble sort? Of searching by name? (O(n^2), O(n).)
8. Why is `Collections.swap` better than writing the temp-variable swap 5 times?
9. What happens if the user types text where a number is expected, and how did you handle it?

## Ideas for the next version

- [ ] Create a `Student` class (name, marks, total, grade) and use one `ArrayList<Student>` - removes the parallel lists. (OOPs)
- [ ] Support a variable number of subjects (use an array or `ArrayList<Double>` per student).
- [ ] Save and load students from a text file (File I/O).
- [ ] Handle ties for topper (show every student with the highest total).
- [ ] Use `try / catch` for input errors (Exception Handling).
- [ ] Sort by name as well as marks.

## Project structure

```
Java/
└── Projects/
    └── 01-Student-Marks-Manager/
        ├── StudentMarksManager.java
        └── README.md
```