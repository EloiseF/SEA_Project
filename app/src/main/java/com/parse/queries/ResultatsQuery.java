package com.parse.queries;

import com.parse.ParseException;

import fr.cnam.model.Resultats;


public class ResultatsQuery {
    public void sauvegarder()
    {
        Resultats resultats = new Resultats();
        //resultats.setEvenementObjectId();
        //resultats.setArcherObjectId();
        //resultats.setBlasonObjectId();
        resultats.setVolee("1");
        resultats.setFleche1(9);
        resultats.setFleche2(10);
        resultats.setFleche3(3);
        resultats.setStatutF1("OK");
        resultats.setStatutF2("M");
        resultats.setStatutF3("P");
        try {
            resultats.save();
        } catch (ParseException e)
        {
            //System.out.println(e.getMessage());
        }

    }
}
