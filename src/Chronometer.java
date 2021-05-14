



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius Jimenez
 */
public class Chronometer implements Runnable{
    private int seconds, minutes, hours;
    private final Thread mainThread;
    
    Chronometer(){
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
    
        this.mainThread = new Thread(this);
    }
    
    public void start(){ 
        this.mainThread.start();
    }
    
    public void stop(){
        this.mainThread.interrupt();
    }


    @Override
    public void run() {
        try{
            while (!Thread.currentThread().isInterrupted()) {
                this.seconds++;
                
                if(this.getSeconds() >= 60){
                    this.seconds = 0;
                    this.minutes++;
                    
                    if(this.getMinutes() >= 60){
                        this.minutes = 0;
                        this.hours++;
                        
                        if(this.getHours() >= 24){
                            this.hours = 0;
                        }
                    }   
                }              
                
                System.out.println(this);
                
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println("The chronometer has been stopped");
        }

    }

    /**
     * @return the seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return (
            this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds()
        );
    }
    
    
}
