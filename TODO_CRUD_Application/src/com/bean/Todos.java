package com.bean;
import java.time.LocalDate;
public class Todos {

	private int todo_id , user_id;
	private String title , descriptions;
	private LocalDate target_date;
	private boolean status;
	public LocalDate getTarget_date() {
		return target_date;
	}
	public void setTarget_date(LocalDate date) {
		this.target_date = date;
	}
	
	public Todos(int todo_id, int user_id, String title, String descriptions, LocalDate target_date, boolean status) {
		super();
		this.todo_id = todo_id;
		this.user_id = user_id;
		this.title = title;
		this.descriptions = descriptions;
		this.target_date = target_date;
		this.status = status;
	}
	
	public Todos(int user_id, String title, String descriptions, LocalDate target_date, boolean status) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.descriptions = descriptions;
		this.target_date = target_date;
		this.status = status;
	}
	public Todos() {
		// TODO Auto-generated constructor stub
	}
	public int getTodo_id() {
		return todo_id;
	}
	public void setTodo_id(int todo_id) {
		this.todo_id = todo_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	@Override
	public String toString() {
		return "Todos [todo_id=" + todo_id + ", user_id=" + user_id + ", title=" + title + ", descriptions="
				+ descriptions + ", target_date=" + target_date + ", status=" + status + "]";
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	
}
