package com.parse.queries;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.util.List;
import android.util.Log;
import com.parse.FindCallback;
import fr.cnam.model.Archer;
import com.parse.Utils;


public class ArcherQuery {
    public void createArcher()
    {
        Archer myArcher = new Archer();
        myArcher.setNom("Test");
        myArcher.setLicence("1234A");
        try {
            myArcher.save();
        } catch (ParseException e)
        {
            //System.out.println(e.getMessage());
        }
    }

    public String retrieveArcherIdByLicence(String licence)
    {
        ParseQuery query=new ParseQuery("Archer");
        query.whereEqualTo("Licence", licence);
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

    public Archer retrieveArcherByLicence(String licence)
    {
        ParseQuery query=new ParseQuery("Archer");
        query.whereEqualTo("Licence", licence);
        query.setLimit(1);

        try
        {
            ParseObject po = query.getFirst();
            return (Archer)po;
        }
        catch (ParseException e)
        {

        }

        return null;
    }

    public String authenticate(String licence, String password)
    {
        ParseQuery query=new ParseQuery("Archer");
        query.whereEqualTo("Licence", licence);
        query.whereEqualTo("MotDePasse", Utils.MD5(password));
        query.setLimit(1);

        try
        {
            ParseObject po = query.getFirst();
            return "AUTHENTICATED";
        }
        catch (ParseException e)
        {

        }

        return "BAD_AUTHENTICATION";
    }

}
