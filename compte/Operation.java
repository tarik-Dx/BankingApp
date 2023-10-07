package com.example.myapplication.compte;

import java.util.Date;

public class Operation {
     protected  int code;
     protected  Date date;
     private double mt;

     public static int nbrOp=0;

     //nbrOp
     public double getMt(){
          return this.mt;
     }
     public void setMt(double mt){
           this.mt=mt;
     }
     public int getCode(){
          return this.code;
     }


     public Operation(double mt){
          this.code=++nbrOp;
          this.mt=mt;
          this.date= new Date();

     }
     public String verser(){ return ("le numero de l'operation est :"+getCode()+" === "+"le montant verser est :"+getMt()+" === "
             +"la date de l'operation est "+date);}
     public String retirer(){    return ("le numero de l'operation est :"+getCode()+" === "+"le montant retirer est :"+getMt()+" === "
             +"la date de l'operation est "+date);}




}
