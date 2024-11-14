package com.example.lab04alexdumitru;

public class Commande {

    private int noCommande;
    private String nomClient;
    private String telClient;
    private int noRepas;
    private String nom;
    private double prix;

    public Commande() {
    }

    public Commande(int noCommande, String nomClient, String telClient, int noRepas, String nom, double prix) {
        this.noCommande = noCommande;
        this.nomClient = nomClient;
        this.telClient = telClient;
        this.noRepas = noRepas;
        this.nom = nom;
        this.prix = prix;
    }

    public int getNoCommande() {
        return noCommande;
    }

    public void setNoCommande(int noCommande) {
        this.noCommande = noCommande;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public int getNoRepas() {
        return noRepas;
    }

    public void setNoRepas(int noRepas) {
        this.noRepas = noRepas;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "noCommande=" + noCommande +
                ", nomClient='" + nomClient + '\'' +
                ", telClient='" + telClient + '\'' +
                ", noRepas=" + noRepas +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}