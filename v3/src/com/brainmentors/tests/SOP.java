package com.brainmentors.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SOP {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setOut(new PrintStream(new File("/Users/amit/Documents/acorpselenium/code/x.log")));
		System.out.println("Hello");
		System.out.println("Java");
	}

}
