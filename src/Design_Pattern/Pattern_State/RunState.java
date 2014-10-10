package Design_Pattern.Pattern_State;


public class RunState implements State
{
	StopWatch stopWatch;
	public RunState(StopWatch stopWatch)
	{
		this.stopWatch = stopWatch;
	}
	
	@Override
	public void start() 
	{
		
	}

	@Override
	public void stop() {
		
		stopWatch.getTimer().stop();
		stopWatch.setRecentStopTime(System.currentTimeMillis());
		stopWatch.setState(stopWatch.getStopState());
		
	}

	@Override
	public void reset() {
		stopWatch.getTimer().stop();
		stopWatch.resetTime(0,0,0,0,0,0,0);
		stopWatch.displayLabel.setText("00:00.000");
		stopWatch.setState(stopWatch.getStopState());
	}

}
