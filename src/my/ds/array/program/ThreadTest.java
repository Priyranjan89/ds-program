package my.ds.array.program;

public class ThreadTest {
    public static void main(String[] args) {

        System.out.println("1");
        synchronized (args){
            System.out.println("2");
            try {
                args.wait();
            }catch (InterruptedException e){

            }
        }
        System.out.println("3");
    }
}
