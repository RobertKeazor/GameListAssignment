package Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import Adapters.CustomListAdapter;
import EventHandling.BUS;
import Model.GameOBj;
import Model.MasterList;
import firebase.mychat.com.gamelistassignment.R;

public class ListFragment extends Fragment {

    List<GameOBj> mGames = new ArrayList<>();
    ArrayAdapter<GameOBj> adapter;
    CustomListAdapter myAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {


        View v = inflater.inflate(R.layout.listview_layout, container, false);
        ListView listView = (ListView) v.findViewById(R.id.game_list);
        mGames = MasterList.getInstance().getmGameMasterList();
       myAdapter= new CustomListAdapter(getActivity(), mGames);
        listView.setAdapter(myAdapter);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        BUS.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BUS.getInstance().unregister(this);
    }




    @Subscribe
    public void HandleEvent(GameOBj game) {
        Toast.makeText(getActivity(), "Eventbus in Fragment", Toast.LENGTH_SHORT).show();
         mGames.add(game);
        myAdapter.notifyDataSetChanged();
        MasterList.getInstance().setmGameMasterList(mGames);

    }
}