/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Uhr.java
 */
/**
 *
 * @author Janes.AbouChleih
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JOptionPane;

public class Uhr extends JPanel {

    public Timer t; // Timer wird angelegt
    public Steuerung s; // Objekt Steuerung wird hier angelegt

    public Uhr(Steuerung steuerung) {
        s = steuerung;
    }

    public void start() {
        Object[] options = {"Level4", "Level3", "Level2", "Level1"}; // Optionen für die Wahl des Schwierigk.lvl
        Object choosenvalue = JOptionPane.showInputDialog(null,
                "Schwieriegkeitslevel", "Wähle...", JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]); // Eine PopUpMessage mit Wahlmöglichkeiten
        int Geschwindigkeit = 0; //Die Geschwindigkeit ist = 0
        if (choosenvalue != null) {
            for (int i = 0; i < options.length; i++) { // Auswahlmöglichkeit Lvl4 = 0, lvl3 = 1...
                if (choosenvalue.equals(options[i])) { // Checkt ob die Werte gleichwertig sind Geschw. = options.length
                    Geschwindigkeit = i + 1; // Geschw. wird erhöht
                }
            }
        }else{
          System.exit(0);
        }
        t = new Timer((Geschwindigkeit * 50), new ActionListener() { // Timer mit takt 200 und actionListener wird angelegt
            public void actionPerformed(ActionEvent ae) {
                Uhr.this.s.verarbeiteUhrTick(); //Bei einem Event wird verarbeiteUhrTick
                // der Steuerung s aufgerufen
            }
        });
        t.start(); // Timer startet gleich zu beginn
    }

    public void stopp() { // Wird bei Sieg oder Niederlage aufgerufen
        t.stop(); // Timer stoppt bei Berührung mit der Wand oder bei Sieg
    }
}
