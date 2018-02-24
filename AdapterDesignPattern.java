/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

interface Boat {
	
	public void row ();
}

class TataBoat implements Boat{

	@Override
	public void row() {
		System.out.println("Started Rowing the Tata boat");
	}
}

class RelianceBoat implements Boat{

	@Override
	public void row() {
		System.out.println("Started Rowing the Reliance boat");
	}
}

interface SpeedBoat {
	
	public void startEngine(String boatType);

	public void endEngine();
}

class FordSpeedBoat implements SpeedBoat {
	
	BoatAdapter boatAdapter;

	@Override
	public void startEngine(String boatType) {
	   if(boatType == "FORD") {
	        System.out.println("Started the Ford SpeedBoat");
	    }
	    else {
	    	boatAdapter = new BoatAdapter();
	    	boatAdapter.startEngine(boatType);
	    }
	}

	@Override
	public void endEngine() {
		System.out.println("Ended the Ford SpeedBoat");
	}
}

class BMWSpeedBoat implements SpeedBoat {

	BoatAdapter boatAdapter;
	
	@Override
	public void startEngine(String boatType) {
		if(boatType == "BMW") {
	        System.out.println("Started the BMW SpeedBoat");
	    }
	    else {
	    	boatAdapter = new BoatAdapter();
	    	boatAdapter.startEngine(boatType);
	    }
	}

	@Override
	public void endEngine() {
		System.out.println("Ended the BMW SpeedBoat");
	}
}

class BoatAdapter implements SpeedBoat{

	Boat boat;

	@Override
	public void startEngine(String boatType) {
	    if(boatType == "TATA") {
	    	boat = new TataBoat();
	    	boat.row();
	    }
	    else if(boatType == "Reliance") {
	    	boat = new RelianceBoat();
	    	boat.row();
	    }
	}

	@Override
	public void endEngine() {
		return ;
	}

}


class AdapterPatternDemo {

	public static void main(String args[]) {

		SpeedBoat speedBoat = new FordSpeedBoat();
		speedBoat.startEngine("FORD");
		speedBoat.endEngine();
		speedBoat.startEngine("BMW");
		speedBoat.endEngine();
		speedBoat.startEngine("TATA");
		speedBoat.endEngine();
		speedBoat.startEngine("Reliance");
		speedBoat.endEngine();
	}
}