package Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import EventHandling.BUS;
import Model.GameOBj;
import Model.MasterList;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import firebase.mychat.com.gamelistassignment.R;


public class AddItem extends Fragment {

    @Bind(R.id.console_name)
    EditText consoleName;
    @Bind(R.id.game_name)
    EditText gameName;
    @Bind(R.id.img)
    ImageView img;
    @Bind(R.id.button1)
    Button button1;
    private static final int SELECT_PICTURE = 1;
    Bitmap image;
    GameOBj addedGameObject= new GameOBj();
    String ImageUri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_item_fragment, container, false);
        ButterKnife.bind(this, v);
        addedGameObject.setDynamic_img(null);
        return v;

    }
@OnClick
        (R.id.img)
public void captureGaller(){
    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
    photoPickerIntent.setType("image/*");
    startActivityForResult(photoPickerIntent, SELECT_PICTURE);


}


   @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (requestCode == SELECT_PICTURE && resultCode == getActivity().RESULT_OK) {
           Bundle extras = data.getExtras();
           if(data.getData()==null){
               image = (Bitmap)data.getExtras().get("data");
           }else{
               try {
                   image = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),
                               data.getData());
                 addedGameObject.setDynamic_img(image);
                   ImageUri= data.getData().toString();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
   }

    @OnClick
            (R.id.button1)
    public void buttonClicked(){
        if (isEmpty(gameName) || isEmpty(consoleName)) {
            Toast.makeText(getActivity(), "Game Credientails incomplete", Toast.LENGTH_SHORT).show();

        }
        else {
            addedGameObject.setmTitle(gameName.getText().toString());
            addedGameObject.setmConsole(gameName.getText().toString());
            addedGameObject = new GameOBj(gameName.getText().toString(),consoleName.getText().toString(),image);
            BUS.getInstance().post(addedGameObject);


        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
}
