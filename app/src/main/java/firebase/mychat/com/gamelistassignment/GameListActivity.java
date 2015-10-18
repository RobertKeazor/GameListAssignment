package firebase.mychat.com.gamelistassignment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import Fragments.ListFragment;
import Fragments.Youtube_Sample_Video_Fragment;

public class GameListActivity extends FragmentActivity {

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
    }
}
