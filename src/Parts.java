/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Zelle.java
 */
/**
 *
 * @author Janes.AbouChleih
 */


import java.awt.Graphics;

public abstract class Parts {

    protected int x = 0; // ableitende Klassen können diese GZs benutzen
    protected int y = 0; // siehe oben

    public Parts(int X, int Y) {
        x = X; // Der Paramter X wird dem GZ x zugewiesen
        y = Y; // Der Paramter Y wird dem GZ y zugewiesen
    }

    public abstract void zeichne(Graphics g, int X, int Y); // Die Abstrakte Methode Zeichne
                                                            // wird für andere Klassen angelegt

    public int X() {
        return x; // Gibt x zurück
    }

    public int Y() {
        return y; // Gibt y zurück
    }
}
