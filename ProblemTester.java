import java.io.*;
import java.util.*;

public class ProblemTester {
	static String dirPath;
	static InputStream IS;
	static PrintStream ps;
	
	/**
	 *  Add THESE functions to YOUR code
	 */
	
/*	static void SetInputStream(InputStream IS) {
		System.setIn(IS);
	}
	static void SetPrintStream(PrintStream out) {
		System.setOut(out);
	} 
*/
	
	/**
	 *
	 * dirPath is directory with in/out files
	 * runProgram tests the program
	 * 
	 * UNCOMMENT BELOW WHEN DONE
	 * 
	 */
	
	static void setDirPath() {
		
		// dirPath = "[PATH_NAME]" + "/"; 
		
	}

	static void runProgram(String[] args) throws IOException {
		
		// [CLASS_NAME].SetInputStream(IS);
		// [CLASS_NAME].SetPrintStream(ps);
		// [CLASS_NAME].main(args);
		
	}

	public static void main(String[] args) throws IOException {
		
		setDirPath();

		/**
		 * files formatted "probXX-1,2,3-in,out.txt"
		 */
		
		File[] allFiles = new File(dirPath).listFiles();
		ArrayList<File> inputFiles = new ArrayList<File>();
		ArrayList<File> outputFiles = new ArrayList<File>();
		for (File f : allFiles) {
			if (f.getName().contains("in")) {
				inputFiles.add(f);
			} else {
				outputFiles.add(f);
			}
		}
		Collections.sort(inputFiles);
		Collections.sort(outputFiles);
	
		int testNumber = 1;
		ByteArrayOutputStream bos;
		for (File f : inputFiles) {
			bos = new ByteArrayOutputStream();
			ps = new PrintStream(bos);
			PrintStream old = System.out;
			System.setOut(ps);
			Scanner s = new Scanner(new File(dirPath + f.getName()));
			while (s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
			System.out.flush();
			System.setOut(old);
			String testCaseString = bos.toString();
			IS = new ByteArrayInputStream(testCaseString.getBytes());
			bos = new ByteArrayOutputStream();
			ps = new PrintStream(bos);
			runProgram(args);
			System.out.flush();
			System.setOut(old);
			String out1 = bos.toString();
			Scanner readOut = new Scanner(new File(dirPath + outputFiles.get(testNumber-1).getName()));
			bos = new ByteArrayOutputStream();
			ps = new PrintStream(bos);
			System.setOut(ps);
			while (readOut.hasNextLine()) {
				System.out.println(readOut.nextLine());
			}
			System.out.flush();
			System.setOut(old);
			readOut.close();
			String out2 = bos.toString();
			
			boolean pass = out1.equals(out2);
			System.out.println(testNumber + ": " + (pass ? "PASS" : "FAIL"));
			if (!pass) { 
				System.out.print("Correct output: " + out2);
				System.out.print("Your output: " + out1);
				s.close(); 
				break; 
			}
			testNumber++;
			
			s.close();
		}
	}
}
