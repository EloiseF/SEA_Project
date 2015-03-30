package fr.cnam.model;

import com.parse.*;
import fr.cnam.model.Club;
import java.util.Date;

@ParseClassName("Archer")
public class Archer extends ParseObject {
    public Archer() {
        // A default constructor is required.
    }

    //objectId String
    // Nom String
    // Prenom String
    //
    // createdAt Date
    // updatedAt Date
    // ACL ACL
    //
    // DateDeNaissance Date
    //
    // Niveau String
    // Licence String
    // Annee Number
    // MotDePasse String
    // AppartientAClub Pointer<Club>


    public String getNom(){
        return getString("Nom");
    }

    public String getPrenom(){
        return getString("Prenom");
    }

    public String getNiveau(){
        return getString("Niveau");
    }

    public String getLicence(){
        return getString("Licence");
    }

    public String getMotDePasse(){
        return getString("MotDePasse");
    }

    public Number getAnnee(){
        return getNumber("Annee");
    }

    public java.util.Date getDateDeNaissance(){
        return getDate("DateDeNaissance");
    }

    public String getClubObjectId(){
        return getString("AppartientAClub");
    }

    public void setObjectId(String objetcId){
        put("objectId", objetcId);
    }

    public void setNom(String nom){
        put("Nom", nom);
    }

    public void setPrenom(String prenom){
        put("Prenom", prenom);
    }

    public void setNiveau(String niveau){
        put("Niveau", niveau);
    }

    public void setLicence(String licence){
        put("Licence", licence);
    }

    public void setMotDePasse(String motDePasse){
        put("MotDePasse", motDePasse);
    }

    public void setAnnee(Number annee){
        put("Annee", annee);
    }

    public void setDateDeNaissance(Date dateDeNaissance){
        put("DateDeNaissance", dateDeNaissance);
    }

    public void setClubObjectId( String clubObjectId ){
        put("AppartientAClub", ParseObject.createWithoutData("Club", clubObjectId));
    }

    /*public ParseUser getOwner() {
        return getParseUser("owner");
    }
    public void setOwner(ParseUser user) {
        put("owner", user);
    }*/


}
