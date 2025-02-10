
import com.week3.day5.LargeFileReadingEfficiency;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class LargeFileReadingEfficiencyTest {

    @Test
    void testMeasureFileReaderTime() throws IOException {
        long time = LargeFileReadingEfficiency.measureFileReaderTime("large_file_1MB.txt");
        assertTrue(time >= 0, "FileReader time should be non-negative");
    }

    @Test
    void testMeasureInputStreamReaderTime() throws IOException {
        long time = LargeFileReadingEfficiency.measureInputStreamReaderTime("large_file_1MB.txt");
        assertTrue(time >= 0, "InputStreamReader time should be non-negative");
    }
}
