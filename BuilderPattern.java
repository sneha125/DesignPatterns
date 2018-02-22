/*
   BuilderPattern is used, when you want to create a complex Object.
   Car Object.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Car {

	private String wheel1,wheel2,wheel3;

	private String engine;

	private String rearBack;

	// getters and setters for all above variables

	public void setWheel1(String wheel1) {
		this.wheel1 = wheel1;
	}

	public void setWheel2(String wheel2) {
		this.wheel2 = wheel2;
	}

	public void setWheel3(String wheel3) {
		this.wheel3 = wheel3;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public void setRearBack(String rearBack) {
		this.rearBack = rearBack;
	}

	public String getRearBack() {
		return this.rearBack;
	}

	public String getEngine() {
		return this.engine;
	}

	public String getWheel1() {
		return this.wheel1;
	}

	public String getWheel2() {
		return this.wheel2;
	}

	public String getWheel3() {
		return this.wheel3;
	}
	
	public static Builder builder() {

	    return new Builder();
	}

	public static class Builder {

	    private String wheel1,wheel2,wheel3,wheel4;

	    private String engine;

	    private String rearBack;

	    public Builder withWheel1(String wheel1)
	    {
	        this.wheel1 = wheel1;
	        return this;
	    }

	    public Builder withWheel2(String wheel2)
	    {
	        this.wheel2 = wheel2;
	        return this;
	    }

	    public Builder withWheel3(String wheel3)
	    {
	        this.wheel3 = wheel3;
	        return this;
	    }

	    public Builder withEngine(String engine)
	    {
	        this.engine = engine;
	        return this;
	    }

	    public Builder withRearBack(String rearBack)
	    {
	        this.rearBack = rearBack;
	        return this;
	    }
        
        public Car build()
        {
          Car c = new Car();
          populateCar(c);
          return c;
        }

        private Car populateCar(Car c) {

        	c.setWheel1(this.wheel1);
        	c.setWheel2(this.wheel2);
        	c.setWheel3(this.wheel3);
        	c.setEngine(this.engine);
        	c.setRearBack(this.rearBack);
        	return c;
        }
    }

} 

class BuilderPatternDemo {

	public static void main(String args[]) {

		Car c = Car.builder()
		           .withWheel1("Hummur_Wheel1")
		           .withWheel2("Hummur_Wheel2")
		           .withWheel3("Hummur_Wheel3")
		           .withEngine("Ford_Engine")
		           .withRearBack("Chins_Back")
		           .build();
		System.out.println("Wheel1 of the Car is:"+c.getWheel1());
		System.out.println("Engine of the Car is:"+c.getEngine());
		System.out.println("RearBack of the Car is:"+c.getRearBack());
	}
}