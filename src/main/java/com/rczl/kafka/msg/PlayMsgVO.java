package com.rczl.kafka.msg;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



//@JsonObject(MemberSerialization.OptOut)
//@JsonIgnoreProperties(ignoreUnknown = true,value={ "endPlayTime", "startPlayTime" })
public class PlayMsgVO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8170359455168216950L;
	//@NotNull
	private CommonInfoVO commonInfo;
	@NotNull
	private PlayInfoVO playInfo;
	public void setCommonInfo(CommonInfoVO commonInfo) { this.commonInfo = commonInfo; } public void setPlayInfo(PlayInfoVO playInfo) { this.playInfo = playInfo; }
	public CommonInfoVO getCommonInfo() { return this.commonInfo; }
	public PlayInfoVO getPlayInfo() { return this.playInfo; }
	@Override
	public String toString() {
		return "PlayMsgVO [commonInfo=" + commonInfo + ", playInfo=" + playInfo + "]";
	}


}


