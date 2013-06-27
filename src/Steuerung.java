/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Steuerung.java
 */
/**
 *
 * @author Janes.AbouChleih
 */


import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JOptionPane;

public class Steuerung {

    private Oberflaeche o; // Objekt der Oberflaeche o wird angelegt
    private FutterParts FZ; // Objekt der FutterZelle FZ wird angelegt
    private Wurm wurm; // Objekt des Wurms wurm wird angelegt
    private Random wuerfel = new Random(); // Ein Würfel wird angelegt für
    // die Random koords der FutterZelle
    // angelegt
    private Uhr time;                      // Zeit für die "Spawndifferenzen"

    public Steuerung() {
        initialisiereSpiel(); // Spiel wird bei Start eingerichtet
    }

    public void initialisiereSpiel() {
        wurm = new Wurm(); // ein neuer Wurm wird eingestelt
        wurm.initialisiereWurm(); //Wurm wird gezeichnet
        wurm.direction(1); // Richtung des Wurms wird auf waagerecht runter eingestellt
        erzeugeFutterAusserhalbWurm(); // Futter wird gezeichnet
        time = new Uhr(this); // Timer wird angelegt
        time.start(); // Timer wird gestartet
    }

    public void setOberflaeche(Oberflaeche oberflaeche) { // Oberflaeche wird in Steuerung intergriert
        o = oberflaeche; // Oberflächenobjekt wird angelegt
    }

    void verarbeiteUhrTick() { // Verarbeitet den Timer 
        if (!(wurm.krieche())) { // Falls sich der Wurm nicht mehr bewegt wird
            // das JOptionPane Verloren aufgerufen
            o.Verloren();        // Ruft JOptionPane in Oberflaeche auf
            time.stopp();        // Timer wird gestoppt
        }

        if (wurm.sameasworm(FZ.X(), FZ.Y())) { // Wenn die Koords des Wurmkopfs
            // und der Futterzelle gleich sind
            wurm.wachse();                     // Ruft methode wachse auf die den Wurm um 1 vergrößert
            erzeugeFutterAusserhalbWurm();     // erzeugt FutterZellen außerhalb des Wurmkopfs
            // und der einzelnen Wurmzellen
        }

        o.aktualisiereOberflaeche();    //Nach jedem Tick wird die Oberflaeche neu gezeichnet
    }

    void zeichne(Graphics g) {
        FZ.zeichne(g, o.widthfield(), o.heightfield()); //FutterZelle wird gezeichnet 40*40

        wurm.zeichne(g, o.widthfield(), o.heightfield()); // Wurm wird gezeichnet an der Stelle der FutterZelle
    }

    void verarbeiteTastenDruck(int KeyCode) { // Der KeyCode wird als Parameter angenommen
        switch (KeyCode) { // Der KeyCode wird mit dem von den tasten verglichen
            case KeyEvent.VK_DOWN: // Wenn nach unten gedrückt wird, wird die direction(Richtung) = 3
               if(wurm.wormpart.get(0).richtung != 4)
                wurm.direction(3); // siehe oben
                break; //Abschluss
            case KeyEvent.VK_UP:  // Wenn nach oben gedrückt wird, wird die direction(Richtung) = 4
                if(wurm.wormpart.get(0).richtung != 3)
                wurm.direction(4); //siehe oben 
                break; //abschluss
            case KeyEvent.VK_RIGHT:  // Wenn nach rechts gedrückt wird, wird die direction(Richtung) = 1
                if(wurm.wormpart.get(0).richtung != 2)
                wurm.direction(1); // siehe oben
                break; // abschluss
            case KeyEvent.VK_LEFT: // Wenn nach links gedrückt wird, wird die direction(Richtung) = 2
                if(wurm.wormpart.get(0).richtung != 1)
                wurm.direction(2); // siehe oben
                break; // abschluss            
            // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
            case KeyEvent.VK_WINDOWS: // ^^
                Object[] options = {"Ja"}; // Witzle gemacht ;D
                JOptionPane.showOptionDialog(null, "Diese scheiß Windowstaste", "Hab ich Recht?", //Jo
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, // nothing more to say
                        null, options, options[0]); // 
                break;// </editor-fold>
        }
    }

    private void erzeugeFutterAusserhalbWurm() {
        int x; // x wird angelegt (lokal)
        int y; // y wird lokal angelegt
        do {
            x = wuerfel(); // x wert wird gewuerfelt
            y = wuerfel(); // y wert wird gewürfelt
            wurm.sameasworm(x, y); //x,y koordinaten des Wurms werden geholt
        } while (wurm.sameasworm(x, y));//Wenn Futter und Wurm =  sind dann anderen x,y wert
        FZ = new FutterParts(x, y); // neue Koordinaten
    }

    private int wuerfel() { // Würfel Methode für x,y der erzeugeFutterAusserhalbWurm()
        return wuerfel.nextInt(10);//es wird der gewürfelte Wert zurück gegeben
    }
}
