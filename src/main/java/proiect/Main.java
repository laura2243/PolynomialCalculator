package proiect;

public class Main {
    public static void main (String[] args){

        String p2 = "x^3-2x^2+6x-5";
       Polinom polinom1 = new Polinom(p2);

        String p1 = "x^2-1";
       Polinom polinom2 = new Polinom(p1);
        System.out.println();
        polinom1.afisare();
        System.out.println();
        polinom2.afisare();
        System.out.println();


        // polinom1.concat(polinom2);




        // polinom1.Add(polinom1);
        // System.out.println();
        // System.out.println(polinom1.substract(polinom2).afisare());
        // polinom1.afisare();



        //polinom1.multiply(polinom1,polinom2);
        // polinom1.derivare(polinom1).afisare();
        //polinom1.integrare(polinom1).afisare();


        //polinom1.imparte(polinom1,polinom2);


        //System.out.println(System.getProperties());

    }
}

