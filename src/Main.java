/*
 *
 * @author Vinicius Jimenez
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        var chronometer = new Chronometer();
        
        chronometer.start();
        
        Thread.sleep(60000);
        
        chronometer.stop();
        
        System.out.println("Final timing: " + chronometer);
    }
}
