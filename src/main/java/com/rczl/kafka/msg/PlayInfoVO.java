package com.rczl.kafka.msg;

import java.io.Serializable;
import java.util.Arrays;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PlayInfoVO implements Serializable{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8476318556013453606L;
	@NotNull
	private Integer playType;
	@NotNull
	private Integer chargeType;
	@NotNull
	private VodInfoVO vodInfo;
	//	@NotNull
//	@JsonIgnore
	private LiveInfoVO liveInfo;

	public void setPlayType(Integer playType) {
		this.playType = playType; 
	} 
	public void setChargeType(Integer chargeType) { 
		this.chargeType = chargeType;
	}
	public void setVodInfo(VodInfoVO vodInfo) { 
		this.vodInfo = vodInfo; 
	} 
	public void setLiveInfo(LiveInfoVO liveInfo) {
		this.liveInfo = liveInfo; 
	} 
	public void setStartPlayTime(java.util.Date startPlayTime) { 
		this.startPlayTime = startPlayTime; } 
	public void setEndPlayTime(java.util.Date endPlayTime) { 
		this.endPlayTime = endPlayTime;
	} 
	public void setPlayTimeLength(Integer playTimeLength) {
		this.playTimeLength = playTimeLength; 
	}
	public void setShowTimeLength(Integer showTimeLength) { 
		this.showTimeLength = showTimeLength; 
	} 
	public void setBufferInfos(BufferInfoVO[] bufferInfos) {
		this.bufferInfos = bufferInfos; 
	}

	//	@NotNull
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date startPlayTime;

	public Integer getPlayType() { return this.playType; }

	public Integer getChargeType() { return this.chargeType; }

	public VodInfoVO getVodInfo() { return this.vodInfo; }

	public LiveInfoVO getLiveInfo() { return this.liveInfo; }

	public java.util.Date getStartPlayTime() { return this.startPlayTime; }

	public java.util.Date getEndPlayTime() { return this.endPlayTime; }

	public Integer getPlayTimeLength() { return this.playTimeLength; }

	public Integer getShowTimeLength() { return this.showTimeLength; }

	public BufferInfoVO[] getBufferInfos() { return this.bufferInfos; }

	//@NotNull
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date endPlayTime;


	@NotNull
	private Integer playTimeLength;
	@NotNull
	private Integer showTimeLength;
	//@NotNull
//	@JsonIgnore
	private BufferInfoVO[] bufferInfos;

	@Override
	public String toString() {
		return "PlayInfoVO [playType=" + playType + ", chargeType=" + chargeType + ", vodInfo=" + vodInfo
				+ ", liveInfo=" + liveInfo + ", startPlayTime=" + startPlayTime + ", endPlayTime=" + endPlayTime
				+ ", playTimeLength=" + playTimeLength + ", showTimeLength=" + showTimeLength + ", bufferInfos="
				+ Arrays.toString(bufferInfos) + "]";
	}

}


/* Location:              D:\doc\msgProcess\lib\com.miri.ott.data.analysis.msg.process-1.0.0.jar!\com\miri\ott\data\analysis\msgprocess\msg\PlayInfoVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */