package io.miniproject.dto;

public class RestaurantDto {
	int rId;
	String rName;
	long rPhone;
	String rCity;
	String rState;
	int rZip;
	String rCountry;
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public long getrPhone() {
		return rPhone;
	}
	public void setrPhone(long rPhone) {
		this.rPhone = rPhone;
	}
	public String getrCity() {
		return rCity;
	}
	public void setrCity(String rCity) {
		this.rCity = rCity;
	}
	public String getrState() {
		return rState;
	}
	public void setrState(String rState) {
		this.rState = rState;
	}
	public int getrZip() {
		return rZip;
	}
	public void setrZip(int rZip) {
		this.rZip = rZip;
	}
	public String getrCountry() {
		return rCountry;
	}
	public void setrCountry(String rCountry) {
		this.rCountry = rCountry;
	}

}
