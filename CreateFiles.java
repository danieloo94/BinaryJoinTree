
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CreateFiles {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		int i;
		int length = 1000000;
		PrintWriter writer = new PrintWriter("/Users/Desktop/updates.txt","UTF-8");
		
		for (i=0; i<length; i++) {
			
			int b = (int) (Math.random()*10);
			int c = (int) (Math.random()*10);
			
			if(i<(length/4)){
				writer.println("onAddR("+ c+b +","+ b+c +")");
			}
			else if(i>=length/4 && i<length/2){
				writer.println("onDelR("+ c+b +","+ b+c +")");
			}
			else if(i>=length/2 && i<length*3/4){
				writer.println("onAddS("+ c+b +","+ b+c +")");
			}
			else if(i>=length*3/4 && i<length){
				writer.println("onDelS("+ c+b +","+ b+c +")");
			}
	}
		writer.close();
}
}
