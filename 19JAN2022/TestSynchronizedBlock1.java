class Table
{
    void printTable(int n){
        synchronized(this){//synchronized block
            for(int i=1;i<=5;i++){
                System.out.println(n*i);
                try{
                    Thread.sleep(400);
                }catch(Exception e){System.out.println(e);}
            }
        }
    }//end of the method
}

class MyThread extends Thread {
    Table t; int val;
    MyThread(Table t, int val){
        this.t=t;
        this.val = val;
    }
    public void run(){
        t.printTable(val);
    }
}

class MyThread1 extends Thread{
    Table t;
    MyThread1(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }

}
class MyThread2 extends Thread{
    Table t;
    MyThread2(Table t){
        this.t=t;
    }
    @Override
    public void run(){
        t.printTable(100);
    }
}

public class TestSynchronizedBlock1{
    public static void main(String args[]){
        Table obj = new Table();//only one object
//        MyThread1 t1=new MyThread1(obj);
//        MyThread2 t2=new MyThread2(obj);
        MyThread t1 = new MyThread(obj, 5);
        MyThread t2 = new MyThread(obj, 100);
        t1.start();
        t2.start();
    }
}    