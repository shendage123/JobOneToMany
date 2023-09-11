package JOB.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jobd {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
public int getId() {
	return id;
}
@Override
public String toString() {
	return "Jobd [id=" + id + ", job=" + job + ", Address=" + Address + ", employesses=" + employesses + "]";
}
public void setId(int id) {
	this.id = id;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public List<Employess> getEmployesses() {
	return employesses;
}
public void setEmployesses(List<Employess> employesses) {
	this.employesses = employesses;
}
private String job;
private String Address;
@OneToMany
private List<Employess>employesses;
}
