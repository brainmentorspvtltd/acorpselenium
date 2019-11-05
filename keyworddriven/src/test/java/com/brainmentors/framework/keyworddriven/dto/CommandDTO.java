package com.brainmentors.framework.keyworddriven.dto;

public class CommandDTO {
	private String commandName;
	private String target;
	private String value;
	public CommandDTO(){
		
	}
	public CommandDTO(String commandName, String target, String value){
		this.commandName = commandName;
		this.target = target;
		this.value = value;
		
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "CommandDTO [commandName=" + commandName + ", target=" + target + ", value=" + value + "]\n";
	}
	
	

	
}
