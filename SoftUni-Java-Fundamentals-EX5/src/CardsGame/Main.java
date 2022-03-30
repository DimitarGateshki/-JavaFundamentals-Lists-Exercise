package CardsGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        List<Integer> firstPlayer = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayer = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            if (firstPlayer.get(0) > secondPlayer.get(0)) {
                swichCards(firstPlayer, secondPlayer);
            } else if (firstPlayer.get(0) < secondPlayer.get(0)) {
                swichCards(secondPlayer, firstPlayer);
            } else {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }
        }

        int sum = 0;
        if (!firstPlayer.isEmpty()) {
            for (Integer element : firstPlayer) {
                sum += element;
            }
            System.out.println("First player wins! Sum: " + sum);
        } else {
            for (Integer element : secondPlayer) {
                sum += element;
            }
            System.out.println("Second player wins! Sum: " + sum);
        }

    }

    private static void swichCards(List<Integer> winner, List<Integer> looser) {
        int winCard=winner.get(0);
        winner.remove(0);
        winner.add(winCard);
        winner.add(looser.get(0));
        looser.remove(0);

    }
}
