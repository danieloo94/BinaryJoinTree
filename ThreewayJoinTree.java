
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;


import java.util.Scanner;


public class ThreewayJoinTree {

			/*   
		     *                 [gmrB] B  
		     *          		  /    \
		     *    		[gmrC](B,C)  	[gmrR] R(A,B)
			 *      		
			 *      		/   \
			 *   [gmrS]S(B,C)    [gmrT]T(C,D)
			 *
			 *
			 */
			
			
			/*
			 * 
			 * GMR:
			 * 
			 * A GMR is a function that maps a record to the record's multiplicity. 
			 * 
			 * This can be implemented by means of a Hashmap<K,V> where:
			 * 	- K is the record type.
			 * 	- V is the multiplicity type. 
			 * 
			 * 
			 * The GMRs for each node is represented by a hashmap: 
			 * 
			 * For the B root node this is a hashmap from B-values to integers.
			 * For the C node this is a hashmap from (B,C) values to integers.
			 * 
			 * For the R node this is a hashmap from (A,B) values to integers.
			 * For the S node this is a hashmap from (B,C) values to integers.
			 * For the T node this is a hashmap from (C,D) values to integers.
			 * 
			 */
			
			public static HashMap<RecordS, Integer> gmrS = new HashMap<RecordS, Integer>();
			public static HashMap<RecordT, Integer> gmrT = new HashMap<RecordT, Integer>();
			public static HashMap<RecordR, Integer> gmrR = new HashMap<RecordR, Integer>();
			
			public static HashMap<RecordS, Integer> gmrC = new HashMap<RecordS, Integer>();
			
			public static HashMap<RecordB, Integer> gmrB = new HashMap<RecordB, Integer>();
			
			public static HashMap<RecordB, Integer> gmrZ = new HashMap<RecordB, Integer>();
			
			public static HashMap<RecordD, Integer> gmrD = new HashMap<RecordD, Integer>();
			
			
			
			
			//static HashMap<RecordD, Integer> gmrZ = new HashMap<RecordD, Integer>();
			static HashMap<RecordA, Integer> gmrA = new HashMap<RecordA, Integer>();

			/*
			 * RECORD:
			 * 
			 * Definition of Record classes.
			 * 
			 * 	- RecordA class has 1 field (A) of the correct type (int).
			 * 	- RecordB class has 1 field (B) of the correct type (int).
			 * 	- RecordC class has 1 field (C) of the correct type (int).
			 * 	- RecordD class has 1 field (D) of the correct type (int).
			 * 
			 * 	- RecordR class has 2 fields (A) and (B) of the correct type (int).
			 * 	- RecordS class has 2 fields (B) and (C) of the correct type (int).
			 * 	- RecordT class has 2 fields (C) and (D) of the correct type (int).
			 * 
			 */
			
			
			
			//RecordB
			public static class RecordB{
				
				private int b_value;
				
				public RecordB(int b_value) {
					super();
					this.b_value = b_value;
				}
				
				public int getB_value() {
					return b_value;
				}

				public void setB_value(int b_value) {
					this.b_value = b_value;
				}

				@Override
				public String toString() {
					return "[b_value: " + b_value + "]";
				}

				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + b_value;
					return result;
				}

				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (obj == null)
						return false;
					if (getClass() != obj.getClass())
						return false;
					RecordB other = (RecordB) obj;
					if (b_value != other.b_value)
						return false;
					return true;
				}	
				
			}
			
			
			
			//Record A
			public static class RecordA{
				
				private int a_value;
				
				public RecordA(int a_value) {
					super();
					this.a_value = a_value;
				}
				
				public int getA_value() {
					return a_value;
				}

				public void setA_value(int a_value) {
					this.a_value = a_value;
				}

				@Override
				public String toString() {
					return "[a_value: " + a_value + "]";
				}

				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + a_value;
					return result;
				}

				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (obj == null)
						return false;
					if (getClass() != obj.getClass())
						return false;
					RecordA other = (RecordA) obj;
					if (a_value != other.a_value)
						return false;
					return true;
				}				
			}
			
			
			
			//Record C
			public static class RecordC{

				private int c_value;

				public RecordC(int c_value) {
					super();
					this.c_value = c_value;
				}
				
				public int getC_value() {
					return c_value;
				}

				public void setC_value(int c_value) {
					this.c_value = c_value;
				}

				@Override
				public String toString() {
					return "[c_value: " + c_value + "]";
				}

				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + c_value;
					return result;
				}

				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (obj == null)
						return false;
					if (getClass() != obj.getClass())
						return false;
					RecordC other = (RecordC) obj;
					if (c_value != other.c_value)
						return false;
					return true;
				}	
			}
			
			
			
			//Record D --> New class in Ternary Join
			public static class RecordD{
				
				private int d_value;
				
				public RecordD(int d_value) {
					super();
					this.d_value = d_value;
				}
				
				public int getD_value() {
					return d_value;
				}

				public void setD_value(int d_value) {
					this.d_value = d_value;
				}

				@Override
				public String toString() {
					return "[d_value: " + d_value + "]";
				}

				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + d_value;
					return result;
				}

				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (obj == null)
						return false;
					if (getClass() != obj.getClass())
						return false;
					RecordD other = (RecordD) obj;
					if (d_value != other.d_value)
						return false;
					return true;
				}	
			}
			

			
			//RecordR
			public static class RecordR{
				
				private int a_value;
				private int b_value;
				
				public RecordR(int a_value, int b_value) {
					super();
					this.a_value = a_value;
					this.b_value = b_value;
				}

				public int getB_value() {
					return b_value;
				}

				public void setB_value(int b_value) {
					this.b_value = b_value;
				}

				public int getA_value() {
					return a_value;
				}

				public void setA_value(int a_value) {
					this.a_value = a_value;
				}

				 @Override 
				 public String toString() { return "[a_value=" + a_value +
				 ", b_value=" + b_value + "]"; }

				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + a_value;
					result = prime * result + b_value;
					return result;
				}

				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (obj == null)
						return false;
					if (getClass() != obj.getClass())
						return false;
					RecordR other = (RecordR) obj;
					if (a_value != other.a_value)
						return false;
					if (b_value != other.b_value)
						return false;
					return true;
				}		 
			}
			
			
			
			//Class RecordS
			public static class RecordS{
				
				private int b_value;
				private int c_value;
				
				public RecordS(int b_value, int c_value) {
					super();
					this.b_value = b_value;
					this.c_value = c_value;
				}

				public int getB_value() {
					return b_value;
				}

				public void setB_value(int b_value) {
					this.b_value = b_value;
				}

				public int getC_value() {
					return c_value;
				}

				public void setC_value(int c_value) {
					this.c_value = c_value;
				}

				@Override
				public String toString() {
					return "[b_value=" + b_value + ", c_value=" + c_value + "]";
				}

				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + b_value;
					result = prime * result + c_value;
					return result;
				}

				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (obj == null)
						return false;
					if (getClass() != obj.getClass())
						return false;
					RecordS other = (RecordS) obj;
					if (b_value != other.b_value)
						return false;
					if (c_value != other.c_value)
						return false;
					return true;
				}	
			}
			
			
			
			//Class RecordT --> New class in Ternary Join
			public static class RecordT{
				
				private int c_value;
				private int d_value;
				
				public RecordT(int c_value, int d_value) {
					super();
					this.c_value = c_value;
					this.d_value = d_value;
				}

				public int getC_value() {
					return c_value;
				}

				public void setC_value(int c_value) {
					this.c_value = c_value;
				}

				public int getD_value() {
					return d_value;
				}

				public void setD_value(int d_value) {
					this.d_value = d_value;
				}
				
				@Override
				public String toString() {
					return "[c_value=" + c_value + ", d_value=" + d_value + "]";
				}

				@Override
				public int hashCode() {
					final int prime = 31;
					int result = 1;
					result = prime * result + c_value;
					result = prime * result + d_value;
					return result;
				}

				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (obj == null)
						return false;
					if (getClass() != obj.getClass())
						return false;
					RecordT other = (RecordT) obj;
					if (c_value != other.c_value)
						return false;
					if (d_value != other.d_value)
						return false;
					return true;
				}
			}	
				
			
			
			/*
			 * INDEX:
			 * 
			 * For the interior nodes we need indexes. An index can be implemented by a HashMap<K,V> where:
			 * 
			 * 	- K = The type of the records that we need to look up.
			 * 	- V = The type of the values that we need to map to.
			 * 
			 * 	V = HashMap<RecordA, Integer>
			 * 	V = HashMap<RecordC, Integer>  
			 * 
			 */

			public static HashMap<RecordB, HashMap<RecordA, Integer> > indexR = new HashMap<RecordB, HashMap<RecordA, Integer>>();
			
			public static HashMap<RecordC, HashMap<RecordB, Integer> > indexS = new HashMap<RecordC, HashMap<RecordB, Integer>>();
			
			public static HashMap<RecordC, HashMap<RecordD, Integer> > indexT = new HashMap<RecordC, HashMap<RecordD, Integer>>();
			
			public static HashMap<RecordB, HashMap<RecordC, Integer> > indexGmrC = new HashMap<RecordB, HashMap<RecordC, Integer>>();
			
			 
	
			/*
			 * 	
			 * 	DELETIONS ON INDEXES:
			 * 
			 * 	Assume that I is an index that maps B-values to GMRs over A-values. 
			 * 	Then, to insert a tuple (a,b) to I we do the following:
			 * 
			 * 	- Lookup b in the corresponding hashmap to indexR.
			 *		- If b is not found in the hashmap:
			 *			- A new empty GMR needs to be created and the record (a) with multiplicity -1 needs to be added to it.
			 *  
			 *		- If b is found in the hashmap:
			 *			- Let I(b) be the associated GMR. Now we need to add (a) with multiplicity -1 to I(b).
			 *			
			 *				- if I(b) consisted only of (a), but the multiplicity of (a) was 1:
			 *					- Then deleting (a) actually gives you (a) with multiplicity (0).
			 *				  	  I(b) actually represents the empty GMR --> delete (b) and its value I(b) from the index altogether. 
			 *
			 *					- Otherwise, adding (a) with multiplicity -1 to I(b) can never make I(b) become empty, 
			 *					  and you simply need to add (a) to I(b).
			 */
			
			
			/*
			 * On insert (b,c) into S:
			 * 
			 * - Add the tuple to the GMR for S.
			 * - See if there is a tuple with C-value c in the GMR of T; if so, 
			 * 	 add the tuple with B and C-value to the gmrC (if it is not already present)
			 * - When (b,c) is added to gmrC you also need to check whether the B-value occurs in R(A,B) 
			 *   and, if so, insert b also into gmrB (if not already present).
			 *   
			 * ---> "bubble the updates all the way to the root of the tree".
			 */

			
			public static void onAddS (int b, int c) {
				
//		  		System.out.println("*************** New call to onAddS method ****************");
//		  		System.out.println("onAddS("+b+","+c+")");
//		  		System.out.println();
		  		
				RecordS record = new RecordS(b,c);
				RecordB record_B = new RecordB(b);
				RecordC record_C = new RecordC(c); 
		  
				//Check if the GMR of S contains the new record.
		  		boolean test = gmrS.containsKey(record);

		  		//Add the tuple to the GMR of S
			    if(test == true && (gmrS.get(record) >= 1 || gmrS.get(record) < -1)){
			    	//System.out.println("*********** We have found the key in the GMR *************");
			    	gmrS.replace(record,gmrS.get(record),gmrS.get(record)+1);	
			    }else if(test == true && gmrS.get(record) == -1){
			    	//System.out.println("************* Entry value is now 0 and we delete it **************");
			    	gmrS.remove(record);
			    }else{
			    	//System.out.println("******************** Key not found ***********************");
			    	gmrS.put(record, 1); 	
			    }
			    
//			    System.out.println("GMR S: "+ gmrS);
//				System.out.println();
			    
			    /*
			     * Add to the root:
			     * 
			     * See if there is a tuple with C-value c in the GMR of T; 
			     * if so, add B- value and C-value to the GMR root (if it is not already present)
			     * 
			     * 
			     * You need to be able to retrieve all D-values in T that have a given C-value 
			     * (necessary on insert(b,c) into S). You hence require an index
			     * 
			     */
				
				if(indexT.containsKey(record_C)) {
					//Calculate m, the number of d with (c,d) in T:
					int m = indexT.get(record_C).keySet().size();
					gmrC.put(record, m);
					//Index of gmrC:
					HashMap<RecordC, Integer> gmrC2 = new HashMap<RecordC, Integer>();
					gmrC2.put(record_C, gmrC.get(record));
					indexGmrC.put(record_B, gmrC2);
					//System.out.println("We find C-value c in indexT --> " + "gmrC: "+ gmrC + " indexGmrC: "+ indexGmrC);
				}
				

				//for(RecordT entry_t: gmrT.keySet()) {
					//if(entry_t.getC_value()==c) {
						//gmrC.put(record,gmrS.get(record));   
					//}
				//}
				
				/*
				 * 
				 * When (b,c) is added to gmrC you also need to check whether the 
				 * B-value occurs in R(A,B) and, if so, insert b also into gmrB 
				 * (if not already present).
				 * 
				 * You need to be able to retrieve all A-values in R that have a given B-value 
				 * (necessary on insert(b,c) into S when updates are propagated from gmrC). 
				 * 
				 */
				if(indexR.containsKey(record_B)) {
					gmrB.put(record_B, gmrS.get(record));
					//System.out.println("We find B-value c in indexR --> " + "gmrB: "+ gmrB);
				}
				
				/*
				 * Upload the index S
				 * 
				 */
				
				gmrZ = indexS.get(record_C);
			    
			    //System.out.println("Modification of index S: " + "" + record_C + "" +  " gmrZ: " + gmrZ);
			    
			    if (gmrZ != null) {
			    	// The key was found, gmrZ is its value
			    	if(gmrZ.containsKey(record_B) && gmrZ.get(record_B) == -1) {
			    		//System.out.println(" The multiplicity of (b) was -1, then adding (b) actually gives you (b) with multiplicity (0)");
			    		gmrZ.remove(record_B);
			    		if(indexS.get(record_C).isEmpty()) {
			    			indexS.remove(record_C);
			    		}
			    	}
			    	else {
				    	// Now insert into gmrZ
				    	gmrZ.put(record_B, gmrS.get(record));
				    	indexS.put(record_C, gmrZ);
				    	//System.out.println(gmrZ);
			    	}
			    } else {
			    	// The key was not found
			    	gmrZ = new HashMap<RecordB, Integer>();
			    	gmrZ.put(record_B, 1);
			    	//insert a into gmrZ with correct multiplicity
			    	indexS.put(record_C, gmrZ);
			    	}
			    
//			  System.out.println("The index S:" + indexS + " gmrZ: "+ gmrZ);
//			  System.out.println();
			  
				
			}
			
			
			
			public static void onDelS (int b, int c) {

//				System.out.println("*************** New call to onDelS method ****************");
//				System.out.println("onDelS("+b+","+c+")");
//		  		System.out.println();
				
				RecordS record = new RecordS(b,c);
				RecordB record_B = new RecordB(b);
				RecordC record_C = new RecordC(c); 
		  		
		  		boolean test = gmrS.containsKey(record);

			    if(test == true && (gmrS.get(record) > 1 || gmrS.get(record) <= -1)){
			    	//System.out.println("*********** We have found the key in the GMR *************");
			    	gmrS.replace(record,gmrS.get(record),gmrS.get(record)-1);	
			    }else if(test == true && gmrS.get(record) == 1){
			    	//System.out.println("************* Entry value is now 0 and we delete it **************");
			    	gmrS.remove(record);
			    }else{
			    	//System.out.println("******************** Key not found ***********************");
			    	gmrS.put(record, -1); 	
			    }
			    
//			    System.out.println("GMR S: "+ gmrS);
//				System.out.println();

				/*
				 * Upload the index
				 * 
				 */
				
				gmrZ = indexS.get(record_C);
			    
			    //System.out.println("Modification of index S: " + "" + record_C + " gmrZ: " + indexS.get(record_C));
			    
			    if (gmrZ != null) {
			    	// the key was found, gmrZ is its value
			    	if(gmrZ.containsKey(record_B) && gmrZ.get(record_B) == 1) {
			    		//System.out.println(" The multiplicity of (b) was 1, then deleting (b) actually gives you (b) with multiplicity (0)");
			    		gmrZ.remove(record_B);
			    		if(indexS.get(record_C).isEmpty()) {
			    			indexS.remove(record_C);
			    		}
			    	}
			    	else {
				    	// now insert into gmrZ
				    	gmrZ.put(record_B, gmrS.get(record));
				    	indexS.put(record_C, gmrZ);
				    	//System.out.println(gmrZ);
			    	}
			    	} else {
			    	// the key was not found
			    	gmrZ = new HashMap<RecordB, Integer>();
			    	gmrZ.put(record_B, -1);
			    	//insert a into gmrZ with correct multiplicity
			    	indexS.put(record_C, gmrZ);
			    	}
			    
//			    System.out.println("The index S: " + indexS + " gmrZ: " + gmrZ);
//			    System.out.println();
			    
			    /*
			     * Delete from the parent node and delete from the root
			     */
			    
			    if(!indexS.containsKey(record_C)) {
			    	//System.out.println("There is no key with value c in indexS");
			    	gmrC.remove(record);
			    	indexGmrC.remove(record_B);
			    	gmrB.remove(record_B);
//			    	System.out.println("gmrC: "+ gmrC + " indexGmrC: "+ indexGmrC);
//			    	System.out.println("gmrB: "+ gmrB);
			    }
			    
			    if(indexT.containsKey(record_C) && indexS.containsKey(record_C)) {
					gmrC.put(record, gmrS.get(record));
					HashMap<RecordC, Integer> gmrC2 = new HashMap<RecordC, Integer>();
					gmrC2.put(record_C, gmrS.get(record));
					indexGmrC.put(record_B, gmrC2);
					//System.out.println("We find C-value c in indexT --> " + "gmrC: "+ gmrC + " indexGmrC: "+ indexGmrC);
				}
				
				
				if(indexR.containsKey(record_B) && indexGmrC.containsKey(record_B)) {
					gmrB.put(record_B, gmrS.get(record));
					//System.out.println("We find B-value c in indexR --> " + "gmrB: "+ gmrB);
				}
			    
			   
			}
			
			
			
			//New method
			public static void onAddT (int c, int d){
				
//		  		System.out.println("*************** New call to onAddT method ****************");
//		  		System.out.println("onAddT("+c+","+d+")");
//		  		System.out.println();
		  		
				RecordT record = new RecordT(c,d);
			    RecordC record_C = new RecordC(c);
				RecordD record_D = new RecordD(d); 
		  		
		  		boolean test = gmrT.containsKey(record);
	 
			    if(test == true && (gmrT.get(record) >= 1 || gmrT.get(record) < -1)){
			    	//System.out.println("*********** We have found the key in the GMR *************");
			    	gmrT.replace(record,gmrT.get(record),gmrT.get(record)+1);	
			    }else if(test == true && gmrT.get(record) == -1){
			    	//System.out.println("************* Entry value is now 0 and we delete it **************");
			    	gmrT.remove(record);
			    }else{
			    	//System.out.println("******************** Key not found ***********************");
			    	gmrT.put(record, 1);
			    }
//			    System.out.println("GMR T: "+ gmrT);
//			    System.out.println();
			    
			    
			    /*
			     * Add to the parent node:
			     * 
			     * For every tuple (b,c) in S (in which the C-value hence equals the C-value inserted into T), 
			     * add (b,c) to the gmrC (if it is not already present)
			     * 
				 * You need to be able to retrieve all B-values in S that have a given C-value 
				 * (necessary on insert(c,d) into T).
				 * 
				 *
				 * When a (b,c) value is added to gmrC you also need to check 
				 * whether the B-value occurs in R(A,B) and, if so, insert b into gmrB 
				 * (if not already present)
				 * 
				 * 
				 *  You need to be able to retrieve all A-values in R that have a given B-value 
				 * (necessary on insert(c,d) into T) into S when updates are propagated from gmrC).
				 * 
			     * 
			     */
			    
			    //Si indexS contiene el mismo c:
			    if(indexS.containsKey(record_C)) {
				    for(RecordC entry: indexS.keySet()){
				    	if(entry.getC_value() == c) {
				    		for(RecordB entry2: indexS.get(entry).keySet()) {
				    			RecordS record_s = new RecordS(entry2.b_value,entry.c_value);
				    			gmrC.put(record_s, indexS.get(entry).get(entry2));
				    			HashMap<RecordC, Integer> gmrC2 = new HashMap<RecordC, Integer>();
				    			gmrC2.put(entry, indexS.get(entry).get(entry2));
				    			indexGmrC.put(entry2, gmrC2);		
				    			
				    			if(indexR.containsKey(entry2)) {
				    				gmrB.put(entry2, indexS.get(entry).get(entry2));	
				    			}
				    	   }
				    	}
				    }
				    
//				    System.out.println("We find C-value c in indexS --> " + "gmrC: "+ gmrC + " indexGmrC: "+ indexGmrC);
//				    System.out.println("We find B-value c in indexR --> " + "gmrB: "+ gmrB);
			    }
    	

			    //for(RecordS entry: gmrS.keySet()) {
			    	//if(entry.getC_value()==c) {
			    		//gmrC.put(entry,gmrS.get(entry));
			    		//if(gmrR.keySet().contains(entry.b_value)) {
			    			//int b = entry.getB_value();
			    			//RecordB b_element = new RecordB(b);
			    			//gmrB.put(b_element, gmrS.get(entry));
			    			//}
			    	//}
			    //}
				
				
			    /*
				 * Upload the index
				 * 
				 */
			     
			    gmrD = indexT.get(record_C);
			    
			    //System.out.println("Modification of index T: " + "" + record_C + " gmrD: " + indexT.get(record_C));
			    
			    if (gmrD != null) {
			    	// the key was found, gmrD is its value
			    	if(gmrD.containsKey(record_D) && gmrD.get(record_D) == -1) {
			    		//System.out.println(" The multiplicity of (c) was -1, then deleting (c) actually gives you (c) with multiplicity (0)");
			    		gmrD.remove(record_D);
			    		if(indexT.get(record_C).isEmpty()) {
			    			indexT.remove(record_C);
			    		}
			    		
			    	}
			    	else {
				    	// now insert into gmrD
				    	gmrD.put(record_D, gmrT.get(record));
				    	indexT.put(record_C, gmrD);
				    	//System.out.println(gmrD);
			    	}
			    	} else {
			    	// the key was not found
			    	gmrD = new HashMap<RecordD, Integer>();
			    	gmrD.put(record_D, 1);
			    	indexT.put(record_C, gmrD);
			    	}	
			    
//			    System.out.println("The index T: " + "" + indexT + " gmrD: " + gmrD);
//			    System.out.println();
			    
			    

			}
			
			
			
			//New method
			public static void onDelT (int c, int d) {
				
//		  		System.out.println("*************** New call to onDelT method ****************");
//		  		System.out.println("onDelT("+c+","+d+")");
//		  		System.out.println();
		  		
				RecordT record = new RecordT(c,d);
				RecordC record_C = new RecordC(c);
				RecordD record_D = new RecordD(d); 
		  		
		  		boolean test = gmrT.containsKey(record);

			    if(test == true && (gmrT.get(record) > 1 || gmrT.get(record) <= -1)){
			    	gmrT.replace(record,gmrT.get(record),gmrT.get(record)-1);	
			    }else if(test == true && gmrT.get(record) == 1){
			    	gmrT.remove(record);
			    }else{
			    	gmrT.put(record, -1); 	
			    }
//			    System.out.println("GMR T: "+ gmrT);
//				System.out.println();
				
				
				/*
				 * Upload the index
				 * 
				 */
				
				gmrD = indexT.get(record_C);
				    
				//System.out.println("Modification of index T: " + "" + record_C + " gmrD: " + indexT.get(record_C));
				    
				if (gmrD != null) {
				// the key was found, gmrD is its value
				    if(gmrD.containsKey(record_D) && gmrD.get(record_D) == 1) {
				    	//System.out.println(" The multiplicity of (d) was 1, then deleting (d) actually gives you (d) with multiplicity (0)");
				    	gmrD.remove(record_D);
				    	if(indexT.get(record_C).isEmpty()) {
			    			indexT.remove(record_C);
			    		}
				    }
				    else {
					    // now insert into gmrD
				    	gmrD.put(record_D, gmrT.get(record));
				    	indexT.put(record_C, gmrD);
				    }
				} else {
				    // the key was not found
				    gmrD = new HashMap<RecordD, Integer>();
				    gmrD.put(record_D, -1);
				    //insert a into gmrD with correct multiplicity
				    indexT.put(record_C, gmrD);
				    }
				
//				System.out.println("The index T: " + indexT + " gmrD: " + gmrD);
//				System.out.println();
//				
				
				/*
			     * Delete from the parent node and delete from the root
			     */
			    if(!indexT.containsKey(record_C)) {
			    	//System.out.println("There is no key with value c in indexT");
			    	for(RecordC entry: indexS.keySet()){
				    	if(entry.getC_value() == c) {
				    		for(RecordB entry2: indexS.get(entry).keySet()) {
				    			RecordS record_s = new RecordS(entry2.b_value,entry.c_value);
				    			gmrC.remove(record_s);
				    			indexGmrC.remove(entry2);
				    			
				    			if(indexR.containsKey(entry2)) {
				    				gmrB.remove(entry2);	
				    			}
				    		}
				    	}
			    	}
			    	
//			    	 System.out.println("We find C-value c in indexS --> " + "gmrC: "+ gmrC + " indexGmrC: "+ indexGmrC);
//					 System.out.println("We find B-value c in indexR --> " + "gmrB: "+ gmrB);
			    }
			    
			    
			    //Si indexS contiene el mismo c:
			    if(indexS.containsKey(record_C) && indexT.containsKey(record_C)) {
				    for(RecordC entry: indexS.keySet()){
				    	if(entry.getC_value() == c) {
				    		for(RecordB entry2: indexS.get(entry).keySet()) {
				    			RecordS record_s = new RecordS(entry2.b_value,entry.c_value);
				    			gmrC.put(record_s, indexS.get(entry).get(entry2));
				    			HashMap<RecordC, Integer> gmrC2 = new HashMap<RecordC, Integer>();
				    			gmrC2.put(entry, indexS.get(entry).get(entry2));
				    			indexGmrC.put(entry2, gmrC2);		
				    			
				    			if(indexR.containsKey(entry2)) {
				    				gmrB.put(entry2, indexS.get(entry).get(entry2));	
				    			}
				    	   }
				    	}
				    }
				    
//				    System.out.println("We find C-value c in indexS --> " + "gmrC: "+ gmrC + " indexGmrC: "+ indexGmrC);
//				    System.out.println("We find B-value c in indexR --> " + "gmrB: "+ gmrB);
			    }
			    
			
			}

			
			
			public static void onAddR (int a, int b){
				
//		  		System.out.println("*************** New call to onAddR method ****************");
//		  		System.out.println("onAddR("+a+","+b+")");
//		  		System.out.println();
		  		
				RecordR record = new RecordR(a,b);
			    RecordB record_B = new RecordB(b);
				RecordA record_A = new RecordA(a); 
		  		
		  		boolean test = gmrR.containsKey(record);
	 
			    if(test == true && (gmrR.get(record) >= 1 || gmrR.get(record) < -1)){
			    	//System.out.println("*********** We have found the key in the GMR *************");
			    	gmrR.replace(record,gmrR.get(record),gmrR.get(record)+1);	
			    }else if(test == true && gmrR.get(record) == -1){
			    	//System.out.println("************* Entry value is now 0 and we delete it **************");
			    	gmrR.remove(record);
			    }else{
			    	//System.out.println("******************** Key not found ***********************");
			    	gmrR.put(record, 1); 	
			    }
			    //System.out.println();
			     
			    
				/*
				 * Update the index
				 */
			    
			    gmrA = indexR.get(record_B);
			    
			    //System.out.println("Modification of index R: " + "" + record_B + " gmrA: " + indexR.get(record_B));
			    
			    if (gmrA != null) {
			    	// the key was found, gmrA is its value
			    	if(gmrA.containsKey(record_A) && gmrA.get(record_A) == -1) {
			    		//System.out.println(" The multiplicity of (a) was -1, then adding (a) actually gives you (a) with multiplicity (0)");
			    		gmrA.remove(record_A);
			    		if(indexR.get(record_B).isEmpty()) {
			    			indexR.remove(record_B);
			    		}
			    	}
			    	else {
				    	// now insert into gmrA
				    	gmrA.put(record_A, gmrR.get(record));
				    	indexR.put(record_B, gmrA);
			    	}
			    	} else {
			    	// the key was not found
			    	gmrA = new HashMap<RecordA, Integer>();
			    	gmrA.put(record_A, 1);
			    	//insert a into gmrA with correct multiplicity
			    	indexR.put(record_B, gmrA);
			    	}
			    
//			    System.out.println("The index R: " + "" + indexR + " gmrA: " + gmrA);
//			    System.out.println();
			    
			   
			    /*
			     * Add to gmrB:
			     * 
			     * See if there is a tuple with B-value b in the gmrC; 
			     * if so, add B-value b to the GMR root.
			     * (if it is not already present)
			     * 
			     */
			    
			    
			    //Modificado
			    
			    if(indexGmrC.containsKey(record_B)) {
			    	
			    	int m1 = 0;
			    	int m2 = 0;
			
			    	for(RecordB entry: indexGmrC.keySet()){
				    	if(entry.getB_value() == b) {
				    		for(RecordC entry2: indexGmrC.get(entry).keySet()) {
				    			m1 += indexGmrC.get(entry).get(entry2);
				    		}
				    	}
				    }
			    	
			    	for(RecordB entry:indexR.keySet()) {
			    		if(entry.getB_value() == b) {
				    		for(RecordA entry2: indexR.get(entry).keySet()) {
				    			m1 += indexR.get(entry).get(entry2);
				    		}	
			    		}
			    	}
			    	
			    	gmrB.put(record_B, m1*m2); 
			    }   
			}
			
			
			
			public static void onDelR (int a, int b) {
				
//		  		System.out.println("*************** New call to onDelR method ****************");
//		  		System.out.println("onDelR("+a+","+b+")");
//		  		System.out.println();
		  		
				RecordR record = new RecordR(a,b);
				RecordB record_B = new RecordB(b);
				RecordA record_A = new RecordA(a); 
		  		
		  		boolean test = gmrR.containsKey(record);

			    if(test == true && (gmrR.get(record) > 1 || gmrR.get(record) < -1)){
			    	//System.out.println("*********** We have found the key in the GMR *************");
			    	gmrR.replace(record,gmrR.get(record),gmrR.get(record)-1);	
			    }else if(test == true && gmrR.get(record) == 1){
			    	//System.out.println("************* Entry value is now 0 and we delete it **************");
			    	gmrR.remove(record);
			    }else{
			    	//System.out.println("******************** Key not found ***********************");
			    	gmrR.put(record, -1); 	
			    }	
				//System.out.println();
				
				
				/*
				 * Update the index
				 */
				
				gmrA = indexR.get(record_B);
			    
			    //System.out.println("Modification of index R: " + record_B + " gmrA: " + indexR.get(record_B));
			    
			    if (gmrA != null) {
			    	// the key was found, gmrA is its value
			    	if(gmrA.containsKey(record_A) && gmrA.get(record_A) == 1) {
			    		//System.out.println(" The multiplicity of (a) was -1, then adding (a) actually gives you (a) with multiplicity (0)");
			    		gmrA.remove(record_A);
			    		if(indexR.get(record_B).isEmpty()) {
			    			indexR.remove(record_B);
			    		}
			    	}
			    	else {
				    	// now insert into gmrA
				    	gmrA.put(record_A,gmrR.get(record));
				    	indexR.put(record_B, gmrA);
				    	//System.out.println(gmrA);
			    	}
			    }else {
			    	// the key was not found
			    	gmrA = new HashMap<RecordA, Integer>();
			    	gmrA.put(record_A, -1);
			    	//insert a into gmrA with correct multiplicity
			    	indexR.put(record_B, gmrA);
			    	}
			    
//			    System.out.println("The index R: " + indexR + " gmrA: " + gmrA);
//			    System.out.println();
			    
			    
			    /*
			     * Delete from gmrB:
			     * 
			     * Deal with deletions from gmrB
			     */
				
				if(!indexR.containsKey(record_B)) {
					gmrB.remove(record_B);
				}
				
				//Modificado
			    
			    if(indexGmrC.containsKey(record_B)) {
			    	
			    	int m1 = 0;
			    	int m2 = 0;
			
			    	for(RecordB entry: indexGmrC.keySet()){
				    	if(entry.getB_value() == b) {
				    		for(RecordC entry2: indexGmrC.get(entry).keySet()) {
				    			m1 += indexGmrC.get(entry).get(entry2);
				    		}
				    	}
				    }
			    	
			    	for(RecordB entry:indexR.keySet()) {
			    		if(entry.getB_value() == b) {
				    		for(RecordA entry2: indexR.get(entry).keySet()) {
				    			m1 += indexR.get(entry).get(entry2);
				    		}	
			    		}
			    	}
			    	
			    	gmrB.put(record_B, m1*m2); 
			    }
			    
			}

			
			
			public static File file1 = new File("/Users/danap/Desktop/prueba_final_ternary.txt");
			
			public static void functions(File file) throws FileNotFoundException {
				
				try (Scanner scan = new Scanner(file)) {
					while(scan.hasNextLine()){
					String line = scan.nextLine();
						if(line.startsWith("onAddT")){
							String int1 = line.substring(7,9);
							String int2 = line.substring(10,12); ;
							int1.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int2.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int numEntero1 = Integer.parseInt(int1);
							int numEntero2 = Integer.parseInt(int2);
							onAddT(numEntero1,numEntero2);
						}if(line.startsWith("onDelT")){
							String int1 = line.substring(7,9);
							String int2 = line.substring(10,12); ;
							int1.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int2.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int numEntero1 = Integer.parseInt(int1);
							int numEntero2 = Integer.parseInt(int2);
							onDelT(numEntero1,numEntero2);	
						}if(line.startsWith("onAddS")){
							String int1 = line.substring(7,9);
							String int2 = line.substring(10,12); ;
							int1.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int2.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int numEntero1 = Integer.parseInt(int1);
							int numEntero2 = Integer.parseInt(int2);
							onAddS(numEntero1,numEntero2);
						}if(line.startsWith("onDelS")){
							String int1 = line.substring(7,9);
							String int2 = line.substring(10,12); ;
							int1.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int2.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int numEntero1 = Integer.parseInt(int1);
							int numEntero2 = Integer.parseInt(int2);
							onDelS(numEntero1,numEntero2);
						}if(line.startsWith("onAddR")){
							String int1 = line.substring(7,9);
							String int2 = line.substring(10,12); ;
							int1.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int2.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int numEntero1 = Integer.parseInt(int1);
							int numEntero2 = Integer.parseInt(int2);
							onAddR(numEntero1,numEntero2);
						}if(line.startsWith("onDelR")){
							String int1 = line.substring(7,9);
							String int2 = line.substring(10,12); ;
							int1.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int2.replaceAll("[^0-1-2-3-4-5-6-7-8-9]", "");
							int numEntero1 = Integer.parseInt(int1);
							int numEntero2 = Integer.parseInt(int2);
							onDelR(numEntero1,numEntero2);
						}		
					}
				}
			}
			
			public static void enumeration() {
				
				//System.out.println("*********************** Enumeration **********************");
				
				for(Entry<RecordB, Integer> root_node: gmrB.entrySet()) {
					RecordB b = root_node.getKey();
						HashMap<RecordA,Integer> a = indexR.get(b);
							HashMap<RecordC,Integer> c = indexGmrC.get(b);
							
							for(RecordC entry: c.keySet()) {
									HashMap<RecordD,Integer> d = indexT.get(entry);

							System.out.println("[ a: " + a + " b: " + b + " c: " + c + " d: "+ d + "]" + " = " + gmrB.get(b));
							
							
							}
				}
						
			}
					
		
		public static void main(String[] args) throws FileNotFoundException {
			
			
			/* 
			 * Read from prueba_final_ternary.txt 
			 */
		
		
			functions(file1);
			enumeration();
			
//			System.out.println("********************* GMR for table S ********************");
//			System.out.println();
//				for(Entry <RecordS, Integer> entry: gmrS.entrySet()) {
//					System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//				}
//			System.out.println();
//				
//			System.out.println("********************* GMR for table T ********************");
//			System.out.println();
//				
//				for(Entry <RecordT, Integer> entry: gmrT.entrySet()) {
//					System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//				}	
//			System.out.println();
//			
//			System.out.println("********************* Internal Node (B,C) ********************");
//			
//			System.out.println();
//			
//			for(Entry <RecordS, Integer> entry: gmrC.entrySet()) {
//				System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//			}
//			
//			System.out.println();
//			
//			System.out.println("********************* GMR for table R ********************");
//			System.out.println();
//				
//				for(Entry <RecordR, Integer> entry: gmrR.entrySet()) {
//					System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//				}	
//			System.out.println();
//			
//			
//			System.out.println("*********************** Root Node (B) **********************");
//			
//			System.out.println();
//			
//			for(Entry <RecordB, Integer> entry: gmrB.entrySet()) {
//				System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//			}	
//			
//			System.out.println();
//			
//
//			System.out.println("********************* index S ********************");
//			System.out.println();
//				
//				for(Entry <RecordC, HashMap<RecordB, Integer> > entry: indexS.entrySet()) {
//					System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//				}	
//			System.out.println();
//			
//			System.out.println("********************* index T ********************");
//			System.out.println();
//				
//				for(Entry <RecordC, HashMap<RecordD, Integer> > entry: indexT.entrySet()) {
//					System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//				}	
//			System.out.println();
//			
//			System.out.println("********************* index R ********************");
//			System.out.println();
//				
//				for(Entry <RecordB, HashMap<RecordA, Integer> > entry: indexR.entrySet()) {
//					System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//				}	
//			System.out.println();
//			
//			System.out.println("********************* index gmrC ********************");
//			System.out.println();
//				
//				for(Entry <RecordB, HashMap<RecordC, Integer> > entry: indexGmrC.entrySet()) {
//					System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//				}	
//			System.out.println();
			
			
			
		}

	}




