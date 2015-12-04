/**
 * The Node.java class creates a Node for use in linked lists.
 * @author Nick Gapp
 * @version 1.0
 * @since 11/13/2014
 */

public class Node
{
  private MapPoint data = null;
  private Node next = null;
  private Node previous = null;

  /**
   * The Node constructor creates a Node
   * @param inData The Student to be stored in linked list
   * @param inNext The position after inData
   * @param inPrev The position before inData
   */
  public Node(MapPoint inData, Node inNext, Node inPrev)
  {
    data = inData;
    next = inNext;
    previous = inPrev;
  }

  /**
   * getNext returns what's in the next position
   * @return The next Node
   */
  public Node getNext()
  {
    return next;
  }

  /**
   * setNext sets the data to be stored in the next slot in the linked list
   * @param inNext The next Node
   */
  public void setNext(Node inNext)
  {
    next = inNext;
  }

  /**
   * getPrevious returns the previous Node
   * @return The previous Node
   */
  public Node getPrevious()
  {
    return previous;
  }

  /**
   * setPrevious sets the data to be stored in the previous slot in the linked list
   * @param inPrev The previous Node
   */
  public void setPrevious(Node inPrev)
  {
    previous = inPrev;
  }

  /**
   * getData returns the data stored in that Node
   * @return A Student with the data that is being requested
   */
  public MapPoint getData()
  {
    return data;
  }
}
