package master;

import javax.swing.JOptionPane;

public class ProgramTester 
{
	public static void main(String[] args) 
    {	
		EnterTime testProgram = new EnterTime();
		
		String currentTime = testProgram.getCurrentTime();
        String userEnteredTime = JOptionPane.showInputDialog("Enter your desired time (24 hr format) (HH:MM)"); 
        
        System.out.println("Your desired time: " + userEnteredTime);
        System.out.println("Current time: "+ currentTime);
        System.out.println("Should alarm go off? " + testProgram.equals(userEnteredTime));
        
        if (testProgram.equals(userEnteredTime) == true)
        {
        	new AlarmRinging();
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "Not time to wake up yet",null, JOptionPane.ERROR_MESSAGE);
        }
    }
}