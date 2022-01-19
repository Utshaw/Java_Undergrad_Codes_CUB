// Building - Lift up down, Air Condition system at each floor - a set temperature and on / off system
// Lift moves floor by floor

class FireExtinguisher extends Thread {
    boolean isFire; Thread t;
    public FireExtinguisher() {
        this.isFire = isFire;
        t = new Thread(this, "Fire");
    }
    public void setIsFire(boolean isFire) {
        this.isFire = isFire;
        if(isFire) {
            t.start();
        }else {
            t.interrupt();
        }
    }

    public void run() {
        while(!Thread.currentThread().isInterrupted()) {

            System.out.println("FireExtinguisher is working...");
        }
        System.out.println("FireExtinguisher's work is done");
    }

}

class Lift2 extends Thread {
    int floorPosition; int targetFloorPosition;
    Thread t;
    public Lift2() {
        this.floorPosition = 0;
        this.targetFloorPosition = 0;
        t= new Thread(this,  "Lift");
    }

    public void moveToFloor(int pos) {
        this.targetFloorPosition = pos;
        t.start();
    }
    public void run() {
        if(this.floorPosition < this.targetFloorPosition) {
            while(this.floorPosition < this.targetFloorPosition) {
                this.floorPosition++;
            }
        }else {
            while(this.floorPosition > this.targetFloorPosition) {
                this.floorPosition--;
            }
        }
        System.out.println("Lift has moved to floor " + floorPosition);
    }
}

public class Building {
    public static void main(String[] args) {
        FireExtinguisher fireExtinguisher = new FireExtinguisher();
        fireExtinguisher.setIsFire(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fireExtinguisher.setIsFire(false);
    }
}
