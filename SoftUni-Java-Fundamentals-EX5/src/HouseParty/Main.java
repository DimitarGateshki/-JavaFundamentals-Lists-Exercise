package HouseParty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> partyList=new ArrayList<>();

        int command=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < command; i++) {
            String input= sc.nextLine();
            checkParyMember(input,partyList);
        }


        for (String name:partyList) {
            System.out.println(name);
        }
    }







    private static void checkParyMember(String input, List<String> partyList) {
        String[] tokens=input.split("\\s+");
        if (tokens[2].equals("going!")){
            if (partyList.contains(tokens[0])){
                System.out.printf("%s is already in the list!%n",tokens[0]);
            }else {
                partyList.add(tokens[0]);
            }

        }else {
            if (partyList.contains(tokens[0])){
                partyList.remove(tokens[0]);
            }else {
                System.out.printf("%s is not in the list!%n" ,tokens[0]);
            }

        }
    }
}
