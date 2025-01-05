package JA11ExamPreparation.E07_13_Dec_2023;

import java.util.*;
import java.util.stream.Collectors;

public class E071WormsAndHoles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> worms = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        Queue<Integer> holes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        int matches = 0;
        boolean wormsDropped = false;

        while (!worms.isEmpty() && !holes.isEmpty()) {

            int lastWorm = worms.peek();
            int firstHole = holes.peek();

            if (lastWorm == firstHole) {
                matches++;
                worms.pop();
                holes.poll();
            }
            else {
                holes.poll();
                lastWorm -= 3;
                if (lastWorm <= 0) {
                    wormsDropped = true;
                    worms.pop();
                }
                else {
                    worms.pop();
                    worms.push(lastWorm);
                }
            }
        }

        if (matches > 0) {
            System.out.println("Matches: " + matches);
        }
        else {
            System.out.println("There are no matches.");
        }

        if (worms.isEmpty() && !wormsDropped) {
            System.out.println("Every worm found a suitable hole!");
        }
        else if (worms.isEmpty()) {
            System.out.println("Worms left: none");
        }
        else {
            System.out.print("Worms left: ");
            System.out.println(worms.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        if (holes.isEmpty()) {
            System.out.println("Holes left: none");
        }
        else {
            System.out.print("Holes left: ");
            System.out.println(holes.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
    }
}