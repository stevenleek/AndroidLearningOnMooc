package com.example.likai.asysnctask;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by likai on 15/4/27.
 */
public class Asystask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {
        Log.d("xyz", "doInBackground");
        //通过publishprogress()方法手动调用onProgressUpdate()方法
        publishProgress();
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("xyz", "onPreExecute");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("xyz", "onPostExecute");

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Log.d("xyz", "onProgressUpdate");
    }
}
