package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Jour {

    //Propriétés:
    LocalDate jour;
    LocalTime heureDebut;
    LocalTime heureFin;
    HashMap<String, Session> maSession;


    //Constructeur:
    public Jour(String inputJour){
        this.jour = LocalDate.parse(inputJour, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.maSession = new HashMap<String, Session>();
    }


    //Methodes:     -> un jour contient des sessions
    public void addSession(String sessionSaisie, Session nvlSession){
        maSession.put(sessionSaisie, nvlSession);
    }

    public void getSession(String maSess){  //remplacer void par le type qui sera renvoyé
        if (maSession.containsKey(maSess)) {    //containsKey = Vérifier qu'un élément existe (true/false)
            Session recupSession = maSession.get(maSess);
            System.out.println(recupSession.intitule);
            System.out.println(recupSession.heureDebutSession);
            System.out.println(recupSession.heureFinSession);
            System.out.println(recupSession.duree);
        }else{  //remplacer mon else par return null -> controller if(getSession = null) alors afficher msg d'erreur
            System.out.println("Cette session n'existe pas dans l'agenda");
        }
    }

    public void deleteSession(int sessionSaisie){
        if(maSession.containsKey(sessionSaisie)) {
            maSession.remove(sessionSaisie);
            System.out.println("La session a bien été supprimée");
        }else{
            System.out.println("Cette session n'existe pas et n'a pas pu être supprimée");
        }
    }




}