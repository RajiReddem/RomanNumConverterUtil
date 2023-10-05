package com.ford.us.roman.util;

import com.ford.us.roman.exception.InvalidInputException;

import java.util.Map;
import java.util.Objects;

import static com.ford.us.roman.util.RomanConstant.INVALID_INPUT;
import static java.util.Objects.isNull;

public final class Roman {


    private final static Map<Character, Integer>

            ROMAN_LETTER_MAP = Map.of(
            'I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500,
            'M', 1000);

    private Roman() {

    }

    /**
     * @param romanString
     * @return
     */
    public static Integer toInteger(String romanString) {

        validate(romanString);
        return -1;
    }

    private static void validate(String romanString) {


        if (isNull(romanString) || romanString.isBlank()) {
            //dont log any error as its util method validation
            throw new InvalidInputException(INVALID_INPUT.formatted(romanString));
        }


    }
}
