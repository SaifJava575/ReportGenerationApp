package com.nit.saif.service;

import java.util.List;

import com.nit.saif.request.SearchRequest;
import com.nit.saif.response.SearchResponse;

public interface IReportService {
	
	public List<String> getPalnNames();
	public List<String> getPlanStatus();
	public List<SearchResponse> searchPlans(SearchRequest request);
}
