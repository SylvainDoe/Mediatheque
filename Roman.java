/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediatheque;

/**
 *
 * @author sylvain
 */
public class Roman extends Ouvrage {
     private int NombreDePage;
     
     public Roman (int num,String auteur, String titre,String editeur,int disponible,int nbre){
         super(num,auteur,titre,editeur,disponible);
         this.NombreDePage = nbre;
     }

    public int getNombreDePage() {
        return NombreDePage;
    }
    
    @Override
    public int testRoman(int nombre){
        if (nombre == this.NombreDePage){
            return 1;
        }
        else {
            return 0;
        }
    }
     public static Roman Initrom(){
         Roman r = new Roman (0,"George Orwell","Animal Farm","Penguin Book",2,200);
         return r;
     }
    
     public static Roman creerRoman(int num){
         System.out.println("quel est le nom de l'auteur ?");
         String auteur = Lire.S();
         System.out.println("quel est le nom du titre du Roman ?");
         String titre = Lire.S();
         System.out.println("quel est le nom de l'éditeur ?");
         String editeur = Lire.S();
         System.out.println("quel est le nombre de page du Roman?");
         int nombre = Lire.i();
         System.out.println("Combien il y a t-il de roman ? ");
         int disponible = Lire.i();
         Roman r = new Roman(num,auteur,titre,editeur,disponible,nombre);
         return r;
     }

    @Override
    public String toString() {
        return "Roman { " + super.toString() + " NombreDePage = " + NombreDePage + '}';
    }
}
