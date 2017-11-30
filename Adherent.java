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
public class Adherent {
    
    private int numero;
    private String nom;
    private String prenom;
    private String AdresseMail;
    private String NumeroTelephone;
    private ArrayList <Emprunt> lstemp;
    private ArrayList<Ouvrage> reservation;
    
    public Adherent(int numero,String nom,String prenom,String mail,String tel,ArrayList<Emprunt> lstemp,ArrayList<Ouvrage> reservation){
        this.numero=numero;
        this.nom = nom;
        this.prenom = prenom;
        this.AdresseMail = mail;
        this.NumeroTelephone = tel;
        this.lstemp = lstemp;
        this.reservation = reservation;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresseMail() {
        return AdresseMail;
    }

    public String getNumeroTelephone() {
        return NumeroTelephone;
    }

    public ArrayList<Ouvrage> getReservation() {
        
        return reservation;
    }
    

    public ArrayList<Emprunt> getLstemp() {
       
        return lstemp;
    }
    
// à changer
    @Override
    public String toString() {
        return "Adherant { " + " numéro = " + (numero+1) + " nom = " + nom + " prenom = " + prenom + " AdresseMail = " + AdresseMail + " NumeroTelephone = " + NumeroTelephone + '}';
    }
    
    public static void affichagead(ArrayList<Adherent> lstad){
        for (int u = 0; u<lstad.size();u++){
            System.out.println(lstad.get(u).toString());
        }
            System.out.println("Liste Emprunt : ");
            for (int i = 0;i<lstad.size();i++){
                Adherent ad = lstad.get(i);
                if (ad.getLstemp() == null){
                    System.out.println("vide");
                }
                else {
                  for (int k=0;k<ad.getLstemp().size();k ++ ){
                       System.out.println(ad.getLstemp().get(i).toString());
           }
            }
                 System.out.println("Liste Reservation : ");
                 if (ad.getReservation() == null){
                     System.out.println("vide");
            }
                else {
                   for (int p=0;p<ad.getReservation().size();p ++ ){
                       System.out.println(ad.getReservation().get(i).toString());
        }
    }
        }
    }
    
    public void AjouterEmprunt(Emprunt emp){
        this.lstemp.add(emp);
    }
    
    
    public static Adherent creerAdherent(int numero){
         System.out.println("quel est le nom de l'adhérant ?");
         String nom = Lire.S();
         System.out.println("quel est le prenom de l'adhérant ?");
         String prenom = Lire.S();
         System.out.println("quel est le mail de l'adhérant ?");
         String mail = Lire.S();
         System.out.println("quel est le numéro de télephone ?");
         String tel = Lire.S();
         ArrayList <Emprunt> lstemp = null ;
         ArrayList <Ouvrage> lstres = null;
         Adherent a = new Adherent(numero,nom,prenom,mail,tel,lstemp,lstres);
         return a;
    }
    
}

    

