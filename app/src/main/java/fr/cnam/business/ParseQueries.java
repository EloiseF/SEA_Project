package fr.cnam.business;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.queries.ClubQuery;

import fr.cnam.model.*;

/**
 * Created by Robert on 02/04/2015.
 */
public class ParseQueries implements Queries {

    @Override
    public Archer AddArcher(Archer a) {
        try {
            a.save();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
        return GetArcher(a.getLicence());
    }

    @Override
    public Archer GetArcher(String licence) {
        ParseQuery query = new ParseQuery("Archer");
        query.whereEqualTo("Licence", licence);
        try
        {
            ParseObject po = query.getFirst();
            return (Archer) po;
        }
        catch (ParseException | ClassCastException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void EditArcher(Archer a) {
        try {
            a.save();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteArcher(Archer a) {
        try {
            a.delete();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
    }

    @Override
    public Club AddClub(Club c) {
        try {
            c.save();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
        return GetClub(c.getIdentifiant());
    }

    @Override
    public Club GetClub(String id) {
        ParseQuery query = new ParseQuery("Club");
        query.whereEqualTo("Identifiant", id);
        try
        {
            ParseObject po = query.getFirst();
            return (Club) po;
        }
        catch (ParseException | ClassCastException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void EditClub(Club c) {
        try {
            c.save();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteClub(Club c) {
        try {
            c.delete();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
    }

    @Override
    public Evenement AddEvenement(Evenement e) {
        return GetEvenement(e.getDateEvent(), e.getOrganisateurObjectId());
    }

    @Override
    public Evenement GetEvenement(String dateEvenement, String idClub) {
        ParseQuery query = new ParseQuery("Evenement");
        query.whereEqualTo("DateEvent", dateEvenement);
        Club orga = GetClub(idClub);
        query.whereEqualTo("Organisateur", orga);
        try
        {
            ParseObject po = query.getFirst();
            return (Evenement) po;
        }
        catch (ParseException | ClassCastException e)
        {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void EditEvenement(Evenement e) {

    }

    @Override
    public void DeleteEvenement(Evenement e) {

    }

    @Override
    public Participants AddParticipants(Participants p) {
        return GetParticipants(p.getParticipantObjectId());
    }

    @Override
    public Participants GetParticipants(String id) {
        return null;
    }

    @Override
    public void EditParticipants(Participants p) {

    }

    @Override
    public void DeleteParticipants(Participants p) {

    }

    @Override
    public Volee AddVolee(Volee v) {
        return GetVolee("0");
    }

    @Override
    public Volee GetVolee(String id) {
        return null;
    }

    @Override
    public void EditVolee(Volee v) {

    }

    @Override
    public void DeleteVolee(Volee v) {

    }
}
