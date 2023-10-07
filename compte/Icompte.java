package com.example.myapplication.compte;

public interface Icompte {

    double totaleVersement();
    double totaleRetrait();

    void getprevioustransation();

    double getSolde();

    void consulterSolde();

    void  updateSolde();
    String toString();


}
