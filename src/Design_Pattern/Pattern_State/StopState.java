package Design_Pattern.Pattern_State;


public class StopState implements State
{
	StopWatch stopWatch;

	public StopState(StopWatch stopWatch)
	{
		this.stopWatch = stopWatch;
	}
	
	
	@Override
	public void start() 
	{		
		stopWatch.setRecentStartTime(System.currentTimeMillis()); 
		stopWatch.getTimer().start();
		if (stopWatch.getStartTime() ==0)
		{
	    	stopWatch.setStartTime(System.currentTimeMillis())  ;	
		}	
		else 
		{
			long updatedStartTime = stopWatch.getStartTime() + stopWatch.getRecentStartTime() - stopWatch.getRecentStopTime();
			stopWatch.setStartTime(updatedStartTime);
		}
		stopWatch.displayTime();
		
		stopWatch.setState(stopWatch.getRunState());	
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {

		stopWatch.resetTime(0,0,0,0,0,0,0);
		
		stopWatch.displayLabel.setText("00:00.000");
		
	}

}
