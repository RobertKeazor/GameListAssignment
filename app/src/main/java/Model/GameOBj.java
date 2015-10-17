package Model;

/**
 * Created by rob2cool on 10/17/15.
 */
public class GameOBj {
   private int mImageRes;
   private String mTitle;
    private String mDescription;

    public GameOBj(int mImageRes, String mTitle, String mDescription) {
        this.mImageRes = mImageRes;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
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

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
