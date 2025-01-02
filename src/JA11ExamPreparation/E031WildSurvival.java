package JA11ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class E031WildSurvival {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> beeGroups = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        Stack<Integer> beeEaterGroups = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        while (!beeGroups.isEmpty() && !beeEaterGroups.isEmpty()) {

            int firstBeeGroup = beeGroups.peek();
            int lastBeeEaterGroup = beeEaterGroups.peek();

            if ( lastBeeEaterGroup > firstBeeGroup * 7) {




            }


        }






    }

}
