
import static org.junit.jupiter.api.Assertions.*;

import com.week3.day5.RecursiveVsIterativeFibonacci;
import org.junit.jupiter.api.Test;

class RecursiveVsIterativeFibonacciTest {

    @Test
    void testFibonacciRecursive() {
        assertEquals(0, RecursiveVsIterativeFibonacci.fibonacciRecursive(0), "Recursive Fibonacci failed for n=0");
        assertEquals(1, RecursiveVsIterativeFibonacci.fibonacciRecursive(1), "Recursive Fibonacci failed for n=1");
        assertEquals(55, RecursiveVsIterativeFibonacci.fibonacciRecursive(10), "Recursive Fibonacci failed for n=10");
    }

    @Test
    void testFibonacciIterative() {
        assertEquals(0, RecursiveVsIterativeFibonacci.fibonacciIterative(0), "Iterative Fibonacci failed for n=0");
        assertEquals(1, RecursiveVsIterativeFibonacci.fibonacciIterative(1), "Iterative Fibonacci failed for n=1");
        assertEquals(55, RecursiveVsIterativeFibonacci.fibonacciIterative(10), "Iterative Fibonacci failed for n=10");
    }
}
