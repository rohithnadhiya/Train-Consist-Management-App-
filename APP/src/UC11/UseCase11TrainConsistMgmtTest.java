import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

class UseCase11TrainConsistMgmtTest {

    String trainRegex = "TRN-\\d{4}";
    String cargoRegex = "PET-[A-Z]{2}";

    boolean isValidTrain(String input) {
        return Pattern.matches(trainRegex, input);
    }

    boolean isValidCargo(String input) {
        return Pattern.matches(cargoRegex, input);
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isValidTrain("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrain("TRAIN12"));
        assertFalse(isValidTrain("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isValidCargo("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargo("PET123"));
        assertFalse(isValidCargo("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrain("TRN-12345"));
    }

    @Test
    void testRegex_CargoUppercaseValidation() {
        assertFalse(isValidCargo("PET-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrain(""));
        assertFalse(isValidCargo(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrain("TRN-1234X"));
    }
}