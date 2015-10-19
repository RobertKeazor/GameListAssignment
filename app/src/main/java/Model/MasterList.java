package Model;

import java.util.List;


public class MasterList {
    public List<GameOBj> getmGameMasterList() {
        return mGameMasterList;
    }

    public void setmGameMasterList(List<GameOBj> mGameMasterList) {
        this.mGameMasterList = mGameMasterList;
    }

    private static MasterList ourInstance = new MasterList();
    private List<GameOBj> mGameMasterList;
    public static MasterList getInstance() {
        return ourInstance;
    }

    private MasterList() {
        mGameMasterList =null;
    }
}
