package InterFaces;

import java.util.List;

import Model.GameOBj;

public interface RealmDataBaseInteraction {
     void createDatabase();
     void saveInDatabase(List<GameOBj> GAMEOBJ);

}
