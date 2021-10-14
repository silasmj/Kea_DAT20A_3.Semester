import java.util.Random;

public class RandomStream {
    public static void main(String[] args) {
        Random random = new Random();
        //        System.out.println(random.nextInt()); // not a stream!
        random.ints().limit(4).forEach((number) -> System.out.println(number));

        //The anatomy of a lambda expession
        //(number) is the argument
        // -> seperates argument from the body
        // after -> is the body

    }
}
