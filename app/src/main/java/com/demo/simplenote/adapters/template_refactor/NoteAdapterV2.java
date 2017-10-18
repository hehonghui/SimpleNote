package com.demo.simplenote.adapters.template_refactor;

import android.view.View;
import android.view.ViewGroup;

import com.demo.simplenote.R;
import com.demo.simplenote.domain.Note;

import java.util.List;

/**
 * Created by mrsimple on 17/10/17.
 */
public class NoteAdapterV2 extends CustomBaseAdapter<Note, NoteViewHolderV2> {

    public NoteAdapterV2(List<Note> dataSet) {
        super(dataSet);
    }


    @Override
    protected void onBindViewHolder(NoteViewHolderV2 viewHolder, int position) {

    }

    protected NoteViewHolderV2 onCreateViewHolder(ViewGroup parent) {
        View convertView = inflateFrom(parent, R.layout.note_item, false);
        return new NoteViewHolderV2(convertView);
    }

}
