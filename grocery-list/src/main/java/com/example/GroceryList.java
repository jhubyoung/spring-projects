package org.jhy.grocerylist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GroceryList{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String item;
	
	public GroceryList(String item){
		this.item = item;
	}
	public GroceryList(){}
	
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getItem(){
		return item;
	}
	public void setItem(String item){
		this.item = item;
	}
	
	public String toString(){
		StringBuilder value = new StringBuilder("Grocery List Item: ");
		value.append("Id: ");
		value.append(id);
		value.append(", Item: ");
		value.append(item);
		return value.toString();
	}
}