package fr.cnam.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Blason")
public class Blason extends ParseObject {
    public Blason() {
        // A default constructor is required.
    }

    public String getDiametre(){
        return getString("Diametre");
    }

    public String getDistance(){
        return getString("Distance");
    }

    public String getEvenementObjectId(){
        return getString("Evenement");
    }

    public void setObjectId(String objectId){
        put("objectId", objectId);
    }

    public void setDiametre(String diametre){
        put("Diametre", diametre);
    }

    public void setDistance(String distance){
        put("Distance", distance);
    }

    public void setEvenementObjectId(String evenementObjectId){
        put("Evenement", ParseObject.createWithoutData("Evenement", evenementObjectId));
    }

}
