/**
 * Data collection management program 
 * (CopmutuerParts Class)
 * 
 * @author Oussama el aallali
 * 9/20/2016
 * 
 */


public class ComputerParts implements Comparable<ComputerParts> {

	private String partName;
	private String brand;
	private String type;
	private double price;
	private int quant;
/**ComputerParts(String pn, String b, String m, double p, int q)
 * Initializes attributes
 * @param pn Part Name 
 * @param b  the brand of the part
 * @param m  the type of the part
 * @param p  price per part
 * @param q  the number purchased of one part
 */
	public ComputerParts(String pn, String b, String t, double p, int q) {

		this.partName = pn;
		this.brand = b;
		this.type = t;
		this.price = p;
		this.quant = q;
	}
/** getPartName()
 * 
 * @return partName Returns the name of the part
 */
	
	public String getPartName() {
		return partName;
	}
/**setPartName(String partName)
 * 
 * @param partName  Sets the name of the part
 */
	public void setPartName(String partName) {
		this.partName = partName;
	}
/**getBrand()
 * 
 * @return  Returns the name of the brand
 */
	public String getBrand() {
		return brand;
	}
/**setBrand(String brand)
 * 
 * @param brand   Sets the name of the brand
 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
/**getType()
 * 
 * @return   Return the type of the part 
 */
	public String getType() {
		return type;
	}
/** settype(String type)
 * 
 * @param type   Sets the type of the part
 */
	public void settype(String type) {
		this.type = type;
	}
/**getPrice()
 * 
 * @return  Returns the price of the part
 */
	public double getPrice() {
		return price;
	}
/**setPrice(double price)
 * 
 * @param price sets the price of the part
 */
	public void setPrice(double price) {
		this.price = price;
	}
/**Quant()
 * 
 * @return  Returns the quantity of the part
 */
	public int getQuant() {
		return quant;
	}
/**
 * 
 * @param quant sets the quantity of the part
 */
	public void setQuant(int quant) {
		this.quant = quant;
	}
/**Eequals(ComputerParts obj)
 * 
 * @param obj  compares  ComputerParts object
 * @return    true if the names are equal
 * 			  false if the names are not equal						    
 */
	public boolean Eequals(ComputerParts obj) {

		if (obj instanceof ComputerParts) {

		

			return (obj.partName.equalsIgnoreCase(partName));

		}

		else
			return false;

	}
	
/**public int compareTo(ComputerParts Cp)
 * 
 * the method is based on the implementation form  the interface compareTo
 * Compare two Strings and return an integer value  
 * 	@return int value 
 */
public int compareTo(ComputerParts Cp){
		
		return (this.partName.compareToIgnoreCase(Cp.partName));
		
	}


	
	/** toString()
	 * Converts object to String
	 * @return	attributes of ComputerParts as one string
	 */
	public String toString() {

		return this.partName + "\t " + this.brand + "\t " + this.type + "\t$ " + this.price + "\t " + this.quant;

	}

}	
