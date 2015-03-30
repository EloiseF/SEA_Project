package fr.cnam.model;

import com.parse.*;

@ParseClassName("Participants")
public class Participants extends ParseObject {
    public Participants() {
        // A default constructor is required.
    }

    public String getParticipantObjectId(){
        return getString("Participant");
    }

    public String getEvenementObjectId(){
        return getString("Evenement");
    }

    public void setParticipantObjectId(String participantObjectId){
        put("Participant", ParseObject.createWithoutData("Archer", participantObjectId));
    }

    public void setEvenementObjectId(String evenementObjectId){
        put("Evenement", ParseObject.createWithoutData("Evenement", evenementObjectId));
    }
}
