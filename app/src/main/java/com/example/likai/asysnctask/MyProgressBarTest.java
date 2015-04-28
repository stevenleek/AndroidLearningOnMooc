package com.example.likai.asysnctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

/**
 * Created by likai on 15/4/28.
 */
public class MyProgressBarTest extends Activity {
    private ProgressBar pgb;
    private AsysnTask mySyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progbar);

        pgb = (ProgressBar) findViewById(R.id.progressBar2);
        mySyncTask = new AsysnTask();
        mySyncTask.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mySyncTask != null&& mySyncTask.getStatus() == AsyncTask.Status.RUNNING) {
            //将mySyncTask标记为cancelled,并非真正的将线程停止;
            mySyncTask.cancel(true);
        }
    }

    public class AsysnTask extends AsyncTask<Void, Integer, Void>{
        //模拟进度栏的更新；
        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 0;i < 100; i++) {
                if (isCancelled()) {
                    break;
                }
                publishProgress(i);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //获取异步线程progressbar的更新值；
            if (isCancelled()) {
                return;
            }
            pgb.setProgress(values[0]);
        }
    }
}
