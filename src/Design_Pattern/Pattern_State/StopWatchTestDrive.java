package Design_Pattern.Pattern_State;

import javax.swing.*;

public class StopWatchTestDrive 
{
	public static void main(String[] args){
		StopWatch stopWatch = new StopWatch();
		stopWatch.setTitle("Stop Watch State Pattern");
		stopWatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stopWatch.setResizable(false);
		stopWatch.setVisible(true);    
	}
}
