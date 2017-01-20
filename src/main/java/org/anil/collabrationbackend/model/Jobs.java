package org.anil.collabrationbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="Jobs")
public class Jobs {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private int jobId;
	private String company;
	private String roles;
	private String skillRequired;
	private String eligibilityCriteria;
	private String ctc;
	private String dateOfInterview;
	private String addressOfTheCompany;
	private String urlOfTheCompany;
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getSkillRequired() {
		return skillRequired;
	}
	public void setSkillRequired(String skillRequired) {
		this.skillRequired = skillRequired;
	}
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public String getDateOfInterview() {
		return dateOfInterview;
	}
	public void setDateOfInterview(String dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}
	public String getAddressOfTheCompany() {
		return addressOfTheCompany;
	}
	public void setAddressOfTheCompany(String addressOfTheCompany) {
		this.addressOfTheCompany = addressOfTheCompany;
	}
	public String getUrlOfTheCompany() {
		return urlOfTheCompany;
	}
	public void setUrlOfTheCompany(String urlOfTheCompany) {
		this.urlOfTheCompany = urlOfTheCompany;
	}
	
	

}
