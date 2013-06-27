/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Kopf.java
 */
/**
 *
 * @author Janes.AbouChleih
 */


import java.awt.Color;
import java.awt.Graphics;

public class Kopf extends WurmParts { //Die Klasse Kopf erbt von der Klasse WurmZelle

    public Kopf(int x, int y) { //Methode Kopf mit Paramet x,y
        super(x, y); // Die Variablen der SuperKlasse X,Y werden auf die FutterZelle übertragen
    }

    @Override
    public void zeichne(Graphics g, int lX, int lY) { // Paramet g,lY,lX
        super.zeichne(g, lX, lY); // Die Methode zeichnen der Wurmzelle wird aufgerufen
        g.setColor(Color.red); // Farbe des Kopfes wird auf Rot gesetzt
        g.fillRect(X() * lX, Y() * lY, lX, lY); // Der Kopf wird gezeichnet
    }
}

