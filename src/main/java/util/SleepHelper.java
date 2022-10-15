package util;

public class SleepHelper {

    public static void sleep(int seconds)  {
        try {
            Thread.sleep(seconds*1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}