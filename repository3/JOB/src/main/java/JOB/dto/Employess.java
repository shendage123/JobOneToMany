package JOB.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Jobname;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Employess [id=" + id + ", Jobname=" + Jobname + ", sal=" + sal + ", number=" + number + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobname() {
		return Jobname;
	}
	public void setJobname(String jobname) {
		Jobname = jobname;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	private double sal;
	private long number;

}
