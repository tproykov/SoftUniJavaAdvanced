package JA10AlgorithmsIntroduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L04SetCover {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().substring(10).split(", ");

        int[] universe = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }

        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));

        List<int[]> sets = new ArrayList<>();

        for (int i = 0; i < numberOfSets; i++) {

            String[] setElements = reader.readLine().split(", ");

            int[] set = new int[setElements.length];

            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }

            sets.add(set);
        }

        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Sets to take (%d):\n", chosenSets.size()));

        for (int[] set : chosenSets) {
            stringBuilder.append("{ ");
            stringBuilder.append(Arrays.toString(set).replaceAll("[\\[\\]]", ""));
            stringBuilder.append(" }").append(System.lineSeparator());
        }

        System.out.println(stringBuilder);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {

        List<Integer> universeSet = IntStream.of(universe)
                .boxed()
                .collect(Collectors.toList());

        List<int[]> selectedSets = new ArrayList<>();

        while (!universeSet.isEmpty()) {
            int maxCoverage = 0;
            int[] bestSet = null;

            for (int[] set : sets) {
                int currentCoverage = 0;
                for (int element : set) {
                    if (universeSet.contains(element)) {
                        currentCoverage++;
                    }
                }

                if (currentCoverage > maxCoverage) {
                    maxCoverage = currentCoverage;
                    bestSet = set;
                }
            }

            if (bestSet == null) {
                break;
            }

            selectedSets.add(bestSet);

            for (int element : bestSet) {
                universeSet.remove(Integer.valueOf(element));  // Use valueOf to ensure we remove the Integer object
            }
        }

        return selectedSets;
    }
}