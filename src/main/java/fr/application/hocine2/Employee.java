package fr.application.hocine2;

public class Employee {
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}

	private int id;
	private int salary;
	private String name;
	
	public Employee(int id, int salary, String name) {
	this.id=id;
	this.salary=salary;
	this.name=name;

	}
	public Employee(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
