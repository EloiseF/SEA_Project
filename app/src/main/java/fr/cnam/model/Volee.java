package fr.cnam.model;

import com.parse.*;

@ParseClassName("Volee")
public class Volee extends ParseObject {
    public Volee() {
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

    public Number getVolee(){
        return getNumber("NumVolee");
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

    public Number getTotalVolee(){ return getNumber("TotalVolee"); }

    public void setArcherObjectId(String archerObjectId){
        put("Archer", ParseObject.createWithoutData("Archer", archerObjectId));
    }

    public void setEvenementObjectId(String evenementObjectId){
        put("Evenement", ParseObject.createWithoutData("Evenement", evenementObjectId));
    }

    public void setBlasonObjectId(String blasonObjectId){
        put("Blason", ParseObject.createWithoutData("Blason", blasonObjectId));
    }

    public void setVolee(Number nVolee){
        put("NumVolee", nVolee);
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

    public void computeTotalVolee() { put("TotalVolee", getFleche1().intValue() + getFleche2().intValue() + getFleche3().intValue()); }

    public void putVolee(Number f1, Number f2, Number f3)
    {
        setFleche1(f1);
        setFleche2(f2);
        setFleche3(f3);
        computeTotalVolee();
    }
}
