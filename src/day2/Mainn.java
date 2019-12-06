package day2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mainn {

    public static void main(String[] args) {
        int keyValue = 0;
        int value1 = 0;
        int value2 = 0;

        while(keyValue != 19690720) {
            int range = 99;
            int noun = (int)(Math.random() * range);
            int verb = (int)(Math.random() * range);
            Scanner in = new Scanner(System.in);

            List<Integer> input = Arrays.asList(1,noun,verb,3,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,19,1,19,10,23,2,10,23,27,1,27,6,31,1,13,31,35,1,13,35,39,1,39,10,43,2,43,13,47,1,47,9,51,2,51,13,55,1,5,55,59,2,59,9,63,1,13,63,67,2,13,67,71,1,71,5,75,2,75,13,79,1,79,6,83,1,83,5,87,2,87,6,91,1,5,91,95,1,95,13,99,2,99,6,103,1,5,103,107,1,107,9,111,2,6,111,115,1,5,115,119,1,119,2,123,1,6,123,0,99,2,14,0,0);

            for (int i = 0; i < input.size(); i+=4) {
                if(input.get(i) == 1) {
                    input.set(input.get(i+3), input.get(input.get(i+1)) + input.get(input.get(i+2)));
                } else if (input.get(i) == 2) {
                    input.set(input.get(i+3), input.get(input.get(i+1))*input.get(input.get(i+2)));
                } else if(input.get(i) == 3) {
                    int userIn = in.nextInt();
                    input.set(input.get(i + 1), userIn);
                }else if (input.get(i) == 4){
                    System.out.println(input.get(i + 1));
                }else if (input.get(i) == 99) {
                    break;
                }
            }
            keyValue = input.get(0);
            value1 = input.get(1);
            value2 = input.get(2);
        }
        System.out.println(value1 + " " + value2);
    }
}
