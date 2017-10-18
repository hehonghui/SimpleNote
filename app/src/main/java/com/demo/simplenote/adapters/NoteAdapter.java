package com.demo.simplenote.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demo.simplenote.R;
import com.demo.simplenote.date.TimestampFormator;
import com.demo.simplenote.domain.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mrsimple on 17/10/17.
 */
public class NoteAdapter extends BaseAdapter {

    protected final List<Note> mDataSet = new ArrayList<>();

    public NoteAdapter(List<Note> dataSet) {
        if (dataSet != null) {
            mDataSet.addAll(dataSet);
            // 排序
            Collections.sort(mDataSet);
        }
    }


    public List<Note> getDataSet() {
        return mDataSet;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Note getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {
        NoteViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
            holder = new NoteViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (NoteViewHolder) convertView.getTag();
        }
        final Note item = getItem(position) ;
        holder.titleView.setText(item.title);
        holder.timestampView.setText(TimestampFormator.format(item.modifyTimeStamp));
        return convertView;
    }


    /**
     *
     */
    public static class NoteViewHolder {
        public View itemView;
        public TextView titleView;
        public TextView timestampView;

        public NoteViewHolder(View itemView) {
            this.itemView = itemView;
            titleView = (TextView) itemView.findViewById(R.id.note_title_tv);
            timestampView = (TextView) itemView.findViewById(R.id.note_modify_tv);
        }
    }
}
