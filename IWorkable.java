package threesolid;

/*
	Interface Segregation Principle: The IWorkable interface will handle all implementations of work(); for any
	type that should need it. It contains just one function, work(); that can be implemented differently for each worker
	that uses it, and remains separate from the eat(); function that is also required (or not, i.e a robot)
	for different workers.

	Open/Close Prinicple: Because this interface has a work(); function that can be extended and implemented in a
	various number of ways without changing the actual interface i believe it does follow the Open/Close prinicpal.

	Single Responcibility Prinicpal: Likewise to the interface segregation prinicipal, this interface only asks to
	implement the work(); function, and does not include implementation to an eat(); function, for example. Because of
	this, it has a single responcibility.
 */
public interface IWorkable {
	public void work();
}   