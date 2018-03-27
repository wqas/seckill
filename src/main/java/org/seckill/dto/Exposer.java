package org.seckill.dto;

public class Exposer {
	
	//是否开启秒杀 
	private Boolean exposed;
	//加密
	private String md5;
	//秒杀第id
	private long seckillId;
	//现在时间
	private long now;
	//开启时间
	private long start;
	//结束时间
	private long end;

	public Exposer(Boolean exposed, String md5, long seckillId) {
		super();
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Exposer(Boolean exposed, long now, long start, long end) {
		super();
		this.exposed = exposed;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public Exposer(Boolean exposed, long seckillId) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
	}

	public Boolean getExposed() {
		return exposed;
	}

	public void setExposed(Boolean exposed) {
		this.exposed = exposed;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getNow() {
		return now;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}
	


}
