package master;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ProgramTester 
{
	public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
            	
            	CentralPanel testProgram = new CentralPanel();
                String alarmTime = JOptionPane.showInputDialog(null, "Enter your desired time (24 hr format) (HH:MM:SS)"); 
                
                System.out.println("Your desired time: " + alarmTime);
                System.out.println("Current time: "+ testProgram.getCurrentTime());
                System.out.println("Should alarm go off? " + testProgram.verifyTime(alarmTime));
            }
        });
    }
}
