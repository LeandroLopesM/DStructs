package com.queue;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

public class TestQueue {
	public TestQueue() {
		String[] clients = { "ADDR_A", "ADDR_B", "ADDR_C", "ADDR_D", "ADDR_E" };
		Queue q = new Queue( clients.length );
		
		for( String client : clients ) {
			q.enQ(client);
		}
		
		try {
			while(true) {
				if( q.isEmpty() ) break;
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println("Client: " + q.deQ() + " has been served");
			}
		} catch (InterruptedException e) {
			throw new RuntimeErrorException(null);
		}
	}
}
