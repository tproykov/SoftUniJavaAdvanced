package JA01StacksAndQueues;

import java.util.*;

public class E10Robotics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Parse robots
        String[] robotsInput = scanner.nextLine().split(";");
        List<Robot> robots = new ArrayList<>();
        for (String robot : robotsInput) {
            String[] robotData = robot.split("-");
            robots.add(new Robot(robotData[0], Integer.parseInt(robotData[1])));
        }

        // Parse starting time
        String[] timeData = scanner.nextLine().split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);
        int startTime = hours * 3600 + minutes * 60 + seconds;

        // Process products
        Queue<String> products = new ArrayDeque<>();
        String product;
        while (!"End".equals(product = scanner.nextLine())) {
            products.add(product);
        }

        processProducts(robots, products, startTime);
    }

    private static void processProducts(List<Robot> robots, Queue<String> products, int startTime) {
        int currentSecond = startTime;

        while (!products.isEmpty()) {
            currentSecond++;
            String currentProduct = products.poll();
            boolean productTaken = false;

            // Try to assign product to a free robot
            for (Robot robot : robots) {
                if (!robot.isBusy(currentSecond)) {
                    System.out.println(String.format("%s - %s [%02d:%02d:%02d]",
                            robot.getName(),
                            currentProduct,
                            (currentSecond / 3600) % 24,
                            (currentSecond / 60) % 60,
                            currentSecond % 60));
                    robot.assignTask(currentSecond);
                    productTaken = true;
                    break;
                }
            }

            // If no robot is free, add product back to queue
            if (!productTaken) {
                products.add(currentProduct);
            }
        }
    }
}

class Robot {
    private String name;
    private int processTime;
    private int busyUntil;
    private boolean isBusy;

    public Robot(String name, int processTime) {
        this.name = name;
        this.processTime = processTime;
        this.busyUntil = -1;
        this.isBusy = false;
    }

    public String getName() {
        return name;
    }

    public int getProcessTime() {
        return processTime;
    }

    public boolean isBusy(int currentTime) {
        return currentTime < busyUntil;
    }

    public void assignTask(int startTime) {
        this.busyUntil = startTime + processTime;
        this.isBusy = true;
    }
}

