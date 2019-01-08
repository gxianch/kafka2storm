package com.rczl.kafka.msg;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class AdvertPlayMsgVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4877300640802868120L;
	@NotNull
	private CommonInfoVO commonInfo;
	@NotNull
	private List<AdvertInfoVO> advertInfos;

	public void setCommonInfo(CommonInfoVO commonInfo) { this.commonInfo = commonInfo; } public void setAdvertInfos(List<AdvertInfoVO> advertInfos) { this.advertInfos = advertInfos; }

	public CommonInfoVO getCommonInfo() { return this.commonInfo; }

	public List<AdvertInfoVO> getAdvertInfos() { return this.advertInfos; }

	@Override
	public String toString() {
		return "AdvertPlayMsgVO [commonInfo=" + commonInfo + ", advertInfos=" + advertInfos + "]";
	}

}


/* Location:              D:\doc\msgProcess\lib\com.miri.ott.data.analysis.msg.process-1.0.0.jar!\com\miri\ott\data\analysis\msgprocess\msg\AdvertPlayMsgVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */