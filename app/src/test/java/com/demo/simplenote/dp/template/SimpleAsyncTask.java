package com.demo.simplenote.dp.template;

import android.os.AsyncTask;

/**
 * Created by mrsimple on 18/10/17.
 */
public abstract class SimpleAsyncTask<R> {

    /**
     * execute the task
     */
    public final void execute()  {
        onPreExecute();
        R result = doInBackground();
        onPostExecute(result);
    }

    protected void onPreExecute() {

    }

    protected abstract R doInBackground() ;

    protected abstract void onPostExecute(R result) ;

    /**
     * test it!
     * @param args
     */
    public static void main(String[] args) {

        AsyncTask task ;

        new SimpleAsyncTask<String>() {
            @Override
            protected String doInBackground() {
                return "Hello";
            }

            @Override
            protected void onPostExecute(String result) {
                System.out.println();
            }
        }.execute();
    }
}
