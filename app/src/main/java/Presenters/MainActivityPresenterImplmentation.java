package Presenters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import Model.DataModel;
import Model.DataModelImplementation;
import Model.GameOBj;
import Model.MasterList;
import firebase.mychat.com.gamelistassignment.GameListActivity;
import firebase.mychat.com.gamelistassignment.GameRatingActivity;
import firebase.mychat.com.gamelistassignment.R;

/**
 * Created by rob2cool on 10/22/15.
 */
public class MainActivityPresenterImplmentation implements MainActivityPresenter {

DataModel dataModel;
    @Override
    public List<GameOBj> onCreateDummyList(List<GameOBj> mGames) {

        dataModel = new DataModelImplementation();
        mGames = dataModel.loadDummyData();
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
