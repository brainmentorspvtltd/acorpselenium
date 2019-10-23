package com.brainmentors.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.brainmentors.dto.User;

public class CSVReader {
	public static ArrayList<User> readCSV() throws IOException {
		String filePath = BundleReader.getValue("csvpath");
		File file = new File(filePath);
		if(!file.exists()) {
			System.out.println("Invalid Path , File Not Exist");
			return null;
		}
		FileInputStream fs = new FileInputStream(file);
		//byte allBytes[] = fs.readAllBytes();
		int singleByte = fs.read();
		final int EOF = -1;
		StringBuilder sb = new StringBuilder();
		while(singleByte!=EOF) {
			sb.append((char)singleByte);
			singleByte = fs.read();
			
		}
		//String allData = new String(allBytes);
		//System.out.println("Data is "+allData);
		String lines[] = sb.toString().split("\n");
		ArrayList<User> users = new ArrayList<>();
		for(String line : lines) {
			User user = new User();
			//System.out.println(line);
			String words[] = line.split(",");
			user.setUserid(words[0]);
			user.setPassword(words[1]);
			users.add(user);
		}
		return users;
	}
	public static void main(String[] args) {
		try {
			ArrayList<User> users = readCSV();
			System.out.println(users);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
