package com.parse.queries;


import com.parse.ParseException;

import fr.cnam.model.Participants;

public class ParticipantsQuery {
    public void inscription()
    {
        Participants inscription = new Participants();
        //inscription.setEvenementObjectId();
        //inscription.setParticipantObjectId();
        try {
            inscription.save();
        } catch (ParseException e)
        {
            //System.out.println(e.getMessage());
        }

    }
}
