package master;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This frame shows up when the alarm is ringing User has to either dismiss or
 * snooze the alarm
 * 
 * @author Nishank Kuppa, Areeb Yaqub, Ruchika Kotha
 *
 */
public class AlarmRinging extends JFrame
{
	private static final long serialVersionUID = 1L;
	boolean playAlarm = true;

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
				EventQueue.invokeLater(() -> {
					JFrame ex = new Snake();
					ex.setVisible(true);
				});
			}
		});

		// Button to snooze the alarm
		JButton snooze = new JButton("Snooze");
		snooze.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// DISPLAY AFTER 5 MINS
				JOptionPane.showMessageDialog(null, "Alarm snoozed for 5 minutes", "Snooze Notification",
						JOptionPane.ERROR_MESSAGE);
				playAlarm = false;
				try
				{
					
					Thread.sleep(1000);
					// Thread.sleep(300000); // 5 minutes = 300000 milliseconds
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
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
		
		//playSound();
		System.out.println(playAlarm);

	}
	
	/*
	
	// Plays an annoying alarm sound
	public void playSound()
	{
		if (playAlarm == true)
		{
			try
			{
				AudioInputStream audioInputStream = AudioSystem
						.getAudioInputStream(new File("alarmFile.wav").getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			} 
			catch (Exception e)
			{
				System.out.println("Could not play audio");
			}
		}
		else
		{
			return;
		}
	}
	*/

}
