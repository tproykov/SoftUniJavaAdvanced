package JA11ExamPreparation.E05_10_Apr_2024;

import java.util.*;
import java.util.stream.Collectors;

public class E051PiePursuit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Integer> contestantCapacities = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));

        Stack<Integer> piecesInPies = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        while (!contestantCapacities.isEmpty() && !piecesInPies.isEmpty()) {

            int firstContestantCapacity = contestantCapacities.peek();
            int piecesInLastPie = piecesInPies.peek();

            if (firstContestantCapacity > piecesInLastPie) {
                firstContestantCapacity -= piecesInLastPie;
                contestantCapacities.poll();
                contestantCapacities.offer(firstContestantCapacity);
                piecesInPies.pop();
            }
            else if (firstContestantCapacity == piecesInLastPie) {
                contestantCapacities.poll();
                piecesInPies.pop();
            }
            else {
                contestantCapacities.poll();
                piecesInPies.pop();

                int remainingPiePieces = piecesInLastPie - firstContestantCapacity;

                if (remainingPiePieces == 1 && piecesInPies.size() > 1) {
                    int addedToNextPie = piecesInPies.pop() + 1;
                    piecesInPies.push(addedToNextPie);
                }
                else if (remainingPiePieces == 1) {
                    piecesInPies.push(remainingPiePieces);
                }
            }
        }

        if (piecesInPies.isEmpty() && !contestantCapacities.isEmpty()) {
            System.out.println("We wil have to wait for more pies to be baked!");
            System.out.print("Contestants left: ");
            System.out.println(contestantCapacities.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        else if (piecesInPies.isEmpty()) {
            System.out.println("We have a champion!");
        }
        else {
            System.out.println("Our contestants need to rest!");
            System.out.print("Pies left: ");
            System.out.println(piecesInPies.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}