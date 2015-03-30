package fr.cnam.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Arc")
public class Arc extends ParseObject {
    public Arc() {
        // A default constructor is required.
    }

    //objectId String
    // Puissance String
    //
    // createdAt Date
    // updatedAt Date
    // ACL ACL
    //
    // Taille String
    // Type String
    //
    // Proprietaire Pointer<Archer>

    public String getTaille(){
        return getString("Taille");
    }

    public String getType(){
        return getString("Type");
    }

    public String getPuissance(){
        return getString("Puissance");
    }

    public String getProprietaireObjectId(){
        return getString("Proprietaire");
    }

    public void setObjectId(String objetcId){
        put("objectId", objetcId);
    }

    public void setTaille(String taille){
        put("Taille", taille);
    }

    public void setType(String type){
        put("Type", type);
    }

    public void setPuissance(String puissance){
        put("Puissance", puissance);
    }

    public void setProprietaireObjectId(String proprietaireObjectId){
        put("Proprietaire", ParseObject.createWithoutData("Archer", proprietaireObjectId));
    }

}
