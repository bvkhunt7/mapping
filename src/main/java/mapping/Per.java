package mapping;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
public class Per {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	private String pname;
	@ManyToMany(cascade = CascadeType .ALL) @JoinColumn (name = "PER_ID")
	   
    private List<Contact> laps;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public List<Contact> getLaps() {
		return laps;
	}
	public void setLaps(List<Contact> laps) {
		this.laps = laps;
	}
	
	


}
