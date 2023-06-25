package org.library.utils;

public class LibraryException extends Exception{
	public LibraryException() {}
	
	public static void getError(Exception e) {
		System.out.printf("Error: %s\n", e.getMessage());
	}
}
