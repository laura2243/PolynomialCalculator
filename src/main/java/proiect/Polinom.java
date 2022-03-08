package proiect;

import java.util.ArrayList;
import java.util.Objects;

public class Polinom {
    private ArrayList<Monom> monoame;

    public Polinom() {
        monoame = new ArrayList<>();
        Monom m = new Monom();
          monoame.add(m);
    }

    public void concat(Polinom p) {
        this.monoame.addAll(p.monoame);
        monoame.sort((monom1, monom2) -> {
                    if (monom1.getPutere() == monom2.getPutere()) {
                        return 0;
                    }
                    return monom1.getPutere() > monom2.getPutere() ? -1 : 1;
                }
        );

    }

    public Polinom substract(Polinom p) {

        for (Monom m : p.monoame) {
            m.setCoeficient((-1) * m.getCoeficient());
        }

        this.monoame.addAll(p.monoame);
        monoame.sort((monom1, monom2) -> {
                    if (monom1.getPutere() == monom2.getPutere()) {
                        return 0;
                    }
                    return monom1.getPutere() > monom2.getPutere() ? -1 : 1;
                }
        );
        return this.Add(this);

    }

    public String imparte(Polinom p1, Polinom p2) {
        p1.monoame.sort((monom1, monom2) -> {
            if (monom1.getPutere() == monom2.getPutere()) {
                return 0;
            }
            return monom1.getPutere() > monom2.getPutere() ? -1 : 1;
        });
        p2.monoame.sort((monom1, monom2) -> {
            if (monom1.getPutere() == monom2.getPutere()) {
                return 0;
            }
            return monom1.getPutere() > monom2.getPutere() ? -1 : 1;
        });

        if (p2.monoame.get(0).getCoeficient() !=0 && p2.monoame.get(0).getPutere() !=0 ) {

            Polinom q = new Polinom();
            Polinom r = new Polinom();
            r = p1;
            while (lead(r).getCoeficient() != 0 && lead(r).getPutere() >= lead(p2).getPutere() && !r.monoame.isEmpty()) {
                Polinom t = new Polinom();
                ArrayList<Monom> monoms = new ArrayList<>();

                int exp = lead(r).getPutere() - lead(p2).getPutere();
                float coef = lead(r).getCoeficient() / lead(p2).getCoeficient();
                Monom m = new Monom(coef, exp);
                monoms.add(m);
                t.setMonoame(monoms);
                q.concat(t);
                q = q.Add(q);
                t = t.multiply(t, p2);
                r = r.substract(t);
            }
            r.concat(new Polinom());
            r =r.Add(r);
            r = r.Add(r);
            String s = "Quotient = " + q.afisare() + "  Remainder = " + r.afisare();
            return s;
        }
        String s="Division by zero";
        return s;
    }

    public Monom lead(Polinom p) {


        int i = 0;
        while (i < p.monoame.size()) {
            if (p.monoame.get(i).getCoeficient() != 0) {
                return new Monom(p.monoame.get(i).getCoeficient(), p.monoame.get(i).getPutere());
            }
            i++;
        }
        return new Monom();
    }

    public Polinom(String polinom) {
        monoame = new ArrayList<>();
        extract(polinom);

    }

    public Polinom Add(Polinom p1) {
        Polinom p = new Polinom();
        for (int i = 0; i < p1.monoame.size(); i++) {
            if (i != p1.monoame.size() - 1 && p1.monoame.get(i + 1).getPutere() == p1.monoame.get(i).getPutere()) {
                float coef = p1.monoame.get(i + 1).getCoeficient() + p1.monoame.get(i).getCoeficient();
                Monom m = new Monom(coef, p1.monoame.get(i).getPutere());
                p.monoame.add(m);
                i++;
            } else {
                p.monoame.add(p1.monoame.get(i));
            }
        }
        return p;
    }


    public Polinom multiply(Polinom p1, Polinom p2) {

        Polinom p = new Polinom();
        for (Monom m : p1.monoame) {
            Polinom polinom = new Polinom();
            ArrayList<Monom> monoms = new ArrayList<>();
            for (Monom m1 : p2.monoame) {
                float coef = m.getCoeficient() * m1.getCoeficient();
                int emp = m.getPutere() + m1.getPutere();

                Monom monom = new Monom(coef, emp);
                monoms.add(monom);
            }
            polinom.setMonoame(monoms);
            p.concat(polinom);
            p=p.Add(p);
        }




        return p;

    }

    public Polinom derivare(Polinom p1) {

        Polinom p = new Polinom();
        ArrayList<Monom> monoms = new ArrayList<>();
        for (Monom m : p1.monoame) {

            int exp = m.getPutere() - 1;
            float coef = m.getCoeficient() * m.getPutere();
            Monom monom = new Monom(coef, exp);
            monoms.add(monom);


        }
        p.setMonoame(monoms);
        return p;
    }

    public Polinom integrare(Polinom p1) {

        Polinom p = new Polinom();
        ArrayList<Monom> monoms = new ArrayList<>();
        for (Monom m : p1.monoame) {

            int exp = m.getPutere() + 1;
            float coef = m.getCoeficient() / exp;
            Monom monom = new Monom(coef, exp);
            monoms.add(monom);


        }
        p.setMonoame(monoms);
        return p;
    }

    private void extract(String s) {

        if (!HelloController.check(s)) {
            s = "Incorrect input";
            return;
        }
        if (s.equals("")) {
            return;
        }
        String poly = s;
        //  poly = poly.replace("-", "+-");
        //  poly = poly.replace("^+-", "^-");
        String[] terms = poly.replace(" ", "").split("(?=\\+|\\-)");

        // System.out.println(Arrays.toString(terms));


        for (String term : terms) {
            String[] splitAroundX = term.split("x", 2);
            if (Objects.equals(splitAroundX[0], "-")) {
                splitAroundX[0] = "-1";
            }
            if (Objects.equals(splitAroundX[0], "+")) {
                splitAroundX[0] = "+1";
            }
            int exponent = 0;
            String sCoeff = "1";
            if (splitAroundX.length > 1) {
                String sExp = splitAroundX[1].replace("^", "");
                exponent = sExp.isEmpty() ? 1 : Integer.parseInt(sExp);
                sCoeff = splitAroundX[0];


            } else if (splitAroundX.length == 1) {
                exponent = 0;
                sCoeff = "1";
            } else if (splitAroundX.length == 0) {
                exponent = 1;
                sCoeff = "1";
            }

            if (sCoeff == "") {
                sCoeff = "1";
            } else {
                sCoeff = splitAroundX[0];
            }

            //  System.out.println(Integer.parseInt(sCoeff));

            Monom m = new Monom(Float.parseFloat(sCoeff), exponent);

            monoame.add(m);


        }
    }

    public void setMonoame(ArrayList<Monom> monoame) {
        this.monoame = monoame;
    }

    public String afisare() {
        String ok = "0";
        String s = "";
        for (Monom m : monoame) {

            if (m.getPutere() == 0 && m.getCoeficient() == 0) {

                s += "";
            } else {
                if (m.getCoeficient() > 0) {
                    if (monoame.indexOf(m) > 0) {

                        s += "+" + m.afisare();

                    } else
                        s += m.afisare();
                } else s += m.afisare();
            }
        }

        if (monoame.size() != 0 && monoame.get(0).getCoeficient() != 1) {
            s = s.replace("1x", "x");
        } else {
            s = s.replace("+1x", "+x");
            s = s.replace("-1x", "-x");
        }
        if (s.equals("")) {
            s = "0";
        }
        if(String.valueOf(s.charAt(0)).equals("+") ){
            s = s.substring(1);

        }
        return s;
    }


}

