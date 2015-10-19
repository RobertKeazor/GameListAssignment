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

import Model.GameOBj;
import Model.MasterList;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.gameListBtn)
    Button gameListBtn;
    @Bind(R.id.gameratingBtn)
    Button gameratingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        if(MasterList.getInstance().getmGameMasterList()==null){
            List<GameOBj> newList=createDummyList();
            MasterList.getInstance().setmGameMasterList(newList);
        }

    }
    public List<GameOBj> createDummyList() {
        List<GameOBj> mGames=new ArrayList<>();
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
    return mGames;}
    public void startRatingActivity (View view) {
        Intent intent = new Intent(this,GameRatingActivity.class);
        startActivity(intent);
        finish();
    }
    public void startListActivity (View view) {
        Intent intent = new Intent(this,GameListActivity.class);
        startActivity(intent);
        finish();
    }
}
