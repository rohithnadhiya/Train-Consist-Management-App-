import java.util.*;

public class UseCase15TrainConsistMgmt {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with validation
        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry Petrol
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petrol")) {

                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie\n");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("=======================================\n");

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petrol"); // ✅ valid

        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petrol"); // ❌ invalid

        System.out.println("UC15 runtime handling completed...");
    }
}