package org.example;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private int id;
    private static int callCount = 0;
    Utilisateur(String nom, String prenom, String email) throws app2.ServiceException {
        /*if (nom == null || nom.isEmpty() || prenom == null || prenom.isEmpty() || email == null || email.isEmpty()) {
            throw new app2.ServiceException("Les arguments nom, prenom et email sont obligatoires.");
        }*/
        this.id = callCount;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        callCount ++ ;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

/*
    public static void main(String[] args) throws app2.ServiceException {

        Utilisateur u = new Utilisateur(null, null,null);
    }*/
}
