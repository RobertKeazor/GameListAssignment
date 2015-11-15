package firebase.mychat.com.gamelistassignment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import EventHandling.BUS;
import Fragments.AddItem;
import Fragments.ListFragment;
import Fragments.Youtube_Sample_Video_Fragment;
import Model.GameOBj;

public class GameListActivity extends AppCompatActivity  {
    AddItem addItem = new AddItem();
    Youtube_Sample_Video_Fragment sample;
    boolean alreadyAdded= false;


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
    protected void onPause() {
        super.onPause();
        BUS.getInstance().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BUS.getInstance().register(this);
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


                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
               if(!alreadyAdded)
               {ft.add(R.id.List_Fragment_Container, addItem, "listfrag");}
                if (sample.isVisible()) {
                    ft.hide(sample);
                    ft.show(addItem);
                    ft.commit();
                    return true;
                } else {
                    Toast.makeText(GameListActivity.this, "already on add screen", Toast.LENGTH_SHORT).show();

                    return false;
                }
            case R.id.home_btn:
                Toast.makeText(GameListActivity.this, "Home Button Click", Toast.LENGTH_SHORT)
                        .show();

                finish();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }

    }

    @Subscribe
    public void EventHandling(GameOBj game) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(addItem);
        ft.show(sample);
        ft.commit();
        alreadyAdded=true;

    }
}