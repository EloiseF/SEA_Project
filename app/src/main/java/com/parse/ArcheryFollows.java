package com.parse;

import fr.cnam.business.ParseQueries;
import fr.cnam.model.*;
import com.parse.queries.*;

import android.util.Log;

import android.app.Application;
import android.widget.Toast;

import java.nio.channels.NotYetConnectedException;
import java.util.Calendar;
import java.util.Date;


public class ArcheryFollows extends Application {

    private static ParseQueries parse = new ParseQueries();

    @Override
    public void onCreate() {
        super.onCreate();

        parse.InitParse(this);

        Date today = Calendar.getInstance().getTime();
        String dateEvent = Utils.getDateInFormat(today);

        String distance = "18";

        // Test d'ajout d'un archer
        Archer edelzongle = new Archer();
        edelzongle.setLicence("8015420G");
        edelzongle.setNom("DELZONGLE");
        edelzongle.setPrenom("Etienne");
        edelzongle.setAnnee(2015);
        edelzongle.setDateDeNaissance(new Date());
        edelzongle.setMotDePasse(Utils.MD5("test"));
        edelzongle = parse.AddArcher(edelzongle);
        Log.i("ArcheryFollows", edelzongle.toString());

        // Test d'ajout d'un club ayant pour président l'archer créé précédemment
        Club myClub = new Club();
        myClub.setNom("AHE");
        myClub.setIdentifiant("AHE67O");
        myClub.setLieu("Obernai");
        myClub.setPresident(edelzongle);
        myClub = parse.AddClub(myClub);
        Log.i("ArcheryFollows", myClub.toString());

        edelzongle.setClub(myClub);
        parse.EditArcher(edelzongle);

        // Test de création d'un Evènement
        Date sysdate_as_date = Calendar.getInstance().getTime();
        Evenement myEvent = new Evenement();
        myEvent.setNom("Concours interne");
        myEvent.setDateEvenement(sysdate_as_date);
        myEvent.setDateEvent(dateEvent);
        myEvent.setOrganisateur(myClub);
        myEvent = parse.AddEvenement(myEvent);
        Log.i("ArcheryFollows", myEvent.toString());

        // Test d'inscription d'un participant à un évènement

        Participants participant = new Participants();
        participant.setArcher(edelzongle);
        participant.setEvenement(myEvent);
        participant = parse.AddParticipants(participant);
        Log.i("ArcheryFollows", participant.toString());

        // Test d'enregistremenet de deux volées
        Volee volee = new Volee();
        volee.setEvenement(myEvent);
        volee.setArcher(edelzongle);
        volee.setVolee(1);
        volee.putScoresVolee(10, 10, 2);
        volee = parse.AddVolee(volee);
        Log.i("ArcheryFollows", volee.toString());

        Volee volee2 = new Volee();
        volee2.setEvenement(myEvent);
        volee2.setArcher(edelzongle);
        volee2.setVolee(2);
        volee2.putScoresVolee(9, 9, 7);
        volee2 = parse.AddVolee(volee2);
        Log.i("ArcheryFollows", volee2.toString());

        // Test de connexion
        Log.i("ArcheryFollows", "User connected : " + parse.Login("8015420G", "test"));

        // Test de suppression
        parse.DeleteVolee(volee2);
        parse.DeleteVolee(volee);
        parse.DeleteParticipants(participant);
        parse.DeleteEvenement(myEvent);
        parse.DeleteClub(myClub);
        parse.DeleteArcher(edelzongle);

    }

}

