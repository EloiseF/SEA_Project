package fr.cnam.business;

import java.util.ArrayList;

import fr.cnam.model.*;

/**
 * Created by Robert on 02/04/2015.
 */
public interface Queries {

    //Gestion des archers en BDD
    public Archer AddArcher(Archer a);
    public Archer GetArcher(String id);
    public void EditArcher(Archer a);
    public void DeleteArcher(Archer a);

    //Gestion des clubs en BDD
    public Club AddClub(Club c);
    public Club GetClub(String id);
    public ArrayList<Archer> GetMembres(Club c);
    public void EditClub(Club c);
    public void DeleteClub(Club c);

    //Gestion des évènements en BDD
    public Evenement AddEvenement(Evenement e);
    public Evenement GetEvenement(String dateEvenement, String idClub);
    public void EditEvenement(Evenement e);
    public void DeleteEvenement(Evenement e);

    //Gestion des participations en BDD
    public Participants AddParticipants(Participants p);
    public Participants GetParticipant(String licenceArcher, Evenement evenement);
    public ArrayList<Participants> GetListeParticipants(Evenement evenement);
    public void EditParticipants(Participants p);
    public void DeleteParticipants(Participants p);

    //Gestion des résultats en BDD
    public Volee AddVolee(Volee v);
    public Volee GetVolee(Evenement event, Archer participant, Number numVolee);
    public void EditVolee(Volee v);
    public void DeleteVolee(Volee v);

    //Gestion de la connexion en BDD
    public boolean Login(String licenceArcher, String password);

}
