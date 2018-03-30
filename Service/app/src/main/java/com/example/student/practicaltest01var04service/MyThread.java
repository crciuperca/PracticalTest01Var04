package com.example.student.practicaltest01var04service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by student on 30.03.2018.
 */

public class MyThread extends Thread {
    private Context context;

    public MyThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        Log.d("[Started service]","Thread.run() was invoked, PID: " + android.os.Process.myPid() + " TID: " + android.os.Process.myTid());
        sendMessage("Doing this");
        sleep();
        sendMessage("Doing that");
        sleep();
        sendMessage("Not doing anything");
        sleep();
    }

    private void sendMessage(String message) {
        Intent intent = new Intent();
        intent.setAction("actionmessage");
        intent.putExtra("actionmessagedata", message);

        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            Log.e("[Service]", interruptedException.getMessage());
            interruptedException.printStackTrace();
        }
    }

}
