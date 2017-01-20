package org.anil.collabrationbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="BlogDetails")
public class Blog {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	  private int bId;
	  private String bName;
	  private String bDiscription;
	  private Date time;
	  private String postedBY;
	  private String category;
	  
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbDiscription() {
		return bDiscription;
	}
	public void setbDiscription(String bDiscription) {
		this.bDiscription = bDiscription;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPostedBY() {
		return postedBY;
	}
	public void setPostedBY(String postedBY) {
		this.postedBY = postedBY;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	  
}
