import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeZeros {

    private static final java.util.function.IntPredicate isPrime = n -> 
        n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);

      private static int countZeros(int n) {
        String binaryStr = Integer.toBinaryString(n);
        return (int) binaryStr.chars().filter(ch -> ch == '0').count();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введiть верхню межу (число n): ");
        int n = scanner.nextInt();
        scanner.close();

        System.out.println("Пошук серед простих чисел <= " + n);
        Optional<Integer> result = IntStream.rangeClosed(2, n)
                .filter(isPrime)
                .boxed()       
                .max(Comparator.comparingInt(PrimeZeros::countZeros));

        if (result.isPresent()) {
            int primeNum = result.get();
            System.out.println("Знайдено просте число: " + primeNum);
            System.out.println("У двiйковiй формi: " + Integer.toBinaryString(primeNum));
            System.out.println("Кiлькiсть нулiв: " + countZeros(primeNum));
        } else {
            System.out.println("У вказаному дiапазонi немає простих чисел.");
        }
    }
}
