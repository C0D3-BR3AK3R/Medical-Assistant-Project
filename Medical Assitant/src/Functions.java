import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Functions {

    // symptomCheck DETERMINES THE DISEASE OF THE PATIENT BASED ON THE SYMPTOMS ENTERED
    
    public String symptomCheck(String patientID, String patientName, String csvPath, String filePath) throws IOException{

        String possibleDisease = "";

        BufferedReader br = new BufferedReader(new FileReader(csvPath));
        BufferedReader sr = new BufferedReader(new FileReader(filePath));

            String csvRowData;
            String sympData;

            while ((csvRowData = br.readLine()) != null) {

                String[] csvTokens = csvRowData.split(",");

                if (csvTokens[0].equals(patientID) && csvTokens[1].equals(patientName)){


                    while ((sympData = sr.readLine()) != null) {
                        String[] sympTokens = sympData.split(",");
                        
                        if (csvTokens[2].equals(sympTokens[1]) && csvTokens[3].equals(sympTokens[2]) && csvTokens[4].equals(sympTokens[3]) && csvTokens[5].equals(sympTokens[4])) {
                            possibleDisease = sympTokens[0];
                            break;
                        }
                    }
                }
            }

        br.close();
        sr.close();

        return possibleDisease;
    }

    // updatingMDB UPDATES THE MEDICAL DATABASE ONCE WE HAVE THE NAME OF THE DISEASE

    public void updatingMDB(String patientID, String patientName, String possibleDisease) throws IOException{

        String oldCSVPath = "C:\\Users\\dhruv\\OneDrive\\Documents\\vs-code-java-HW\\Medical Assitant\\lib\\medicalDatabase.csv";
        String newCSVPath = "C:\\Users\\dhruv\\OneDrive\\Documents\\vs-code-java-HW\\Medical Assitant\\lib\\NewMedicalDB.csv";

        BufferedReader br = new BufferedReader(new FileReader(oldCSVPath));
        // BufferedWriter bw = new BufferedWriter(new FileWriter(newCSVPath, true));
        FileWriter fw = new FileWriter(newCSVPath, true);
        PrintWriter pw = new PrintWriter(fw, true);

        File oldCSV = new File(oldCSVPath);
        File newCSV = new File(newCSVPath);

        String csvRowData;

        int rowCounter = 0;

        List<String[]> csvData = new ArrayList<>();

        while ((csvRowData = br.readLine()) != null) {
            
            String[] csvTokens = csvRowData.split(",");

            csvData.add(csvTokens);

            if (csvTokens[0].equals(patientID) && csvTokens[1].equals(patientName)){

                csvData.get(rowCounter)[6] = possibleDisease;
            }

            rowCounter++;
        }

        newCSV.createNewFile();

        for (String[] strings : csvData) {
            
            for (int i = 0; i < strings.length; i++) {
                
                pw.print(strings[i] + ",");
            }

            pw.println();
        }

        pw.close();
        br.close();
        oldCSV.delete();
        File dump = new File(oldCSVPath);
        newCSV.renameTo(dump);
    }

    

    public int symptomValidity(String symp1, String symp2, String symp3, String symp4) throws IOException, WrongSymptomsException{

        String filePath = "C:\\Users\\dhruv\\OneDrive\\Documents\\vs-code-java-HW\\Medical Assitant\\lib\\diseases.txt";
        FileReader file = new FileReader(filePath);

        BufferedReader br = new BufferedReader(file);

        String s;

        int correctHits = 0;

        while ((s = br.readLine()) != null) {
            String[] st = s.split(":");
            String symptoms = st[0];
            
            if (symp1.equals(symptoms)) {
                correctHits++;
                break;
            }
        }

        while ((s = br.readLine()) != null) {
            String[] st = s.split(":");
            String symptoms = st[0];

            if (symp2.equals(symptoms)) {
                correctHits++;
                break;
            }
        }

        while ((s = br.readLine()) != null) {
            String[] st = s.split(":");
            String symptoms = st[0];
            
            if (symp3.equals(symptoms)) {
                correctHits++;
                break;
            }
        }

        while ((s = br.readLine()) != null) {
            String[] st = s.split(":");
            String symptoms = st[0];
            
            if (symp4.equals(symptoms)) {
                correctHits++;
                break;
            }
        }

        if (correctHits != 4) {
            throw new WrongSymptomsException();
        }

        return correctHits;
    }
}
