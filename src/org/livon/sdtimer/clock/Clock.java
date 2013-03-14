package org.livon.sdtimer.clock;

public class Clock {

	private int Hour;

	private int Minute;

	private int Second;

	public Clock(int _hours, int _minutes, int _secondes)
			throws EmptyClockException {
		if (_hours == 0 && _minutes == 0 && _secondes == 0)
			throw new EmptyClockException();
		setHour(_hours);
		setMinute(_minutes);
		setSecond(_secondes);
	}

	public int getHour() {
		return Hour;
	}

	public void setHour(int hour) {
		Hour = hour;
	}

	public int getMinute() {
		return Minute;
	}

	public void setMinute(int minute) {
		Minute = minute;
	}

	public int getSecond() {
		return Second;
	}

	public void setSecond(int seconde) {
		Second = seconde;
	}

	public void setTimeFromMillis(long millis){
		long time = millis / 1000;  
		setHour((int) (time / 3600));
		setMinute((int)((time % 3600) / 60));
		setSecond((int)(time % 60));
	}
	
	public long toMillis() {
		return (this.getHour() * 3600000) + (this.getMinute() * 60000)
				+ (this.getSecond() * 1000);
	}

	public long getTimeLeft() {
		return toMillis();
	}
	
	public void retrieveSeconde(){
		setTimeFromMillis(toMillis() - 1000);
	}
}
