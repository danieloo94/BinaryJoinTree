
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;



public class TwowayJoinTree {
		
		
		/*
		 *        B
	     *    /        \
	     *
	     *  R(A,B)    S(B,C)
		 *
		 */
		
		
		/*
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
		 * 
		 */
	
		
	
		static HashMap<RecordA, Integer> gmrA = new HashMap<RecordA, Integer>();
		static HashMap<RecordB, Integer> gmrB = new HashMap<RecordB, Integer>();
		static HashMap<RecordC, Integer> gmrC = new HashMap<RecordC, Integer>();
		static HashMap<RecordR, Integer> gmrR = new HashMap<RecordR, Integer>();
		static HashMap<RecordS, Integer> gmrS = new HashMap<RecordS, Integer>();
		
	
		
		/*
		 * RECORD:
		 * 
		 * Definition of Record classes.
		 * 
		 * 	- RecordA class has 1 field (A) of the correct type (int).
		 * 	- RecordB class has 1 field (B) of the correct type (int).
		 * 	- RecordC class has 1 field (C) of the correct type (int).
		 * 
		 * 	- RecordR class has 2 fields (A) and (B) of the correct type (int).
		 * 	- RecordS class has 2 fields (B) and (C) of the correct type (int).
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
		

		static HashMap<RecordB, HashMap<RecordA, Integer> > indexR = new HashMap<RecordB, HashMap<RecordA, Integer>>();
		static HashMap<RecordB, HashMap<RecordC, Integer> > indexS = new HashMap<RecordB, HashMap<RecordC, Integer>>();
		
		
		
		/* 
		 * 	INSERTIONS:
		 * 
		 * 	(OnAddR and OnAddS)
		 * 
		 *	- If the key was already present with value v (which is a multiplicity, i.e., an integer).
		 *		- Then we modify v to become v + 1.
		 * 			- If v+1 ==0 then the multiplicity of (a,b) in X was -1 
		 * 			  and has become zero with the addition. 
		 * 				- remove key (a,b) or (b,c) altogether from the hashmap's set of keys.
		 * 
		 * 	- If this key was not present:
		 * 		- Insert (a,b) or (b,c) into the hashmap with value v = 1.(The addition sets the value to 1).
		 * 
		 * 	
		 * 
		 * 	INSERTIONS ON INDEXES:
		 * 
		 * 	Assume that I is an index that maps B-values to GMRs over A-values. 
		 * 	Then, to insert a tuple (a,b) to I we do the following:
		 * 
		 * - Lookup b in the corresponding hashmap to indexR.
		 *		- If b is not found in the hashmap:
		 *			- A new empty GMR needs to be created and the record (a) with multiplicity 1 needs to be added to it.
		 *  
		 *		- If b is found in the hashmap:
		 *			- Let I(b) be the associated GMR. Now we need to add (a) with multiplicity 1 to I(b).
		 *			
		 *				- if I(b) consisted only of (a), but the multiplicity of (a) was -1:
		 *					- Then adding (a) actually gives you (a) with multiplicity (0).
		 *				  	  I(b) actually represents the empty GMR --> delete (b) and its value I(b) from the index altogether. 
		 *
		 *					- Otherwise, adding (a) with multiplicity 1 to I(b) can never make I(b) become empty, 
		 *					  and you simply need to add (a) to I(b).			
		 */


		 
		/* 
		 * 	DELETIONS:
		 * 
		 * 	(OnDelR and OnDelS)
		 * 
		 *	- If the key was already present with value v (which is a multiplicity, i.e., an integer).
		 *		- Then we modify v to become v - 1.
		 * 			- If v-1 ==0 then the multiplicity of (a,b) in X was -1 
		 * 			  and has become zero with the addition. 
		 * 				- Remove (a,b) or (b,c) altogether from the hashmap's set of keys.
		 * 
		 * 	- If this key was not present:
		 * 		- Insert (a,b) or (b,c) into the hashmap with value v = -1.(negative number).
		 * 
		 *
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

		
			
		
		public static void onAddR (int a, int b){
			
	  		//System.out.println("*************** New call to onAddR method ****************");
	  		//System.out.println("onAddR("+ a+","+b+")");
	  		//System.out.println();
	  		
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
		    //System.out.println( "GMR R: "+ gmrR);
		    //System.out.println();
		    
		    gmrA = indexR.get(record_B);
		    
		    //System.out.println("Modificaci�n de index: " + "" + record_B + " " + gmrA);
		    
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
			    	//System.out.println(gmrA);
		    	}
		    	} 
		    	else {
		    	// the key was not found
		    	gmrA = new HashMap<RecordA, Integer>();
		    	gmrA.put(record_A, 1);
		    	//System.out.println(gmrA);
		    	//Insert a into gmrA with correct multiplicity
		    	indexR.put(record_B, gmrA);
		    	}
		    
		    //System.out.println(indexR);
		    //System.out.println();
			
		    /*
		     * Add to gmrB:
		     * 
		     * See if there is a tuple with B-value b in the GMR of S; 
		     * if so, add B-value b to the GMR root (if it is not already present)
		     * 
		     */
		    
		    
			if(indexS.containsKey(record_B) && indexR.containsKey(record_B)) {
				Integer m1 = 0;
				Integer m2 = 0;
				for(Entry<RecordC, Integer> entry: indexS.get(record_B).entrySet()) {
					m1 += entry.getValue();
				}
				for(Entry<RecordA, Integer> entry2: indexR.get(record_B).entrySet()) {
					m2 += entry2.getValue();
				}
					gmrB.put(record_B, m1*m2);	
			}
			
		}
		
		
		
		public static void onDelR (int a, int b) {
			
	  		//System.out.println("*************** New call to onDelR method ****************");
	  		//System.out.println("onDelR("+ a+","+b+")");
	  		//System.out.println();
	  		
			RecordR record = new RecordR(a,b);
			RecordB record_B = new RecordB(b);
			RecordA record_A = new RecordA(a); 
	  		
	  		boolean test = gmrR.containsKey(record);

		    if(test == true && (gmrR.get(record) > 1 || gmrR.get(record) <= -1)){
		    	//System.out.println("*********** We have found the key in the GMR *************");
		    	gmrR.replace(record,gmrR.get(record),gmrR.get(record)-1);	
		    }else if(test == true && gmrR.get(record) == 1){
		    	//System.out.println("************* Entry value is now 0 and we delete it **************");
		    	gmrR.remove(record);
		    }else{
		    	//System.out.println("******************** Key not found ***********************");
		    	gmrR.put(record, -1); 	
		    }
		    
		    //System.out.println("GMR R: " + gmrR);
	  		//System.out.println();
			
		
			gmrA = indexR.get(record_B);
		    
		    //System.out.println("Modificaci�n de index: " + "" + record_B + " " + gmrA);
		    
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
		    	//Insert a into gmrA with correct multiplicity
		    	indexR.put(record_B, gmrA);
		    	//System.out.println(gmrA);
		    	}
		    
		    //System.out.println(indexR);
		    //System.out.println();
		    
		    
		    /*
		     * Delete from gmrB:
		     * 
		     * Deal with deletions from gmrB
		     */
			
			if(!indexR.containsKey(record_B)) {
				gmrB.remove(record_B);
			}
			
			/*
		     * Add to gmrB:
		     * 
		     * See if there is a tuple with B-value b in the GMR of S; 
		     * if so, add B-value b to the GMR root (if it is not already present)
		     * 
		     */
		    
		    
			if(indexS.containsKey(record_B) && indexR.containsKey(record_B)) {
				Integer m1 = 0;
				Integer m2 = 0;
				for(Entry<RecordC, Integer> entry: indexS.get(record_B).entrySet()) {
					m1 += entry.getValue();
				}
				for(Entry<RecordA, Integer> entry2: indexR.get(record_B).entrySet()) {
					m2 += entry2.getValue();
				}
					gmrB.put(record_B, m1*m2);	
			}
		
		}
		
		
		
		public static void onAddS (int b, int c) {
			
	  		//System.out.println("*************** New call to onAddS method ****************");
			//System.out.println("onAddS("+ b+","+c+")");
			//System.out.println();
	  		
		  	RecordS record = new RecordS(b,c);
			RecordB record_B = new RecordB(b);
			RecordC record_C = new RecordC(c); 
	  
	  		boolean test = gmrS.containsKey(record);

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
		    
		    //System.out.println("GMR S: "+ gmrS);
		    //System.out.println();
		 
			gmrC = indexS.get(record_B);
		    
			//System.out.println("Modificaci�n de index: " + "" + record_B + "" + gmrC);
		    
		    if (gmrC != null) {
		    	// the key was found, gmrA is its value
		    	if(gmrC.containsKey(record_C) && gmrC.get(record_C) == -1) {
		    		//System.out.println(" The multiplicity of (a) was -1, then adding (a) actually gives you (a) with multiplicity (0)");
		    		gmrC.remove(record_C);
		    		if(indexS.get(record_B).isEmpty()) {
		    			indexS.remove(record_B);
		    		}
		    	}
		    	else {
			    	// now insert into gmrA
			    	gmrC.put(record_C, gmrS.get(record));
			    	indexS.put(record_B, gmrC);
			    	//System.out.println(gmrC);
		    	}
		    } else {
		    	// the key was not found
		    	gmrC = new HashMap<RecordC, Integer>();
		    	gmrC.put(record_C, 1);
		    	//insert a into gmrA with correct multiplicity
		    	indexS.put(record_B, gmrC);
		    	//System.out.println(gmrC);
		    	}
		    
		    //System.out.println(indexS);
		    //System.out.println();
		    
		    /*
		     * Add to gmrB:
		     * 
		     * See if there is a tuple with B-value b in the GMR of S; 
		     * if so, add B-value b to the GMR root (if it is not already present)
		     * 
		     */ 
			 
			if(indexR.containsKey(record_B) && indexS.containsKey(record_B)) {
				Integer m1 = 0;
				Integer m2 = 0;
				
				for(Entry<RecordA, Integer> entry2: indexR.get(record_B).entrySet()) {
					m2 += entry2.getValue();
				}
				for(Entry<RecordC, Integer> entry: indexS.get(record_B).entrySet()) {
					m1 += entry.getValue();
				}
					gmrB.put(record_B, m1*m2);	
			}
		
		}
		
		
		
		public static void onDelS (int b, int c) {

			//System.out.println("*************** New call to onDelS method ****************");
			//System.out.println("onDelS("+ b+","+c+")");
			//System.out.println();
			
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
		    //System.out.println("GMR S: "+ gmrS);
		    //System.out.println();
			
			
			
			gmrC = indexS.get(record_B);
		    
			//System.out.println("Modificaci�n de index: " + "" + record_B + "" + indexR.get(record_B));
		    
		    if (gmrC != null) {
		    	// the key was found, gmrA is its value
		    	if(gmrC.containsKey(record_C) && gmrC.get(record_C) == 1) {
		    		//System.out.println(" The multiplicity of (a) was 1, then deleting (a) actually gives you (a) with multiplicity (0)");
		    		gmrC.remove(record_C);
		    		if(indexS.get(record_B).isEmpty()) {
		    			indexS.remove(record_B);
		    		}
		    	}
		    	else {
			    	// now insert into gmrA
			    	gmrC.put(record_C, gmrS.get(record));
			    	indexS.put(record_B, gmrC);
			    	//System.out.println(gmrC);
		    	}
		    	} else {
		    	// the key was not found
		    	gmrC = new HashMap<RecordC, Integer>();
		    	gmrC.put(record_C, -1);
		    	//insert a into gmrA with correct multiplicity
		    	indexS.put(record_B, gmrC);
		    	//System.out.println(gmrC);
		    	}
		    
		    //System.out.println(indexS);
		    //System.out.println();
		    
		    /*
		     * Delete from gmrB:
		     * 
		     * Deal with deletions from gmrB
		     */
			
			if(!indexS.containsKey(record_B)) {
				gmrB.remove(record_B);
			}
			
			/*
		     * Add to gmrB:
		     * 
		     * See if there is a tuple with B-value b in the GMR of S; 
		     * if so, add B-value b to the GMR root (if it is not already present)
		     * 
		     */ 
			 
			if(indexR.containsKey(record_B) && indexS.containsKey(record_B)) {
				Integer m1 = 0;
				Integer m2 = 0;
				
				for(Entry<RecordA, Integer> entry2: indexR.get(record_B).entrySet()) {
					m2 += entry2.getValue();
				}
				
				for(Entry<RecordC, Integer> entry: indexS.get(record_B).entrySet()) {
					m1 += entry.getValue();
				}
					gmrB.put(record_B, m1*m2);	
			}
			
		}
		
		

		
		public static void enumeration() {
			
			//System.out.println("*********************** Enumeration **********************");
			
			for(Entry<RecordB, Integer> root_node: gmrB.entrySet()) {
				RecordB b = root_node.getKey();
				
				
					for(RecordA entry: indexR.get(b).keySet()) {
						RecordA a = entry;
					
						
							for(RecordC entry2: indexS.get(b).keySet()) {
								RecordC c = entry2;
					
								System.out.println("{ a: " + a + " b: " + b + " c: " + c + " }" + "=" + gmrB.get(b));
							}
					}
			}	
		}
				
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		 
//		System.out.println("********************* GMR for table R ********************");
//		System.out.println();
//			for(Entry <RecordR, Integer> entry: gmrR.entrySet()) {
//				System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//			}
//		System.out.println();
//			
//		System.out.println("********************* GMR for table S ********************");
//		System.out.println();
//			for(Entry <RecordS, Integer> entry: gmrS.entrySet()) {
//				System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//			}	
//		System.out.println();
//			
		
//			
//	    System.out.println();
//		System.out.println("**********************************************************");
//		System.out.println("**********************************************************");
//		System.out.println();
//		
//		
//		
//		System.out.println("************************ Index R *************************");
//	    System.out.println();
//		System.out.println(indexR);
//		System.out.println();
//		
//		System.out.println("************************ Index S *************************");
//	    System.out.println();
//		System.out.println(indexS);
//		System.out.println();
//		
		
		/* 
		 * Read from final_update.txt 
		 */
		

			File file1 = new File("/Users/Desktop/updates.txt");
			
			Scanner scan = new Scanner(file1);
		
			while(scan.hasNextLine()){
			String line = scan.nextLine();
				if(line.startsWith("onAddR")){
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
				}		
			}		
		
		enumeration();
		

//		
//		System.out.println("************************** gmrB **************************");
//		System.out.println();
//			for(Entry <RecordB, Integer> entry: gmrB.entrySet()) {
//				System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//			}
//			
//		System.out.println("********************* GMR for table R ********************");
//		System.out.println();
//			for(Entry <RecordR, Integer> entry: gmrR.entrySet()) {
//				System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//			}	
//			
//		System.out.println("************************* Index R ************************");
//		System.out.println();
//			for(Entry <RecordB, HashMap<RecordA,Integer>> entry: indexR.entrySet()) {
//				System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//			}
//				
//		System.out.println("********************* GMR for table S ********************");
//		System.out.println();
//			for(Entry <RecordS, Integer> entry: gmrS.entrySet()) {
//				System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//			}
//			
//		System.out.println("************************* Index S ************************");
//		System.out.println();
//			for(Entry <RecordB, HashMap<RecordC,Integer>> entry: indexS.entrySet()) {
//				System.out.println(entry.getKey() + " ---> " + "[multiplicity: "+entry.getValue()+"]");
//			}
//			
//		System.out.println();
//			
		//enumeration();
		
	}

}
