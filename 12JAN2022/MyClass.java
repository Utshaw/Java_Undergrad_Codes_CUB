import java.util.Scanner;
/*

    Suppose, you are creating a java program for a simple feature phone.
    The program is a FM radio app which displays currently available FM Radios and tune to it.
    As you give input of the Radio name (i.e Radio Foorti) the program will get the frequency band 
    from the name and tune to it. Getting the frequency band is a costly operation. 
    The app also renders some random images related to the currently playing radio.
    The program can't stop playing if it does so while doing any such sort of task.

*/
class BookDownloaderThread implements Runnable {
    String bookName;
    
    public BookDownloaderThread(String bookName) {
        this.bookName = bookName;
    }
    
    public static void downloadBook(String bookName) {
        System.out.println("Downloading.... the book " + bookName);
        try {
            Thread.sleep(5000);    
        }catch(InterruptedException e) {
                
        }
        System.out.println(bookName + " has been downloaded ");
    }
    
    public void run() {
        downloadBook(this.bookName);
    }
}

public class MyClass {
    
    public static void main(String args[]) {
      Scanner scanner = null;
      scanner = new Scanner(System.in);

      while(true) {
          
        System.out.println("Enter a book name: ");
        String bookName = scanner.nextLine();   
        Thread t = new Thread(new BookDownloaderThread(bookName), "Book Thread");
        t.start();
        // System.out.println("More books suggestion base on " + bookName);    
        
      }

    }
    
   
}