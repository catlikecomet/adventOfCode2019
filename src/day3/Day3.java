package day3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//I needed quite a lot of help with this, so i referred to some older game code that i have done in the past for this task

public class Day3 {
    public static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static int[] getDir (char c) {
        switch (c) {
            case 'U': return new int[] {0,1};
            case 'D': return new int[] {0,-1};
            case 'L': return new int[] {-1,0};
            case 'R': return new int[] {1,0};
        }
        return null;
    }

    public static void main(String[] args) throws Exception {

        Map<String, Integer> wire = new HashMap<>();
        String[] input = r.readLine().split(",");

        int closestDistance = Integer.MAX_VALUE;
        int shortestWire = Integer.MAX_VALUE;

        int x = 0, y = 0, d = 0;

        for (int i = 0; i < input.length; i++) {
            int[] dir = getDir(input[i].charAt(0));
            int len = Integer.parseInt(input[i].substring(1));
            for (int j = 0; j < len; j++) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                wire.put(newX + "_" + newY, ++d);
                x = newX;
                y = newY;
            }
        }
        input = r.readLine().split(",");
        x = y = d = 0;
        for (int i = 0; i < input.length; i++) {
            int[] dir = getDir(input[i].charAt(0));
            int len = Integer.parseInt(input[i].substring(1));
            for (int j = 0; j < len; j++) {

                int newX = x + dir[0];
                int newY = y + dir[1];
                d++;

                if (wire.containsKey(newX + "_" + newY)) {
                    closestDistance = Math.min(closestDistance, Math.abs(newX) + Math.abs(newY));
                    shortestWire = Math.min(shortestWire, wire.get(newX + "_" + newY) + d);
                }
                x = newX;
                y = newY;
            }
        }
        System.out.println(closestDistance);
        System.out.println(shortestWire);
    }
}
