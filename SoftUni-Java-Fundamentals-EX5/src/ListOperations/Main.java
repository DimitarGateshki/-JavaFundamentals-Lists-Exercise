package ListOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        List<Integer> numbs= Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        String input= sc.nextLine();

        while (!input.equals("End")){
            String[] tokens=input.split("\\s+");
            swichCommand(tokens,numbs);
            input=sc.nextLine();
        }

        for (Integer wagon:numbs) {
            System.out.print(wagon+" ");
        }
    }

    private static void swichCommand(String[] tokens, List<Integer> numbs) {
        switch (tokens[0]) {
            case "Add":
                numbs.add(Integer.parseInt(tokens[1]));
                break;
            case "Insert":
                if (checkIndex(numbs, tokens[2])) {
                    numbs.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
                }
                break;
            case "Remove":
                if (checkIndex(numbs, tokens[1])) {
                    numbs.remove(Integer.parseInt(tokens[1]));
                }
                break;
            case "Shift":
                if (tokens[1].equals("left")) {
                    shiftLeft(Integer.parseInt(tokens[2]), numbs);
                }else {

                    shiftRight(Integer.parseInt(tokens[2]), numbs);
                }
                break;

        }

    }

    private static void shiftRight(int parseInt, List<Integer> numbs) {
        for (int i = 0; i < parseInt; i++) {
            numbs.add(0,numbs.get(numbs.size()-1));
            numbs.remove(numbs.size()-1);
        }
    }

    private static void shiftLeft(int parseInt, List<Integer> numbs) {
        for (int i = 0; i < parseInt; i++) {
            numbs.add(numbs.get(0));
            numbs.remove(0);
        }
    }

    private static boolean checkIndex(List<Integer> numbs, String token) {
        if (Integer.parseInt(token)<0||Integer.parseInt(token)>numbs.size()+1){
            System.out.println("Invalid index");
            return false;
        }
        return true;

    }

}
