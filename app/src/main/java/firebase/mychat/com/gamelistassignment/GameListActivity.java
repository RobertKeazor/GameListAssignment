package firebase.mychat.com.gamelistassignment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.zip.Inflater;

import Fragments.AddItem;
import Fragments.ListFragment;
import Fragments.Youtube_Sample_Video_Fragment;

public class GameListActivity extends AppCompatActivity {
    Youtube_Sample_Video_Fragment sample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_game_list);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ListFragment fragment = new ListFragment();
        sample = new Youtube_Sample_Video_Fragment();

        transaction.add(R.id.List_Fragment_Container, sample, "listfrag");
        transaction.commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_button:

                AddItem addItem = new AddItem();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.add(R.id.List_Fragment_Container, addItem, "listfrag");
                if(sample.isVisible()) {
                    ft.hide(sample);
                    ft.show(addItem);
                    ft.commit();
                    return true;
                }else {Toast.makeText(GameListActivity.this, "already on add screen", Toast.LENGTH_SHORT).show();
                return false;}
            case R.id.home_btn:
                Toast.makeText(GameListActivity.this, "Home Button Click", Toast.LENGTH_SHORT)
                        .show();
                finish();
                startActivity(new Intent(this,MainActivity.class));
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }

    }
}