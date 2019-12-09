package day4;

public class day4 {

    public static void main(String[] args) {
        boolean isValid = true;
        int count = 0;
        int countValidFound = 0;

        for (Integer i = 271973; i < 785961; i++) {

            if (isSixDigits(i) && containsTwoOfSameNumber(i) && containsIncreasingNumbersOnly(i)) {
                System.out.println("Potential valid password -> " + i);
                countValidFound ++;
            }
        }
        System.out.println("Total potential valid passwords found = " + countValidFound);
    }

    // Is 6 digits only
    public static boolean isSixDigits(Integer num) {
        boolean bResult = false;
        // Check length by converting to string so we can use the length() function
        if (String.valueOf(num).length() == 6) {
            bResult = true;
        }
        return bResult;
    }

    // Contains two of the same number
    //I still don't fully understand substrings, so need to look into them more
    public static boolean containsTwoOfSameNumber(Integer num) {
        boolean bResult = false;
        String sConvertedNumber = num.toString();
        String sPreviousChar = "";
        String sCurrentChar = "";

        for (Integer i = 0; i < sConvertedNumber.length(); i++) {
            sCurrentChar = sConvertedNumber.substring(i, i+1);
            if (sPreviousChar.equals(sCurrentChar)) {
                bResult = true; // We have found a repeating number so flag as true
            }
            sPreviousChar = sCurrentChar;
        }
        return bResult;
    }

    // Contains increasing numbers only
    public static boolean containsIncreasingNumbersOnly(Integer num) {
        boolean bResult = true; // Start as valid until we find an invalid test
        String sConvertedNumber = num.toString();
        Integer nPreviousNumber = 0;
        Integer nCurrentNumber = 0;

        for (Integer i = 0; i < sConvertedNumber.length(); i++) {
            nCurrentNumber = Integer.parseInt(sConvertedNumber.substring(i, i+1));
            if (nCurrentNumber < nPreviousNumber) {
                bResult = false; // We have found a number that is less than the prebouse numbers value so fail the test
            }
            nPreviousNumber = nCurrentNumber;
        }
        return bResult;
    }
}


//I wanted to keep my older code as reference, to show my development/ thought process...
//
//public class day4 {
//
//    public static void main(String[] args) {
//
//        //can't figure this out!!!!
//        boolean isValid = true;
//        int count = 0;
//
//        for (Integer i = 271973; i < 785961; i++) {
//
//            String number = i.toString();
//
//            for (int x = 0; x < 5; x++) {
//                if (number.charAt(x + 1) < number.charAt(x)) {
//                    isValid = false;
//                } else if (number.charAt(x + 1) != number.charAt(x)) {
//                    isValid = false;
//                } else if (!number.contains("11") && !number.contains("22") && !number.contains("33") && !number.contains("44") && !number.contains("55") && !number.contains("66") && !number.contains("77") && !number.contains("88") && !number.contains("99")){
//                    isValid = false;
//                }else {
//                    isValid = true;
//                }
//
//                }
//            if (isValid == true) {
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
//}
