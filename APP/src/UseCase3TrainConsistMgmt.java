import java.util.HashSet;
import java.util.Set;

public class UseCase3TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("      UC3 - Track Unique Bogie IDs     ");
        System.out.println("=======================================\n");

        // Create HashSet (stores only unique values)
        Set<String> bogies = new HashSet<>();

        // ADD bogie IDs (including duplicates)
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        // Duplicate entries (will be ignored automatically)
        bogies.add("BG101");
        bogies.add("BG102");

        // Display unique bogie IDs
        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);

        // Note
        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("\nUC3 Uniqueness Validation completed...");
    }
}