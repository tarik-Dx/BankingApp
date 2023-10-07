package com.example.myapplication.compte;


import com.example.myapplication.compte.exception.MtException;
import com.example.myapplication.compte.exception.SoldException;

public class CompteCourant extends Compte {
    private double dec;


    public CompteCourant(double sold, double dec,StatutDeCompte status) {
        super();
        this.solde = sold;
        this.dec = dec;
        this.status=status;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void retirer(int mt) throws Exception {
        if (mt > this.dec + this.solde) throw new SoldException("le solde est insiffussant");
        if (mt < 0) throw new MtException("le montant est negativ");
        if (mt == 0) throw new MtException("le montant est null");
        this.solde -= mt;
        previousRet = -mt;
        System.out.println("transaction succes");
    }

    public void getprevioustransation(){
        if (previousVers>0){
            System.out.println("derniere verment "+previousVers);
        }
        else if (previousRet<0){
            System.out.println("derniere retirement "+Math.abs(previousRet));
        }
        else{
            System.out.println("il ya pas de transaction ");
        }
    }
    public void consulterSolde(){
        System.out.print("le  solde est : ");
        System.out.println(getSolde());
    }
    public  void  updateSolde(){};


    public String toString(){

        return (super.toString()+" decouvrement est: "+this.dec);
    }
}
