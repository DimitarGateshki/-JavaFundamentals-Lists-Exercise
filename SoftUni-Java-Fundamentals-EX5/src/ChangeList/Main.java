package ChangeList;

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

        while (!input.equals("end")){
            String[] tokens=input.split("\\s+");
            if (tokens[0].equals("Delete")){
                int delIndex=Integer.parseInt(tokens[1]);
                for (int i = 0; i < numbs.size(); i++) {
                    if (numbs.get(i)==delIndex){
                        numbs.remove(i);
                        i--;
                    }
                }


            }else {
                int position=Integer.parseInt(tokens[2]);
                int value=Integer.parseInt(tokens[1]);
                numbs.add(position,value);

            }
            input=sc.nextLine();
        }

        for (Integer wagon:numbs) {
            System.out.print(wagon+" ");
        }
    }

}
