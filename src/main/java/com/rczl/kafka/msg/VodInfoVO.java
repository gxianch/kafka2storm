package com.rczl.kafka.msg;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class VodInfoVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4655735672304267315L;
	@NotNull
	private Long columnId;
	@NotNull
	@Length(max=512)
	private String columnName;
	@NotNull
	private Long mediaId;
	@NotNull
	@Length(max=72)
	private String mediaName;

	public void setColumnId(Long columnId)
	{
		this.columnId = columnId;
	}

	public void setColumnName(String columnName)
	{
		this.columnName = columnName;
	}

	public void setMediaId(Long mediaId)
	{
		this.mediaId = mediaId;
	}

	public void setMediaName(String mediaName)
	{
		this.mediaName = mediaName;
	}

	public void setContentId(Long contentId)
	{
		this.contentId = contentId;
	}
	@NotNull
	private Long contentId;

	public void setContentName(String contentName)
	{
		this.contentName = contentName;
	}

	public void setDefinition(Integer definition)
	{
		this.definition = definition;
	}

	public void setShowTimeLength(Integer showTimeLength)
	{
		this.showTimeLength = showTimeLength;
	}

	@NotNull
	@Length(max=72)
	private String contentName;

	public Long getColumnId()
	{
		return this.columnId;
	}

	public String getColumnName()
	{
		return this.columnName;
	}

	public Long getMediaId()
	{
		return this.mediaId;
	}

	public String getMediaName()
	{
		return this.mediaName;
	}

	public Long getContentId()
	{
		return this.contentId;
	}

	public String getContentName()
	{
		return this.contentName;
	}

	public Integer getDefinition()
	{
		return this.definition;
	}

	public Integer getShowTimeLength()
	{
		return this.showTimeLength;
	}


	@NotNull
	private Integer definition;
	@NotNull
	private Integer showTimeLength;

	@Override
	public String toString() {
		return "VodInfoVO [columnId=" + columnId + ", columnName=" + columnName + ", mediaId=" + mediaId + ", mediaName="
				+ mediaName + ", contentId=" + contentId + ", contentName=" + contentName + ", definition=" + definition
				+ ", showTimeLength=" + showTimeLength + "]";
	}

}


/* Location:              D:\doc\msgProcess\lib\com.miri.ott.data.analysis.msg.process-1.0.0.jar!\com\miri\ott\data\analysis\msgprocess\msg\VodInfoVO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */