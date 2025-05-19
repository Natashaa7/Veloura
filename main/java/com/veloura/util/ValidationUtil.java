package com.veloura.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

import jakarta.servlet.http.Part;

/**
 * 
 * LMU ID: 23048637
 * NAME: NATASHA BABU
 * 
 */
public class ValidationUtil {

    // 1. Validate if a field is null or empty
    /**
     * Validates if the given value is null or empty.
     * 
     * @param value the string to validate
     * @return true if the value is null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    // 2. Validate if a string contains only letters
    /**
     * Validates if the given value contains only alphabetic characters.
     * 
     * @param value the string to validate
     * @return true if the value contains only letters, false otherwise
     */
    public static boolean isAlphabetic(String value) {
        return value != null && value.matches("^[a-zA-Z]+$");
    }

    // 3. Validate if a string starts with a letter and is composed of letters and numbers
    /**
     * Validates if the given value starts with a letter and contains only letters and numbers.
     * 
     * @param value the string to validate
     * @return true if the value starts with a letter and contains only letters and numbers, false otherwise
     */
    public static boolean isAlphanumericStartingWithLetter(String value) {
        return value != null && value.matches("^[a-zA-Z][a-zA-Z0-9]*$");
    }

    // 4. Validate if a string is "male" or "female" (case insensitive)
    /**
     * Validates if the given title is "MR", "MS", or "MRS" (case insensitive).
     * 
     * @param title the string to validate
     * @return true if the title is valid, false otherwise
     */
    public static boolean isValidTitle(String title) {
        return title != null && (title.equalsIgnoreCase("MR") || title.equalsIgnoreCase("MS") || title.equalsIgnoreCase("MRS"));
    }

    /**
     * Validates if the username is alphanumeric and starts with a letter.
     * 
     * @param username the username to validate
     * @return true if the username is valid, false otherwise
     */
    public static boolean isValidUsername(String username) {
        return username != null && username.matches("^[a-zA-Z][a-zA-Z0-9]*$");
    }

    /**
     * Validates if the full name contains only alphabetic characters.
     * 
     * @param fullName the full name to validate
     * @return true if the full name is valid, false otherwise
     */
    public static boolean isValidCustomerName(String fullName) {
        return fullName != null && fullName.matches("^[a-zA-Z][a-zA-Z].*$");
    }

    // 5. Validate if a string is a valid email address
    /**
     * Validates if the given email is in a valid format.
     * 
     * @param email the email address to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email != null && Pattern.matches(emailRegex, email);
    }

    // 6. Validate if a number is of 10 digits and starts with 98
    /**
     * Validates if the given phone number is a valid 10-digit number starting with 98.
     * 
     * @param phonenumber the phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    public static boolean isValidPhoneNumber(String phonenumber) {
        return phonenumber != null && phonenumber.matches("^98\\d{8}$");
    }

    // 9. Validate if the date of birth is at least 16 years before today
    /**
     * Validates if the given date of birth is at least 16 years before today.
     * 
     * @param dob the date of birth to validate
     * @return true if the person is at least 16 years old, false otherwise
     */
    public static boolean isAgeAtLeast16(LocalDate dob) {
        if (dob == null) {
            return false;
        }
        LocalDate today = LocalDate.now();
        return Period.between(dob, today).getYears() >= 16;
    }

    // 7. Validate if a password is composed of at least 1 capital letter, 1 number, and 1 symbol
    /**
     * Validates if the given password meets the required strength criteria.
     * The password must contain at least 1 capital letter, 1 number, and 1 special character.
     * 
     * @param password the password to validate
     * @return true if the password is valid, false otherwise
     */
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password != null && password.matches(passwordRegex);
    }

    // 8. Validate if password and retype password match
    /**
     * Validates if the given passwords match.
     * 
     * @param password the original password
     * @param confirmPassword the retyped password
     * @return true if the passwords match, false otherwise
     */
    public static boolean doPasswordsMatch(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    // Jewellery validation methods

    /**
     * Validates if the jewellery name is valid (contains only letters).
     * 
     * @param jewellery_name the jewellery name to validate
     * @return true if the name is valid, false otherwise
     */
    public static boolean isValidJewelleryName(String jewellery_name) {
        return jewellery_name != null && jewellery_name.matches("^[a-zA-Z][a-zA-Z].*$");
    }

    /**
     * Validates if the material is one of the accepted types.
     * 
     * @param material the material to validate
     * @return true if the material is valid, false otherwise
     */
    public static boolean isValidMaterial(String material) {
        return material != null && material.matches("^(yellow gold|beige gold|white gold|rose gold|platinum|silver)$");
    }

    /**
     * Validates if the diamond weight is a valid number with up to two decimal places.
     * 
     * @param diamonds the diamond weight to validate
     * @return true if the diamond weight is valid, false otherwise
     */
    public static boolean isValidDiamond(String diamonds) {
        return diamonds != null && diamonds.matches("^\\d+(\\.\\d{0,2})?$");
    }

    /**
     * Validates if the gold purity is one of the accepted values (0, 18, 22, 24).
     * 
     * @param gold the gold purity to validate
     * @return true if the gold purity is valid, false otherwise
     */
    public static boolean isValidGold(String gold) {
        return gold != null && gold.matches("^(0|18|22|24)");
    }

    /**
     * Validates if the stock quantity is a valid number between 1 and 999.
     * 
     * @param stock the stock quantity to validate
     * @return true if the stock quantity is valid, false otherwise
     */
    public static boolean isValidStock(String stock) {
        return stock != null && stock.matches("^\\d{1,3}$");
    }

    /**
     * Validates if the total cost is a valid number with up to 8 digits.
     * 
     * @param total_cost the total cost to validate
     * @return true if the total cost is valid, false otherwise
     */
    public static boolean isValidTotalCost(String total_cost) {
        return total_cost != null && total_cost.matches("^\\d{1,8}$");
    }
    
    
}
