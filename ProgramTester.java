package master;

import javax.swing.JOptionPane;

public class ProgramTester 
{
	public static void main(String[] args) 
    {	
		EnterTime testProgram = new EnterTime();
        String userEnteredTime = JOptionPane.showInputDialog("Enter your desired time (24 hr format) (HH:MM:SS)"); 
        
        System.out.println("Your desired time: " + userEnteredTime);
        System.out.println("Current time: "+ testProgram.getCurrentTime());
        System.out.println("Should alarm go off? " + testProgram.equals(userEnteredTime));
        
        AlarmRinging testing = new AlarmRinging();
    }
}
