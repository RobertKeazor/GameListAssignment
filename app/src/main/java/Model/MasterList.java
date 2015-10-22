package Model;

import java.util.List;


public class MasterList {
   private String databaseSaveName;
    private String DatabaseSaveConsole;
    private String DatabaseimageUrl;

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

    public String getDatabaseSaveName() {
        return databaseSaveName;
    }

    public void setDatabaseSaveName(String databaseSaveName) {
        this.databaseSaveName = databaseSaveName;
    }

    public String getGetDatabaseSaveConsole() {
        return DatabaseSaveConsole;
    }

    public void setGetDatabaseSaveConsole(String getDatabaseSaveConsole) {
        this.DatabaseSaveConsole = getDatabaseSaveConsole;
    }

    public String getDatabaseimageUrl() {
        return DatabaseimageUrl;
    }

    public void setDatabaseimageUrl(String databaseimageUrl) {
        this.DatabaseimageUrl = databaseimageUrl;
    }
}
