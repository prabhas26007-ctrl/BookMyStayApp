// UC9: Error Handling & Validation
import java.util.*;
class ValidationException extends Exception {
    public ValidationException(String message) { super(message); }
}
class BookingValidator {
    public void validateReservation(String resId, String guestName, int guests) throws ValidationException {
        if (resId == null || resId.isEmpty()) throw new ValidationException("Invalid reservation ID");
        if (guestName == null || guestName.isEmpty()) throw new ValidationException("Guest name required");
        if (guests <= 0) throw new ValidationException("Invalid guest count");
        System.out.println("Validation passed for " + resId);
    }
}
public class UC9_ErrorHandlingValidation {
    public static void main(String[] args) {
        BookingValidator validator = new BookingValidator();
        try {
            validator.validateReservation("RES001", "John Doe", 2);
            validator.validateReservation("", "Jane", 1);
        } catch (ValidationException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
