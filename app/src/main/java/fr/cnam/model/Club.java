package fr.cnam.model;

import com.parse.*;

@ParseClassName("Club")
public class Club extends ParseObject {
    public Club() {
        // A default constructor is required.
    }

    //objectId String
    // Nom String
    // createdAt Date
    // updatedAt Date
    // ACL ACL
    // Lieu String
    // President Pointer<Archer>
    // Identifiant String

    public String getNom(){
        return getString("Nom");
    }

    public String getLieu(){
        return getString("Lieu");
    }

    public String getIdentifiant(){
        return getString("Identifiant");
    }

    public String getPresidentObjectId(){
        return getString("President");
    }

    public void setNom(String nom){
        put("Nom", nom);
    }

    public void setLieu(String lieu){
        put("Lieu", lieu);
    }

    public void setIdentifiant(String identifiant){
        put("Identifiant", identifiant);
    }


    public void setPresidentObjectId( String presidentObjectId ){
        put("President", ParseObject.createWithoutData("Archer", presidentObjectId));
    }
}
