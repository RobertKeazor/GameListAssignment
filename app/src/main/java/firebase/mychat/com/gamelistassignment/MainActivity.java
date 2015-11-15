package firebase.mychat.com.gamelistassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import Model.GameOBj;
import Model.MasterList;
import Presenters.MainActivityPresenter;
import Presenters.MainActivityPresenterImplmentation;
import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity  {

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




}
