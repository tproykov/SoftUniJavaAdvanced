package JA11ExamPreparation.E22_26_Jun_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class E01OsPlanning {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        Deque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(threads::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        int taskKiller;
        while (true) {

            int currentTask = tasks.peek();
            int currentThread = threads.peek();

            if (taskToKill == currentTask) {
                taskKiller = currentThread;
                break;
            }

            tasks.pop();
            threads.poll();

            if (currentThread < currentTask) {
                tasks.push(currentTask);
            }
        }

        System.out.println("Thread with value " + taskKiller + " killed task " + taskToKill);
        threads.forEach(thread -> System.out.print(thread + " "));
    }
}