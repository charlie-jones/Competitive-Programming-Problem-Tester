import java.io.*;
import java.util.*;

public class probXXDemo {
	
	/**
	 * REQUIRED functions
	 */
	static void SetInputStream(InputStream IS) {
		System.setIn(IS);
	}
	static void SetPrintStream(PrintStream out) {
		System.setOut(out);
	}
	
	public static void main(String[] args) throws IOException {
		
		/**
		 * Input from stdin
		 */
		Scanner s = new Scanner(System.in); 
		
		int count = 0;
		
		while (s.hasNextLine()) { 
			
			int n = Integer.parseInt(s.nextLine());
			if (n==0) break;
			if (n > 10) count++;
			
		}
		
		System.out.println(count);
		
		s.close();
	}
	
}