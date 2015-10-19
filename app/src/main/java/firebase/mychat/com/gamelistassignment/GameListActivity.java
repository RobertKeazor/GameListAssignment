package firebase.mychat.com.gamelistassignment;

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

import java.util.zip.Inflater;

import Fragments.ListFragment;
import Fragments.Youtube_Sample_Video_Fragment;

public class GameListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_game_list);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        ListFragment fragment =new ListFragment();
        Youtube_Sample_Video_Fragment  sample = new Youtube_Sample_Video_Fragment();
        transaction.add(R.id.List_Fragment_Container,sample,"listfrag");
        transaction.commit();

      createActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void createActionBar() {


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

            actionBar.setHomeButtonEnabled(true);
           actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
            actionBar.setIcon(R.mipmap.ic_add);
        }
    }


}
