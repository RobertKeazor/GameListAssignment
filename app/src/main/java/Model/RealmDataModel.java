package Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class RealmDataModel extends RealmObject {
    @PrimaryKey
    private String mGameName;
    private String mConsole;
    private String mImageUrl;

    public String getmGameName() {
        return mGameName;
    }

    public void setmGameName(String mGameName) {
        this.mGameName = mGameName;
    }

    public String getmConsole() {
        return mConsole;
    }

    public void setmConsole(String mConsole) {
        this.mConsole = mConsole;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
