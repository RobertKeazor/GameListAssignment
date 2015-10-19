package firebase.mychat.com.gamelistassignment;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

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

    }
    public void startRatingActivity (View view) {}
    public void startListActivity (View view) {
        Intent intent = new Intent(this,GameListActivity.class);
        startActivity(intent);
        finish();
    }
}
