package BombNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> splited = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int bombNumber = splited.get(0);
        int bombRange = splited.get(1);

        while (integerList.contains(bombNumber)) {
            int bomb = integerList.indexOf(bombNumber);
            int left = Math.max(0, bomb - bombRange);
            int right = Math.min(integerList.size() - 1, bomb + bombRange);

            for (int i = right; i >= left; i--) {
                integerList.remove(i);

            }

        }
        int sum = 0;
        for (int i = 0; i < integerList.size(); i++) {
            sum += integerList.get(i);
        }

        System.out.println(sum);
    }
}
