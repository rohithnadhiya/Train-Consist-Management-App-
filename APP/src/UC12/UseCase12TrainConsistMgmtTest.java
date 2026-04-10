import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UseCase12TrainConsistMgmtTest {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    boolean isSafe(List<GoodsBogie> list) {
        return list.stream().allMatch(g ->
                !g.type.equalsIgnoreCase("Cylindrical")
                        || g.cargo.equalsIgnoreCase("Petrol")
        );
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Petrol"),
                new GoodsBogie("Box", "Grain")
        );

        assertTrue(isSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(isSafe(list));
    }

    @Test
    void testSafety_NonCylindricalAllowed() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        assertTrue(isSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = List.of(
                new GoodsBogie("Cylindrical", "Petrol"),
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(isSafe(list));
    }

    @Test
    void testSafety_EmptyList() {
        List<GoodsBogie> list = new ArrayList<>();

        assertTrue(isSafe(list)); // no violation
    }
}