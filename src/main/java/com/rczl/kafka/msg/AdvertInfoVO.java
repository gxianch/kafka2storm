package com.rczl.kafka.msg;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdvertInfoVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2070973240911970678L;
//	@NotNull
	private Long advertId;
//	@NotNull
	private String advertName;
//	@NotNull
	private Integer pushType;

	public void setAdvertId(Long advertId) { this.advertId = advertId; } public void setAdvertName(String advertName) { this.advertName = advertName; } public void setPushType(Integer pushType) { this.pushType = pushType; } public void setAdvertType(Integer advertType) { this.advertType = advertType; } public void setShowTimeLength(Integer showTimeLength) { this.showTimeLength = showTimeLength; } public void setStartPlayTime(java.util.Date startPlayTime) { this.startPlayTime = startPlayTime; } public void setPlayTimeLength(Integer playTimeLength) { this.playTimeLength = playTimeLength; }

	public Long getAdvertId() { return this.advertId; }

	public String getAdvertName() { return this.advertName; }

	public Integer getPushType() { return this.pushType; }

	public Integer getAdvertType() { return this.advertType; }

	public Integer getShowTimeLength() { return this.showTimeLength; }

	public java.util.Date getStartPlayTime() { return this.startPlayTime; }

	public Integer getPlayTimeLength() { return this.playTimeLength; }

//	@NotNull
	private Integer advertType;


//	@NotNull
	private Integer showTimeLength;
//	@NotNull
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date startPlayTime;
//	@NotNull
	private Integer playTimeLength;

	@Override
	public String toString() {
		return "AdvertInfoVO [advertId=" + advertId + ", advertName=" + advertName + ", pushType=" + pushType
				+ ", advertType=" + advertType + ", showTimeLength=" + showTimeLength + ", startPlayTime="
				+ startPlayTime + ", playTimeLength=" + playTimeLength + "]";
	}
	
}


/* Location:              D:\doc\msgProcess\lib\com.miri.ott.data.analysis.msg.process-1.0.0.jar!\com\miri\ott\data\analysis\msgprocess\msg\AdvertInfoVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */