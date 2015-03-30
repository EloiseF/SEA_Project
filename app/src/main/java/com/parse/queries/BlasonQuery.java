package com.parse.queries;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import fr.cnam.model.Blason;


public class BlasonQuery {

    public void createBlason()
    {
        Blason myBlason = new Blason();
        myBlason.setDiametre("Test");
        myBlason.setDistance("1234A");
        try {
            myBlason.save();
        } catch (ParseException e)
        {
            //System.out.println(e.getMessage());
        }
    }

    public String retrieveBlasonIdByCriterion(String dateEvenement, String organisateur, String distance){
        ParseQuery query=new ParseQuery("Blason");

        query.whereEqualTo("Distance", distance);
        //query.whereLessThanOrEqualTo("DateEvenement", dateFin);

        EvenementQuery eq = new EvenementQuery();
        String evenementId = eq.retrieveEventIdByCriterion(dateEvenement, organisateur);

        query.whereEqualTo("Evenement", ParseObject.createWithoutData("Evenement", evenementId));
        query.setLimit(1);

        try
        {
            ParseObject po = query.getFirst();
            return po.getObjectId();
        }
        catch (ParseException e)
        {

        }
        return "NoResult";
    }
}
