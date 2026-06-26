# 🧩 Sudoku Solver with Real-Time Visualization

A Java-based **9×9 Sudoku Solver** that solves partially filled Sudoku puzzles using a **recursive backtracking algorithm** while providing a **real-time graphical visualization** of the solving process. The application also automatically generates an **MP4 video** demonstrating every step of the solution using **FFmpeg**.

---

## 📌 Features

* Interactive **9×9 Sudoku** board input through the console.
* Validates the Sudoku configuration before solving.
* Solves the puzzle using **recursive backtracking**.
* Real-time visualization using **Java Swing**.
* Color-coded animation for:

  * 🟩 Number placement
  * 🟥 Backtracking
* Automatically records the solving process into an **MP4 video**.
* Stores the initial and solved Sudoku board as screenshots.
* Modular, object-oriented implementation following the **Observer Design Pattern**.

---

## 🛠 Technologies Used

* Java
* Java Swing
* Java AWT
* Object-Oriented Programming (OOP)
* Recursive Backtracking Algorithm
* Observer Design Pattern
* FFmpeg
* Java ProcessBuilder

---

## 📂 Project Structure

```text
Sudoku-Solver/
│
├── Main.java
├── SudokuBoard.java
├── SudokuSolver.java
├── SudokuGUI.java
├── SolverListener.java
├── FrameRecorder.java
│
├── Output/
│   └── sample_output.mp4
│
├── Screenshots/
│   ├── initial.png
│   └── solved.png
│
├── frames/
│   └── Sample frame sequence
│
├── README.md
├── LICENSE
└── .gitignore
```

---

## 🧠 Algorithm

The solver uses the **Recursive Backtracking Algorithm**.

### Workflow

1. Find the next empty cell.
2. Try digits **1–9**.
3. Check validity using:

   * Row constraint
   * Column constraint
   * 3×3 subgrid constraint
4. If valid, place the digit and continue recursively.
5. If no digit works, backtrack and try another possibility.
6. Continue until all **81 cells** are filled or determine that no solution exists.

---

## 🎥 Output

During execution, the program automatically generates:

```text
Output/
    solution.mp4
```

The video contains the complete solving process from the initial puzzle to the final solution.

Additionally,

```text
Screenshots/
    initial.png
    solved.png
```

are generated for quick visualization.

---

## 🚀 How to Run

### 1. Compile

```bash
javac *.java
```

### 2. Run

```bash
java Main
```

### 3. Enter the Sudoku

Use **0** for empty cells.

Example:

```text
5 3 0 0 7 0 0 0 0
6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 0 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 6 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 7 9
```

---

## 📸 Frames

### Initial Sudoku

> Add `StartingEndingState/initial.png` here.

### Solving Animation

> Add `frames/framexxxx.png` here

### Solved Sudoku

> Add `StartingEndingState/solved.png` here.

---

## 🎬 Demo

A sample execution video is available in:

```text
Output/solution.mp4
```

---

## 📈 Highlights

* Solves valid Sudoku puzzles using **recursive depth-first search (DFS)** with backtracking.
* Performs dynamic constraint checking across **81 cells**, **9 rows**, **9 columns**, and **9 subgrids**.
* Implements an event-driven architecture using the **Observer Design Pattern** to decouple the solving algorithm from visualization.
* Integrates **FFmpeg** for automatic MP4 generation, recording every intermediate board state.

---

## 🔮 Future Improvements

* GUI-based board input.
* Variable animation speed.
* Difficulty estimation.
* Sudoku puzzle generator.
* Support for larger Sudoku variants (e.g., 16×16).

---

## 👨‍💻 Author

**Mayukh Paul**

B.Tech, Chemical Engineering
Indian Institute of Technology Kharagpur
