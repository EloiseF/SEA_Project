package com.parse.queries;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import fr.cnam.model.Evenement;

/**
 * Created by LMR on 29/03/15.
 */
public class EvenementQuery {
    public void createEvenement()
    {

        Evenement e = new Evenement();
        e.setNom("MyEvent");
        Calendar dateEvenement = GregorianCalendar.getInstance();
        TimeZone tz = TimeZone.getTimeZone("Europe/Paris");
        dateEvenement.setTimeZone(tz);
        dateEvenement.set(Calendar.YEAR, Calendar.JUNE, Calendar.DAY_OF_MONTH, 0,0,0);
        e.setDateEvenement(dateEvenement.getTime());
        e.setDateEvent("" + Calendar.YEAR + Calendar.MONTH + Calendar.DAY_OF_MONTH);
        try {
            e.save();
        } catch (ParseException ep)
        {
            //System.out.println(e.getMessage());
        }
    }

    public String retrieveEventIdByCriterion(String dateEvenement, String organisateur){
        ParseQuery query=new ParseQuery("Evenement");

        query.whereEqualTo("DateEvent", dateEvenement);
        //query.whereLessThanOrEqualTo("DateEvenement", dateFin);

        ClubQuery cq = new ClubQuery();
        String organisateurId = cq.retrieveClubIdByIdentifiant(organisateur);

        query.whereEqualTo("Organisateur", ParseObject.createWithoutData("Club", organisateurId));
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
