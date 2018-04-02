package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class PracticalTest01Var07Service extends Service {
    private ProcessingThread processingThread = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int f = 0, s = 0, t = 0, ft = 0;


        processingThread = new ProcessingThread(this, f, s, t, ft);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy(){
        processingThread.stopThread();
    }
}
