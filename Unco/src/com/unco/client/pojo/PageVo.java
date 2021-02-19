package com.unco.client.pojo;

import com.alibaba.druid.support.json.JSONUtils;

import java.util.List;

public class PageVo<T> {

	private int pageNo; //当前页
	private int startIndex; //从第几条开始
	private int pageSize = 7; //每页多少条数据
	
	private int totalPageNo; //总页数
	private int totalRecords; //总数据条数
	private List<T> records;
	
	private String url;
	
	public int getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getStartIndex() {
		return (pageNo-1) * pageSize;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPageNo() {
		return totalRecords % pageSize == 0 ? totalRecords/pageSize : totalRecords/pageSize + 1;
	}

	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "PageVo{" +
				"pageNo=" + pageNo +
				", startIndex=" + startIndex +
				", pageSize=" + pageSize +
				", totalPageNo=" + totalPageNo +
				", totalRecords=" + totalRecords +
				", records=" + records +
				", url='" + url + '\'' +
				'}';
	}
}
