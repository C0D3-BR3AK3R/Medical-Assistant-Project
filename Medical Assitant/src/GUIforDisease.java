import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class GUIforDisease {
    
    GUIforDisease(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setSize(250, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);

        panel.setLayout(null);

        // Jlabel for showing possible Disease

        String diseaseString = DataFromCSV.patientNameString + " has " + DataFromCSV.possibleDisease;
        JLabel userLabel = new JLabel(diseaseString);
        userLabel.setBounds(10, 20, 200, 25);
        panel.add(userLabel);

        frame.setVisible(true);
    }
}
