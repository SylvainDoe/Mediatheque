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
public class CD extends Ouvrage {
    
    private ArrayList<String> lst;
    
    public CD (int num,String auteur, String titre,String editeur,int disponible,ArrayList<String> lst){
        
        super (num,auteur,titre,editeur,disponible);
        this.lst = lst;
    }

    public ArrayList<String> getLst() {
        return lst;
    }
    
    @Override
    public int testCD(String titre){
        int test =0;
        for (int i=0;i<this.lst.size();i++){
            if (this.lst.get(i).equals(titre)){
                test = 1;
            }
            
        }
        return test;
        
    }

    @Override
    public String toString() {
        return "CD { " +super.toString()+ "\n lst = " + lst + '}';
    }
    public static CD InitCD1(){
        ArrayList<String> lst = new ArrayList<>();
        lst.add("Fall Apart");
        lst.add("Congratulation");
        lst.add("White Iverson");
        lst.add("Beanie King");
        lst.add("Popa John's");
        CD cd = new CD(7,"Post Malone", "Stoney", "WallMart",2,lst );
        return cd;
    }
    public static CD InitCD2(){
        ArrayList<String> lst = new ArrayList<>();
        lst.add("First Day Out");
        lst.add("Horses");
        lst.add("Tunnel Vison");
        CD cd = new CD(8,"Kodak Black", "Painting Pictures", "WallMart",2,lst );
        return cd;
    }
    public static CD InitCD3(){
        ArrayList<String> lst = new ArrayList<>();
        lst.add("Consideration");
        lst.add("Kiss It Better");
        lst.add("James Joint");
        lst.add("Work");
        lst.add("Needed Me");
        CD cd = new CD(9,"Rihanna", "Anti", "Def Jam",3,lst );
        return cd;
    }
    public static CD InitCD4(){
        ArrayList<String> lst = new ArrayList<>();
        lst.add("What's My Name ? ");
        lst.add("Cheers");
        lst.add("Only Girl");
        lst.add("California King Bed");
        lst.add("Man Down");
        lst.add("Skin");
        CD cd = new CD(10,"Rihanna", "Loud", "Def Jam",7,lst );
        return cd;
    }
    public static CD InitCD5(){
        ArrayList<String> lst = new ArrayList<>();
        lst.add("Consideration");
        lst.add("Kiss It Better");
        lst.add("James Joint");
        lst.add("Work");
        CD cd = new CD(11,"Rihanna", "Anti", "Def Jam",8,lst );
        return cd;
    }
    
    public static CD creerCD(int num){
         ArrayList<String> lst = new ArrayList<>();
         System.out.println("quel est le nom de l'auteur ?");
         String auteur = Lire.S();
         System.out.println("quel est le nom du titre du CD ?");
         String titre = Lire.S();
         System.out.println("quel est le nom de l'éditeur ?");
         String editeur = Lire.S();
         System.out.println("quel est le nombre de chanson?");
         int taille = Lire.i();
         for (int i=0; i < taille; i++){
         System.out.println("quel est le nom de la chanson ?"); 
         lst.add(Lire.S());
         }
         System.out.println("Combien il y a t-il de ce CD ? ");
         int disponible = Lire.i();
         CD r = new CD(num,auteur,titre,editeur,disponible,lst);
         return r;
    }
    
}
