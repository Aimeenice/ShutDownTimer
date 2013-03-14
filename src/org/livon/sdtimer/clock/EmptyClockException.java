package org.livon.sdtimer.clock;

public class EmptyClockException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String exception_message = "Empty clock, change your numbers";
	
	public String toString(){
		return exception_message;
	}

}
