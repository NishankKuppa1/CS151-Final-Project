package master;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AlarmRinging extends JFrame
{
	private static final long serialVersionUID = 1L;
	//private Timer timer;
	
	public AlarmRinging()
	{
		// The main panel that notifies the user that the alarm is ringing
		JPanel alarmPanel = new JPanel();
		alarmPanel.setLayout(new BorderLayout());
		alarmPanel.add(new JLabel("Alarm is ringing!"), BorderLayout.CENTER);

		// Button to dismiss the alarm
		JButton dismiss = new JButton("Dismiss");
		dismiss.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// LAUNCH SNAKE GAME
			}
			
		});
		
		// Button to snooze the alarm
		JButton snooze = new JButton("Snooze");
		snooze.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				//DISPLAY AFTER 5 MINS
				//new AlarmRinging();
			}
			
		});
		
		// Add the buttons to its own panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(dismiss);
		buttonPanel.add(snooze);
		
		// Lay out the alarm notification and buttons
		JFrame frame = new JFrame();
		frame.add(alarmPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		// Viewing settings
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
