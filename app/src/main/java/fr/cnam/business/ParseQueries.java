package fr.cnam.business;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import android.widget.Toast;

import com.parse.ArcheryFollows;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.Utils;
import com.parse.queries.ClubQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import fr.cnam.model.*;

/**
 * Created by Robert on 02/04/2015.
 */
public class ParseQueries implements Queries {

    private static final String PARSE_APP_ID  = "PhyOxGjACcVSyOnIQUuwSjs2R9ORvdeWVciTHbty";
    private static final String PARSE_CLIENT_KEY  = "wgEpJtIAQYFz8yytcFICVv3u2fgpVmnDF5WjXeQk";
    private Context context;

    /**
     * Initialize a connection to Parse
     * @param c Context of the application
     */
    public void InitParse(Context c){
        context = c;
        // Initialize Crash Reporting.
        ParseCrashReporting.enable(context);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(context);

        //Enregistrer les sous-classes
        ParseObject.registerSubclass(Archer.class);
        ParseObject.registerSubclass(Club.class);
        ParseObject.registerSubclass(Evenement.class);
        ParseObject.registerSubclass(Participants.class);
        ParseObject.registerSubclass(Volee.class);

        // Add your initialization code here
        Parse.initialize(context, PARSE_APP_ID, PARSE_CLIENT_KEY);


        ParseUser.enableAutomaticUser();
        ParseUser.getCurrentUser().saveInBackground();
        ParseACL defaultACL = new ParseACL();

        // Optionally enable public read access.
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }

    @Override
    public Archer AddArcher(Archer a) {
        Archer arch = GetArcher(a.getLicence());
        if(arch != null){
            Log.w("ParseQueries", "Un archer ayant la licence " + a.getLicence() + " existe déjà.");
            return arch;
        }

        try {
            a.save();
            a.fetchIfNeeded();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
        return a;
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
            Log.w("ParseQueries", e.getMessage());
        }
        return null;
    }

    @Override
    public void EditArcher(Archer a) {
        try {
            a.save();
            a.fetchIfNeeded();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteArcher(Archer a) {
        Log.i("ParseQueries", "Suppression de " + a.getObjectId());
        try {
            a.delete();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
    }

    @Override
    public Club AddClub(Club c) {
        Club club = GetClub(c.getIdentifiant());
        if(club != null){
            Log.w("ParseQueries", "Un club ayant l'identifiant " + club.getIdentifiant() + " existe déjà.");
            return club;
        }

        try {
            c.save();
            c.fetchIfNeeded();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
        return c;
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
            Log.w("ParseQueries", e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Archer> GetMembres(Club c){
        ArrayList<Archer> membres = new ArrayList<>();
        ParseQuery query = new ParseQuery("Archer");
        query.whereEqualTo("AppartientAClub", c);
        try
        {
            List po = query.find();
            for(Object o : po){
                Archer a = (Archer) o;
                membres.add(a);
            }
        }
        catch (ParseException | ClassCastException ex)
        {
            ex.printStackTrace();
        }
        return membres;
    }

    @Override
    public void EditClub(Club c) {
        try {
            c.save();
            c.fetchIfNeeded();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteClub(Club c) {
        Log.i("ParseQueries", "Suppression de " + c.getObjectId());
        try {
            c.delete();
        } catch (ParseException e) {
            //TODO: Gestion des erreurs
            e.printStackTrace();
        }
    }

    @Override
    public Evenement AddEvenement(Evenement e) {
        Evenement event = GetEvenement(e.getDateEvent(), e.getOrganisateur().getIdentifiant());
        if(event != null){
            Log.w("ParseQueries", "L'évènement \"" + e.getNom()+ "\" ne peut pas être ajouté : un autre évènement est déjà enregistré pour le club " + e.getOrganisateur().getNom() + " à la même date");
            return event;
        }
        try {
            e.save();
            e.fetchIfNeeded();
        } catch (ParseException ex) {
            //TODO: Gestion des erreurs
            ex.printStackTrace();
        }
        return e;
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
            Log.w("ParseQueries", e.getMessage());
        }
        return null;
    }

    @Override
    public void EditEvenement(Evenement e) {
        try {
            e.save();
            e.fetchIfNeeded();
        } catch (ParseException ex) {
            //TODO: Gestion des erreurs
            ex.printStackTrace();
        }
    }

    @Override
    public void DeleteEvenement(Evenement e) {
        Log.i("ParseQueries", "Suppression de " + e.getObjectId());
        try {
            e.delete();
        } catch (ParseException ex) {
            //TODO: Gestion des erreurs
            ex.printStackTrace();
        }
    }

    @Override
    public Participants AddParticipants(Participants p) {
        Participants part = GetParticipant(p.getParticipant().getLicence(), p.getEvenement());
        if(part != null){
            Log.w("ParseQueries", "Le participant " +p.getParticipant().getPrenom() + " " + p.getParticipant().getNom() + " est déjà inscrit pour \"" + p.getEvenement().getNom() + "\"");
            return part;
        }

        try {
            p.save();
            p.fetchIfNeeded();
        } catch (ParseException ex) {
            //TODO: Gestion des erreurs
            ex.printStackTrace();
        }
        return p;
    }

    @Override
    public Participants GetParticipant(String licenceArcher, Evenement evenement) {
        Archer a = GetArcher(licenceArcher);
        ParseQuery query = new ParseQuery("Participants");
        query.whereEqualTo("Participant", a);
        query.whereEqualTo("Evenement", evenement);
        try
        {
            ParseObject po = query.getFirst();
            return (Participants) po;
        }
        catch (ParseException | ClassCastException ex)
        {
            Log.w("ParseQueries", ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Participants> GetListeParticipants(Evenement event){
        ParseQuery query = new ParseQuery("Participants");
        query.whereEqualTo("Evenement", event);
        ArrayList<Participants> liste = new ArrayList<>();
        try
        {
            List po = query.find();
            for(Object o : po){
                Participants p = (Participants) o;
                liste.add(p);
            }
        }
        catch (ParseException | ClassCastException ex)
        {
            Log.w("ParseQueries", ex.getMessage());
        }
        return liste;
    }

    @Override
    public void EditParticipants(Participants p) {

    }

    @Override
    public void DeleteParticipants(Participants p) {
        Log.i("ParseQueries", "Suppression de " + p.getObjectId());
        try {
            p.delete();
        } catch (ParseException ex) {
            //TODO: Gestion des erreurs
            ex.printStackTrace();
        }
    }

    @Override
    public Volee AddVolee(Volee v) {
        Volee volee = GetVolee(v.getEvenement(), v.getArcher(), v.getVolee());
        if(volee != null){
            Log.w("ParseQueries", "La volée N°" + v.getVolee() + " , tirée par " + v.getArcher().getPrenom() + " " + v.getArcher().getNom() + " sur le concours " + v.getEvenement().getNom() + " existe déjà.");
            return volee;
        }
        try {
            v.save();
            v.fetchIfNeeded();
        } catch (ParseException ex) {
            //TODO: Gestion des erreurs
            ex.printStackTrace();
        }
        return v;
    }

    @Override
    public Volee GetVolee(Evenement event, Archer participant, Number numVolee) {
        ParseQuery query = new ParseQuery("Volee");
        query.whereEqualTo("Archer", participant);
        query.whereEqualTo("Evenement", event);
        query.whereEqualTo("NumVolee", numVolee);
        try
        {
            ParseObject po = query.getFirst();
            return (Volee) po;
        }
        catch (ParseException | ClassCastException ex)
        {
            //TODO: Gestion des erreurs
            Log.w("ParseQueries", ex.getMessage());
        }
        return null;
    }

    @Override
    public void EditVolee(Volee v) {
        try {
            v.save();
            v.fetchIfNeeded();
        } catch (ParseException ex) {
            //TODO: Gestion des erreurs
            ex.printStackTrace();
        }
    }

    @Override
    public void DeleteVolee(Volee v) {
        Log.i("ParseQueries", "Suppression de " + v.getObjectId());
        try {
            v.delete();
        } catch (ParseException ex) {
            //TODO: Gestion des erreurs
            ex.printStackTrace();
        }
    }

    @Override
    public boolean Login(String licenceArcher, String password) {
        ParseQuery query=new ParseQuery("Archer");
        query.whereEqualTo("Licence", licenceArcher);
        query.whereEqualTo("MotDePasse", Utils.MD5(password));
        query.setLimit(1);
        try
        {
            ParseObject po = query.getFirst();
            return true;
        }
        catch (ParseException e)
        {
            e.getStackTrace();
        }
        return false;
    }


}
