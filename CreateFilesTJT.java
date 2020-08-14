
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CreateFilesTJT {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		int i;
		int length = 1000000;
		PrintWriter writer = new PrintWriter("/Users/Desktop/updates.txt","UTF-8");
		
		for (i=0; i<length; i++) {
			
			int b = (int) (Math.random()*10);
			int c = (int) (Math.random()*10);
			
			if(i<(length/6)){
				writer.println("onAddR("+ c+b +","+ b+c +")");
			}
			else if(i>=length/6 && i<length/3){
				writer.println("onDelR("+ c+b +","+ b+c +")");
			}
			else if(i>=length/3 && i<length*1/2){
				writer.println("onAddS("+ c+b +","+ b+c +")");
			}
			else if(i>=length*1/2 && i<length*2/3){
				writer.println("onDelS("+ c+b +","+ b+c +")");
			}
			else if(i>=length*2/3 && i<length*5/6){
				writer.println("onAddT("+ c+b +","+ b+c +")");
			}
			else if(i>=length*5/6 && i<length){
				writer.println("onDelT("+ c+b +","+ b+c +")");
			}
	}
		writer.close();
}
}