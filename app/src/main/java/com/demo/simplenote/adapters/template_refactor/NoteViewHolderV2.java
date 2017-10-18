package com.demo.simplenote.adapters.template_refactor;

import android.view.View;
import android.widget.TextView;

import com.demo.simplenote.R;

/**
 * Created by mrsimple on 18/10/17.
 */

public class NoteViewHolderV2 extends CustomBaseAdapter.ViewHolder {
    public TextView titleView ;
    public TextView timestampView ;

    public NoteViewHolderV2(View itemView) {
        super(itemView);
        titleView = (TextView) itemView.findViewById(R.id.note_title_tv) ;
        timestampView = (TextView) itemView.findViewById(R.id.note_modify_tv) ;
    }
}
