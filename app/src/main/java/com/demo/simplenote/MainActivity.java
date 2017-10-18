package com.demo.simplenote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.demo.simplenote.adapters.NoteAdapter;
import com.demo.simplenote.domain.Note;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
                Toast.makeText(MainActivity.this, "click " + mNoteAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Note> mockNotes() {
        List<Note> notes = new LinkedList<>() ;
        for (int i = 0; i < 5; i++) {
            Note item = new Note() ;
            item.title = "Note - " + i ;
            item.content = "Note - " + i + " content !!!!";
            item.modifyTimeStamp = System.currentTimeMillis() -  new Random().nextInt(100000) ;
            notes.add(item) ;
        }
        return notes ;
    }
}
