package day4;

public class day4 {

    public static void main(String[] args) {

        //can't figure this out!!!!
        boolean isValid = true;
        int count = 0;

        for (Integer i = 271973; i < 785961; i++) {

            String number = i.toString();

            for (int x = 0; x < number.length(); x++) {
                if (x + 1 < x) {
                    isValid = false;
                } else if (x + 1 == x) {
                    isValid = false;
                } else {
                    isValid = true;
                }

                if (isValid == true) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
