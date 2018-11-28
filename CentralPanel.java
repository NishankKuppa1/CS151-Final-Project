package master;

import java.awt.BorderLayout;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class CentralPanel extends JFrame
{

	private static final long serialVersionUID = 1L;
	JTextField timeInputField;

	public CentralPanel() // throws InterruptedException
	{
		timeInputField = new JTextField();

		add(timeInputField, BorderLayout.NORTH);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String getCurrentTime()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("kk:mm:ss");
		Calendar calendar = Calendar.getInstance();

		String currentTime = dateFormat.format(calendar.getTime());

		return currentTime;
	}

	public boolean verifyTime(String alarmTime)
	{
		Time timeValue = null;
		SimpleDateFormat formatter = new SimpleDateFormat("kk:mm:ss"); // 24 hr format
		try
		{
			timeValue = new Time(formatter.parse(alarmTime).getTime());
		} catch (ParseException e)
		{
			// e.printStackTrace();
			System.out.print("Invalid input, please try again.");
		}

		LocalTime converted = timeValue.toLocalTime();

		return (LocalTime.now().isBefore(converted));
	}

}
