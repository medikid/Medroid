package com.meditrainer.medroid.storage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
/*
 * Handles internal storage read and write functions
 */
public class iStorage {
	
	
	protected static void createFolder(Context context, String newFolderName){
			String appFilesFolderPath = context.getFilesDir().toString();
			String newFolderPath = appFilesFolderPath  + "/" + newFolderName;
			File newDir = new File(newFolderPath);
			
			if (!newDir.exists()) {
				newDir.mkdirs();
				}
	}
	
	protected static void createFile(Context context, String folderName, String fileName) throws IOException{
		String appFilesFolderPath = context.getFilesDir().toString();
		String newFolderPath = appFilesFolderPath  + "/" + folderName;
		  File newDir = new File(newFolderPath);
		  File newFile = new File(newDir, fileName);
		  if (!newDir.exists()) { 
			  newDir.mkdirs(); 
			  newFile.createNewFile();
			  } else if (!newFile.exists()){
				  newFile.createNewFile();
			  }
		  
	}
	
	protected static File getFolder(Context context, String folderName){
		File newDir = new File(context.getFilesDir(), folderName);
		return newDir;
	}
	
	protected static File getFile(Context context, String folderName, String fileName) throws IOException{
		  File newDir = getFolder(context, folderName);
		  File newFile = new File(newDir, fileName);
		  if (!newDir.exists()) { 
			  newDir.mkdirs(); 
			  newFile.createNewFile();
			  } else if (!newFile.exists()){
				  newFile.createNewFile();
			  }
		return newFile;
	}
	
	protected static Boolean exists(Context context, File file){
		return file.exists();
	}
	
	protected static Boolean isDirectory(Context context, File file){
		return file.isDirectory();
	}
	
	protected static Boolean isFile(Context context, File file){
		return file.isFile();
	}
	
	protected static void deleteFolder(Context context, File dir){
		if (dir.isDirectory()) {
	        String[] children = dir.list();
	        for (int i = 0; i < children.length; i++) {
	            new File(dir, children[i]).delete();
	        }
	    }

	}
	protected static void deleteFile(Context context, File file){
		file.delete();
	}
	
	protected static void addFileContent(Context context, File file, String fileContent) throws IOException{
		OutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		bos.write(fileContent.getBytes());
		bos.close();
	}
		
	
	protected static void writeFile(Context context, String folderName, String fileName, String fileContent) throws IOException {
		File folder = getFolder(context, folderName);
		File file = new File(folder, fileName);
		
		addFileContent(context, file, fileContent);
	}
	
	protected static String getFileContent(Context context, File file) throws IOException{
		InputStream fis = new BufferedInputStream(new FileInputStream(file));
		String content = "";
		byte[] input = new byte[fis.available()];
		while (fis.read(input) != -1) {}
	     content += new String(input);
	    
	     fis.close();
	     
	    return content;
	}
	
	
	protected static String readFile(Context context, File file) throws IOException{
		String fileContents = getFileContent(context, file);
		return fileContents;
	}



}

