package com.ford.us.roman.util;

import com.ford.us.roman.exception.InvalidInputException;

import java.util.OptionalInt;

import static com.ford.us.roman.util.RomanConstant.*;
import static java.util.Objects.isNull;

public final class Roman {


    private Roman() {

    }

    //Convert Integer to Roman number
    public static String toRoman(Integer input) {
        validate(input);
        StringBuilder rString = new StringBuilder();
        for (var eachVal : ROMAN_INT_VALUES.entrySet()) {
            while (input >= eachVal.getKey()) {
                rString.append(eachVal.getValue());
                input = input - eachVal.getKey();
            }
        }

        return rString.toString();

    }

    private static void validate(Integer romanString) {

        if (isNull(romanString) || romanString <= 0) {
            //dont log any error as its util method validation
            throw new InvalidInputException(INVALID_INPUT.formatted(romanString));
        }
    }

    public static Integer toInteger(String romanString) {

        validate(romanString);
        return convertStringToInteger(romanString);

    }

    //convert roman number to Integer
    private static Integer convertStringToInteger(String romanString) {
        int length = romanString.length();
        int startValue = 0;
        Integer convertedValue = 0;

        for (var index = length - 1; index >= 0; index--) {
            Character x = romanString.charAt(index);
            Integer integerValue = ROMAN_LETTER_MAP.get(x);
            convertedValue = integerValue >= startValue ? convertedValue + integerValue :
                    convertedValue - integerValue;

            startValue = integerValue;

        }
        return convertedValue;
    }

    private static void validate(String romanString) {

        if (isNull(romanString) || romanString.isBlank()) {
            //dont log any error as its util method validation
            throw new InvalidInputException(INVALID_INPUT.formatted(romanString));
        }

        //invalid roman chars.
        OptionalInt invalidRomanLetter = romanString.chars()
                .filter(c -> !ALLOWED_ROMAN_CHARS.contains((char) c))
                .findFirst();

        if (invalidRomanLetter.isPresent()) {
            throw new InvalidInputException(INVALID_INPUT.formatted(romanString));
        }

    }
}
