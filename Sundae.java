
public class Sundae {

	//Private variables that can only be accessed with accesors and mutators, for privacy purposes.
	private String Flavor;
	private int Scoops;
	private boolean Nuts;
	private double Cost;
	private static int Tracker;
	
// Default constructor: 1)same name, 2)no return at all, 3) public 4) No paramaterizations
public Sundae()
{
	Flavor="";
	Scoops=0;
	Nuts=false;
	Cost=0;
	Tracker++;
	
}
//constructor: 1)same name, 2)no return at all, 3) public 4) paramaterizations
public Sundae(int Scoops, String Flavor, boolean Nuts)
{
	setScoops(Scoops);
	setFlavor(Flavor);
	setNuts(Nuts);
	Tracker++;
	this.calcCost();
}

//Copy constructor
public Sundae(Sundae sundae) {
    this.Flavor = sundae.Flavor;
    this.Scoops = sundae.Scoops;
    this.Nuts = sundae.Nuts;
    this.Cost = sundae.Cost;
    Tracker++;
}


//Accesors allow the program to get the values, meanwhile Mutators are to change and set values.

//Accessors (usually only return type)
public String getFlavor()
{
	return Flavor;
}
// Accessors (usually only return type)
public int getScoops()
{
	return Scoops;
}
// Accessors (usually only return type)
public boolean getNuts()
{
	return Nuts;
}
//Accessors (usually only return type)
public double getCost()
{
	return Cost;
}
//Accessors (usually only return type)
public static int getTracker()
{
	return Tracker;
}
// Mutators (usually no return type)
public void setFlavor(String Flavor)
{
	this.Flavor=Flavor;
}
//Mutators (usually no return type)
public void setScoops(int Scoops)
{
	this.Scoops=Scoops;
}
//Mutators (usually no return type)
public void setNuts(boolean Nuts)
{
	this.Nuts=Nuts;
}
//This method helps update the cost
public void updateCost()
{
	this.calcCost();
}
//This method calculates the cost of the ice cream
private void calcCost()
{
	
	if(Nuts)
		Cost= (1.5*Scoops) + 1.25;
	else
		Cost=1.5*Scoops;
	
}
//This method checks if the content of two objects are equal
public boolean isEquals(Sundae anotherSundae)	
{
return anotherSundae.getFlavor().equals(this.Flavor) && this.Scoops == anotherSundae.getScoops() && this.Nuts == anotherSundae.getNuts();
}
//This method prints out a string
public String toString() {
	if (Nuts)
		 return ("Sundae with " + getScoops() + " scoops" +
            " of " + getFlavor() + " with nuts for a cost of: " + this.getCost());
	else
		return ("Sundae with " + getScoops() + " scoops" +
        " of " + getFlavor() + " without nuts for a cost of: " + this.getCost());

}

}
