import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UseCase10TrainConsistMgmtTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    int totalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );

        assertEquals(128, totalCapacity(list));
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("First Class", 24),
                new Bogie("AC Chair", 56)
        );

        assertEquals(152, totalCapacity(list));
    }

    @Test
    void testReduce_SingleBogie() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 72)
        );

        assertEquals(72, totalCapacity(list));
    }

    @Test
    void testReduce_EmptyList() {
        List<Bogie> list = new ArrayList<>();

        assertEquals(0, totalCapacity(list));
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 30)
        );

        assertEquals(100, totalCapacity(list));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = List.of(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 50)
        );

        assertEquals(100, totalCapacity(list));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));

        totalCapacity(list);

        assertEquals(1, list.size());
    }
}