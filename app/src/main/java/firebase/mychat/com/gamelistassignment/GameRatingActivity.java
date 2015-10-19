package firebase.mychat.com.gamelistassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import Adapters.RatingListAdapter;
import Model.MasterList;

public class GameRatingActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.home_btn):
                finish();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case(R.id.add_button):
                Toast.makeText(GameRatingActivity.this, "Need to be in List Activity", Toast
                        .LENGTH_SHORT).show();


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_rating);
        ListView listView = (ListView) findViewById(R.id.rating_listview);
        RatingListAdapter myAdapter = new RatingListAdapter (MasterList.getInstance().getmGameMasterList(),this);
        listView.setAdapter(myAdapter);

    }
}
