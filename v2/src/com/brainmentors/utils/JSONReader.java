package com.brainmentors.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.brainmentors.dto.User;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

public class JSONReader {
	public static ArrayList<User> readJSON() throws IOException {
		//System.out.println("Calling URL");
		URL url= new URL("https://raw.githubusercontent.com/brainmentorspvtltd/myserverdata/master/users.json");
		URLConnection con = url.openConnection();
		con.connect();
		//System.out.println("Connection Created...");
		InputStream is = con.getInputStream();
		byte bytes[] = is.readAllBytes();
		String json = new String (bytes);
		is.close();
		
		Gson gson = new Gson();
		//gson.fromJson(json, User.class);
		Map<String, ArrayList<LinkedTreeMap>> userMap = gson.fromJson(json, Map.class);
		//System.out.println("After Parse");
		//System.out.println(userMap);
		ArrayList<LinkedTreeMap> users = userMap.get("users");
		ArrayList<User> userList = new ArrayList<>();
		for(int i = 0; i<users.size(); i++) {
			System.out.println(users.get(i).get("userid"));
			User user = new User();
			user.setUserid(users.get(i).get("userid").toString());
			user.setPassword(users.get(i).get("password").toString());
			userList.add(user);
		}
		return userList;
		
		
	}
	public static void main(String[] args) {
		//arr["delhi"] = 30
		HashMap<String, Integer> map = new HashMap<>();
		map.put("delhi", 30);
		int temp = map.get("delhi");
		try {
			ArrayList<User> users = readJSON();
			System.out.println("Users are "+users);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
