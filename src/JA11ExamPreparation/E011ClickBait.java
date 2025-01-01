package JA11ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class E011ClickBait {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> engagementScores = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Integer> popularityScores = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        int targetEngagementValue = Integer.parseInt(scanner.nextLine());

        List<Integer> finalFeed = new ArrayList<>();

        while (!engagementScores.isEmpty() && !popularityScores.isEmpty()) {

            int suggestedLink = engagementScores.poll();
            int featuredArticle = popularityScores.pop();

            if (featuredArticle > suggestedLink) {

                int remainder = featuredArticle % suggestedLink;
                finalFeed.add(remainder);
                if (remainder != 0) {
                    popularityScores.push(remainder * 2);
                }
            }
            else if (featuredArticle < suggestedLink) {

                int remainder = suggestedLink % featuredArticle;
                finalFeed.add(-remainder);
                if (remainder != 0) {
                    engagementScores.offer(remainder * 2);
                }
            }
            else {
                finalFeed.add(0);
            }
        }

        System.out.print("Final Feed: ");
        System.out.println(String.join(", ", finalFeed.stream()
                .map(String::valueOf)
                .toList()));

        int totalEngagementValue = finalFeed.stream().mapToInt(Integer::intValue).sum();

        if (totalEngagementValue >= targetEngagementValue) {
            System.out.println("Goal achieved! Engagement Value: " + totalEngagementValue);
        }
        else {
            int shortfall = targetEngagementValue - totalEngagementValue;
            System.out.println("Goal not achieved! Short by: " + shortfall);
        }
    }
}