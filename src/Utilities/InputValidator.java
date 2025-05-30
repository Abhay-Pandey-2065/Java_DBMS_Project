package Utilities;

import Exception.*;

public class InputValidator {
    public static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidEmailException("Invalid email format.");
        }
    }
    public static void validatePassword(String password) throws InvalidPasswordException {
        if (!password.matches("[A-Za-z0-9@_]*")) {
            throw new InvalidPasswordException("Password contains invalid special characters. Only '@' and '_' are allowed.");
        }
    }
    
    public static void validatePasswordStrength(String password) throws WeakPasswordException {
        System.out.println("DEBUG: Password received = '" + password + "'");
        
        if (password.length() < 6)
            throw new WeakPasswordException("Password must be at least 6 characters long.");
        if (!password.matches(".*[A-Z].*"))
            throw new WeakPasswordException("Password must contain at least one uppercase letter.");
        if (!password.matches(".*\\d.*"))
            throw new WeakPasswordException("Password must contain at least one number.");
        if (!password.contains("@") && !password.contains("_"))
            throw new WeakPasswordException("Password must contain '@' or '_'.");
    }
    
    public static String validatePhoneNumber(String number) throws InvalidPhoneNumberException {
        if (number == null) {
            throw new InvalidPhoneNumberException("Phone number cannot be null.");
        }
        number = number.trim();
        // Remove leading zeros
        number = number.replaceFirst("^0+(?!$)", "");
        if (!number.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits and contain only numbers.");
        }
        return number;
    }
}
