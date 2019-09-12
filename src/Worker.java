/*
 *  Victor Hernandez
 *
 *  Open Close Principle: This Worker class is open for extension but
 *                        closed for modification. It uses the interfaces
 *                        IWorkable and IFeedable to extend the behaviors
 *                        to this class without having to modify the existing
 *                        source code.
 *
 *  Single Responsibility Principle: This class is only responsible to the Worker.
 *                                   It is separate from the SuperWorker class and
 *                                   the RobotWorker class in order to maintain
 *                                   single responsibility. Changes made to the
 *                                   Worker class will not interfere with the
 *                                   other classes.
 *
 *  Interface Segregation Principle: DNA (Does Not Apply).
 */


package threesolid;

public class Worker implements IWorkable, IFeedable {

    public void work() {
        // do some work
    }

    public void eat() {
        // eat something
    }
}