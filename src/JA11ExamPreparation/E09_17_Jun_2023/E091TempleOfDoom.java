package JA11ExamPreparation.E09_17_Jun_2023;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class E091TempleOfDoom {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> tools = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect((Collectors.toCollection(LinkedList::new)));

        Stack<Integer> substances = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!substances.isEmpty() && !tools.isEmpty()) {

            int firstTool = tools.peek();
            int lastSubstance = substances.peek();
            int product = firstTool * lastSubstance;

            boolean foundEqual = false;
            for (Integer challenge : challenges) {
                if (challenge == product) {
                    foundEqual = true;
                    tools.poll();
                    substances.pop();
                    challenges.remove(challenge);
                    break;
                }
            }
            if (!foundEqual) {
                firstTool++;
                tools.poll();
                tools.offer(firstTool);
                lastSubstance--;
                substances.pop();
                if (lastSubstance > 0) {
                    substances.push(lastSubstance);

                }
            }
        }

        if (!challenges.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }
        else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        if (!tools.isEmpty()) {
            System.out.print("Tools: ");
            System.out.println(tools.stream().
                    map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        if (!substances.isEmpty()) {
            System.out.print("Substances: ");
            System.out.println(substances.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        if (!challenges.isEmpty()) {
            System.out.print("Challenges: ");
            System.out.println(challenges.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
    }
}