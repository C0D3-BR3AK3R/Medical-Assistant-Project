import java.io.*;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class WritingToCSV {    

    public void medicalDatabase() throws IOException{

        // Instantiating the CSVWriter class
        String filePath = "C:\\Users\\dhruv\\OneDrive\\Documents\\vs-code-java-HW\\Medical Assitant\\lib\\medicalDatabase.csv";
        File file = new File(filePath);

        FileWriter outputFile = new FileWriter(file, true);
        CSVWriter writer = new CSVWriter(outputFile, ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.RFC4180_LINE_END);

        // Picking data from the GUI
        // Headings for the CSV file = Patient ID, Patient Name, Symptom 1, Symptom 2, Symptom 3, Symptom 4
        String line1[] = {GUI.patientID, GUI.patientName, GUI.Symptom1String, GUI.Symptom2String, GUI.Symptom3String, GUI.Symptom4String, " "};

        // Writing data to the CSV file
        writer.writeNext(line1);
        

        writer.close();
        System.out.println("Data entered");
    }
}
