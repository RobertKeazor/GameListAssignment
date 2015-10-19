package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Model.GameOBj;
import firebase.mychat.com.gamelistassignment.R;

public class CustomListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context context;
    List<GameOBj> mDataSet;

    public CustomListAdapter(Context context, List<GameOBj> mDataSet) {
        this.context = context;

        this.mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        holder.latestMessage.setText(data.getmConsole());

        return view;
    }
    private class ViewHolder {
        public ImageView avatar;
        public TextView name, latestMessage;
    }
}
