package com.tp1hibernate;
import jakarta.persistence.*;

@Entity
@Table(name = "entreprises")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntreprise;

    @Column(name = "nomEnt")
    private String nomEnt;

    @Column(name = "listeActivites")
    private String listeActivites;

    @Column(name = "nbEmployes")
    private int nbEmployes;

    public Entreprise() {}

    public Entreprise(String nomEnt, String listeActivites, int nbEmployes) {
        this.nomEnt = nomEnt;
        this.listeActivites = listeActivites;
        this.nbEmployes = nbEmployes;
    }

    public int getIdEntreprise() { return idEntreprise; }
    public void setIdEntreprise(int idEntreprise) { this.idEntreprise = idEntreprise; }

    public String getNomEnt() { return nomEnt; }
    public void setNomEnt(String nomEnt) { this.nomEnt = nomEnt; }

    public String getListeActivites() { return listeActivites; }
    public void setListeActivites(String listeActivites) { this.listeActivites = listeActivites; }

    public int getNbEmployes() { return nbEmployes; }
    public void setNbEmployes(int nbEmployes) { this.nbEmployes = nbEmployes; }

    @Override
    public String toString() {
        return "Entreprise{" +
                "idEntreprise=" + idEntreprise +
                ", nomEnt='" + nomEnt + '\'' +
                ", listeActivites='" + listeActivites + '\'' +
                ", nbEmployes=" + nbEmployes +
                '}';
    }
}

