import java.util.List;

public class Inventory<T extends Supplies> {

	/*     STEP 3 
	*        
	*      Create this bounded type generic class with everything you 
	*      would expect in a class (instance variable, constructor,
	*      get/set methods) and then make two additional generic methods:
	*
	*      Go to Transfer.java for STEP 4
	*/
	private String note;

	public Inventory() {}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/** Searches for an element in the given list by name
	 *
	 * @return The index of the found element, or {@code -1} if the element does not exist.
	**/
	public int searchByName(List<T> inputList, String name) {
		for (int i = 0; i < inputList.size(); i++) {
			if (inputList.get(i).getName().equalsIgnoreCase(name))
				return i;
		}

		return -1;
	}

	/*     STEP 7:
	* 
	*      Create a method called checkQty() that takes three parameters:
	*           - The input List<T>
	*           - The String name of the object we want to check
	*           - The int desiredQuantity that we want to check/change for 
	*             the item
	*           
	*      Use our method searchByName() to be able to get the index of 
	*      the object we are looking for and use the index to access the 
	*      object within the List<T>. If the object is not found, or if
	*      our searchByName() method returns -1, return null.
	*
	*      Once our object is found, check the quantity via the .get() 
	*      method from the List class and by using the .getQuantity()
	*      from the Supplies class. Compare the value with the parameter 
	*      desiredQuantity, if they match then return the object as-is
	*      and notify user that the quantity matches. If it does not 
	*      match the quantity in the list, then update using .setQuantity
	*      and return the object with the new quantity.
	*/
	public T checkQty(List<T> input, String name, int desiredQuantity) {
		int index = this.searchByName(input, name);
		if (index == -1)
			return null;

		T item = input.get(index);
		if (item.getQuantity() == desiredQuantity) {
			System.out.println("The quantity already matches!");
		} else {
			item.setQuantity(desiredQuantity);
		}

		return item;
	}
}