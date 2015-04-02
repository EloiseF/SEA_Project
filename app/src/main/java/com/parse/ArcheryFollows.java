package com.parse;

import fr.cnam.business.ParseQueries;
import fr.cnam.model.*;
import com.parse.queries.*;

import android.util.Log;

import android.app.Application;

import java.nio.channels.NotYetConnectedException;
import java.util.Calendar;
import java.util.Date;


public class ArcheryFollows extends Application {

    private static ArcherQuery aq = new ArcherQuery();
    private static ArcQuery arcq = new ArcQuery();
    private static ClubQuery cq = new ClubQuery();
    private static EvenementQuery eq = new EvenementQuery();
    private static ParticipantsQuery pq = new ParticipantsQuery();
    private static ResultatsQuery rq = new ResultatsQuery();
    private static ParseQueries parse = new ParseQueries();

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Crash Reporting.
        ParseCrashReporting.enable(this);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        //Enregistrer les sous-classes
        ParseObject.registerSubclass(Archer.class);
        ParseObject.registerSubclass(Arc.class);
        ParseObject.registerSubclass(Club.class);
        ParseObject.registerSubclass(Evenement.class);
        ParseObject.registerSubclass(Participants.class);
        ParseObject.registerSubclass(Volee.class);

        // Add your initialization code here
        Parse.initialize(this, "PhyOxGjACcVSyOnIQUuwSjs2R9ORvdeWVciTHbty", "wgEpJtIAQYFz8yytcFICVv3u2fgpVmnDF5WjXeQk");


        ParseUser.enableAutomaticUser();
        ParseUser.getCurrentUser().saveInBackground();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

        String identifiantClub = "67203001";

        Date today = Calendar.getInstance().getTime();
        String dateEvent = Utils.getDateInFormat(today);

        String distance = "18";

        Archer edelzongle = new Archer();
        edelzongle.setLicence("8015420G");
        edelzongle.setNom("DELZONGLE");
        edelzongle.setPrenom("Etienne");
        edelzongle.setAnnee(2015);
        edelzongle.setDateDeNaissance(new Date());
        edelzongle.setMotDePasse(Utils.MD5("test"));
        edelzongle = parse.AddArcher(edelzongle);

        bArc(edelzongle.getLicence());

        Club myClub = new Club();
        myClub.setNom("AHE");
        myClub.setIdentifiant("AHE67O");
        myClub.setLieu("Obernai");
        myClub.setPresidentObjectId(aq.retrieveArcherIdByLicence(edelzongle.getLicence()));
        parse.AddClub(myClub);

        dEvenement(identifiantClub);
        fParticipants(edelzongle.getLicence(), dateEvent, identifiantClub);
        gResultats(edelzongle.getLicence(), dateEvent, identifiantClub, distance);

        hAuthenticate(edelzongle.getLicence(), "test");

        parse.GetEvenement("20150402", "AHE67O");

    }

    public void bArc(String licenceArcher)
    {
        Arc myArc = new Arc();
        myArc.setPuissance("22");
        myArc.setTaille("68");
        myArc.setType("Classique");
        myArc.setProprietaireObjectId(aq.retrieveArcherIdByLicence(licenceArcher));
        save(myArc);
    }

    public void dEvenement(String identifiantClub)
    {
        Date sysdate_as_date = Calendar.getInstance().getTime();
        String dateEvent = Utils.getDateInFormat(sysdate_as_date);

        Evenement myEvent = new Evenement();
        myEvent.setNom("MyEvent");
        myEvent.setDateEvenement(sysdate_as_date);
        myEvent.setDateEvent(dateEvent);
        myEvent.setClubObjectId(cq.retrieveClubIdByIdentifiant(identifiantClub));

        save(myEvent);
    }

    public void fParticipants(String licenceArcher, String dateEvent, String identifiantClub)
    {
        Participants myInscription = new Participants();
        myInscription.setParticipantObjectId(aq.retrieveArcherIdByLicence(licenceArcher));
        myInscription.setEvenementObjectId(eq.retrieveEventIdByCriterion(dateEvent, identifiantClub));
        save(myInscription);
    }

    public void gResultats(String licenceArcher, String dateEvent, String identifiantClub, String distance)
    {
        Volee volee = new Volee();
        volee.setEvenementObjectId(eq.retrieveEventIdByCriterion(dateEvent, identifiantClub));
        volee.setArcherObjectId(aq.retrieveArcherIdByLicence(licenceArcher));
        volee.setVolee(1);
        volee.putVolee(10, 10, 2);
        save(volee);
    }

    public void hAuthenticate(String licence, String password)
    {
        Log.d("auth", aq.authenticate(licence, password));
    }

    public void save(ParseObject item)
    {
        try
        {
            item.save();
        }
        catch (Exception e){
            Log.e("Save Error", e.getMessage());
        }
    }
}

