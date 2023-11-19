/**
    @author Alexander Arizola
*/

// THIS CLASS REPRESENTS A LONG INTEGER
public class LongInteger {
    private long value;

    /**
        * CREATE ARGUMENT-REQUIRED CONSTRUCTOR FOR CLASS, IT TAKES A PARAMETER TO ASSIGN THE 'value' VARIABLE MANUALLY.
        * @param pValue The new value to initialize the class.
    */
    public LongInteger(long pValue) {
        this.value = pValue;
    }

    /**
        * RETURNS THE VALUE OF THIS CLASS
        * @return The long value of the class.
    */
    public long toLong() {
        return this.value;
    }

    /**
        * CHECKS IF THE CLASS VALUE IS EVEN.
        * @return true if the value is even, false otherwise.
    */
    public boolean isEven() {
        return this.value % 2 == 0;
    }

    /**
        * CHECKS IF THE CLASS VALUE IS ODD.
        * @return true if the value is odd, false otherwise.
    */
    public boolean isOdd() {
        return this.value % 2 != 0;
    }

    /**
        * CHECKS IF THE PARAMETER VALUE IS EVEN.
        * @param pValue The value to check if it is even.
        * @return true if the value is even, false otherwise.
    */
    public static boolean isEven(long pValue) {
        return pValue % 2 == 0;
    }

    /**
        * CHECKS IF THE PARAMETER VALUE IS ODD.
        * @param pValue The value to check if it is odd.
        * @return true if the value is odd, false otherwise.
    */
    public static boolean isOdd(long pValue) {
        return pValue % 2 != 0;
    }

    /**
        * CHECKS IF THE CLASS VALUE IS PRIME.
        * @return true if the value is prime, false otherwise.
    */
    public boolean isPrime() {
        if (value < 2) {
            return false;
        }

        // ITERATE THROUGH TO CHECK IF IT IS PRIME
        for (long i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }

        // RETURN DEFAULT BOOLEAN
        return true;
    }

    /**
        * CHECKS IF THE PARAMETER VALUE IS PRIME.
        * @param pValue The value to check if it is prime.
        * @return true if the value is prime, false otherwise.
    */
    public static boolean isPrime(long pValue) {
        if (pValue < 2) {
            return false;
        }

        // ITERATE THROUGH TO CHECK IF IT IS PRIME
        for (long i = 2; i <= Math.sqrt(pValue); i++) {
            if (pValue % i == 0) {
                return false;
            }
        }

        // RETURN DEFAULT BOOLEAN
        return true;
    }

    /**
        * CHECKS IF THE CLASS VALUE IS EQUAL TO THE PARAMETER VALUE
        * @param pValue The long value to compare for equality.
        * @return true if the values are equal, false otherwise.
    */
    public boolean equals(long pValue) {
        return this.value == pValue;
    }

    /**
        * CHECKS IF THE CLASS VALUE IS EQUAL TO ANOTHER LongInteger OBJECT.
        * @param pValue The LongInteger object to compare for equality.
        * @return true if the values are equal, false otherwise.
    */
    public boolean equals(LongInteger pValue) {
        return this.value == pValue.toLong();
    }

    /**
        * CONVERTS A STRING INTO A LONG VALUE, POSITIVE OR NEGATIVE.
        * @param stringToCheck The string to parse into a long value.
        * @return The converted value that can be long, positive or negative.
        * @throws IllegalArgumentException Can be thrown based on 4 conditions which include.
    */
    public static long parseLong(String stringToCheck) throws IllegalArgumentException {
        int sign = 1;
        long result = 0;

        // CHECK THE FIRST CHARACTER TO TELL IF IT IS NEGATIVE
        if (stringToCheck.charAt(0) == '-') {
            sign = -1;
            stringToCheck = stringToCheck.substring(1);
        }

        // ITERATE THROUGH STRING'S CHARACTERS TO BUILD THE RESULT
        for (char stringCharacter : stringToCheck.toCharArray()) {
            if (Character.isDigit(stringCharacter)) {
                result = result * 10 + Character.getNumericValue(stringCharacter);
                if (result < 0) {
                    throw new IllegalArgumentException("String's number representation is too large and is producing overflow.");
                }
            } else {
                throw new IllegalArgumentException("String contains non-digit characters.");
            }
        }

        // ADD SIGN TO RESULT AND CHECK FOR UNDERFLOW
        result *= sign;
        if ((sign == 1 && result < 0) || (sign == -1 && result > 0)) {
            throw new IllegalArgumentException("String's number representation is too small and is producing underflow.");
        }

        // FINALLY RETURN RESULT
        return result;
    }
}
