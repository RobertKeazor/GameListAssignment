package firebase.mychat.com.gamelistassignment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import HelperMethods.CustomListAdapter;
import Model.GameOBj;

/**
 * Created by rob2cool on 10/20/15.
 */
public class ListFragment extends Fragment {

    List<GameOBj> mGames= new ArrayList<GameOBj>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

          createDummyList();
        View v = inflater.inflate(R.layout.listview_layout, container, false);
        ListView listView = (ListView) v.findViewById(R.id.game_list);
        listView.setAdapter(new CustomListAdapter(getActivity(),mGames));
        return v;
    }

public void createDummyList (){
    mGames.add(new GameOBj(R.drawable.mario,"Mario","MarioGame"));
    mGames.add(new GameOBj(R.drawable.sonic ,"Sonic","Sonic the HedgeHog"));
    mGames.add(new GameOBj(R.drawable.naruto,"Naruto","Help Naruto Defeat Sasuake"));
    mGames.add(new GameOBj(R.drawable.zelda,"Zelda","Help Link win,in this adventure game "));
    mGames.add(new GameOBj(R.drawable.tyson,"Mike TYson PunchOUt","Help Little Rocky beat Iron Mike"));
    mGames.add(new GameOBj(R.drawable.karatekid,"The Karate Kid","Help DanielSon beat up the bullies"));
    mGames.add(new GameOBj(R.drawable.bleach,"Bleach","Help Ichago beat Aizen"));
    mGames.add(new GameOBj(R.drawable.arrow,"The Green Arrow","Help Oliver protect his city"));
    mGames.add(new GameOBj(R.drawable.spiderman,"Spiderman","Help PeterParker win"));}

}
