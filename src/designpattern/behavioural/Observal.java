package designpattern.behavioural;

import java.util.Observable;
import java.util.Observer;

public class Observal {

	public static void main(String[] args) {
		Publisher publisher = new Publisher();
		publisher.addObserver(new Subscriber1());
		publisher.addObserver(new Subscriber2());
		publisher.addObserver((Observable o, Object arg) -> {
			System.err.println("New state received by Subscriber 3:" + arg.toString());
			
			String currentPublisherState = (String) arg;
		});
		publisher.changeStateTo("assigned");

	}
}

class Publisher extends Observable {
	public void changeStateTo(String newStateName) {
		this.setChanged();
		this.notifyObservers(newStateName);
	}
	
	
}

class Subscriber2 implements Observer {
	String currentPublisherState;

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("New state received by Subscriber 2:" + arg.toString());
		this.currentPublisherState = (String) arg;
	}
}

class Subscriber1 implements Observer {
	String currentPublisherState;

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("New state received by Subscriber 1:" + arg.toString());
		this.currentPublisherState = (String) arg;
	}
}
