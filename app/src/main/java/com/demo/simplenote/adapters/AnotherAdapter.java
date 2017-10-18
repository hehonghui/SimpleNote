package com.demo.simplenote.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.demo.simplenote.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mrsimple on 17/10/17.
 */
public class AnotherAdapter extends BaseAdapter {

    protected final List<String> mDataSet = new ArrayList<>();

    public AnotherAdapter(List<String> dataSet) {
        if (dataSet != null) {
            mDataSet.addAll(dataSet);
            // 排序
            Collections.sort(mDataSet);
        }
    }


    public List<String> getDataSet() {
        return mDataSet;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public String getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StringViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
            holder = new StringViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (StringViewHolder) convertView.getTag();
        }
        final String item = getItem(position) ;
        holder.titleView.setText(item);
        return convertView;
    }


    /**
     *
     */
    public static class StringViewHolder {
        public View itemView;
        public TextView titleView;

        public StringViewHolder(View itemView) {
            this.itemView = itemView;
            titleView = (TextView) itemView.findViewById(R.id.note_title_tv);
        }
    }
}
