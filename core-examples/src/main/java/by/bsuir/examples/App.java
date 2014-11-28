package by.bsuir.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        Scanner s = new Scanner(System.in);
        FileWriter outp = new FileWriter("lala.txt");
        while(s.hasNext()){
        	String ss = s.next();
        	//System.out.println("lala "+ ss);
        	outp.write(ss);
        	if(ss=="s")
        	break;
        	
        }
        s.close();
        outp.close();
        
       
    }
}
