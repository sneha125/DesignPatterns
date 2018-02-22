

import java.util.*;
import java.lang.*;
import java.io.*;


interface Brake 
{
  public void createBrake();
}

class Brake1 implements Brake 
{
	private String brakeName = "Brake1";

	@Override
	public void createBrake()
	{
	    System.out.println("Creating Brake1:");
	}
}

class Brake2 implements Brake 
{
	private String brakeName = "Brake2";

	@Override
	public void createBrake()
	{
	    System.out.println("Creating Brake2:");
	}
}

class Brake3 implements Brake 
{
	private String brakeName = "Brake3";

	@Override
	public void createBrake()
	{
	    System.out.println("Creating Brake3:");
	}
}

interface Wheel {

	public void createWheel();
}

class Wheel1 implements Wheel 
{
	private String brakeName = "Wheel1";

	@Override
	public void createWheel()
	{
	    System.out.println("Creating Wheel1:");
	}
}

class Wheel2 implements Wheel 
{
	private String brakeName = "Wheel2";

	@Override
	public void createWheel()
	{
	    System.out.println("Creating Wheel2:");
	}
}

class Wheel3 implements Wheel 
{
	private String brakeName = "Wheel3";

	@Override
	public void createWheel()
	{
	    System.out.println("Creating Wheel3:");
	}
}

abstract class AbstractFactory {

	abstract Wheel getWheel(String wheel);
	abstract Brake getBrake(String brake);
}

class BrakeFactory extends AbstractFactory {

	@Override
	public Wheel getWheel(String wheel) {
		return null;
	}

	@Override
	public Brake getBrake(String brake) {
		switch(brake) {
			case "Brake1" :
			return new Brake1();
			case "Brake2" :
			return new Brake2();
			case "Brake3" :
			return new Brake3();
			default :
			return null;
		}
	}
}

class WheelFactory extends AbstractFactory {

	@Override
	public Wheel getWheel(String wheel) {
		switch(wheel) {
			case "Wheel1" :
			return new Wheel1();
			case "Wheel2" :
			return new Wheel2();
			case "Wheel3" :
			return new Wheel3();
			default :
			return null;
		}
	}

	@Override
	public Brake getBrake(String brake) {
		return null;
	}
}


class FactoryProducer {

	private AbstractFactory abstractFactory;

	public static AbstractFactory getComponentFactory(String componentFactory) {

		switch(componentFactory) {
		case "BREAK" :
		return new BrakeFactory();
		case "WHEEL" :
		return new WheelFactory();
		default :
		return null;
	    }
    }
}

class AbstractFactoryPatternDemo {

	public static void main(String args[]) {

		AbstractFactory brakeFactory = FactoryProducer.getComponentFactory("BREAK");

		AbstractFactory wheelFactory = FactoryProducer.getComponentFactory("WHEEL");

		Brake b = brakeFactory.getBrake("Brake1");
		Wheel w = wheelFactory.getWheel("Wheel1");
		b.createBrake();
		w.createWheel();
	}
}