package config;

public class Util {
	public static String encKor(String han) {
		String res = null;
		try {
			byte[] bs = han.getBytes("utf-8");
			res = new String(bs,"8859_1");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
