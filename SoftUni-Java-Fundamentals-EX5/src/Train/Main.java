package Train;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        List<Integer> wagons= Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int max=Integer.parseInt(sc.nextLine());


        String input= sc.nextLine();

        while (!input.equals("end")){
            String[] tokens=input.split("\\s+");
            if (tokens[0].equals("Add")){
                int newWagon=Integer.parseInt(tokens[1]);
                wagons.add(newWagon);
            }else {
                int wagonEntry=Integer.parseInt(tokens[0]);
                for (int i = 0; i <wagons.size() ; i++) {
                    if (wagons.get(i)+wagonEntry<=max){
                        wagonEntry=wagonEntry+wagons.get(i);
                        wagons.set(i,wagonEntry);
                        break;
                    }
                }


            }
            input=sc.nextLine();
        }

        for (Integer wagon:wagons) {
            System.out.print(wagon+" ");
        }
    }
}
