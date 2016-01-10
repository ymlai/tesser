import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.text.html.HTMLDocument.Iterator;
public class marks6 {
	public static void main(String[] args) { 
		TreeSet<Integer> target = new TreeSet<Integer>();
		TreeSet<Integer> current = new TreeSet<Integer>();
		LinkedList<Double> current_ave = new LinkedList<Double>();
		Boolean loop = true;
		double mean = 0, sd=0;
		long n=0,  n_win=0, current_n=0;
		for (int i=0; i<10 ;i++){
			loop=true;
			current = genFunction();
			target = genFunction();
		    while (loop){
			    n+=1;
			    current_n+=1;
			    if (not_win(current ,target)){
			    		current = genFunction();
			    }
			    if (!not_win(current ,target)){
				System.out.println(current+"="+target);				
				n_win+=1;
				System.out.println("no of winner:" +n_win);
				loop=false;
				System.out.println("current_n:"+current_n);
				current_ave.add((double) current_n);
				mean=n/n_win;
				System.out.println("mean:"+mean);
				sd = Math.sqrt( get_var(mean, current_ave )  );
				System.out.println("sd:"+sd);
				current_n=0;
				}
			}
		}
		System.out.println("============================");
		System.out.println("total player:"+n);
		System.out.println("total no of winner:"+n_win);
		System.out.println("mean:"+mean);
		System.out.println("sd:"+sd);
		}
	
	public static double get_var(double mean, LinkedList<Double> current_ave ) {
		double sample_x;
		double sum_diff_2 = 0;
		double diff;
		double diff_2, var;
		java.util.Iterator<Double> cur_n = current_ave.iterator();
		while(cur_n.hasNext()){
			sample_x = cur_n.next();	
			diff = (sample_x-mean);
			diff_2= Math.pow(diff,2);
			sum_diff_2+=diff_2;
			}
		var = sum_diff_2/(current_ave.size()-1);
		return var;
	}

	
	public static TreeSet<Integer> genFunction() {
		Random rng = new Random(); // Ideally just create one instance globally
		// Note: use LinkedHashSet to maintain insertion order
		TreeSet<Integer> generated = new TreeSet<Integer>();
		int numbersNeeded = 6 ;
		while (generated.size() < numbersNeeded){
		    int max = 49;
			Integer next = rng.nextInt(max) + 1;		
		    // As we're adding to a set, this will automatically do a containment check
		    generated.add(next);
			}
		//System.out.print(generated);
	    return generated; 
	   	}
	public static boolean not_win(TreeSet<Integer> target, TreeSet<Integer> current){
			java.util.Iterator<Integer> itr = current.iterator();
	        while ( itr.hasNext()) {
	        	    Integer element = itr.next();
	                if (!target.contains(element)){
	                	return true;
	                	}
	                }
	                current.iterator().next();
					return false;
					}
	}























