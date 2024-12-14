package JA03SetsAndMapsAdvanced;

import java.util.*;

public class L06ProductShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> chainsProducts = new TreeMap<>();

        String command;
        while (!"Revision".equals(command = scanner.nextLine())) {

            String[] tokens = command.split(", ");
            String chainName = tokens[0];
            String productNameAndPrice = tokens[1] + " " + tokens[2];

            if (!chainsProducts.containsKey(chainName)) {
                chainsProducts.put(chainName, new ArrayList<>());
            }

            chainsProducts.get(chainName).add(productNameAndPrice);
        }

        printOutput(chainsProducts);
    }

    private static void printOutput(Map<String, List<String>> chainsProducts) {
        for (Map.Entry<String, List<String>> entry : chainsProducts.entrySet()) {

            System.out.println(entry.getKey() + "->");

            List<String> products = entry.getValue();
            for (String product : products) {

                String[] tokens = product.split(" ");
                String currentProduct = tokens[0];
                double price = Double.parseDouble(tokens[1]);

                System.out.printf("Product: %s, Price: %.1f\n", currentProduct, price);
            }
        }
    }
}