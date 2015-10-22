package Presenters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import Model.GameOBj;
import Model.MasterList;
import firebase.mychat.com.gamelistassignment.GameListActivity;
import firebase.mychat.com.gamelistassignment.GameRatingActivity;
import firebase.mychat.com.gamelistassignment.R;

/**
 * Created by rob2cool on 10/22/15.
 */
public class MainActivityPresenterImplmentation implements MainActivityPresenter {


    @Override
    public List<GameOBj> onCreateDummyList(List<GameOBj> mGames) {

        mGames.add(new GameOBj(R.drawable.mario, "Mario", "MarioGame"));
        mGames.add(new GameOBj(R.drawable.sonic, "Sonic", "Sonic the HedgeHog"));
        mGames.add(new GameOBj(R.drawable.naruto, "Naruto", "Help Naruto Defeat Sasuake"));
        mGames.add(new GameOBj(R.drawable.zelda, "Zelda", "Help Link win,in this adventure game "));
        mGames.add(new GameOBj(R.drawable.tyson, "Mike TYson PunchOUt", "Help Little Rocky beat Iron Mike"));

        mGames.add(new GameOBj(R.drawable.karatekid, "The Karate Kid", "Help DanielSon beat up " +
                "the bullies"));
        mGames.add(new GameOBj(R.drawable.bleach, "Bleach", "Help Ichago beat Aizen"));
        mGames.add(new GameOBj(R.drawable.arrow, "The Green Arrow", "Help Oliver protect his city" +
                ""));
        mGames.add(new GameOBj(R.drawable.spiderman, "Spiderman", "Help PeterParker win"));
        MasterList.getInstance().setmGameMasterList(mGames);
        return mGames;


    }

    @Override
    public void onStartRatingActivity(Activity context) {
        Intent intent = new Intent(context,GameRatingActivity.class);
        context.startActivity(intent);
        context.finish();

    }

    @Override
    public void onStartListActivity( Activity activity) {
        Intent intent = new Intent(activity,GameListActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
