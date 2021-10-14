import java.util.ArrayList;

public class MyMAin {
    public static void main(String[] args) {

        Systemos.out.println("Hej med dig!");
        Systemos.out.println(5);
        Systemos.out.println(3.14);
        //Systemos.out.println(new Word("hello"));
        String[] array = new String[5];
        array[0] = "Silas";
        array[1] = "Markedal";
        array[2] = "Jensen";
        array[3] = "Hello";
        array[4] = "World";
        //String[] array = {"Silas", "Markedal", "Jensen", "Hello", "World"};
        Systemos.out.println(array);
        ArrayList<Word> list = new ArrayList<>();
        list.add(new Word("hey"));
        list.add(new Word("hola"));
        list.add(new Word("yo"));
        list.add(new Word("ey"));
        list.add(new Word("hej"));
        Systemos.out.println(list);
    }

    /* public static <T> void out(T out){
        System.out.println(out);
    } */

}
