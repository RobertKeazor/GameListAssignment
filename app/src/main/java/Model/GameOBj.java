package Model;

import android.os.Parcel;
import android.os.Parcelable;


public class GameOBj implements Parcelable {
   private int mImageRes;
   private String mTitle;
    private String mDescription;
    private String previewURL;

    public GameOBj(int mImageRes, String mTitle, String mDescription) {
        this.mImageRes = mImageRes;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
    }

    protected GameOBj(Parcel in) {
        mImageRes = in.readInt();
        mTitle = in.readString();
        mDescription = in.readString();
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

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
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
        dest.writeString(mDescription);
        dest.writeString(previewURL);
    }
}
