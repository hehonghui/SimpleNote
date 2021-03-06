package com.demo.simplenote.ui.edit;

import com.demo.simplenote.api.NoteSyncAPi;
import com.demo.simplenote.domain.Note;
import com.demo.simplenote.network.NetworkWatchDog;

/**
 * Created by mrsimple on 18/10/17.
 */

public class NoteEditPresenter {

    NoteEditView mView ;
    NoteSyncAPi mApi ;
    NetworkWatchDog mWatchDog ;

    // dagger 依赖注入

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
            // 发送网络请求
            mApi.saveNote(note, new NoteSyncAPi.SyncListener() {
                @Override
                public void onSuccess() {
                    if ( mView != null ) {
                        // update timestamp
                        note.modifyTimeStamp = System.currentTimeMillis();
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

//
//    /**
//     * 模拟发送网络请求  【 耦合在 Presenter 类中, Test 】
//     * @param note
//     * @param listener
//     */
//    private void saveNote(Note note, final NoteSyncAPi.SyncListener listener) {
//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if ( listener != null ) {
//                    listener.onSuccess();
//                }
//            }
//        }, 1000);
//    }
}
