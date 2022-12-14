import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class DataFromCSV {

    Functions fn = new Functions();

    static JLabel patientIDJLabel;
    static JLabel patientNameJLabel;

    static String patientIDString = "";
    static String patientNameString = "";

    static String possibleDisease = "";
    
    DataFromCSV(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

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

        // BUTTON
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 200, 80, 25);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                
                patientIDString = userText.getText();
                patientNameString = userNameText.getText();

                String csvPath = "C:\\Users\\dhruv\\OneDrive\\Documents\\vs-code-java-HW\\Medical Assitant\\lib\\medicalDatabase.csv";
                String symptomsPath = "C:\\Users\\dhruv\\OneDrive\\Documents\\vs-code-java-HW\\Medical Assitant\\lib\\symptoms.txt";
                
                try 
                {
                    possibleDisease =  fn.symptomCheck(patientIDString, patientNameString, csvPath, symptomsPath);
                    fn.updatingMDB(patientIDString, patientNameString, possibleDisease);
                } 
                catch (IOException e1) 
                {
                    e1.printStackTrace();
                }

                new GUIforDisease();
                System.out.println("Possible Disease = " + possibleDisease);
            }
        }); 
        
        frame.setVisible(true);
    }
}
