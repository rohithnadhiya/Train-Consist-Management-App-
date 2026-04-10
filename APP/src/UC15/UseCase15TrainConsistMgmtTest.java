import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase15TrainConsistMgmtTest {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String msg) {
            super(msg);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petrol")) {
                throw new CargoSafetyException("Unsafe cargo assignment!");
            }
            this.cargo = cargo;
        }
    }

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        b.assignCargo("Petrol");

        assertEquals("Petrol", b.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("Rectangular");

        assertThrows(CargoSafetyException.class, () -> {
            b.assignCargo("Petrol");
        });
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie b = new GoodsBogie("Rectangular");

        try {
            b.assignCargo("Petrol");
        } catch (Exception e) {
            // ignore
        }

        assertNull(b.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b1 = new GoodsBogie("Rectangular");
        GoodsBogie b2 = new GoodsBogie("Cylindrical");

        try {
            b1.assignCargo("Petrol");
        } catch (Exception e) {
            // handled
        }

        b2.assignCargo("Coal"); // should still run

        assertEquals("Coal", b2.cargo);
    }

    @Test
    void testCargo_FinallyLogicSimulation() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        b.assignCargo("Grain");

        assertEquals("Grain", b.cargo);
    }
}