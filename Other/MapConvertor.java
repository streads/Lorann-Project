import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.Charset;




public class main {
	
	// Variable which take the name of the file who want to convert to .CSV
	public static String filename = "EndMap.txt";
	
	// Number of the level in the DB who want to convert
	public static int levelnumber = 8;
	

	public static void main(String[] args) throws IOException{
		handleFile(new File(filename), Charset.defaultCharset());
			
	}
	
	private static void handleFile(File file, Charset encoding) throws IOException {
        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in, encoding);
             // buffer for efficiency
             Reader buffer = new BufferedReader(reader)) {
            handleCharacters(buffer, file.getName());
        }
    }

    private static void handleCharacters(Reader reader, String fileName)
            throws IOException {
    	BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".csv"));
        PrintWriter pWriter = new PrintWriter(bw);
        int r;
        int x = 0;
        int y = 0;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            if (ch == '\n') {
                y += 1;
                x = 0;
            }else if (ch == '\r') {
            	
            }else if(ch == ' ' ) {
            	x+= 1;
            }
            else {
                
                pWriter.println( levelnumber + ";" + ch + ";" + x + ";" + y);
                x +=1 ;
			}
            
        }
        pWriter.close() ;
 }
	

}
