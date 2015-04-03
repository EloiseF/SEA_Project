package fr.cnam.model;

import com.parse.*;

import fr.cnam.business.ParseQueries;

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

    public Archer getPresident(){
        return (Archer) getParseObject("President");
    }

    public void setObjectId(String objectId){
        put("objectId", objectId);
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

    public void setPresident(Archer president ){
        put("President", president);
    }

    public String toString(){
        return getObjectId() + "; " + getNom() + " / " + getIdentifiant();
    }
}
