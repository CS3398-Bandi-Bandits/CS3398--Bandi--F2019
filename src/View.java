/**
 * 	@author Devon Tyson
 */

import java.util.HashMap;
import java.util.Map.Entry;

public class View {
	
	Controller controller;
	
	public View(Controller control) {
		this.controller = control;
	}

	public void showStats() {
		HashMap<String, Integer> stats = controller.playerStats();
		
		for (Entry<String, Integer> entry : stats.entrySet())  
            System.out.println(entry.getKey() + 
                             ": " + entry.getValue());
		System.out.println();
	}
	
}
