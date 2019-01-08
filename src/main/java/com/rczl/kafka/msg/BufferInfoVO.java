package com.rczl.kafka.msg;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;



public class BufferInfoVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8573238490041925726L;
//	@javax.validation.constraints.NotNull
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startBufferTime;
	@javax.validation.constraints.NotNull
	@javax.validation.constraints.Min(0L)
	private Integer bufferTimeLength;

	public void setStartBufferTime(Date startBufferTime) { this.startBufferTime = startBufferTime; } public void setBufferTimeLength(Integer bufferTimeLength) { this.bufferTimeLength = bufferTimeLength; }

	public Date getStartBufferTime()
	{
		return this.startBufferTime;
	}

	public Integer getBufferTimeLength() { return this.bufferTimeLength; }

	@Override
	public String toString() {
		return "BufferInfoVO [startBufferTime=" + startBufferTime + ", bufferTimeLength=" + bufferTimeLength + "]";
	}


}

