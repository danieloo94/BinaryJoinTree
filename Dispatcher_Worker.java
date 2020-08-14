
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Dispatcher_Worker {
	
	// Number of workers
	public static int total_workers = 16;
	
	// Dispatcher queue
	public static ArrayList <String> dispatcher_queue = new ArrayList<String>();
	
	private static final long startMillis = System.currentTimeMillis();
	
	HashMap<RecordB, Integer> gmrB;
	HashMap<RecordR, Integer> gmrR;
	HashMap<RecordS, Integer> gmrS;
	HashMap<RecordB, HashMap<RecordA, Integer> > indexR;
	HashMap<RecordB, HashMap<RecordC, Integer> > indexS;
	
	public Dispatcher_Worker() {
		this.gmrB = new HashMap<RecordB, Integer>();
		this.gmrR = new HashMap<RecordR, Integer>();
		this.gmrS = new HashMap<RecordS, Integer>();
		this.indexR = new HashMap<RecordB, HashMap<RecordA, Integer>>();
		this.indexS= new HashMap<RecordB, HashMap<RecordC, Integer>>();	
	}
	
	//RecordB
	public class RecordB{
		
		
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
	public class RecordA{
		
		
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
	
	public class RecordC{
		
		
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
	public class RecordR{
		
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
	
	//Record S
	public class RecordS{
		
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
	 * Dispatcher:
	 * 
	 * The dispatcher is also a thread that works as follows. 
	 * 
	 * Responsible for creating the workers.
	 * Receiving all updates from the database --> Dispatching these updates to the correct workers.
	 * Add to worker's queue all updates.
	 * 
	 */ 
	
	public static class Dispatcher implements Runnable {
		
		public Worker[] workers;

		public Dispatcher(Worker[] workers) {
			this.workers = workers;	
		}

		public void run() { 
			
			while (System.currentTimeMillis() < (startMillis + 8000)) {
			
				// Receive input from a file
				File file_dispatcher = new File("/Users/danap/Desktop/prueba_final.txt");
				FileReader fileR = null;
				BufferedReader file2 = null;

			try {
				fileR = new FileReader(file_dispatcher);
				file2 = new BufferedReader(fileR);
				    
			} catch (FileNotFoundException e) {
				System.out.println("We could not find the file "+file_dispatcher.getName());
			}

				String line0 = "";
				   
			try {
				while((line0 = file2.readLine()) != null) {
					dispatcher_queue.add(line0);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			int k = 0;
			//Add it to the corresponding queue.
			for (int j=0; j<dispatcher_queue.size(); j++) {
		   		   
				if (dispatcher_queue.get(j).contains("R")) {
					// we divide the hashcode by the number of workers to ensure that k is a value between 0 and #number of workers - 1
					//System.out.println(dispatcher_queue.get(j).subSequence(10,12).hashCode() % total_workers);
					k = dispatcher_queue.get(j).subSequence(10,12).hashCode() % total_workers;
				}
		   		if (dispatcher_queue.get(j).contains("S")) {
		   			// we divide the hashcode by the number of workers to ensure that k is a value between 0 and #number of workers - 1
		   			//System.out.println(dispatcher_queue.get(j).subSequence(7,9).hashCode() % total_workers);
		   			k = dispatcher_queue.get(j).subSequence(7,9).hashCode() % total_workers;
		   		}
		   		
		   		//Add it to the corresponding queue 
		   		workers[k].worker_queue.add(dispatcher_queue.get(j));
		   		
		   		
			}
		
			for(int j = 0; j<total_workers;j++) {
				if(workers[j].worker_queue.size() != 0) {
					
//					synchronized (workers[j].worker_queue) {
//		                workers[j].worker_queue.notify();    
//		            }
					
					//System.out.println("Worker "+ j + " queue: "+ workers[j].worker_queue);
				}
				//System.out.println();
			}
			
	        //Wait some time before exiting, giving the threads a chance to run
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        for(int j = 0; j<total_workers;j++) {
	        	synchronized (workers[j].worker_queue) { 
	        		workers[j].worker_queue.notifyAll();
	        	}
	        }
	        
	        try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			}
		}
	}



	/*
	 * Worker:
	 * 
	 * Each worker thread has a queue --> ConcurrentLinkedQueue
	 * 
	 * Each worker then has a run() method that roughly works as follows:
	 * 
	 * while (true) { // run forever
	 *   synchronized (queue) {
	 *      try {
	 *         queue.wait(); // block until the dispatcher add somethign to the queue
	 *    } catch (InterruptedException e) {
	 *       e.printStackTrace();
	 *    }
	 *    }
	 *  while (!queue.isEmpty()) {
	 *      do_work(queue.poll()); //process the update
	 *  }
	 *}
	 * 
	 * 
	 * Here do_work is the method that specifies how the worker processes the the update.
	 * 
	 * You can replace the while(true) loop by while(!done) where done represents some flag of the worker 
	 * that indicates that the worker should shut down (this is a flag that can be set in the main loop, for example).
	 * 
	 */
			
	
	public static class Worker implements Runnable {
		

		public String name;
		public Queue<String> worker_queue;
		HashMap<RecordA, Integer> gmrA;
		HashMap<RecordB, Integer> gmrB;
		HashMap<RecordC, Integer> gmrC;
		HashMap<RecordR, Integer> gmrR;
		HashMap<RecordS, Integer> gmrS;
		HashMap<RecordB , HashMap<RecordA, Integer>> indexR;
		HashMap<RecordB, HashMap<RecordC, Integer> > indexS;

		public Worker(String name) {
			this.name = new String(name);
			this.worker_queue = new ConcurrentLinkedQueue<String>();
			this.gmrA = new HashMap<RecordA, Integer>();
			this.gmrB = new HashMap<RecordB, Integer>();
			this.gmrC = new HashMap<RecordC, Integer>();
			this.gmrR = new HashMap<RecordR, Integer>();
			this.gmrS = new HashMap<RecordS, Integer>();
			this.indexR = new HashMap<RecordB, HashMap<RecordA, Integer>>();
			this.indexS= new HashMap<RecordB, HashMap<RecordC, Integer>>();
			
		}

		public Queue<String> getWorker_queue() {
			return worker_queue;
		}

		public void setWorker_queue(Queue<String> worker_queue) {
			this.worker_queue = worker_queue;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		//RecordB
		public class RecordB{
					
					
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
		
		//RecordA
		public class RecordA{
					
					
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
				
		
		//RecordC
		public class RecordC{
					
					
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
		public class RecordR{
					
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
		public class RecordS{
					
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
		
		public void onAddR (int a, int b){
			
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
		    
		    //System.out.println("Modificación de index: " + "" + record_B + " " + gmrA);
		    
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
		
		
		
		public void onDelR (int a, int b) {
			
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
		    
		    //System.out.println("Modificación de index: " + "" + record_B + " " + gmrA);
		    
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
		
		
		
		public void onAddS (int b, int c) {
			
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
		    
			//System.out.println("Modificación de index: " + "" + record_B + "" + gmrC);
		    
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
		
		
		
		public void onDelS (int b, int c) {

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
		    
			//System.out.println("Modificación de index: " + "" + record_B + "" + indexR.get(record_B));
		    
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
		
		
		public void enumeration() {
			
			
			//System.out.println("*********************** Enumeration **********************");
			
			for(Entry<RecordB, Integer> root_node: gmrB.entrySet()) {
				RecordB b = root_node.getKey();
					HashMap<RecordA,Integer> a = indexR.get(b);
						HashMap<RecordC,Integer> c = indexS.get(b);
						System.out.println("[ a: " + a + " b: " + b + " c: " + c + " ]"+ " = " + gmrB.get(b));
			}
			
		}
		
		

		@Override
		public void run() {
			
			
			//while (true) {
				// we run forever, or until the main thread exits.
				// We wait to be signaled that a message has been delivered on the queue
				synchronized (worker_queue) {
					try {
						worker_queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// We only reach this when the queue has been notify() by another thread.
				// In our case the dispatcher thread above.
				if (!worker_queue.isEmpty()) {
					//System.out.println("Dispatcher notifies " + this.name);
					//System.out.println();
					
					while(worker_queue.size() != 0){
						String line = worker_queue.poll();
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
						//} //End of while
					
					
					
				}

			}
				enumeration();

			
		}
		
		
	
		
		
		
}	
	
			    
	public static void main(String[] args) throws InterruptedException {
		
		
	        Worker [] workers = new Worker[total_workers];
	        Thread [] mythreads = new Thread[total_workers];

	        //The main thread first starts all of the workers

	        for(int i = 0; i< workers.length; i++) {
	            workers[i] = new Worker("worker"+i); //Le das nombre a los workers
	            mythreads[i] = new Thread(workers[i], workers[i].getName());
	            //System.out.println(workers[i].getName()+" ----> "+ mythreads[i].getName());
	        }


	        // First start the threads
	        for(int i = 0; i< mythreads.length; i++) {
	            mythreads[i].start();
	        }
	        
	        // Start the dispatcher thread
	        Thread dispatcherThread = new Thread(new Dispatcher(workers), "dispatcher"); 
	        dispatcherThread.start();
	        
	        
	        
	       
	    }
	


}

