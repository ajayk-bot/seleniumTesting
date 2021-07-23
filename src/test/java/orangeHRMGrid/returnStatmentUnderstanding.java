package orangeHRMGrid;

import java.util.ArrayList;
import java.util.List;

public class returnStatmentUnderstanding {
	
	//method to generate multiple Names 
	
	
	
	
	

	public static String getTheList(List<String> st) {
		String text = "hi";

		if (st.get(1).equals("21")) {

			if (st.get(2).equals("13")) {
				return "13";
			}

			return "present";
		}

		return text;

	}

	public static void main(String[] args) {

		ArrayList<String> str = new ArrayList<String>();
		str.add("1");
		str.add("21");
		str.add("13");
		str.add("11");

		String testing = getTheList(str);
		System.out.println(testing);

		// ------------------------
		int i = 10;
		do {
			System.out.println(i--);
		} while (i > 1);

		// ------------------------
		System.out.println("---------------------");
		int j = 10;
		while (j > 1) {
			System.out.println(j--);
		}
		
		
		 String needForOption  = "//tbody/tr[1]/td[1]";
		 System.out.println("verify for correct Path:"+ needForOption);
		
		System.out.println("checking and understanding break statement in java");
		 
		 for (int k = 0; k < 5; k++) {
			System.out.println(k);
			for (int k2 = 0; k2 < 5 ; k2++) {
				System.out.println(k2);
				
				if(k2 == 3) {
					System.out.println("test for out loop");
					break;
				}
				
			}
			
		}
	
			

	}

	
	
	
	
}
