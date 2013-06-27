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
import javax.swing.JFrame;

public class Frame {

    public static JFrame jf;

    public static void main(String[] args) {
        jf = new JFrame(); // Frame-Objekt wird angelegt : FrameName->jf
        jf.setSize(400, 400); //Größe des Frame wird auf 400,400 gesetzt
        jf.setTitle("Janes' Wurmspiel"); //Frame-"Überschrift lautet Janes' Wurmspiel
        Oberflaeche ob = new Oberflaeche(); // Oberflächenobjekt wird angelegt: Name -> ob
        Steuerung s = new Steuerung(); // Steuerungsobjekt wird angelegt: Name -> s
        ob.Steuer(s); //Steuerung wird auf die Oberfläche gelegt
        s.setOberflaeche(ob); //siehe oben

        jf.setContentPane(ob); // Der Inhalt des Frames ist die Oberflaeche.
        ob.setFocusable(true); // Tastatur eingaben werden vom Frame verarbeitet
        ob.requestFocus();

        ob.setVisible(true); // Sichtbarkeit der Oberflaeche ist auf sichtbar gesetzt

        jf.setDefaultCloseOperation(3); //Bei Klick auf x(schließen) schließt das Programm

        jf.setVisible(true); // Sichtbarkeit des Frame ist auf sichtbar gesetzt
    }
}
