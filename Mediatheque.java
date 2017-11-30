/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatheque;
import java.util.ArrayList;
/**
 *
 * @author sylvain
 */

// Mieux fair l'affichage de liste etc.. avec /n
// faire initialisation avec plus de 5 CD et 5 Roman pour vérifier tous
public class Mediatheque {
    private ArrayList<Adherent> listAdherent;
    private ArrayList<Ouvrage> listOuvrage;
    
    public Mediatheque(ArrayList<Adherent> lstA,ArrayList<Ouvrage> lstO){
        this.listAdherent = lstA;
        this.listOuvrage = lstO;
    }

    public ArrayList<Adherent> getListAdherent() {
        return listAdherent;
    }


    public ArrayList<Ouvrage> getListOuvrage() {
        return listOuvrage;
    }
    // ajouter des méthodes pour afficher dans recherche bien les ouvrages avec le i pour qu'il choissise ses ouvrages pour le reste pas oublier i+1
    public static ArrayList<Adherent> InitlistAdherent(){
        ArrayList<Adherent> listAdherent = new ArrayList<Adherent>();
        Adherent ad1 = new Adherent(0,"Derory","Sylvain","derory.sylvain@insa-strasbourg.fr","0606568459",null,null);
        Adherent ad2 = new Adherent(1,"My name is","Jeff","MyNameJeffYeett@eskatit.com","06055969",null,null);
        listAdherent.add(ad1);
        listAdherent.add(ad2);
        return listAdherent;
    }
    public static ArrayList<Adherent> creerlistAdherent(){
        System.out.println("Combien d'adhérent il y a t-il ?");
        int size = Lire.i();
        ArrayList<Adherent> listAdherent = new ArrayList<Adherent>();
        for (int i=0;i<size;i++){
            System.out.println("Adherent "+i);
            listAdherent.add(Adherent.creerAdherent(i));
        }
        return listAdherent;
    }
    
    public static ArrayList<Ouvrage> InitlistOuvrage(){
        ArrayList<Ouvrage> lstouv = new ArrayList<>();
        lstouv.add(Roman.Initrom());
        lstouv.add(CD.InitCD1());
        lstouv.add(CD.InitCD2());
        lstouv.add(CD.InitCD3());
        lstouv.add(CD.InitCD4());
        lstouv.add(CD.InitCD5());
        return lstouv;
    }
    
    public static ArrayList<Ouvrage> creerlistOuvrage(){
        System.out.println("Combien d'ouvrage il y a t-il ?");
        int size = Lire.i();
        Ouvrage o = Ouvrage.creerOuvrage(0);
        ArrayList<Ouvrage> listOuvrage =  new ArrayList<Ouvrage>();
        for (int i=0;i<size;i++){
            listOuvrage.add(Ouvrage.creerOuvrage(i));
        }
        return listOuvrage;
    }
    
    
    public static void afficherOuv(ArrayList<Ouvrage> listOuvrage){
        System.out.println("Voici la liste complète des ouvrages ");
        for (int i=0;i<listOuvrage.size();i++){
            System.out.println(listOuvrage.get(i).toString());
        }
    }
    public static int admin(){
        System.out.println("Bonjour admin");
        System.out.println("Quel modifications voulez vous apporter ?");
        System.out.println("Tapez 1 pour ajouter un adhérent");
        System.out.println("Tapez 2 pour afficher tous les adhérents");
        System.out.println("Tapez 3 pour supprimer un adhérent");
        System.out.println("Tapez 4 pour ajouter un Ouvrage");
        System.out.println("Tapez 5 pour afficher tous les Ouvrages");
        System.out.println("Tapez 6 pour supprimer un Ouvrage");
        System.out.println("Tapez 7 pour revenir à la Médiatheque");
        return Lire.i();
    }
    
   

    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choix=0;
        int test = 0;
        int utilisateur;
        int admin = 0;
        ArrayList<Ouvrage> lstOuv = InitlistOuvrage();
        ArrayList<Adherent> lstAd = InitlistAdherent();
        System.out.println("Bienvenu à la Médiathèque ");
        while (choix<1||choix>6){
            System.out.println("Tapez 1 si vous êtes un admin");
            System.out.println("Tapez 2 si vous êtes un adhérent");
            utilisateur = Lire.i();
            if (utilisateur == 1){
                  //initialisation

                while (test==0){
                    test = admin();
                    if (test == 1){
                        lstAd.add(Adherent.creerAdherent(lstAd.size()));
                        test = 0;
                    }
                    if (test == 2){
                        Adherent.affichagead(lstAd);
                        test = 0;
                    }
                    if (test == 3){
                        System.out.println("Tapez le numéro de l'adhérent à supprimer");
                        lstAd.remove(Lire.i()-1);
                        test = 0;
                    }
                     if (test == 4){
                        int existence = 0;
                        Ouvrage o = Ouvrage.creerOuvrage(lstOuv.size()); 
                        for (int i=0;i<lstOuv.size();i++){
                            if (lstOuv.get(i).equals(o)){
                                existence = i+1;
                            }
                        }
                        if (existence !=0){
                            lstOuv.get(existence-1).setDisponible(lstOuv.get(existence-1).getDisponible()+1);
                            System.out.println("La liste a été mise à jour");
                        }
                        else {
                            lstOuv.add(o);
                            utilisateur = 0;
                        }
                    }
                    if (test == 5){
                        lstOuv.toString();
                        test = 0;
                    }
                    if (test == 6){
                        System.out.println("Tapez le numéro de l'Ouvrage à supprimer");
                        lstOuv.remove(Lire.i()-1);
                        test = 0;
                    }
                }
                
            }
            if (utilisateur ==2){
                // système pour identifier l'adhérent
                System.out.println("Vous vous idhentifiés en tant qu'adhérent ");
                Adherent.affichagead(lstAd);
                System.out.println("Veuillez entrez votre numéro s'il vous plaît");
                int numero = Lire.i()-1;
                Adherent ad = lstAd.get(numero );
                while (choix<1||choix>7){
                System.out.println("Que voulez vous faire ?");
                System.out.println("Tapez 1 pour afficher la liste d'ouvrage complet");
                System.out.println("Tapez 2 pour rechercher un ouvrage");
                System.out.println("Tapez 3 pour emprunter un ouvrage");
                System.out.println("Tapez 4 pour réservez un ouvrage");
                System.out.println("Tapez 5 pour annulez une réservation");
                System.out.println("Tapez 6 pour rallongez un emprunt");
                System.out.println("Tapez 7 pour quitter la Médiatheque");
                choix = Lire.i();
                
                
                if (choix == 1){
                    afficherOuv(lstOuv); 
                    choix =0;
                }
                if (choix == 2){
                    int index = Ouvrage.recherche(lstOuv);
                    choix = 0;
                }
                if (choix >2){
                   int index = 0;
                   System.out.println("Veuillez indiquer l'index de l'Ouvrage voulu");
                    index = Lire.i()-1;
                    if (choix == 3){
                         Emprunt emp = null;
                         emp.creerEmprunt(index, lstOuv, ad);
                         ad.AjouterEmprunt(emp);
                         choix = 0;
                }
                     if (choix == 4){
                         System.out.println("Vous avez choisi de réserveez un ouvrage");
                         Reservation.reserver(ad, index);
                         choix = 0;
            }
                     if (choix == 5) {
                         System.out.println("Vous avez choisi d'annulez une réservation");
                         Reservation.annuler(index, ad, lstOuv);
                         choix = 0;
                     }
                     if (choix == 6){
                         System.out.println("Vous avez décidés de rallonger votre emprunt");
                         Emprunt emp = null;
                         emp = Emprunt.ralonger(index, ad);
                         ad.AjouterEmprunt(emp);
                         choix = 0;
                     }
             
                }  
    }
    }
    }
    }
    
}
