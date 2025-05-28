# EdX - Algorithmic Design and Techniques - Solutions

This repository contains solutions to programming assignments for the EdX course "Algorithmic Design and Techniques". The solutions are implemented in Java.

## Structure

The solutions are organized into folders corresponding to the weeks and topics covered in the course:

* **`week_1_programming_challenges`**: Solutions for the programming challenges from Week 1.
* **`week_2_algorithmic_warmup`**: Solutions for the algorithmic warmup exercises from Week 2.

## Programs Included

### Week 1: Programming Challenges

* **`APlusB.java`**: A simple program to compute the sum of two integers.
* **`MaxPairwiseProductNaive.java`**: A naive approach to find the maximum pairwise product in a sequence of numbers.
* **`MaxPairwiseProductFast.java`**: An optimized approach to find the maximum pairwise product in a sequence of numbers, including a stress test utility.

### Week 2: Algorithmic Warmup

* **`Fibonacci.java`**: Calculates the Nth Fibonacci number using an iterative approach with an array.
* **`FibonacciLastDigit.java`**: Calculates the last digit of the Nth Fibonacci number efficiently.
* **`GCD.java`**: Computes the Greatest Common Divisor (GCD) of two integers using the Euclidean algorithm.
* **`LCM.java`**: Computes the Least Common Multiple (LCM) of two integers, utilizing the GCD.
* **`FibonacciHuge.java`**: Calculates the Nth Fibonacci number modulo M, leveraging the Pisano period. Includes a naive method and a stress testing utility to compare the fast and naive approaches.
* **`FibonacciSumLastDigit.java`**: Calculates the last digit of the sum of the first N Fibonacci numbers.

## How to Compile and Run

These programs are written in Java. You will need a Java Development Kit (JDK) installed to compile and run them.

1.  **Compilation**:
    Open a terminal or command prompt, navigate to the directory containing the `.java` file, and compile it using the Java compiler:
    ```bash
    javac FileName.java
    ```
    Replace `FileName.java` with the actual name of the file (e.g., `Fibonacci.java`).

2.  **Execution**:
    After successful compilation, a `FileName.class` file will be created. Run the compiled program using:
    ```bash
    java week_X_topic.FileName
    ```
    Replace `week_X_topic.FileName` with the fully qualified class name (e.g., `week_2_algorithmic_warmup.Fibonacci`).
    The programs generally expect input from the standard input (console) as per the problem descriptions.

---
