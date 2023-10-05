package com.ford.us.roman.util;

import com.ford.us.roman.exception.InvalidInputException;

import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;

import static com.ford.us.roman.util.RomanConstant.INVALID_INPUT;
import static java.util.Objects.isNull;

public final class Roman {


    private  static final Map<Character, Integer>

            ROMAN_LETTER_MAP = Map.of(
            'I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500,
            'M', 1000);

    private static final Set<Character> ALLOWED_ROMAN_CHARS = ROMAN_LETTER_MAP.keySet();

    private Roman() {

    }

    /**
     * @param romanString
     * @return
     */
    public static Integer toInteger(String romanString) {

        validate(romanString);
        return convertStringToInteger(romanString);

    }


    //XI
    private static Integer convertStringToInteger(String romanString) {
        int length = romanString.length();
        int startValue=0;
        Integer convertedValue=0;

        for (var index = length-1;  index>=0;  index--) {
            Character x=romanString.charAt(index);
            Integer integerValue = ROMAN_LETTER_MAP.get(x);
            convertedValue=integerValue>=startValue?convertedValue+integerValue:
                    convertedValue-integerValue;

            startValue=integerValue;

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
                .filter(c -> !ALLOWED_ROMAN_CHARS.contains((char)c))
                .findFirst();

        if (invalidRomanLetter.isPresent())
        {
            throw new InvalidInputException(INVALID_INPUT.formatted(romanString));
        }

    }
}
