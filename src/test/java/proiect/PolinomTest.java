package proiect;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolinomTest {

    @org.junit.jupiter.api.Test
    void substract() {
        String p2 = "x+1";
        Polinom polinom1 = new Polinom(p2);

        String p1 = "x^2-1";
        Polinom polinom2 = new Polinom(p1);
        assertEquals("-x^2+x+2",polinom1.substract(polinom2).afisare());
    }

    @org.junit.jupiter.api.Test
    void imparte() {
        String p2 = "x+1";
        Polinom polinom1 = new Polinom(p2);

        String p1 = "x^2-1";
        Polinom polinom2 = new Polinom(p1);
        assertEquals("Quotient = 0  Remainder = x+1",polinom1.imparte(polinom1,polinom2));
    }


    @org.junit.jupiter.api.Test
    void add() {
        String p2 = "x+1";
        Polinom polinom1 = new Polinom(p2);

        String p1 = "x^2-1";
        Polinom polinom2 = new Polinom(p1);
        polinom1.concat(polinom2);

        assertEquals("x^2+x", polinom1.Add(polinom1).afisare());
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        String p2 = "x+1";
        Polinom polinom1 = new Polinom(p2);

        String p1 = "x^2-1";
        Polinom polinom2 = new Polinom(p1);
        assertEquals("x^3+x^2-x-1",polinom1.multiply(polinom1,polinom2).afisare());
    }

    @org.junit.jupiter.api.Test
    void derivare() {
        String p2 = "x+1";
        Polinom polinom1 = new Polinom(p2);


        assertEquals("1",polinom1.derivare(polinom1).afisare());
    }

    @org.junit.jupiter.api.Test
    void integrare() {
        String p2 = "x+1";
        Polinom polinom1 = new Polinom(p2);


        assertEquals("0.5x^2+x",polinom1.integrare(polinom1).afisare());
    }


}