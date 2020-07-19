package com.yc.Link;

//½ÚµãÀà
public class Link {
	private int idate;
	private double ldate;
	private Link   next;
	
	public Link(int idate, double ldate) {
		super();
		this.idate = idate;
		this.ldate = ldate;
	}
	
	public Link(int idate) {
		super();
		this.idate = idate;
	}

	public int getIdate() {
		return idate;
	}
	public void setIdate(int idate) {
		this.idate = idate;
	}
	public double getLdate() {
		return ldate;
	}
	public void setLdate(double ldate) {
		this.ldate = ldate;
	}
	public Link getNext() {
		return next;
	}
	public void setNext(Link next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Link [idate=" + idate + ", ldate=" + ldate + ", next=" + next + "]";
	}
	
	
	
	
}
