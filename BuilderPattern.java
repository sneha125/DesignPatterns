/*
   BuilderPattern is used, when you want to create a complex Object.
   Car Object.
*/

class Car {

	private Wheel wheel1,wheel2,wheel3,wheel4;

	private Engine engine;

	private RearBack rearBack;

	// getters and setters for all above vraiables
	
	public static Builder builder() {

	    return new Builder();
	}

	public static class Builder {

	    private Wheel wheel1,wheel2,wheel3,wheel4;

	    private Engine engine;

	    private RearBack rearBack;

	    public Builder withWheel1(Wheel wheel)
	    {
	        this.wheel1 = wheel;
	        return this;
	    }

	    // Similarly, for other variables
        
        public Car build()
        {
          Car c = new Car();
          populateCar(c);
          return c;
        }

        private Car populateCar(Car c) {

        	c.setWheel1(this.wheel1);
        	...
        	return c;
        }
    }

} 