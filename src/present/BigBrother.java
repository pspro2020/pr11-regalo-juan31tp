package present;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

public class BigBrother implements Runnable{

    final CountDownLatch countDownLatch;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    int goal;

    public BigBrother(int goal) {
        this.goal=goal;
        countDownLatch=new CountDownLatch(goal);
    }

    public void countMoney(String name, int cash) {
        System.out.printf(LocalTime.now().format(dtf) + " -> The alumn " + name + " gave " + cash + " + \n");
        for (int i=0; i<cash;i++){
            countDownLatch.countDown();
        }
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.printf(LocalTime.now().format(dtf) + " -> The big brother has the money needed \n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
