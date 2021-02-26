package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to

		// - connect to the broker
		// - publish the temperature(s)
		// - disconnect from the broker

		// TODO - end
		
		Client sensor = new Client("SENSOR", Common.BROKERHOST, Common.BROKERPORT);
		boolean connected = sensor.connect();
		
		if(connected) {
			for(int i = 0; i < COUNT; i++) {
				
				sensor.publish(Common.TEMPTOPIC, ""+sn.read());	
			}	
		}else {
			System.out.println("Sensor could not connect");
		}
		sensor.disconnect();
		System.out.println("Temperature device stopping ... ");
	}
}
