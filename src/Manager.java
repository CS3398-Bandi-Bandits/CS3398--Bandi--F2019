package threesolid;

// Author: Jose Herrera

// Open Closed Principle:
// Class is open to additions and closed to modifications.
// New methods may be added but the simplicity of the existing
// methods prevent any potential need for tampering.

// Single Responsibility Principle:
// The Manager has a single responsibility: to manage work.  It accepts a worker or eater
// and allows it to either work or eat.  Although two seperate tasks they are,
// together, one responsibility: Manage.

// Interface Segregation Principal:
// This principal applies more to the files containing the interface definitions but this 
// Manager class employs it well enough.  It takes two simple interfaces that could have been written
// together but have instead had their functionality split, and employs them more appropriately depending 
// on the task required.  


public class Manager {
	
	public Manager() {
		
	}

	public void manageWork(IWorkable w) {
		w.work();
	}
	
	public void manageLunch(IFeedable f) {
		f.eat();
	}
	
}
