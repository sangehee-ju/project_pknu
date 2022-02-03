package pj;

import java.io.IOException;

public class Util {
	
	public static String change( String a ) {
		try {
			byte[] bs = a.getBytes("8859_1");
			a = new String( bs, "utf-8" );
		}
		catch( IOException e ) {}
		return a;
	}
}
