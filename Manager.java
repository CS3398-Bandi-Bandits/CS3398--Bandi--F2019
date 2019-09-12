package threesolid;

//Author: Jose Herrera
// open closed principle:
// class is open to additions and closed to modifications
//hello

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
