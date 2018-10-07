package org.jhy.booklist;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Book{
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String title;
	private boolean read;
	private Date date;
	
	public Book(String title){
		this.title=title;		
	}
	public Book(){}
	
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id=id;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public boolean getRead(){
		return read;
	}
	public void setRead(boolean read){
		this.read=read;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date=date;
	}
}