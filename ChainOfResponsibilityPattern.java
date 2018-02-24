/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

interface Handler {
	
	public int numberOfNotes(int amount);

	public void setNextHandler(Handler h);

	public Handler getNextHandler();

}

class Handler_100 implements Handler {
	
	Handler handler;

	@Override
	public int numberOfNotes(int amount) {
	    if(amount < 100) {
	        return 0;
	    }
        int count = amount/100;
        amount = amount - (100*count);
        System.out.println("Number Of 100 Notes for given amount is :"+count);
        return amount;
	}

	@Override
	public void setNextHandler(Handler h) {
		this.handler = h;
	}

	@Override
	public Handler getNextHandler() {
		return this.handler;
	}
}

class Handler_500 implements Handler {
	
	Handler handler;

	@Override
	public int numberOfNotes(int amount) {
	    if(amount < 500) {
	        return 0;
	    }
        int count = amount/500;
        amount = amount - (500*count);
        System.out.println("Number Of 500 Notes for given amount is :"+count);
        return amount;
	}

	@Override
	public void setNextHandler(Handler h) {
		this.handler = h;
	}

	@Override
	public Handler getNextHandler() {
		return this.handler;
	}
}

class Handler_1000 implements Handler {
	
	Handler handler;

	@Override
	public int numberOfNotes(int amount) {
	    if(amount < 1000) {
	        return amount;
	    }
        int count = amount/1000;
        amount = amount - (1000*count);
        System.out.println("Number Of 1000 Notes for given amount is :"+count);
        return amount;
	}

	@Override
	public void setNextHandler(Handler h) {
		this.handler = h;
	}

	@Override
	public Handler getNextHandler() {
		return this.handler;
	}
}


class Strategy {

	Handler_1000 handler_1000;
	Handler_500 handler_500;
	Handler_100 handler_100;


	public Strategy() {
		handler_1000 = new Handler_1000();
		handler_500 = new Handler_500();
		handler_100 = new Handler_100();
		handler_1000.setNextHandler(handler_500);
		handler_500.setNextHandler(handler_100);
		handler_100.setNextHandler(null);
	}
	public void getAmountFromATM (int amount) {
		Handler currentHandler = handler_1000;
		while (amount > 0 && currentHandler != null) {
			amount = currentHandler.numberOfNotes(amount);
			currentHandler = currentHandler.getNextHandler();
		}
		if(currentHandler == null && amount > 0) {
			System.out.println("The given amount cant be withdrawn, because, amt is not in multiples of 100");
		}
	}
}

class CORPatternDemo {

	public static void main (String args[]) {

		Strategy strategy = new Strategy();
		strategy.getAmountFromATM(5500);
		strategy.getAmountFromATM(5600);
		strategy.getAmountFromATM(5720);
	}
}