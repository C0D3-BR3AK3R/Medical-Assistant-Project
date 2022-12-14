public class WrongSymptomsException extends Exception{
    
    public WrongSymptomsException(){
        super("Symptom combination entered doesn't exist in database"); 
       }

    public WrongSymptomsException(String message){
        super(message);
    }
}
