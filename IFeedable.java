package threesolid;

/*
	Interface Segregation Principle: The feedable interface will handle all implementations of eating for any
	Workers Type. It contains just one function, eat(); that can be implemented differently for each worker that uses
	it, and remains separate from the work(); function that is also required (or not) for different workers.

	Open/Close Prinicple: Because this interface has an eat(); function that can be extended and implemented in a
	various number of ways without changing the actual interface i believe it does follow the Open/Close prinicpal.

	Single Responcibility Prinicpal: Likewise to the interface segregation prinicipal, this interface only asks to
	implement the eat(); function, and does not include implementation to a work(); function, for example. Because of
	this, it has a single responcibility.
 */
public interface IFeedable {
	public void eat();
}