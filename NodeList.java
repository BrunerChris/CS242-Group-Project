/**
 * The NodeList.java class controls the order of the linked list and can add and remove data from the list
 * @author Nick Gapp
 * @version 1.0
 * @since 11/13/2014
 */

public class NodeList
{
  Node head = null;

  /**
   * add adds data to the end of the linked list
   * @param data The data in the form of a Student that needs to be added to the list
   */
  public void add(MapPoint data)
  {
    if(head == null)
      head = new Node(data, null, null);
    else
    {
      Node current  = head;
      while(current.getNext() != null)
      {
        current = current.getNext();
      }

      Node temp = new Node(data, null, current);
      current.setNext(temp);
    }
  }

  /**
   * remove removes data from the linked list and moves other data around to fill the missing data's spot
   * @param name The first name of the Student needing to be removed from the list
   * @return The Student that was removed
   */
  public MapPoint remove(MapPoint point)
  {
    Node target = search(point);

    if(target == null)// not there/no items in list
    	return null;
    else// there/more items in list 
    {
      if(target == head)// first item in list
      {
        if(target.getNext() == null)// What if only one item in list?
        {
          head = null;
          return target.getData();
        }
        else// first item and more than one item in the list
        {
          target.getNext().setPrevious(null);
          head = target.getNext();
          return target.getData();
        }
      }
      else// not first item in list
      {
        target.getPrevious().setNext(target.getNext()); 
  
        if(target.getNext() != null)// if item is at end of list
        {
          target.getNext().setPrevious(target.getPrevious());
          return target.getData();
        }

        return target.getData();
      }
    }
  }
  
  /**
   * search searches the linked list for a requested first name of a Student
   * @param name The first name of the Student in needing of finding
   * @return The Node where that Student is stored in the linked list
   */
  public Node search(MapPoint point)
  {
    Node current = head;

    while(current != null)
    {
      if(current.getData().getStartPoint().equals(point.getStartPoint()))
        return current;

      current = current.getNext();
    }

    return null;
  }

  /**
   * numElements counts the number of Students in the linked list
   * @return The number of Students in the linked list
   */
  public int numElements()
  {
    Node current = head;
    int count = 0;

    if(current == null)
      return 0;

    while(current != null)
    {
      count++;
      current = current.getNext();
    }

    return count;
  }

  /**
   * toString returns information about what is inside the NodeList
   * @return A String containing information about the contents of the NodeList
   */
  public String toString()
  {
    Node current = head;
    String output = "";
    while(current != null)
    {
      output = output + current.getData() + "\n";
      current = current.getNext();
    }
    
    return output;
  }
}
