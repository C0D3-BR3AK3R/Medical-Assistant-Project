import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class GUI {

    static JLabel patientIDJLabel;
    static JLabel patientNameJLabel;

    static String patientID = "";
    static String patientName = "";

    static String Symptom1String = "";
    static String Symptom2String = "";
    static String Symptom3String = "";
    static String Symptom4String = "";

    WritingToCSV csv = new WritingToCSV();

    GUI() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        Functions fn = new Functions();

        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);

        panel.setLayout(null);

        // PATIENT ID
        JLabel userLabel = new JLabel("Patient ID");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);


        // PATIENT NAME
        JLabel userNameLabel = new JLabel("Patient Name");
        userNameLabel.setBounds(10, 50, 80, 25);
        panel.add(userNameLabel);

        JTextField userNameText = new JTextField();
        userNameText.setBounds(100, 50, 165, 25);
        panel.add(userNameText);

        // SYMPTOM 1
        JLabel symptom1 = new JLabel("Symptom 1");
        symptom1.setBounds(10, 80, 80, 25);
        panel.add(symptom1);

        JTextField symptom1Text = new JTextField();
        symptom1Text.setBounds(100 , 80, 165, 25);
        panel.add(symptom1Text);

        // SYMPTOM 2
        JLabel symptom2 = new JLabel("Symptom 2");
        symptom2.setBounds(10, 110, 80, 25);
        panel.add(symptom2);

        JTextField symptom2Text = new JTextField();
        symptom2Text.setBounds(100 , 110, 165, 25);
        panel.add(symptom2Text);

        // SYMPTOM 3
        JLabel symptom3 = new JLabel("Symptom 3");
        symptom3.setBounds(10, 140, 80, 25);
        panel.add(symptom3);

        JTextField symptom3Text = new JTextField();
        symptom3Text.setBounds(100 , 140, 165, 25);
        panel.add(symptom3Text);

        // SYMPTOM 4
        JLabel symptom4 = new JLabel("Symptom 4");
        symptom4.setBounds(10, 170, 80, 25);
        panel.add(symptom4);

        JTextField symptom4Text = new JTextField();
        symptom4Text.setBounds(100 , 170, 165, 25);
        panel.add(symptom4Text);
        
        // BUTTON
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 200, 80, 25);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                
                patientID = userText.getText();
                patientName = userNameText.getText();
                Symptom1String = symptom1Text.getText();
                Symptom2String = symptom2Text.getText();
                Symptom3String = symptom3Text.getText();
                Symptom4String = symptom4Text.getText();

                
                
                try {
                    if (fn.symptomValidity(Symptom1String, Symptom2String, Symptom3String, Symptom4String) == 4) {
                        
                        try {
                            csv.medicalDatabase();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        
                        if (e.getSource() == submitButton) {
                            new DataFromCSV();
                            
                        }
                    }

                } catch (IOException | WrongSymptomsException e2) {
                    System.out.println(e2.getMessage());
                }
                 
                
            } 
        });

        JLabel success = new JLabel("");
        success.setBounds(10, 250, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }  
}
