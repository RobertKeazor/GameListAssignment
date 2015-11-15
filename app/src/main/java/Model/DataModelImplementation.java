package Model;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import firebase.mychat.com.gamelistassignment.R;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.dynamic.DynamicRealmList;

/**
 * Created by rob2cool on 10/23/15.
 */
public class DataModelImplementation implements DataModel {
    @Override
    public void loadFromDatabase(Context context) {
        Realm realm = Realm.getInstance(context);
        List<GameOBj>gameOBjs = new ArrayList<>();



            RealmResults<RealmDataModel> query = realm.where(RealmDataModel.class)
                    .findAll();
            for (RealmDataModel p : query) {

                gameOBjs.add(new GameOBj(R.drawable.mario, p.getmConsole(), p.getmGameName()));
            }

        }


    @Override
    public void saveInDatabase(Activity context, List<GameOBj> GAMEOBJ) {

       Realm realm = Realm.getInstance(context.getApplicationContext());
        realm.beginTransaction();
        RealmDataModel dataBaseModel = realm.createObject(RealmDataModel.class);

        RealmList<RealmDataModel>modelList= new RealmList<>();

        /*for (int position = 0;position <GAMEOBJ.size();position++)
        {
            if (dataBaseModel.getmGameName()!= GAMEOBJ.get(position).getmTitle()&& dataBaseModel.getmConsole()!= GAMEOBJ.get(position).getmConsole()) {
                dataBaseModel.setmGameName(GAMEOBJ.get(position).getmTitle());
                dataBaseModel.setmConsole(GAMEOBJ.get(position).getmConsole());
                modelList.add(dataBaseModel);
                realm.commitTransaction();

            }*/
        Toast.makeText(context, dataBaseModel.getmGameName(), Toast.LENGTH_SHORT).show();




    }

    @Override
    public List<GameOBj> loadDummyData() {
        List <GameOBj>mGames = new ArrayList<>();
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
        return  mGames;
    }

    @Override
    public boolean needToLoadFromDatabase(Context context) {
        Realm realm = Realm.getInstance(context);
        RealmDataModel foo = realm.allObjects(RealmDataModel.class).first();
        return foo.isValid();
    }
}

