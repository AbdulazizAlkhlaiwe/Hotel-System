
public class Reservation {

private String ReservationDate;
private String guestName;
private String guestPhoneNumber;
private String paymentMethod;
private Room[] Rooms;
private int countRoom;
private int numOfStandard;
private int numOfSuite;






public Reservation(String guestName, String reservationDate, String guestPhoneNumber, String paymentMethod) {

Rooms=new Room[3];


this.ReservationDate = reservationDate;
this.guestName = guestName;
this.guestPhoneNumber = guestPhoneNumber;
this.paymentMethod = paymentMethod;
countRoom=0;

}


public String getGuestName() {
return guestName;

}

public String getGuestPhoneNumber() {
return guestPhoneNumber;

}

public Reservation(Reservation r) {
this.ReservationDate = r.ReservationDate;
this.guestName = r.guestName;
this.guestPhoneNumber = r.guestPhoneNumber;
this.paymentMethod = r.paymentMethod;
this.Rooms=new Room[r.Rooms.length];

for(int i=0;i<r.countRoom;i++) {
this.Rooms[i]=r.Rooms[i];
}
}

public boolean addRoom(Room R) {
if(R instanceof StandardRoom) {
    Rooms[countRoom] = R;
    countRoom++;
    numOfStandard++;
    return true;
}
else
	Rooms[countRoom] = R;
	countRoom++;
	numOfSuite++;
	return true;
}



public boolean removeRoom(Room R) {
    for (int i = 0; i < countRoom; i++) {
        if (Rooms[i].equals(R)) { // Check for equality with the given room
            for (int j = i; j < countRoom - 1; j++) {
                Rooms[j] = Rooms[j + 1];
            }
            Rooms[countRoom - 1] = null;
            countRoom--;
            if(R instanceof StandardRoom)
                numOfStandard--;
            else
            	numOfSuite--;

            return true;
        }
    }
    return false; // Room not found
}


@Override
public String toString() {
	String resFormat="ReservationDate : " + ReservationDate + ", guestName : " + guestName + ", guestPhoneNumber : "
			+ guestPhoneNumber + ", paymentMethod : " + paymentMethod  
			+ ", number of rooms : " + countRoom+"\n\n" ;
	
	for(int i=0;i<countRoom;i++) {
		if(Rooms[i] instanceof StandardRoom)
		resFormat+=((StandardRoom)Rooms[i]).toString()+"\n"+"Total cost of all Standard : "+((StandardRoom)Rooms[i]).calculateCost(numOfStandard)+"\n\n";
		else
			resFormat+=((SuiteRoom)Rooms[i]).toString()+"\n"+"Total cost of all Suite : "+((SuiteRoom)Rooms[i]).calculateCost(numOfSuite)+"\n\n";
	}
	return resFormat;
}

public Room FindRoom(String Type) {//Finding the room
    
    	if(Type.equalsIgnoreCase("Standard")) {
        for(int i=0;i<countRoom;i++)
        	if(Rooms[i] instanceof StandardRoom)
        		return ((StandardRoom)Rooms[i]);
        }
    	if(Type.equalsIgnoreCase("Suite")) {
            for(int i=0;i<countRoom;i++)
            	if(Rooms[i] instanceof SuiteRoom)
            		return ((SuiteRoom)Rooms[i]);
    	
        
    }System.out.println("Can't remove the Room");
    return null;}}














	


