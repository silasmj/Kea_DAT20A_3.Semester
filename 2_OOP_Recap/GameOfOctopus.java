public class GameOfOctopus extends Thread {
    @Override
    public void run() {
        Octopus otto = new Octopus();
        otto.makeDoActivity();
    }

}
