


import static org.junit.jupiter.api.Assertions.*;

import com.week3.day5.StringConcatenationPerformance;
import org.junit.jupiter.api.Test;

class StringConcatenationPerformanceTest {

    @Test
    void testStringConcatenation() {
        double time = StringConcatenationPerformance.stringConcatenation(1000);
        assertTrue(time >= 0, "String concatenation time should be non-negative");
    }

    @Test
    void testStringBuilderConcatenation() {
        double time = StringConcatenationPerformance.stringBuilderConcatenation(1000);
        assertTrue(time >= 0, "StringBuilder concatenation time should be non-negative");
    }

    @Test
    void testStringBufferConcatenation() {
        double time = StringConcatenationPerformance.stringBufferConcatenation(1000);
        assertTrue(time >= 0, "StringBuffer concatenation time should be non-negative");
    }
}

