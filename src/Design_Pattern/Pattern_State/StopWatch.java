package Design_Pattern.Pattern_State;

import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;


public class StopWatch extends JFrame implements ActionListener
{
	JPanel buttonPanel; 
	JPanel showPanel;
	JLabel displayLabel;
	
	 JButton startButton;
	 JButton stopButton;
	 JButton resetButton;
	 
	 Border signalBorder;
	 
	 private int centiseconds = 0;
	 private int seconds = 0;
	 private int minuties = 0;	
	 private int milliseconds = 0;
	 private int totalmillis = 0;
	 private long startTime = 0;
		
	 private long recentStartTime = 0;
	 private long recentStopTime = 0;
	
	 String centisecondString ;
	 String secondString ;
	 String minuteString;
	 String milliString;
	 
	 private  State runState;
	 private State stopState;
	 private  State state;	 
	 	 
	 Timer swTimer = new Timer(1, this);
	 
	 public StopWatch()
	 {		 
		 runState = new RunState(this);
		 stopState = new StopState(this);		
		 state = stopState;
				
		 setSize(500,200);		    
		 Container contentPane = getContentPane();   
		 		 
		 
		 contentPane.setLayout(new BorderLayout());   
		 
		 showPanel = new JPanel();
		 showPanel.setBackground(Color.BLACK);
		 
		 contentPane.add(showPanel,BorderLayout.CENTER);
		 
		 buttonPanel = new JPanel(new GridLayout(0,3));    
		 buttonPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		 
		 contentPane.add(buttonPanel,BorderLayout.SOUTH);
		 
		 startButton = new JButton("Start"); buttonPanel.add(startButton);
		 stopButton = new JButton("Stop"); buttonPanel.add(stopButton);
		 resetButton = new JButton("Reset"); buttonPanel.add(resetButton);
		 
		 displayLabel = new JLabel("00:00.000"); 
		
		 displayLabel.setBackground(Color.BLACK);
		 displayLabel.setForeground(Color.YELLOW);
		 
		 Font bigFont = new Font ("serif",Font.BOLD,100);
		 displayLabel.setFont(bigFont);
		
		 
		 showPanel.add(displayLabel);

		 startButton.addActionListener(this);		 
		 stopButton.addActionListener(this);		 
		 resetButton.addActionListener(this);
		 
	 }
	 
	 public void actionPerformed(ActionEvent e) 
	 {
		 if(e.getSource() == swTimer)
		 {
	    		displayTime();
		 }
		 
		 if(e.getSource() == startButton)
		 {
			 start(); 	 		
		 }
		 
	 	else if(e.getSource() == stopButton)
	 	{
	 		stop();
	 	}
		 
	 	else if(e.getSource() == resetButton)
	 	{
	 		reset();
	 	}
	 }
	 
	 public void displayTime()
	 {   		
		 	this.totalmillis = (int) getTimeDiffernce();
 	    	minuties = totalmillis /60000;
 	    	milliseconds = totalmillis % 60000;
			seconds = milliseconds / 1000;
			milliseconds = milliseconds % 1000;
			centiseconds = milliseconds / 10;
			milliseconds = milliseconds % 10;

			if(minuties < 10)
				minuteString = "0" + minuties;
			else minuteString = "" + minuties;
			if(seconds < 10)
				secondString = "0" + seconds;
			else 
				secondString = "" + seconds;
			if(centiseconds < 10)
				centisecondString = "0" + centiseconds;
			else 
				centisecondString = "" + centiseconds;
				milliString = "" + milliseconds;
				displayLabel.setText(minuteString + ":" + secondString + "." + centisecondString + milliString);

	 }
	 public long getTimeDiffernce() 
	 {	
			 return  (System.currentTimeMillis() - startTime );
	 }
	 
	 public Timer getTimer()
	 {
		 return swTimer;
	 }	
	 
	 public void resetTime(int min, int second, int centisecond, int milisecond, int startTime, int justStartTime, int justStopTime){
		 this.minuties = min;
		 this.seconds = second;
		 this.centiseconds = centisecond;
		 this.milliseconds = milisecond;
		 this.startTime = startTime;
		 this.recentStartTime = justStartTime;
		 this.recentStopTime = justStopTime;
	 }
	 
	 public void setState(State state)
	 {
		 this.state = state;
	 }
	 
	 public  void start()
	 {		
		state.start();
	 }
	 
	public  void stop()
	{
		state.stop();
	}
	
	public  void reset()
	{	
		state.reset();
	}
	
	public State getTheState() {
        return state;
    }
	
	public State getStopState(){
		return stopState;
		
	}

	public State getRunState(){
		return runState;
	}
	public long getStartTime(){
		return startTime;
	}
	public long getRecentStartTime(){
		return recentStartTime;
	}
	public long getRecentStopTime(){
		return recentStopTime;
	}
	public void setStartTime(long updatedStartTime){
		startTime = updatedStartTime;
	}
	public void setRecentStartTime(long millisecond){
		recentStartTime = millisecond;
	}
	public void setRecentStopTime(long millisecond){
		recentStopTime = millisecond;
	}
	
	
	 
}









