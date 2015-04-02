package com.parse.queries;

import com.parse.ParseException;

import fr.cnam.model.Volee;


public class ResultatsQuery {
    public void sauvegarder()
    {
        Volee volee = new Volee();
        //resultats.setEvenementObjectId();
        //resultats.setArcherObjectId();
        //resultats.setBlasonObjectId();
        volee.setVolee(1);
        volee.setFleche1(9);
        volee.setFleche2(10);
        volee.setFleche3(3);
        try {
            volee.save();
        } catch (ParseException e)
        {
            //System.out.println(e.getMessage());
        }

    }
}
