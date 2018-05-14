package sysexp;

import java.util.ArrayList;

public class main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*RegleSimple r1 = new RegleSimple("P","Q");
		RegleSimple r2 = new RegleSimple("Q","R");
		
		
		ArrayList <String> BF = new ArrayList<String>();
		ArrayList<RegleSimple> BR = new ArrayList<RegleSimple>();
		
		BR.add(r1);
		BR.add(r2);
		
		BF.add("P");*/
		
		//COMPOSEE
		//System.out.print( MoteurInference.chainageavant(BR, BF, "F"));
		
		RegleComposee r3 = new RegleComposee("P&J","Q");
		RegleComposee r4 = new RegleComposee("Q&K","R");
		
		
		ArrayList <String> BF1 = new ArrayList<String>();
		ArrayList<RegleComposee> BR1 = new ArrayList<RegleComposee>();
		
		BR1.add(r3);
		BR1.add(r4);
		
		BF1.add("P");
		
		
		//System.out.print( MoteurInference.chainageavant(BR1, BF1, "P"));
		//AVANT
		System.out.println(BF1);
		System.out.println(BR1);
		//System.out.println( MoteurInference.chainagearriere(BR, BF, "Z"));
		System.out.println( MoteurInference.chainagearrierecom(BR1, BF1, "Z"));
	}

}