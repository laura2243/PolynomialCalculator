package proiect;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;

public class HelloController {


    public TextField pol;
    public TextField pol2;
    public TextField output1;
    public MenuButton op;


    String s = "";


    @FXML
    protected void delButton() {
        if (choice == 1 && !pol2.equals(null)) {

            pol.setText(pol.getText().substring(0, pol.getText().length() - 1));
        }
        if (choice == 2 && !pol2.equals(null)) {

            pol2.setText(pol2.getText().substring(0, pol2.getText().length() - 1));
        }

    }

    @FXML
    protected void ON1Button() {
        if (choice == 1) {
            pol.appendText("1");
        } else {
            pol2.appendText("1");
        }


    }

    @FXML
    protected void ON2Button() {
        if (choice == 1) {
            pol.appendText("2");
        } else {
            pol2.appendText("2");
        }
    }

    @FXML
    protected void ON3Button() {
        if (choice == 1) {
            pol.appendText("3");
        } else {
            pol2.appendText("3");
        }
    }

    @FXML
    protected void ON4Button() {
        if (choice == 1) {
            pol.appendText("4");
        } else {
            pol2.appendText("4");
        }
    }

    @FXML
    protected void ON5Button() {
        if (choice == 1) {
            pol.appendText("5");
        } else {
            pol2.appendText("5");
        }
    }

    @FXML
    protected void ON6Button() {
        if (choice == 1) {
            pol.appendText("6");
        } else {
            pol2.appendText("6");
        }
    }

    @FXML
    protected void ON7Button() {
        if (choice == 1) {
            pol.appendText("7");
        } else {
            pol2.appendText("7");
        }
    }

    @FXML
    protected void ON8Button() {
        if (choice == 1) {
            pol.appendText("8");
        } else {
            pol2.appendText("8");
        }
    }

    @FXML
    protected void ON9Button() {
        if (choice == 1) {
            pol.appendText("9");
        } else {
            pol2.appendText("9");
        }
    }

    @FXML
    protected void ON0Button() {
        if (choice == 1) {
            pol.appendText("0");
        } else {
            pol2.appendText("0");
        }
    }
    @FXML
   protected void OnPunctButton(){
        if(choice == 1){
            pol.appendText(".");
        } else{
            pol2.appendText(".");
        }
    }
    @FXML
    protected void ONPlusButton() {
        if (choice == 1) {
            pol.appendText("+");
        } else {
            pol2.appendText("+");
        }
    }


    @FXML
    protected void ONMinusButton() {
        if (choice == 1) {
            pol.appendText("-");
        } else {
            pol2.appendText("-");
        }
    }

    @FXML
    protected void ONPutereButton() {
        if (choice == 1) {
            pol.appendText("^");
        } else {
            pol2.appendText("^");
        }
    }

    @FXML
    protected void ONXButton() {
        if (choice == 1) {
            pol.appendText("x");
        } else {
            pol2.appendText("x");
        }
    }

    @FXML
    protected void ONAddButton() {

        String poly1 = pol.getText();
        String poly2 = pol2.getText();
        if (!check(poly1) || !check(poly2)) {
            output1.setText("Input incorect ");
            return;
        }

        Polinom polinom1 = new Polinom(poly1);
        Polinom polinom2 = new Polinom(poly2);
        polinom1.concat(polinom2);

        // polinom1.Add(polinom1).afisare();
        s = polinom1.Add(polinom1).afisare();
        op.setText("Add");
        // output1.setText(polinom1.Add(polinom1).afisare());
    }

    @FXML
    public void ONSubstractButton() {

        String poly1 = pol.getText();
        String poly2 = pol2.getText();
        if (!check(poly1) || !check(poly2)) {
            output1.setText("Input incorect ");
            return;
        }
        Polinom polinom1 = new Polinom(poly1);
        Polinom polinom2 = new Polinom(poly2);

        // polinom1.Add(polinom1).afisare();
        s = polinom1.substract(polinom2).afisare();
        op.setText("Substract");
        // output1.setText(polinom1.substract(polinom2).afisare());
    }

    @FXML
    protected void ONMultiplyButton() {

        String poly1 = pol.getText();
        String poly2 = pol2.getText();
        if (!check(poly1) || !check(poly2)) {
            output1.setText("Input incorect ");
            return;
        }

        Polinom polinom1 = new Polinom(poly1);
        Polinom polinom2 = new Polinom(poly2);
        //polinom1.concat(polinom2);

        // polinom1.Add(polinom1).afisare();
        s = polinom1.multiply(polinom1, polinom2).afisare();
        op.setText("Multiply");
        // output1.setText(polinom1.multiply(polinom1,polinom2).afisare());
    }

    @FXML
    protected void ONDerivareButton() {

        String poly1 = pol.getText();


        Polinom polinom1 = new Polinom(poly1);
        if (!check(poly1)) {
            output1.setText("Input incorect ");
            return;
        }

        // polinom1.Add(polinom1).afisare();
        s = polinom1.derivare(polinom1).afisare();
        op.setText("Derivate");
        // output1.setText(polinom1.derivare(polinom1).afisare());
    }

    @FXML
    protected void ONIntegrareButton() {

        String poly1 = pol.getText();
        Polinom polinom1 = new Polinom(poly1);

        if (!check(poly1)) {
            output1.setText("Input incorect ");
            return;
        }
        // polinom1.Add(polinom1).afisare();
        s = polinom1.integrare(polinom1).afisare()+"+C";
        op.setText("Integrate");
        //output1.setText(polinom1.integrare(polinom1).afisare());
    }

    @FXML
    protected void ONDivideButton() {

        String poly1 = pol.getText();
        String poly2 = pol2.getText();
        if (!check(poly1) || !check(poly2)) {
            output1.setText("Input incorect ");
            return;
        }

        Polinom polinom1 = new Polinom(poly1);
        Polinom polinom2 = new Polinom(poly2);

        // polinom1.Add(polinom1).afisare();
        s = polinom1.imparte(polinom1, polinom2);
        op.setText("Divide");
        //  output1.setText(polinom1.imparte(polinom1,polinom2));
    }

    int choice;

    @FXML
    protected void textBoxChoice1() {
        choice = 1;
    }

    @FXML
    protected void textBoxChoice2() {
        choice = 2;
    }

    static boolean check(String s) {
        String check = "1234567890^+-x.";
        if (!StringUtils.containsOnly(s, check))
            return false;
        return true;
    }

    @FXML
    protected void computeButton() {
        if (s.equals("")) {

            output1.setText("Input incorect ");
            return;
        }


        output1.setText(s);

    }

}