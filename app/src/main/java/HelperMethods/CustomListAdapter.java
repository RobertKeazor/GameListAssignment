package HelperMethods;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Model.GameOBj;
import firebase.mychat.com.gamelistassignment.R;

/**
 * Created by rob2cool on 10/17/15.
 */
public class CustomListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    List<GameOBj> mDataSet;

    public CustomListAdapter(LayoutInflater mInflater, List<GameOBj> mDataSet) {
        this.mInflater = mInflater;
        this.mDataSet = mDataSet;
    }


    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        ViewHolder holder;
        if(convertView == null) {
            view = mInflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.avatar = (ImageView)view.findViewById(R.id.avatar);
            holder.name = (TextView)view.findViewById(R.id.name);
            holder.latestMessage = (TextView)view.findViewById(R.id.latest_message);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder)view.getTag();
        }

        GameOBj data = mDataSet.get(position);
        holder.avatar.setImageResource(data.getmImageRes());
        holder.name.setText(data.getmTitle());
        holder.latestMessage.setText(data.getmDescription());

        return view;
    }
    private class ViewHolder {
        public ImageView avatar;
        public TextView name, latestMessage;
    }
}
