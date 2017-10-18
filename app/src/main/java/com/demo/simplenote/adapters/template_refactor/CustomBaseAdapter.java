package com.demo.simplenote.adapters.template_refactor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrsimple on 17/10/17.
 */
public abstract class CustomBaseAdapter<D, V extends CustomBaseAdapter.ViewHolder> extends BaseAdapter {

    protected List<D> mDataSet = new ArrayList<>();

    public CustomBaseAdapter(List<D> dataSet) {
        if (dataSet != null) {
            mDataSet.addAll(dataSet);
        }
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public D getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {
        V holder;
        if (convertView == null) {
            holder = onCreateViewHolder(parent);
        } else {
            holder = (V) convertView.getTag();
        }
        onBindViewHolder(holder, position);
        return holder.itemView;
    }

    /**
     * 创建
     * @param parent
     * @return
     */
    protected abstract V onCreateViewHolder(ViewGroup parent);

    /**
     *
     * @param viewHolder
     * @param position
     */
    protected abstract void onBindViewHolder(V viewHolder, int position);


    protected View inflateFrom(ViewGroup parent, int layoutRes, boolean attachToRoot) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, attachToRoot) ;
    }

    /**
     * 抽象类 ViewHolder
     */
    public static abstract class ViewHolder {
        public View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
            // set tag
            this.itemView.setTag(this);
        }
    }
}
