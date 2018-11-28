package master;

import java.awt.BorderLayout;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class CentralPanel extends JFrame
{

	private static final long serialVersionUID = 1L;
	JTextField timeInputField;

	public CentralPanel() throws InterruptedException 
	{
		timeInputField = new JTextField();

		add(timeInputField, BorderLayout.NORTH);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void checkTime()
	{
		
	}
	
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                String alarmTime = JOptionPane.showInputDialog(null, "Enter your desired time (24 hr format) (HH:MM:SS)"); 
                SimpleDateFormat formatter = new SimpleDateFormat("kk:mm:ss"); // 24 hr format
                
                Time timeValue = null;
				try 
				{
					timeValue = new Time(formatter.parse(alarmTime).getTime());
					LocalTime converted = timeValue.toLocalTime();
					System.out.println(LocalTime.now().isAfter( converted ));
				} 
				catch (ParseException e) 
				{
					//e.printStackTrace();
					System.out.println("Invalid Input!");
					
				}
				
                System.out.println("Your desired time: " + timeValue);
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("kk:mm:ss");
                Calendar calendar = Calendar.getInstance();
              
                String currentTime = dateFormat.format(calendar.getTime());
                
                System.out.println("Current time: "+ currentTime);
                
        		
                
                
                /*
                if (timeValue.toString().equals(currentTime))
                {
                	System.out.println("The times are equal");
                }
                else
                {
                	System.out.println("The times are not equal");
                }
                
                LocalTime mine = LocalTime.now();
                System.out.println(mine);
                */
                
            }
        });
    }

}
