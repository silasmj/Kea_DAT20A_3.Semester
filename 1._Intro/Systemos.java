import java.util.ArrayList;
import java.util.List;

public class Systemos {

    public static class out{
        public static void println(String s) {
            System.out.println(s);
        }
        public static void println(int x) {
            System.out.println(x);
        }

        public static void println(double d) {
            System.out.println(d);
        }
     /*   public static void println(Object content){
            System.out.println(content);
        }*/
        public static void println(Object[] array) {
            for(Object object : array) {
                System.out.print(object + " ");
            }
        }
        public static void println(List list) {
            System.out.println(list);
        }
    }
}
