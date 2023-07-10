package Week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HedefSayiyaUlasma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tam sayı dizisini girin (virgülle ayrılmış):");
        String input = scanner.nextLine();
        String[] numStrings = input.split(",");
        int[] numbers = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            numbers[i] = Integer.parseInt(numStrings[i]);
        }

        System.out.println("Hedef sayıyı girin:");
        int target = scanner.nextInt();

        List<List<Integer>> combinations = findCombinations(numbers, target);
        if (combinations.isEmpty()) {
            System.out.println("Hedef sayıya ulaşılamadı.");
        } else {
            System.out.println("Farklı kombinasyonlarla hedef sayıya ulaşılıyor:");
            for (List<Integer> combination : combinations) {
                System.out.println(combination);
            }
        }
    }

    public static List<List<Integer>> findCombinations(int[] numbers, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), numbers, target, 0);
        return combinations;
    }

    public static void backtrack(List<List<Integer>> combinations, List<Integer> current, int[] numbers, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < numbers.length; i++) {
            current.add(numbers[i]);
            backtrack(combinations, current, numbers, target - numbers[i], i);
            current.remove(current.size() - 1);
        }
    }
}
