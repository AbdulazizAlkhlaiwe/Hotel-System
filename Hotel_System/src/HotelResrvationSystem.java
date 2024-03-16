
import java.util.Scanner;
public class HotelResrvationSystem {

public static void main(String[] args) {
Scanner input = new Scanner(System.in); 

Hotel GrandBudapestHotel =new Hotel("GrandBudapestHotel");
int NumOfRes=0;
int foundRes=0;

System.out.println("********************************* The Grand Budapest Hotel ********************************* ");

System.out.println("Welcome to The Grand Budapest Hotel                                                          ");

System.out.println("---------------------------------------------------------------------------------------------");



  






System.out.println("--------------------------------------------------------------------------------------------");

System.out.println("1-New Reservation");

System.out.println("2-Adding a Room to the Reservation");

System.out.println("3-Finding a Reservation");

System.out.println("4-remove Room from Reservation");               

System.out.println("5-Exiting the program...");


System.out.println("");

System.out.println("What is your choice?");







int choice = input.nextInt();

while(choice!=5) {
        switch (choice) {
        case 1:
        	System.out.println("New Reservation");
        	
        	  System.out.println("What is your name? ");
        	  String name =input.next();
        	  
        	  System.out.println("What is your Reservation Start date? ");
        	  String Date =input.next();
        	  
        	  System.out.println("What is your Phone number? ");
        	  String phoneNum =input.next();
        	  
        	  System.out.println("Choice your Payment method?\n 1-Credit card\n 2-Debit Card\n 3-Cash ");
        	  String paymentMethod =input.next();
        	  
        	  GrandBudapestHotel.addReser(new Reservation(name, Date, phoneNum, paymentMethod));
        	  NumOfRes++;
        	  	break;
        	  	
            case 2:     
            	System.out.println("Enter your name ");       
                String nameAdd=input.nextLine();
                
                input.nextLine();
                
                System.out.println("Enter your phoneNumber");
                String PhoneAdd=input.nextLine();
            	
                System.out.println("what type of room you want (Standard /Suite)");
                String roomType = input.next();
                
                Room newRoom=null;
                if (roomType.equalsIgnoreCase("Standard")) {
                    newRoom = new StandardRoom(1499);
                }
                else if (roomType.equalsIgnoreCase("Suite")) {
                    newRoom = new SuiteRoom(2999);
                }
                for(int i=0;i<NumOfRes;i++)
                    if(GrandBudapestHotel.getReservation(i).getGuestName().equalsIgnoreCase(nameAdd)||GrandBudapestHotel.getReservation(i).getGuestPhoneNumber().equalsIgnoreCase(PhoneAdd))
                    	if (GrandBudapestHotel.getReservation(i).addRoom(newRoom))  {
                    System.out.println("Room has been added Successfully");
                }
                
            	
                break;

            case 3:           
                System.out.println("Finding a Reservation");
                
                System.out.println("Enter your name ");       
                String nameRes=input.nextLine();
                
                input.nextLine();
                
                System.out.println("Enter your phoneNumber");
                String PhoneRes=input.nextLine();
                
                for(int i=0;i<NumOfRes;i++)
                if(GrandBudapestHotel.getReservation(i).getGuestName().equalsIgnoreCase(nameRes)||GrandBudapestHotel.getReservation(i).getGuestPhoneNumber().equalsIgnoreCase(PhoneRes))
                		System.out.println(GrandBudapestHotel.getReservation(i).toString());

            	 
                 break;

            case 4:   
            	System.out.println("remove Room from Reservation");               

            	 System.out.println("Enter your name ");       
                 String nameRemove=input.nextLine();
                 
                 input.nextLine();
                 System.out.println("Enter your phoneNumber");
                 String PhoneRemove=input.nextLine();
                 
                 System.out.println("What type of room you want to remove (Standard/Suite) ? ");
                 String TypeName=input.nextLine();
                 
                 
                 
                 
                 Room roomToRemove;
                 for(int i=0;i<NumOfRes;i++) {
                     if(GrandBudapestHotel.getReservation(i).getGuestName().equalsIgnoreCase(nameRemove)||GrandBudapestHotel.getReservation(i).getGuestPhoneNumber().equalsIgnoreCase(PhoneRemove)) {
                    	 
                  roomToRemove = GrandBudapestHotel.getReservation(i).FindRoom(TypeName);
                 if (roomToRemove != null) {
             	    GrandBudapestHotel.getReservation(i).removeRoom(roomToRemove);
             	    System.out.println("Room has been removed successfully.");
             	} else {
             	    System.out.println("Room not found in the reservation.");
             	}}}

                 
                 

        
                    	 
               
                 
                 break;
                 
                        	            	            	                                       
            case 5:
            	System.out.println("Exiting the program...");
                break;
            
            default:
                System.out.println("inCorrect choice.");
        }
        System.out.println("--------------------------------------------------------------------------------------------");

        System.out.println("1-New Reservation");

        System.out.println("2-Adding a Room to the Reservation");

        System.out.println("3-Finding a Reservation");

        System.out.println("4-remove Room from Reservation");               

        System.out.println("5-Exiting the program...");


        System.out.println("");

        System.out.println("What is your choice?");
        choice = input.nextInt();


}      
System.out.println("Thank for using The Grand Budapest Hotel system! See You Soon [: ");
}

}