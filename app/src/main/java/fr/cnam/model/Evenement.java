package fr.cnam.model;

import com.parse.*;
import java.util.Date;

@ParseClassName("Evenement")
public class Evenement extends ParseObject {
    public Evenement() {
        // A default constructor is required.
    }

    public String getNom(){
        return getString("Nom");
    }

    public String getDateEvent(){
        return getString("DateEvent");
    }

    public Date getDateEvenement(){
        return getDate("DateEvenement");
    }

    public Club getOrganisateur(){
        return (Club) getParseObject("Organisateur");
    }

    public void setObjectId(String objectId){
        put("objectId", objectId);
    }

    public void setNom(String nom){
        put("Nom", nom);
    }

    public void setDateEvent(String dateEvent){
        put("DateEvent", dateEvent);
    }

    public void setDateEvenement(Date dateEvenement){
        put("DateEvenement", dateEvenement);
    }

    public void setOrganisateur( Club club ){
        put("Organisateur", club);
    }

    public String toString(){
        return getObjectId() + "; " + getNom() + " @ " + getDateEvent() + ", organisé par " + getOrganisateur().getNom();
    }
}
