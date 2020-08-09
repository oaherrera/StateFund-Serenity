package com.conexia.qa.statefund.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Folder {

	public static void main(String[] args) {
//		Folder folder = new Folder();
//		folder.deleteDirectory(System.getProperty("user.dir") + "\\lib\\downloads");
//		folder.deleteFile();
//		folder.getFilePath(System.getProperty("user.dir") + "\\lib\\downloads");
	}

	public void deleteFile() {

	}

	public void deleteDirectory(String path) {
		File dir = new File(path);
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			System.out.println("Deleting File....\n" + file.getAbsolutePath() + "\n" + file.delete());
		}
	}

	protected void closeFile(File file) {
	}

	public boolean fileExist(String path) {
		File file = new File(path);
		File[] listFiles = file.listFiles();
		if (listFiles.length > 0) {
			Path path2 = Paths.get(listFiles[0].toString());
			if (path2.getFileName().toString().contains("summary_")) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	public String getFilePath(String path) {
		while (fileExist(path)) {
			try {
				Thread.sleep(500);
				System.out.println("Searching File...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		File dir = new File(path);
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			System.out.println("File Found...");
			path = file.getPath();
		}
		return path;
	}

}