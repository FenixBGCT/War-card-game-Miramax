import java.io.*;
import java.math.*;
import java.util.*;
public class Solution {
	public static void ubaciKarte(String karta,LinkedList<Integer> karte1){
 	    String r=karta.substring(0,karta.length()-1);
 	   switch(r){
            case "A":karte1.add(15);break;
            case "J":karte1.add(12);break;
            case "Q": karte1.add(13);break;
            case "K": karte1.add(14);break;
            default: karte1.add(Integer.parseInt(r));break;
        }
	}   
   
	 public static void main(String args[]) {
	        Scanner in = new Scanner(System.in);
	        long n = in.nextLong();
	        LinkedList<Integer> karte1=new LinkedList<Integer>();
	        for (int i = 0; i < n; i++){ 
	            Solution.ubaciKarte(in.next(),karte1);
	        } 
	        LinkedList<Integer> karte2=new LinkedList<Integer>();
	        long m = in.nextLong(); 
	        for (int j = 0; j < m; j++){
	            Solution.ubaciKarte(in.next(),karte2);
	        }
			in.close();
	        LinkedList <Integer> buffer1=new LinkedList<Integer>();
	        LinkedList <Integer> buffer2=new LinkedList<Integer>();
            boolean rat=false;
            int brojac=0;
            boolean pat=false;
	        while((!karte1.isEmpty())&&(!karte2.isEmpty())){
                if(!rat)brojac++;
                if(karte1.getFirst()>karte2.getFirst()){
                    rat=false;
                    buffer1.add(karte1.removeFirst()); 
                    buffer2.add(karte2.removeFirst());                    
                         for(int i=buffer1.size();i>0;i--){
                            karte1.add(buffer1.removeFirst());
                        }
                        for(int j=buffer2.size();j>0;j--){
                           karte1.add(buffer2.removeFirst());
                        }
                }
                else if (karte2.getFirst()>karte1.getFirst()) {
                    rat=false;
                    buffer1.add(karte1.removeFirst()); 
                    buffer2.add(karte2.removeFirst());
                    
                         for(int i=buffer1.size();i>0;i--){
                            karte2.add(buffer1.removeFirst());
                        }
                        for(int j=buffer2.size();j>0;j--){
                           karte2.add(buffer2.removeFirst());
                        }
                    
                } else {
                    rat=true;
                    buffer1.add(karte1.removeFirst());
                    buffer2.add(karte2.removeFirst());
                    if((karte1.size()<4 || karte2.size()<4)){                       
                      System.out.println("PAT");
                        pat=true;
                        break;
                    }
                    else{                       
                        buffer1.add(karte1.removeFirst());
                        buffer1.add(karte1.removeFirst());
                        buffer1.add(karte1.removeFirst());
                        
                        buffer2.add(karte2.removeFirst());
                        buffer2.add(karte2.removeFirst());
                        buffer2.add(karte2.removeFirst());
                        continue;
                    }
                }
            }
           if (karte1.size()!=0 && !pat) System.out.println("1 "+brojac);
           else if(karte2.size()!=0 && !pat)System.out.println("2 "+brojac);        
     }
}
