package com.supertool.dspui.param.carboninterface;

import java.util.List;
import java.util.Map;

public class AlgorithmTestData{
	public AlgorithmTestRtb rtb;
	public AlgorithmTestBid bid;
	public AlgorithmTestRady rady;
	public List<Integer> frequency;
	public Map<String, AlgorithmTestDataSource> datasource;
	public AlgorithmTestRtb getRtb() {
		return rtb;
	}
	public void setRtb(AlgorithmTestRtb rtb) {
		this.rtb = rtb;
	}
	public AlgorithmTestBid getBid() {
		return bid;
	}
	public void setBid(AlgorithmTestBid bid) {
		this.bid = bid;
	}
	public AlgorithmTestRady getRady() {
		return rady;
	}
	public void setRady(AlgorithmTestRady rady) {
		this.rady = rady;
	}
	public List<Integer> getFrequency() {
		return frequency;
	}
	public void setFrequency(List<Integer> frequency) {
		this.frequency = frequency;
	}
	public Map<String, AlgorithmTestDataSource> getDatasource() {
		return datasource;
	}
	public void setDatasource(Map<String, AlgorithmTestDataSource> datasource) {
		this.datasource = datasource;
	}
}