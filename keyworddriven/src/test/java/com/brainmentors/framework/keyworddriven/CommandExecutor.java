package com.brainmentors.framework.keyworddriven;

import java.io.IOException;
import java.util.ArrayList;

import com.brainmentors.framework.keyworddriven.dto.CommandDTO;
import com.brainmentors.framework.keyworddriven.utils.Command;
import com.brainmentors.framework.keyworddriven.utils.ExcelReader;

public class CommandExecutor {
	
	public static void main(String[] args) {
		CommandExecutor executor = new CommandExecutor();
		executor.executeTestCase();
	}
	
	Command commandObject = new Command();
	public void executeTestCase() {
		ExcelReader reader = new ExcelReader();
		try {
			ArrayList<CommandDTO> commands = reader.readXLS();
			System.out.println(commands);
			for(CommandDTO command : commands) {
				if(command.getCommandName().equalsIgnoreCase("browser")) {
					commandObject.browser(command.getValue());
				}
				else
				if(command.getCommandName().equalsIgnoreCase("open")) {
					commandObject.open(command.getValue());
				}
				else
				if(command.getCommandName().equalsIgnoreCase("type")) {
					commandObject.type(command.getValue(), command.getTarget());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
