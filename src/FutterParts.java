/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FutterZelle.java
 */
/**
 *
 * @author Janes.AbouChleih
 */


import java.awt.Color;
import java.awt.Graphics;

public class FutterParts extends Parts{ // Die Futterzelle erbt von der Klasse Zelle

    protected float fz; //FKZ fz(FutterZelle) wird angelegt

    public FutterParts(int X, int Y)  {
        super(X, Y); // Die Variablen der SuperKlasse X,Y werden auf die FutterZelle übertragen
        fz = 0; // Die FKZ der FutterZelle wird auf 0 gesetzt
    }

    public void zeichne(Graphics g, int lX, int lY) { //
        g.setColor(Color.green); //Farbe der FutterZelle ist grün
        g.fillRect(X() * lX, Y() * lY, lX, lY); //Die Futterzelle wird gezeichnet
                                                //in einem Kästchen mit den Maßen
                                                //X() * lX, Y() * lY, lX, lY
    }
}

