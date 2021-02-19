package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
				
		// create a client object and use it to
		
		// - connect to the broker
		// - create the temperature topic on the broker
		// - subscribe to the topic
		// - receive messages on the topic
		// - unsubscribe from the topic
		// - disconnect from the broker
		
		// TODO - END
		
		Client display = new Client("SENSOR", Common.BROKERHOST, Common.BROKERPORT);
		boolean connected = display.connect();
		
		if(connected) {
			String topic = Common.TEMPTOPIC;
			
			display.createTopic(topic);
			display.subscribe(topic);
		
			for(int i = 0; i < COUNT; i++) {
				
				Message msg = display.receive();
				System.out.println(msg.toString());
			}
			
			display.unsubscribe(topic);
			display.disconnect();
		}else {
			System.out.println("Sensor could not connect");
		}
		System.out.println("Display stopping ... ");
		
	}
}
