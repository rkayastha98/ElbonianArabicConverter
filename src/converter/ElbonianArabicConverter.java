package converter;


import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException  Thrown if the value is an Elbonian number that does not conform
     *                                   to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     *                                   in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {
        String tempNum;


        tempNum = number.trim();
        isEmpty(tempNum);
        illegalSpace(tempNum);
        try {

            isArabic(number); //throws ValueOutOfBounds exception
        } catch (NumberFormatException e) {
            isElbonian(number); //throws MalformedNumberException
        }

        //We only get here if no errors were thrown
        this.number = number;
    }


    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        if (!isElbonian(number)) {
            return Integer.parseInt(number);
        } else {
            int sum = 0;
            int M = 0;
            int C = 0;
            int X = 0;
            int I = 0;
            int N = 0;
            int D = 0;
            int Y = 0;
            int J = 0;
            for (int i = 0; i < number.length(); i++) {
                String sub = number.substring(i, i + 1);
                switch (sub) {
                    case "M":
                        M++;
                        break;
                    case "C":
                        C++;
                        break;
                    case "X":
                        X++;
                        break;
                    case "I":
                        I++;
                        break;
                    case "N":
                        N++;
                        break;
                    case "D":
                        D++;
                        break;
                    case "Y":
                        Y++;
                        break;
                    case "J":
                        J++;
                        break;
                }


            }
            sum += M * 1000;
            sum += C * 100;
            sum += X * 10;
            sum += I;
            sum += N * 3000;
            sum += D * 300;
            sum += Y * 30;
            sum += J * 3;
            return sum;
        }
    }


    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        if (isElbonian(number)){
            return number;
        } else {
            int number = Integer.parseInt(this.number);
            String letters = "";
            while (number >= 3000) {
                letters += "N";
                number -= 3000;
            }
            while (number >= 1000) {
                letters += "M";
                number -= 1000;
            }
            while (number >= 300) {
                letters += "D";
                number -= 300;
            }
            while (number >= 100) {
                letters += "C";
                number -= 100;
            }
            while (number >= 30) {
                letters += "Y";
                number -= 30;
            }
            while (number >= 10) {
                letters += "X";
                number -= 10;
            }
            while (number >= 3) {
                letters += "J";
                number -= 3;
            }
            while (number >= 1) {
                letters += "I";
                number -= 1;
            }
            return letters;
        }

    }

    Boolean isElbonian(String number) {
        int M = 0;
        int C = 0;
        int X = 0;
        int I = 0;
        int N = 0;
        int D = 0;
        int Y = 0;
        int J = 0;
        for (int i = 0; i < number.length(); i++) {
            String sub = number.substring(i, i + 1);
            switch (sub) {
                case "M":
                    M++;
                    break;
                case "C":
                    C++;
                    break;
                case "X":
                    X++;
                    break;
                case "I":
                    I++;
                    break;
                case "N":
                    N++;
                    break;
                case "D":
                    D++;
                    break;
                case "Y":
                    Y++;
                    break;
                case "J":
                    J++;
                    break;
                default:
                    return false;
            }
            if (sub == "N" && (M > 0 || D > 0 || C > 0 || Y > 0 || X > 0 || J > 0 || I > 0)) {
                return false;
            }
            if (sub == "M" && (D > 0 || C > 0 || Y > 0 || X > 0 || J > 0 || I > 0)) {
                return false;
            }
            if (sub == "D" && (C > 0 || Y > 0 || X > 0 || J > 0 || I > 0)) {
                return false;
            }
            if (sub == "C" && (Y > 0 || X > 0 || J > 0 || I > 0)) {
                return false;
            }
            if (sub == "Y" && (X > 0 || J > 0 || I > 0)) {
                return false;
            }
            if (sub == "X" && (J > 0 || I > 0)) {
                return false;
            }
            if (sub == "J" && (I > 0)) {
                return false;
            }
        }


        if (M > 2 || C > 2 || X > 2 || I > 2) {
            return false;
        } else if (N > 3 || D > 3 || Y > 3 || J > 3) {
            return false;
        } else if ((N >= 3 && M > 0) || (D >= 3 && C > 0) || (Y >= 3 && X > 0) || (J >= 3 && I > 0)) {
            return false;
        } else {
            return true;
        }
    }

    void isArabic(String Number) throws ValueOutOfBoundsException {
        int myNum = Integer.parseInt(Number);
        if ((myNum > 0 ) && (myNum < 10000)) {
        } else {
            throw new ValueOutOfBoundsException("Input: " + Number + " is not between 0 and 10000");
        }
    }

    private void isEmpty(String number) throws MalformedNumberException {
        if (number.isEmpty()) throw new MalformedNumberException("empty string");
    }

    private void illegalSpace(String number) throws MalformedNumberException {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == ' ') {
                throw new MalformedNumberException("no spaces please");
            }
        }
    }



}