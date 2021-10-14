import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStream {
    public static void main(String[] args) {
        List<String> coolWords = Arrays.asList("Swag", "Soft-Ice", "Swag", "", "Jan", "");
        List<String> onlyWords = coolWords.stream().filter(word -> !word.isEmpty()).collect(Collectors.toList());
        //System.out.println(onlyWords);

        long vocabulary = coolWords.stream().filter(word -> word.length() > 0).distinct().count();

        //System.out.println(vocabulary);

        String sentence = coolWords
                .parallelStream()
                .filter(word -> !(word.equals("")))
                .collect(Collectors.joining( " ")) + ".";

        System.out.println(sentence);
    }
}
