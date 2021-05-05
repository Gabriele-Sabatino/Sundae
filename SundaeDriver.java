//Assignment (2)
// Written by: (Gabriele Sabatino 40130099)
// For COMP 248 Section (U) – Winter 2020

import java.util.Scanner;
public class SundaeDriver {

	public static void main (String[] args)
	{
		Scanner kb = new Scanner(System.in);
	
		
/*This program's purpose is to personalize icereams and some information about the icream; 
		  1. List all sundaes sold today
		  2. Details of cheapest sundae
		  3. Number of sundaes sold today
		  4. Number of sundaes with a specific # of scoops
		  5. Average cost of sundaes
		  6. Quit	*/
	

		// The use of the welcome banner is to allows the user to know that the program is starting
		System.out.println("---------------------------------------------------------");
		System.out.println("         Welcome to Our Sundae Program!");
		System.out.println("---------------------------------------------------------");
		
		
		
		
		System.out.println("How many sundaes could you make today? ");
		Sundae  obj[] = new Sundae[kb.nextInt()];//Creating an array of objects
		Sundae OP = new Sundae(0," ", false); //Creating the object 

		
		
		System.out.print("What do you want to do\n\t1.Enter a new sundae order\n\t2.Change information of a specific order\n\t3.Display details for all sundaes of a specific order\n\t4.Statistics on todya's sundaes\n\t5.Quit\n\tPlease enter your choice > ");
		int l = kb.nextInt(); 
		int t=0;
		do //The do while loop is used to loop through all the options ustil the user choses option 5 which quits the program, ending the loop.
		{

		if(t!=0)
		{
		System.out.print("What do you want to do\n\t1.Enter a new sundae order\n\t2.Change information of a specific order\n\t3.Display details for all sundaes of a specific order\n\t4.Statistics on todya's sundaes\n\t5.Quit\n\tPlease enter your choice > ");
		
		l = kb.nextInt();
		}
		
		t++;
		switch(l) //The switch statement is used to take the user input and display the information depending on which  option they chose.
		{
		// Case 1 is to enter a new sundae order
		case 1: 
			    
				if(OP.getTracker()>obj.length)
				System.out.println("Sorry we don't have enough ingrediants to make another sundae");
				else
				{
					System.out.print("How many scoops of ice cream? ");
					int x= kb.nextInt();
					System.out.print("What Flavor? ");
					String str = kb.next();
					System.out.print("Any nuts? (y for yes anything else for no) ");
					String str1 = kb.next();
					OP.setFlavor(str);
					OP.setScoops(x);
					OP.setNuts((str1.equals("y")));
					OP.updateCost();
			       
					
					
					
						obj [OP.getTracker()]= new Sundae(OP.getScoops(), OP.getFlavor(), OP.getNuts());
						for(int i=0;i<obj.length;i++)
					 		if(obj[i]!=null)
					 		  System.out.println(obj[i]);
					
				}
			    continue;
		//Case 2 is the change information of a specific order
		case 2: 
					if(l>=0 && l<=obj.length)
				{
					System.out.println("\t--> Valid sundae numbers are 1 to " + obj.length);
					System.out.print("Which sundae do you wish to modify?");
					int k= kb.nextInt();
					if(obj[k]!=null)
					{
					System.out.println("Sundae #" + k);
					System.out.println(obj[k]);
					
					System.out.print("What would you like to change?\n "
							+ "1. Ice cream flavour\n" + 
							"  2. Number of scoops\n"  + 
							"  3. Nuts or no nuts\n"   + 
							"  4. Quit\nEnter choice > ");
					
					switch(kb.nextInt())
					{
					case 1:System.out.print("New flavour: ");
					OP.setFlavor(kb.next());
					
				    System.out.println("Here is what the sundae looks like now: ");
				    System.out.println(obj [k]= new Sundae(OP.getScoops(), OP.getFlavor(), OP.getNuts()));//obj[k].getFlavor());
				    break;
				    
					case 2: System.out.print("How many scoops? ");
							OP.setScoops(kb.nextInt());
							System.out.println("Here is what the sundae looks like now");
							System.out.println(obj [k]= new Sundae(OP.getScoops(), OP.getFlavor(), OP.getNuts()));
							break;
					
					case 3: if(OP.getNuts())
							{
							OP.setNuts(false);
							System.out.println("Nuts removed from this sundae");
							}
							else
							{
								OP.setNuts(true);
								System.out.println("Nuts added from this sundae");
							}
							System.out.println(obj[k]= new Sundae(OP.getScoops(), OP.getFlavor(), OP.getNuts()));
							break;
					
					case 4: break;
					}
					}
					
					else
					{
						System.out.println("Sorry no such sundae.");
						System.out.println("Do you want to enter another sundae number or return to the Main Menu (quit to return)?");
						if(kb.next().equals("quit"))
							continue;
						else
							break;
					}
				}
					else
					{
					System.out.println("Sorry no such sundae.");
					System.out.println("Do you want to enter another sundae number or return to the Main Menu (quit to return)?");
					if(kb.next().equals("quit"))
						continue;
					else
						break;
					}
					continue;
		//Case 3 is the display details for all sundaes of a specific ice cream flavor
		case 3:   System.out.println("What flavour do you want a list of?");
				  String u = kb.next();
				  for(int i=0;i<obj.length;i++)
					{
						//obj[i].Sundae(kb.nextInt(),kb.nextLine(),kb.next());
						if(obj[i]!=null && obj[i].getFlavor().equals(u))
							System.out.println(obj[i].toString());
					}
				  continue;
			
		//Case 4 is the statistics on today’s sundaes
		case 4: System.out.println("What information would you like?\n" + 
				"  1. List all sundaes sold today\n" + 
				"  2. Details of cheapest sundae\n" + 
				"  3. Number of sundaes sold today\n" + 
				"  4. Number of sundaes with a specific # of scoops\n" + 
				"  5. Average cost of sundaes\n" + 
				"  6. Quit\nEnter choice > ");
		
				 switch(kb.nextInt())
				 {
				 case 1: for(int i=0;i<obj.length;i++)
					 		if(obj[i]!=null)
					 		  System.out.println(obj[i]);
				 			break;
				 
				 case 2: 
					 
				 double smallest = 0;
				 
				 
				 for(int i=0; i< obj.length; i++)
				 {
				 if(obj[i]!=null && obj[i+1]!=null && obj[i].getCost() < obj[i+1].getCost())
				 smallest = obj[i].getCost();
				 
				 }
				 
				 for(int i=0; i< obj.length; i++)
				 {
					 if(obj[i]!=null && smallest==obj[i].getCost())
						 System.out.println(obj[i]);
				 }
				 
					 break;
					 
				//Case 3 provides number of sundaes sold	 
				 case 3: System.out.println("Number of sundaes sold " + (OP.getTracker()-1));
				 break;
				 
				 //Case 4 provides number sundaes sold of a specific number
				 case 4: System.out.println("How many scoops? ");
							 for(int i=0;i<obj.length;i++)
							 		if(obj[i]!=null && obj[i].getScoops()==(kb.nextInt()))
							 			System.out.println(obj[i]);
							 break;
		
				//Case 5 Average cost of sundaes
				 case 5:  double sum=0;
					 	
				  for(int i=0;i<obj.length;i++)
				  {
				 		if(obj[i]!=null)
				 			sum+=obj[i].getCost();
				 			
				  }
				  System.out.println(sum/(OP.getTracker()-1));
				 
					 break;
				
				//Case 6 is to Quit
				 case 6: break;
				 }
				 continue;
			
			//Case 5 is the Quit
			case 5: System.out.println("Thank you for using our game");
					System.exit(0);
					 
				  
		
		}
		}while(l!=5);//do while loop ends when user inputs 5 which is quit
	
	     kb.close();//Closes the keyboard
	}
}

