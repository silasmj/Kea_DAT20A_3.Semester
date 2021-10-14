import java.util.Random;

public class Octopus extends Animal {
    final Random rand = new Random();
    private static final int min = 1;
    private static final int max = 10;


    @Override
    public String move() {
        return "Swish Swosh";
    }

    public void makeDoActivity() {
        while(true) {
            try {
                String activity = activity();
                System.out.println(activity);
                if(activity.equalsIgnoreCase("Mate")) {
                    GameOfOctopus gameThread = new GameOfOctopus();
                    gameThread.start();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private String activity() {
        int x = rand.nextInt(max) + min;
        if(x == 1) {
            return "Jump";
        }else if (x == 2) {
            return "Run";
        }else if (x == 3) {
            return "Dance";
        }else if (x == 4) {
            return "Mate";
        }else if (x == 5) {
            return "Eat";
        }else if (x == 6) {
            return "Spit";
        }else{
            return "Bang";
        }
    }
}
