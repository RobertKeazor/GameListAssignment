package Model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;


public class GameOBj implements Parcelable {
   private int mImageRes;
   private String mTitle;
    private String mConsole;
    private String previewURL;
    private Bitmap dynamic_img;
    private Boolean isInserted;
    private String  IMG_URL;

    public GameOBj (){
        mImageRes =-1;
        mTitle="";
        mConsole="";
    }

    public GameOBj( String mTitle,String mConsole, Bitmap dynamic_img) {
        this.mTitle = mTitle;
        this.mConsole = mConsole;

        this.isInserted=true;
    }

    protected GameOBj(Parcel in) {
        mImageRes = in.readInt();
        mTitle = in.readString();
        mConsole = in.readString();
        previewURL = in.readString();
    }

    public static final Creator<GameOBj> CREATOR = new Creator<GameOBj>() {
        @Override
        public GameOBj createFromParcel(Parcel in) {
            return new GameOBj(in);
        }

        @Override
        public GameOBj[] newArray(int size) {
            return new GameOBj[size];
        }
    };



    public GameOBj(int imageRES,String mTitle, String mConsole) {
        this.mTitle = mTitle;
        this.mConsole = mConsole;
        this.mImageRes=imageRES;
        isInserted=false;
    }

    public int getmImageRes() {
        return mImageRes;
    }

    public void setmImageRes(int mImageRes) {
        this.mImageRes = mImageRes;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmConsole() {
        return mConsole;
    }

    public void setmConsole(String mConsole) {
        this.mConsole = mConsole;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageRes);
        dest.writeString(mTitle);
        dest.writeString(mConsole);
        dest.writeString(previewURL);

    }

    public Bitmap getDynamic_img() {
        return dynamic_img;
    }

    public void setDynamic_img(Bitmap dynamic_img) {
        this.dynamic_img = dynamic_img;
    }

    public Boolean getIsInserted() {
        return isInserted;
    }

    public void setIsInserted(Boolean isInserted) {
        this.isInserted = isInserted;
    }

    public String getIMG_URL() {
        return IMG_URL;
    }

    public void setIMG_URL(String IMG_URL) {
        this.IMG_URL = IMG_URL;
    }
}
