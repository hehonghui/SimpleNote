package com.demo.simplenote.ui.edit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.simplenote.R;
import com.demo.simplenote.api.NoteSyncAPi;
import com.demo.simplenote.domain.Note;
import com.demo.simplenote.network.NetworkWatchDog;

import de.greenrobot.event.EventBus;

/**
 * Created by mrsimple on 18/10/17.
 */
public class NoteEditActivity extends AppCompatActivity implements NoteEditView {

    NoteEditPresenter mPresenter ;
    Note mNote ;
    EditText mTitleEdit;
    EditText mContentEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);
        mNote = getIntent().getParcelableExtra("note") ;
        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.save(mNote, mTitleEdit.getText().toString(), mContentEdit.getText().toString());
            }
        });

        mTitleEdit = (EditText) findViewById(R.id.title_edit) ;
        mTitleEdit.setText(mNote.title);
        mContentEdit = (EditText) findViewById(R.id.content_edit) ;
        mContentEdit.setText(mNote.content);

        // presenter
        mPresenter = new NoteEditPresenter(this, new NoteSyncAPi(), new NetworkWatchDog()) ;
    }

    @Override
    public void onSaved() {
        Toast.makeText(NoteEditActivity.this, "saved", Toast.LENGTH_SHORT).show();
        EventBus.getDefault().post(mNote);
        finish();
    }

    @Override
    public void onSaveError() {
        Toast.makeText(NoteEditActivity.this, "save error", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
