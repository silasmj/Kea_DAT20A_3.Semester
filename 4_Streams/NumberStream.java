import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 33, 55, 22, 88, 66, 99, 99, 2, 33);

        int sum = numbers.stream().mapToInt(number -> number).sum();
        System.out.println(sum);

        int sumParallelized = numbers.parallelStream().mapToInt(number -> number).sum();

        Double averageTemperature = numbers.stream().mapToInt(number -> number).average().getAsDouble();

        List<Integer> squaredNumbers = numbers.stream().map(nomNom -> nomNom * nomNom).collect(Collectors.toList());

      //  System.out.println(squaredNumbers);

        List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());

       // System.out.println(evenNumbers);

        List<Integer> oddNumbers = numbers.stream().filter(number -> number % 2 == 1).collect(Collectors.toList());
       // System.out.println(oddNumbers);

        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNumbers);

        IntSummaryStatistics summary = numbers.parallelStream().mapToInt(number -> number).summaryStatistics();

        System.out.println(summary);

    }
}
