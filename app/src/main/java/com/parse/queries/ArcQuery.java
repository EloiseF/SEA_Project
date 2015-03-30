package com.parse.queries;


import com.parse.ParseException;
import fr.cnam.model.Arc;


public class ArcQuery {
    public void createArc()
    {
        Arc myArc = new Arc();
        myArc.setTaille("Test");
        myArc.setType("1234A");
        myArc.setPuissance("9999");
        try {
            myArc.save();
        } catch (ParseException e)
        {
            //System.out.println(e.getMessage());
        }
    }
}
