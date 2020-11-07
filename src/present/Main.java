package present;

public class Main {
    public static void main(String[] args) {

        BigBrother bigBro = new BigBrother(10);

        Thread bigBroThread = new Thread(bigBro);
        bigBroThread.start();

        Thread[] alumni = new Thread[5];
        for (int i=0; i<alumni.length;i++){
            alumni[i]=new Thread(new Alumn(bigBro), "Alumn " + (i+1));
        }

        for (int i=0; i<alumni.length;i++){
            alumni[i].start();
        }

    }
}
