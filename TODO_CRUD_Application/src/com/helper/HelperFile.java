package com.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class HelperFile {

	public static  boolean deleteFile(String path) {
		boolean f= false;
		try {
			
			File file = new File(path);
			file.delete();
			f=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return f;
	}
	public static boolean saveFile(InputStream is , String path) {
		boolean f= false;
		try {
			byte b[] = new byte[is.available()];
			is.read(b);
			FileOutputStream file = new FileOutputStream(path);
			file.write(b);
			f = true;
			file.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return f;
	}
}
