package fr.cnam.model;

import com.parse.*;

@ParseClassName("Participants")
public class Participants extends ParseObject {
    public Participants() {
        // A default constructor is required.
    }

    public Archer getParticipant(){
        return (Archer) getParseObject("Participant");
    }

    public Evenement getEvenement(){
        return (Evenement) getParseObject("Evenement");
    }

    public void setArcher(ParseObject participant){
        put("Participant", participant);
    }

    public void setEvenement(ParseObject evenement){
        put("Evenement", evenement);
    }

    public String toString(){
        return getObjectId() + "; " + getParticipant().getPrenom() + " " + getParticipant().getNom() + " participe à " + getEvenement().getNom();
    }
}
