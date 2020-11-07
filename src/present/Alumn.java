package present;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Alumn implements Runnable {

    private final BigBrother bigBro;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Alumn(BigBrother bigBro) {
        this.bigBro=bigBro;
    }

    @Override
    public void run() {
        int cash;

        cash = gainMoney();
        if (bigBro.countDownLatch.getCount()<1){
            System.out.printf(LocalTime.now().format(dtf) + " -> " + Thread.currentThread().getName() + " gained " + cash + " money \n");
        } else {
            bigBro.countMoney(Thread.currentThread().getName(), cash);
        }
    }

    private int gainMoney() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10)+3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextInt(5)+2;
    }
}
