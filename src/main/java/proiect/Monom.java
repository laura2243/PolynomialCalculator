package proiect;

public class Monom {

    public int putere;
    public float coeficient;


    public Monom(float coeficient, int putere) {
        this.putere = putere;
        this.coeficient = coeficient;
    }

    public int getPutere() {
        return putere;
    }

    public float getCoeficient() {
        return coeficient;
    }

    public Monom() {

    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }

    public String afisare() {
        String s = "";
        String ok = "0";
        if (coeficient == 0 && putere == 0)
            s += "0";

        if (coeficient == 1 && putere == 0)
            s += "1";
        else {
            if (coeficient != 1 && coeficient != 0)
                if (coeficient % 1 == 0) {
                    s += (int) coeficient;
                } else

                    s += coeficient;
        }
        if (putere == 1 && coeficient != 0)
            s += "x";
        else {
            if (putere != 0 && coeficient != 0)

                s += "x^" + putere;

        }
        //  if (!s.equals(""))
        //  ok = "1";
        //   System.out.print("aici"+s );

        return s;

    }
}
