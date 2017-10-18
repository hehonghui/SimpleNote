package com.demo.simplenote.adapters.template_refactor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.simplenote.R;

import java.util.List;

/**
 * Created by mrsimple on 17/10/17.
 */
public class AnotherAdapter extends CustomBaseAdapter<String, AnotherAdapter.StringViewHolder> {

    public AnotherAdapter(List dataSet) {
        super(dataSet);
    }

    @Override
    protected StringViewHolder onCreateViewHolder(ViewGroup parent) {
        View rootView = inflateFrom(parent, R.layout.note_item, false) ;
        return new StringViewHolder(rootView);
    }

    @Override
    protected void onBindViewHolder(StringViewHolder viewHolder, int position) {
        final String item = getItem(position) ;
        viewHolder.titleView.setText(item);
    }

    /**
     * 
     */
    public static class StringViewHolder extends CustomBaseAdapter.ViewHolder {
        public TextView titleView;

        public StringViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.note_title_tv);
        }
    }
}
