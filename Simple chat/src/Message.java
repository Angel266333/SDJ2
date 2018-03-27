package src;

import java.io.Serializable;

public class Message implements Serializable{
	
	private int id;
	private String messageBody;
	
	public Message(int id, String msg) {
		this.id =id;
		this.messageBody = msg == null ? "" : msg;
	}
	public Message(String message) {
		this(0, message);
		setId((int) (messageBody.hashCode()* Math.random()));
	}
	private void setId(int id) {
		this.id = id;
		
	}
	public int getId() {
		return id;
	}
	public String getBody() {
		return messageBody;
	}
	public String toString() {
		return "id = " + id + ", \"" + messageBody + "\"";
	}
}
