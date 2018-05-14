package sysexp;

import java.util.ArrayList;
import java.util.Scanner;

public class MoteurInference {
	
	public MoteurInference() {
			}
	
	public static boolean chainageavant(ArrayList<RegleSimple>BR,ArrayList<String>BF, String Propverif) {
		RegleSimple r=new RegleSimple();
		boolean found= true; 
		while(BF.contains(Propverif)== false && found == true ) {
			found = false;
		for ( int i=0; i<BR.size(); i++) {
			r = BR.get(i);
			if(BF.contains(r.getPremisse())==true )
				found=true;
				BF.add(r.getConclusion());
			    BR.remove(i);
		}
		}
		if (BF.contains(Propverif)==true)
			return true;
		else {
			return false;
		}	
	}
	@SuppressWarnings("unlikely-arg-type")
	public static boolean chainageavantCom(ArrayList<RegleComposee>BR,ArrayList<String>BF, String Propverif) {
		RegleComposee r=new RegleComposee();
		boolean found= true; 
		while(BF.contains(Propverif)== false && found == true ) {
			found = false;
		for ( int i=0; i<BR.size(); i++) {
			r = BR.get(i);
			boolean flag = false;
			for(int j=0;j<r.getPremisse().length; j++) {
				String premisse = r.getPremisse()[j];
				if(BF.contains(premisse)==false) {
				flag = true;
				break;
				}
			}
			if(flag==false) {
				found=true;
				BF.add(r.getConclusion());
			    BR.remove(i);
			 	}
			}
		}
		if (BF.contains(Propverif)==true)
			return true;
		else {
			return false;
		}
	}
	public static boolean chainagearriere(ArrayList<RegleSimple> BR,ArrayList<String> BF, String Propverif) {
		boolean fin=true;
		boolean flag1 = true;
				if (BF.contains(Propverif)) {
					fin = true;
				}else {
					RegleSimple r=new RegleSimple();
					boolean flag = true;
						for ( int i=0; i<BR.size(); i++) {
							r = BR.get(i);
							if(Propverif.equals(r.getConclusion())==true ) {
								flag = false;
								Propverif=r.getPremisse();
							    MoteurInference.chainagearriere(BR, BF,Propverif);
							    break;
							}
						}
					if (flag==true){
						Scanner scan = new Scanner(System.in);
						System.out.println("We are having a problem finding it, are you sure about this? y/n ");
						String answer = scan.nextLine();
						if(answer.equals("y")) {
							fin = true;
						}else if(answer.equals("n")){
							fin = false;
						}
					}
				}
				flag1 = false;
				return fin;
	}
	public static boolean chainagearrierecom(ArrayList<RegleComposee> BR,ArrayList<String> BF, String Propverif) {
		boolean fin=true;
		boolean flag1 = true;
		RegleComposee r=new RegleComposee();
				if (BF.contains(Propverif)) {
					fin = true;
				}else {
					
					boolean flag = true;
						for ( int i=0; i<BR.size(); i++) {
							r = BR.get(i);
							if(Propverif.equals(r.getConclusion())==true ) {
								flag = false;
								for (int j=0; j<r.getPremisse().length; j++) {
									Propverif=r.getPremisse()[j];
									if (MoteurInference.chainagearrierecom(BR, BF,Propverif)==false) {
										flag = true;
										fin = false;
										break;
									}else {
										fin = true;
									}
								}
							}
						}
					if (flag==true){
						Scanner scan = new Scanner(System.in);
						System.out.println("We are having a problem finding it, are you sure about this? y/n ");
						String answer = scan.nextLine();
						if(answer.equals("y")) {
							BF.add(Propverif);
							fin = true;
						}else if(answer.equals("n")){
							fin = false;
						}
					}
				}
				flag1 = false;
				return fin;
	}
}

