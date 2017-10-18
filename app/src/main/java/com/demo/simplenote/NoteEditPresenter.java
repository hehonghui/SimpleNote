package com.demo.simplenote;

import com.demo.simplenote.api.NoteSyncAPi;
import com.demo.simplenote.domain.Note;
import com.demo.simplenote.network.NetworkWatchDog;

import de.greenrobot.event.EventBus;

/**
 * Created by mrsimple on 18/10/17.
 */

public class NoteEditPresenter {

    NoteEditView mView ;
    NoteSyncAPi mApi ;
    NetworkWatchDog mWatchDog ;

    public NoteEditPresenter(NoteEditView view, NoteSyncAPi api, NetworkWatchDog dog) {
        this.mView = view;
        this.mApi = api ;
        this.mWatchDog = dog;
    }

    public void attach(NoteEditView v) {
        mView = v ;
    }

    public void save(final Note note, final String title, final String content) {
        if ( mView == null ) {
            return;
        }
        if ( mApi != null && note != null && mWatchDog.isNetworkAvailable() ) {
            note.title = title ;
            note.content = content ;
            mApi.saveNote(note, new NoteSyncAPi.SyncListener() {
                @Override
                public void onSuccess() {
                    if ( mView != null ) {
                        // update timestamp
                        note.modifyTimeStamp = System.currentTimeMillis();
                        EventBus.getDefault().post(note);
                        mView.onSaved();
                    }
                }

                @Override
                public void onFailure() {
                    if ( mView != null ) {
                        mView.onSaveError();
                    }
                }
            });
        } else {
            mView.onSaveError();
        }
    }


    public void detach() {
        mView = null ;
    }
}
