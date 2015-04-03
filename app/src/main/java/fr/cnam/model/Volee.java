package fr.cnam.model;

import com.parse.*;

@ParseClassName("Volee")
public class Volee extends ParseObject {
    public Volee() {
        // A default constructor is required.
    }

    public Archer getArcher(){
        return (Archer) getParseObject("Archer");
    }

    public Evenement getEvenement(){
        return (Evenement) getParseObject("Evenement");
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

    public void setArcher(Archer archer){
        put("Archer", archer);
    }

    public void setEvenement(Evenement evenement){
        put("Evenement", evenement);
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

    public void putScoresVolee(Number f1, Number f2, Number f3)  {
        setFleche1(f1);
        setFleche2(f2);
        setFleche3(f3);
        computeTotalVolee();
    }

    public String toString(){
        return getObjectId() + "; " + getArcher().getPrenom() + " " + getArcher().getNom() + " a fait " + getTotalVolee() + " points sur sa volée " + getVolee();
    }
}
