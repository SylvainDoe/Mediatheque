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
public class Ouvrage {
     private int numero;
     private String auteur;
     private String titre;
     private String editeur;
     private int disponible;
     
     public Ouvrage(int num,String auteur, String titre,String editeur,int disponible){
         this.numero = num;
         this.auteur = auteur;
         this.titre = titre;
         this.editeur = editeur;
         this.disponible=disponible;
         
     }

    public int getNumero() {
        return numero;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getEditeur() {
        return editeur;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }
    
    
// /n fonctionne à changer le reste des autres
    @Override
    public String toString() {
        return "numero=" + numero+1 + "\n auteur=" + auteur + "\n titre=" + titre + "\n editeur=" + editeur + "\n quantité disponible" + disponible + '}';
    }
    public int testRoman(int nombre){
        return 0;
    }
    
    public int testCD(String titre){
        return 0;
    }
     public static int recherche(java.util.ArrayList<Ouvrage> listOuvrage){
        int index;
        System.out.println("Quels sont vos critères de recherche ?");
        System.out.println("Tapez 1 pour une recherche selon l'auteur");
        System.out.println("Tapez 2 pour une recherche selon le titre");
        System.out.println("Tapez 3 pour une recherche selon l'éditeur");
        System.out.println("Tapez 4 pour une recherche selon le titre de l'album");
        System.out.println("Tapez 5 pour une recherche selon le nombre de page");
        System.out.println("Tapez 6 pour une recherche selon le titre de la chanson");
        int choix = Lire.i();
        while ( choix<1 || choix>5){
            System.out.println("Veuillez rentrez un nombre");
            System.out.println("Quels sont vos critères de recherche ?");
            System.out.println("Tapez 1 pour une recherche selon l'auteur");
            System.out.println("Tapez 2 pour une recherche selon le titre");
            System.out.println("Tapez 3 pour une recherche selon l'éditeur");
            System.out.println("Tapez 4 pour une recherche selon le titre de la chanson");
            System.out.println("Tapez 5 pour une recherche selon le nombre de page");
      
            choix = Lire.i();
        }
        if (choix == 1){
            System.out.println("Entrez l'auteur voulu");
            String auteur = Lire.S();
            for (int i=0;i<listOuvrage.size();i++){
                if (listOuvrage.get(i).getAuteur().equals(auteur)){
                    System.out.println(listOuvrage.get(i).toString());
                             
                }
            }           
        }
        if (choix == 2){
            System.out.println("Entrez le titre voulu");
            String titre = Lire.S();
            for (int i=0;i<listOuvrage.size();i++){
                if (listOuvrage.get(i).getTitre().equals(titre)){
                    System.out.println(listOuvrage.get(i).toString());
                }
            }
            
        }
        if (choix == 3){
            System.out.println("Entrez l'éditeur voulu");
            String éditeur = Lire.S();
            for (int i=0;i<listOuvrage.size();i++){
                if (listOuvrage.get(i).getEditeur().equals(éditeur)){
                    System.out.println(listOuvrage.get(i).toString());
                }
            }
            
        }
        if (choix == 4){
            System.out.println("Entrez le titre de la chanson voulu");
            String titre = Lire.S();
            for (int i=0;i<listOuvrage.size();i++){
                if (listOuvrage.get(i) instanceof CD){
                    
                    if (listOuvrage.get(i).testCD(titre)==1)
                        System.out.println(listOuvrage.get(i).toString());
                }
            }
            
        }
        if (choix == 5){
            System.out.println("Entrez le nombre de pages voulu");
            int nombre = Lire.i();
            for (int i=0;i<listOuvrage.size();i++){
                if (listOuvrage.get(i) instanceof Roman){
                    if (listOuvrage.get(i).testRoman(nombre)==1)
                        System.out.println(listOuvrage.get(i).toString());
                }
            }
            
        }
        System.out.println("Si c'est l'ouvrage recherché veuillez entrez son index");
         return index = Lire.i();
        
    }
    
    
     
    public static Ouvrage creerOuvrage(int num){
        int test = 0;
        Ouvrage o = null;
        System.out.println("Quel type d'Ouvrage s'agit-il ?");
        System.out.println("Tapez 1 pour un Ouvrage de type CD ");
        System.out.println("Tapez 2 pour un ouvrage de type Roman");
        test = Lire.i();
        while ( test < 1 || test > 2){
            System.out.println("Entrée incorrect veuillez entrez 1 pour un CD ou 2 pour un Roman");    
        }
        if ( test == 1){
            o = CD.creerCD(num);
        }
        if ( test == 2){
            o = Roman.creerRoman(num);
        }
        return o;
    }
    
    
    
}
