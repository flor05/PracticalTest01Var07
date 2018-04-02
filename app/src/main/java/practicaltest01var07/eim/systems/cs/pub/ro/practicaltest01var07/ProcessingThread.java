package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;
import java.util.Random;

public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;

    private Random random = new Random();

    private double arithmeticMean;
    private double geometricMean;
    private int f = 0;
    private int s = 0;
    private int t = 0;
    private int ft = 0;


    public ProcessingThread(Context context, int firstNumber, int secondNumber, int thirdNumber, int fourthNumber) {
        this.context = context;
        f = firstNumber;
        s = secondNumber;
        t = thirdNumber;
        ft = fourthNumber;
    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
            sendMessage(f, s, t, ft);
            sleep();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage(int f, int s, int t, int ft) {
        Intent intent = new Intent();
        String[] actions = {"ACTION_SEND", "ACTION_CALL_BUTTON"};
        intent.setAction(Constants.actionTypes[random.nextInt(Constants.actionTypes.length)]);
        intent.putExtra("message", new Date(System.currentTimeMillis()) + " " + f + " " + s + " "+ t + " "+ ft + " " );
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }


}
