package firebase.mychat.com.gamelistassignment;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import InterFaces.RealmDataBaseInteraction;
import Model.GameOBj;
import Model.MasterList;
import Model.RealmDataModel;
import Presenters.MainActivityPresenter;
import Presenters.MainActivityPresenterImplmentation;
import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements RealmDataBaseInteraction {

    @Bind(R.id.gameListBtn)
    Button gameListBtn;
    @Bind(R.id.gameratingBtn)
    Button gameratingBtn;
    private Realm realm;
    MainActivityPresenter activityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityPresenter = new MainActivityPresenterImplmentation();
        ButterKnife.bind(this);
        realm.getInstance(this);
        getSupportActionBar().hide();
        if(MasterList.getInstance().getmGameMasterList()==null){
            List<GameOBj> newList = new ArrayList<>();
            activityPresenter.onCreateDummyList(newList);

        }

    }

    public void startRatingActivity (View view) {
        activityPresenter.onStartRatingActivity(this);

    }
    public void startListActivity (View view) {
        activityPresenter.onStartListActivity(this);
    }

    @Override
    public void createDatabase() {
        RealmDataModel dataBaseModel = realm.createObject(RealmDataModel.class);


    }

    @Override
    public void saveInDatabase(List<GameOBj> GAMEOBJ) {
        RealmDataModel dataBaseModel = realm.createObject(RealmDataModel.class);

        for (int position = 0;position <GAMEOBJ.size();position++)
        {
         dataBaseModel.setmGameName(GAMEOBJ.get(position).getmTitle());
            dataBaseModel.setmConsole(GAMEOBJ.get(position).getmConsole());
        }

    }


}
