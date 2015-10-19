package firebase.mychat.com.gamelistassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import Adapters.RatingListAdapter;
import Model.MasterList;

public class GameRatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_rating);
        ListView listView = (ListView) findViewById(R.id.rating_listview);
        RatingListAdapter myAdapter = new RatingListAdapter (MasterList.getInstance().getmGameMasterList(),this);
        listView.setAdapter(myAdapter);
    }
}
