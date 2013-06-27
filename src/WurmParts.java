/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Frame.java
 */
/**
 *
 * @author Janes.AbouChleih
 */


import java.awt.Color;
import java.awt.Graphics;

public class WurmParts extends Parts {

    
    protected int richtung;
    protected WurmParts next = null;

    public WurmParts(int X, int Y) {
        super(X, Y); // SuperKlasse wird aufgerufen mit Parameter x,y
    }

    public void zeichne(Graphics g, int lX, int lY) {
        g.setColor(Color.orange); // Farbe : Orange
        g.fillRect(X() * lX, Y() * lY, lX, lY); // Viereck wird gezeichnet
    }

    public boolean krieche() {
        int newX = x;
        int newY = y;
        switch (Richtung()) {
            case 1: // Wenn rechts dann wird newX immer 1 mehr
                ++newX;
                break;
            case 2:
                --newX; // Wenn links dann wird newX immer 1 weniger
                break;
            case 3:
                ++newY; // Wenn oben dann wird newY immer 1 mehr
                break;
            case 4:
                --newY; // Wenn unten dann wird newY immer 1 mehr
        }


        if (liegtAusserhalbFeld(newX, newY)) {
            return false; // Wenn der wurm ausserhalb des Feldes ist dann false
        }

        if (emptyfield(newX, newY)) {
            x = newX; // x wird der Wert newX zugewießen
            y = newY; // y wird der Wert newY zugewießen
            return false; // Es wird false returned
        }

        x = newX;
        y = newY;

        if (next == null) { // Wenn next = null ist wird true zurückgegeben
            return true; //
        }

        boolean ergebnis = next.krieche();

        next.Richtung(Richtung());

        return ergebnis;
    }

    public void Richtung(int neueRichtung) {
        richtung = neueRichtung; // richtung wird der booleanwert von neueRichtung
                                 // zugewießen

    }

    public void setNext(WurmParts part) {
        next = part; // next wird der wert von part zurückgegeben
    }

    public int Richtung() {
        return richtung; //Richtung wird zurückgegeben
    }

    private boolean liegtAusserhalbFeld(int x, int y) {
        return ((x < 0) || (x > 9) || (y < 0) || (y > 9));
    }

    public boolean emptyfield(int X, int Y) {
        if ((x == X) && (y == Y)) {
            return true; // Wenn das Feld leer ist dann wird true zurückgegeben
        }

        if (next == null) {
            return false; // Wenn nicht,dann wird false zurückgegeben
        }

        return next.emptyfield(X, Y);
    }

}
