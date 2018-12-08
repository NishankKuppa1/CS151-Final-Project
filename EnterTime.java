package master;

import java.awt.BorderLayout;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * The default panel (where the user enters their desired time) and the associated
 * methods
 * 
 * @author Nishank Kuppa
 *
 */
public class EnterTime extends JFrame
{
	private static final long serialVersionUID = 1L;
	JTextField timeInputField;
	SimpleDateFormat formatter = new SimpleDateFormat("kk:mm"); // Format the time in hours:minutes (24 hr format)
																	

	/**
	 * Sets up the panel to enter the desired time
	 */
	public EnterTime() // throws InterruptedException
	{
		/*
		timeInputField = new JTextField();

		add(timeInputField, BorderLayout.NORTH);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
	}

	/**
	 * Returns the current time (to compare with the desired time)
	 * 
	 * @return
	 */
	public String getCurrentTime()
	{
		// Create a calendar object to get the current time
		Calendar calendar = Calendar.getInstance();

		// Get the current time and format it as hours:minutes:seconds
		String currentTime = formatter.format(calendar.getTime());

		return currentTime;
	}

	/**
	 * Check if the desired time matches the current time
	 * 
	 * @param alarmTime
	 * @return
	 */
	@Override
	public boolean equals(Object o)
	{
		// Create a time object
		Time timeValue = null;

		// If the object is compared with itself, return true
		if (o == this)
		{
			return true;
		}

		// Check if o is an instance of String or not
		if (o instanceof String)
		{
			// Cast o to String to compare data
			String alarmTime = (String) o;

			try
			{
				// format the inputted alarm time into a Time object
				timeValue = new Time(formatter.parse(alarmTime).getTime());
			} catch (ParseException e)
			{
				// e.printStackTrace();
				System.out.println("Invalid input, please try again.");

			}

			// convert the Time object to a LocalTime object
			/**
			 * PRONE TO BUGS
			 */
			LocalTime converted = timeValue.toLocalTime();

			// compare the two times
			return (LocalTime.now().isAfter(converted));

		}
		return false;
	}

	/*
	 * public void run() { EnterTime testProgram = new EnterTime(); }
	 * 
	 * // Get the current time 
		GregorianCalendar currentTime = new GregorianCalendar();
		int hours = currentTime.get(Calendar.HOUR);
		int minutes = currentTime.get(Calendar.MINUTE);
		int seconds = currentTime.get(Calendar.SECOND);
		System.out.println(hours + ":" + minutes + ":" + seconds);
	 */
	

}