package snapchat21;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		ClassTimes lecture1 = new ClassTimes(30, 75);
		ClassTimes lecture2 = new ClassTimes(0, 50);
		ClassTimes lecture3 = new ClassTimes(60,150);
//		ClassTimes lecture4 = new ClassTimes(30,75);
//		ClassTimes lecture5 = new ClassTimes(0,75);
//		ClassTimes lecture6 = new ClassTimes(90, 175);
		
		ClassTimes[] day = {lecture1, lecture2, lecture3}; //, lecture4, lecture5, lecture6};
	
		roomsNeeded(day);

	}

	private static void roomsNeeded(ClassTimes[] day) {
		
		int needed = 0;
		int most = 0;
		
		int[] starts = new int[day.length];
		int[] ends = new int[day.length];
		for(int x = 0; x < day.length; x++) {
			starts[x] = day[x].getStart();
			ends[x]=day[x].getFinish();
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		
		for(int x = starts[0]; x < ends[day.length-1]; x++) {
			for(ClassTimes y : day) {
				if(x >= y.getStart() && x <= y.getFinish() ) {
					needed++;
				}
			}
			if(needed > most)most = needed;
			needed = 0;
		}
		
		System.out.println("rooms needed = " + most);
		
	}
}




