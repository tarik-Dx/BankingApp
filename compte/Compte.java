package com.example.myapplication.compte;
import com.example.myapplication.compte.exception.MtException;
import com.example.myapplication.compte.exception.SoldException;


import java.util.ArrayList;




public abstract    class Compte implements Icompte {
    private int code;
   /* public int previousVers;
    public int previousRet;*/
    protected double solde ;
    private static int nbComptes ;
    protected static int mt ;
    protected double previousRet;
    protected double previousVers;
    public StatutDeCompte status ;


    public Compte(){
        this.code =++nbComptes ;
    }
    public Compte(double solde,StatutDeCompte status){
        this.solde = solde;
        this.code =++nbComptes ;
        this.status = status;
    }

    public StatutDeCompte getStatus(){
        return this.status;
    }

    public double getSolde() {
        return this.solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public void setCode(int code) {
        this.code = code;
    }
    ArrayList<Operation> op = new ArrayList<>();


    public  void verser(int mt) throws Exception{

        if(mt<0) throw new MtException("le montant est negativ");
        if(mt == 0) throw new MtException("le montant est null");
        this.solde +=mt;
         previousVers = mt;

        op.add(new Versement(mt));
    }
    public void retirer(int mt)throws Exception{

        if (mt>=this.solde)throw new SoldException("solde insifussant: ");
        if(mt<0) throw new MtException("le montant est negativ");
        if(mt == 0) throw new MtException("le montant est null");
        this.solde -=mt;
        previousRet = -mt;


        op.add(new Retrait(mt));

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
    public double totaleVersement(){
        double var = 0;
        for (Operation operation : op){
            if(operation instanceof Versement){
                var +=operation.getMt();
            }
        }
        return var ;
    }
    public double totaleRetrait(){
        double var = 0;
        for (Operation operation: op ){
            if (operation instanceof Retrait){
                var+=operation.getMt();
            }
        }
        return -var;
    }

    public static void Versement(double mt,Compte compte1,Compte compte2)throws Exception{
        compte1.retirer(500);
        compte2.verser(500);
    }
    public void consulterSolde(){
        System.out.println(getSolde());
    }
    public  void  updateSolde(){};
    public String toString(){
        return ("le code est: "+this.code+" le solde est: "+this.solde+","+getStatus());
    }
}
