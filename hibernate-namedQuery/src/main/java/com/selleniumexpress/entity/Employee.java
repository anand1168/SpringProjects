package com.selleniumexpress.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
//@NamedQuery(name = "Employee.GetALL",query = "FROM Employee")
//@NamedQuery(name= "Employee.GetEmpByAge", query="FROM Employee where empAge >:AGE")
//@NamedQuery(name= "Employee.GetEmpByName", query="FROM Employee where empName like :substring ")
//We can also place  all the name query like below as well

@NamedQueries(value = {
		@NamedQuery(name = "Employee.GetALL",query = "FROM Employee"),
		@NamedQuery(name= "Employee.GetEmpByAge", query="FROM Employee where empAge >:AGE"),
		@NamedQuery(name= "Employee.GetEmpByName", query="FROM Employee where empName like :substring ")	
		
})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "EmployeeName", length = 70)
	private String empName;
	
	@Column(name="EmployeeAge")
	private int empAge;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empAge=" + empAge + "]";
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	

	
	
}
