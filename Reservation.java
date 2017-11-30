/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatheque;
import java.util.ArrayList;
import java.time.*;
/**
 *
 * @author sderory01
 */

public class Reservation {
    private ArrayList<Ouvrage> reservation;
    
    public Reservation(ArrayList<Ouvrage> res){
        this.reservation = res;
        
    }

    public ArrayList<Ouvrage> getReservation() {
        if (reservation.isEmpty()){
            return null;
        }
        else {
        return reservation;
        }
    }
    
    
    public static void reserver(Adherent ad,int index){
        int retard =0;
        Emprunt emp = ad.getLstemp().get(index);
        Ouvrage o = emp.getO();
        System.out.println("Vous avez choisi de réservez un ouvrage");
        for ( int i =0; i<ad.getLstemp().size();i++){
            LocalDate DateRendu = ad.getLstemp().get(i).getDateRendu();
          if (DateRendu.isAfter(LocalDate.now()) ){
              retard = retard +1;
        }
        if (retard>3){
            System.out.println("Vous avez plus de 3 retards veuillez rendre vos Ouvrages au plus vite");
        }
        else {
        if (ad.getReservation().size() <4){
        ad.getReservation().add(o);
        }
        else {
            System.out.println("Vous avez plus de 3 réservations,annulez en une si vous voulez réservez cet ouvrage");
        }
        }
    }
    }
    public static void annuler(int index, Adherent ad, ArrayList<Ouvrage> lst ){
        if (ad.getReservation().isEmpty()){
            System.out.println("Vous n'avez aucune réservation");
        }
        else {
            ad.getReservation().remove(lst.get(index));
            System.out.println("Votre réservation a bien été annulée");
        }
    }
}
