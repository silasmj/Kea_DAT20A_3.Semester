import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        AbstractClass abstractClassImplemented = new AbstractClass() { // En abstract klasse kan laves som en anonym klasse
            @Override
            public void makeSurrealArt() {
                System.out.println("Created by Dali!");
            }
        };
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String firstString, String secondString) {
                return firstString.compareTo(secondString);
            }
        };

        //stringComparator.compare("Hello", "world");

        Comparator<String> stringComparatorLambda = (String firstString, String secondString) -> firstString.compareTo(secondString); //lambda
        System.out.println(stringComparatorLambda.compare("a", "b"));

        //Concatenator concat = (prependorString, appendorString) -> {return prependorString + appendorString};
        //Kan også gøres således:
        Concatenator concat = (prependorString, appendorString) -> prependorString + appendorString;

        System.out.println(concat.cat("Jan", "Jan"));
    }
}
