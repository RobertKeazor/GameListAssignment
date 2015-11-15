package Model;

import android.app.Activity;
import android.content.Context;

import java.util.List;

import Model.GameOBj;

public interface DataModel {
     void loadFromDatabase(Context context);
     void saveInDatabase(Activity context,List<GameOBj> GAMEOBJ);
     List<GameOBj> loadDummyData ();
     boolean needToLoadFromDatabase (Context context);

}
