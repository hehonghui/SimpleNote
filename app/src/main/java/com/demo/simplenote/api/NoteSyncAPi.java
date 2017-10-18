package com.demo.simplenote.api;

import android.os.Handler;
import android.os.Looper;

import com.demo.simplenote.domain.Note;

/**
 * Created by mrsimple on 18/10/17.
 */
public class NoteSyncAPi {

    public void saveNote(Note note, final SyncListener listener) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if ( listener != null ) {
                    listener.onSuccess();
                }
            }
        }, 1000);
    }

    /**
     *
     */
    public static interface SyncListener {
        void onSuccess();
        void onFailure();
    }
}
