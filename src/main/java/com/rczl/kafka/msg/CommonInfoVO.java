package com.rczl.kafka.msg;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


public class CommonInfoVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8836629483718225944L;
	@NotNull
	@org.hibernate.validator.constraints.Length(max=3)
	private String typeCode;
	@NotNull
	@org.hibernate.validator.constraints.Length(max=12)
	private String mac;
	@NotNull
	@org.hibernate.validator.constraints.Length(max=32)
	private String version;

	public void setTypeCode(String typeCode) { this.typeCode = typeCode; } public void setMac(String mac) { this.mac = mac; } public void setVersion(String version) { this.version = version; } public void setRegion(Integer region) { this.region = region; } public void setArea(Integer area) { this.area = area; } public void setSp(Integer sp) { this.sp = sp; }

	@NotNull
	private Integer region;

	public String getTypeCode() { return this.typeCode; }

	public String getMac() {
		return this.mac;
	}

	public String getVersion() { return this.version; }

	public Integer getRegion() { return this.region; }

	public Integer getArea() { return this.area; }

	public Integer getSp() { return this.sp; }

	@NotNull
	private Integer area;


	@NotNull
	private Integer sp;

	@Override
	public String toString() {
		return "CommonInfoVO [typeCode=" + typeCode + ", mac=" + mac + ", version=" + version + ", region=" + region
				+ ", area=" + area + ", sp=" + sp + "]";
	}

}


