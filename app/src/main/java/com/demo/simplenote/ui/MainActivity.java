package com.demo.simplenote.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.demo.simplenote.R;
import com.demo.simplenote.adapters.NoteAdapter;
import com.demo.simplenote.domain.Note;
import com.demo.simplenote.ui.edit.NoteEditActivity;
import com.demo.simplenote.ui.login.LoginActivity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    ListView mNoteListView ;
    NoteAdapter mNoteAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNoteListView = (ListView) findViewById(R.id.note_list) ;
        mNoteAdapter = new NoteAdapter(mockNotes()) ;
        mNoteListView.setAdapter(mNoteAdapter);
        mNoteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NoteEditActivity.class) ;
                intent.putExtra("note", mNoteAdapter.getItem(position)) ;
                startActivity(intent);
            }
        });
        EventBus.getDefault().register(this);

//        TestReflect.setupLeakCanaryForTest(getApplication());
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    private List<Note> mockNotes() {
        List<Note> notes = new LinkedList<>() ;
        for (int i = 0; i < 5; i++) {
            Note item = new Note() ;
            item.id = i ;
            item.title = "Note - " + i ;
            item.content = "Note - " + i + " content !!!!";
            item.modifyTimeStamp = System.currentTimeMillis() -  new Random().nextInt(100000) ;
            notes.add(item) ;
        }
        return notes ;
    }


    public void onEventMainThread(Note note) {
        for (Note item : mNoteAdapter.getDataSet()) {
            if ( item.id == note.id ) {
                item.title = note.title;
                item.content = note.content ;
                item.modifyTimeStamp = note.modifyTimeStamp;
                break;
            }
        }
        // 排序
        Collections.sort(mNoteAdapter.getDataSet());
        mNoteAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
