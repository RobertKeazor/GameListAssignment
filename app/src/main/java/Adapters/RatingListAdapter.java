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

public class RatingListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<GameOBj> mGame;

    public RatingListAdapter(List<GameOBj> mGame,Context context) {
        this.mGame = mGame;
        this.mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mGame.size();
    }

    @Override
    public Object getItem(int position) {
        return mGame.get(position);
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
            view = mInflater.inflate(R.layout.game_rating, parent, false);
            holder = new ViewHolder();
            holder.avatar = (ImageView)view.findViewById(R.id.game);

            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder)view.getTag();
        }

        GameOBj data = mGame.get(position);

        if(data.getDynamic_img() == null)
        {
            holder.avatar.setImageResource(data.getmImageRes());
        }
       else if (data.getDynamic_img()!=null){
            holder.avatar.setImageBitmap(data.getDynamic_img());
        }


        return view;
    }

    private class ViewHolder {
        public ImageView avatar;
        public TextView name, latestMessage;
    }
}
