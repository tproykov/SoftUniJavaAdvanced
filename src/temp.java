import java.util.*;

public class temp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        int counter = 1;
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.getFirst().size(); col++) {
                matrix.get(row).add(counter++);
            }
        }

    }
}
