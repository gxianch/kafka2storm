package com.rczl.kafka.msg;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LiveInfoVO implements Serializable{ /**
 * 
 */
	private static final long serialVersionUID = 3246771777539052303L;
	@NotNull
	private Long columnId;
	@NotNull
	@org.hibernate.validator.constraints.Length(max=512)
	private String columnName;
	@NotNull
	private Integer channelId;
	@NotNull
	@org.hibernate.validator.constraints.Length(max=72)
	private String channelName;
	@NotNull
	private Integer showTimeLength;

	public void setColumnId(Long columnId) { this.columnId = columnId; } public void setColumnName(String columnName) { this.columnName = columnName; } public void setChannelId(Integer channelId) { this.channelId = channelId; } public void setChannelName(String channelName) { this.channelName = channelName; } public void setShowTimeLength(Integer showTimeLength) { this.showTimeLength = showTimeLength; }

	public Long getColumnId() {
		return this.columnId;
	}

	public String getColumnName() { return this.columnName; }

	public Integer getChannelId() { return this.channelId; }


	public String getChannelName() { return this.channelName; }

	public Integer getShowTimeLength() { return this.showTimeLength; }

	@Override
	public String toString() {
		return "LiveInfoVO [columnId=" + columnId + ", columnName=" + columnName + ", channelId=" + channelId
				+ ", channelName=" + channelName + ", showTimeLength=" + showTimeLength + "]";
	}

}


/* Location:              D:\doc\msgProcess\lib\com.miri.ott.data.analysis.msg.process-1.0.0.jar!\com\miri\ott\data\analysis\msgprocess\msg\LiveInfoVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */