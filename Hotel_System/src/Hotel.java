
public class Hotel {
		private String name;
		private Reservation ReservationArr[];
		private int countReser;

		public Hotel(String name) {

		this.name = name;


		ReservationArr=new Reservation[100];

		countReser=0;

		}


		public boolean addReser(Reservation r) {
		if(countReser<ReservationArr.length) {
			
		ReservationArr[countReser]=new Reservation(r);
		countReser++;
		
		return true;
}
		else {
		System.out.println("can't make Reservation");
		return false;
	}
}
		
		public boolean removeReser(Reservation r) {

		for(int i=0;i<countReser;i++) 
			if(ReservationArr[i].getGuestName().equalsIgnoreCase(r.getGuestName())&&ReservationArr[i].getGuestPhoneNumber().equalsIgnoreCase(r.getGuestPhoneNumber())) {
				ReservationArr[i]=ReservationArr[countReser-1];
				ReservationArr[countReser-1]=null;
				countReser--;
		return true;
		}
		System.out.println("Reservation not found");

		return false;
}


		public Reservation getReservation(int i) {
	        if (i>=0 && i<countReser ) {
	            return ReservationArr[i];
	        } else {
	        	
	            System.out.println("Invalid reservation index.");
	            return null;
	        }
	    }
}





