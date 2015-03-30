package fr.cnam.model;

import com.parse.*;

@ParseClassName("Resultats")
public class Resultats extends ParseObject {
    public Resultats() {
        // A default constructor is required.
    }

    public String getArcherObjectId(){
        return getString("Archer");
    }

    public String getEvenementObjectId(){
        return getString("Evenement");
    }

    public String getBlasonObjectId(){
        return getString("Blason");
    }

    public String getVolee(){
        return getString("Volee");
    }

    public String getStatutF1(){
        return getString("StatutF1");
    }

    public String getStatutF2(){
        return getString("StatutF2");
    }

    public String getStatutF3(){
        return getString("StatutF3");
    }

    public Number getFleche1(){
        return getNumber("Fleche1");
    }

    public Number getFleche2(){
        return getNumber("Fleche2");
    }

    public Number getFleche3(){
        return getNumber("Fleche3");
    }

    public void setArcherObjectId(String archerObjectId){
        put("Archer", ParseObject.createWithoutData("Archer", archerObjectId));
    }

    public void setEvenementObjectId(String evenementObjectId){
        put("Evenement", ParseObject.createWithoutData("Evenement", evenementObjectId));
    }

    public void setBlasonObjectId(String blasonObjectId){
        put("Blason", ParseObject.createWithoutData("Blason", blasonObjectId));
    }

    public void setVolee(String volee){
        put("Volee", volee);
    }

    public void setStatutF1(String statutF1){
        put("StatutF1", statutF1);
    }

    public void setStatutF2(String statutF2){
        put("StatutF2", statutF2);
    }

    public void setStatutF3(String statutF3){
        put("StatutF3", statutF3);
    }

    public void setFleche1(Number fleche1){
        put("Fleche1", fleche1);
    }

    public void setFleche2(Number fleche2){
        put("Fleche2", fleche2);
    }

    public void setFleche3(Number fleche3){
        put("Fleche3", fleche3);
    }
}
