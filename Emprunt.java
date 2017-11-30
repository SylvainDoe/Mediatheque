/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatheque;
import java.util.ArrayList;
import java.time.*;/**
 *
 * @author sylvain
 */
public class Emprunt {
    Ouvrage o;
    private LocalDate DateEmprunt;
    private LocalDate DateRendu;
    
    public Emprunt ( Ouvrage o,LocalDate emprunt,LocalDate retour){
         this.o=o;
         this.DateEmprunt = emprunt;
         this.DateRendu = retour;
    }

    public LocalDate getDateEmprunt() {
        return DateEmprunt;
    }

    public LocalDate getDateRendu() {
        return DateRendu;
    }

    public Ouvrage getO() {
        return o;
    }
    
    

    @Override
    public String toString() {
        return "Emprunt{" + "DateEmprunt=" + DateEmprunt + "/n DateRendu=" + DateRendu + o.toString() + '}';
    }

    
    public static Emprunt ralonger(int index,Adherent ad){
        int DateRendu;
        Emprunt emp;
        emp = ad.getLstemp().get(index);
        System.out.println("Vous avez decidés de rallonger votre date de rendu de 28 jours ");
        Period periode = Period.of(28, 0, 0);
        emp.getDateRendu().plus(periode);
        return emp;
    }
    
    public Emprunt creerEmprunt(int i,ArrayList<Ouvrage> lstOuvrage, Adherent ad){
        int empruntCD=0;
        int empruntRoman=0;
        Emprunt emp = null;
        for (int boucle=0;boucle<ad.getLstemp().size();boucle++){
            if (ad.getLstemp().get(boucle).getO() instanceof CD){
                empruntCD = empruntCD+1;
            }
            if (ad.getLstemp().get(boucle).getO() instanceof Roman){
                empruntRoman = empruntRoman+1;
            }
        }
        if(empruntRoman>5 || empruntCD>5){
            System.out.println("Vous avez effectuez trop d'emprunt ! Vous ne pouvez pas emprunter plus de 5 CD ou 5 Roman");
            System.out.println(empruntRoman +" roman empruntés");
            System.out.println(empruntCD+" CD empruntés");
        }
        else {
          Ouvrage o = lstOuvrage.get(i);
          if ( o.getDisponible()==0){
              System.out.println("L'ouvrage n'est pas disponible; veuillez le réservez si vous le voulez");
          }
          else {
           this.DateEmprunt=LocalDate.now();
           Period periode = Period.of(28, 0, 0);
           this.DateRendu= this.DateEmprunt.plus(periode);
            emp = new Emprunt(o,this.DateEmprunt,this.DateRendu);
            System.out.println("Vous avez décidé d'emprunter le ");
            if (o instanceof CD){
             System.out.println("Le CD "+ o.getTitre());
        }
         else {
             System.out .println("Le Roman "+ o.getTitre());
        }
         
          }
        }
        return emp;
}
}
   
    
    

