package mapping;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
public class Contact {
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;

	private int cno;
	
	@ManyToMany (mappedBy = "laps")
	private List <Per> per;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public List<Per> getPer() {
		return per;
	}

	public void setPer(List<Per> per) {
		this.per = per;
	}

	

}
