package com.example.baitap13th4;

public class Employee {
	 private String id;
	 private String name;
	 
	 public String getId() {
	 return id;
	 }
	 
	public void setId(String id) {
	 this.id = id;
	 }
	 
	public String getName() {
	 return name;
	 }
	 
	public void setName(String name) {
	 this.name = name;
	 }
	 
	public double TinhLuong() {
		return 0;
	}
	 @Override
	 public String toString() {
		 return this.id+" - "+this.name;
	 }

}
