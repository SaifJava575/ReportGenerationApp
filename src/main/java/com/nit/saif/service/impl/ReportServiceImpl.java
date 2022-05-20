package com.nit.saif.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nit.saif.entity.EligibilityDetails;
import com.nit.saif.repository.IEligibilityRepository;
import com.nit.saif.request.SearchRequest;
import com.nit.saif.response.SearchResponse;
import com.nit.saif.service.IReportService;

@Service
public class ReportServiceImpl implements IReportService {
	@Autowired
	private IEligibilityRepository repository;

	@Override
	public List<String> getPalnNames() {
		return repository.getUniquePlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		return repository.getUniquePlanStatus();
	}

	@Override
	public List<SearchResponse> searchPlans(SearchRequest request) {
		List<EligibilityDetails> eligibleRecords=null;
		if (request == null) {
			eligibleRecords=repository.findAll();
		}
		else {
			String planName=request.getPlanName();
			String planStatus=request.getPlanStatus();
			LocalDate startDate=request.getStartDate();
			LocalDate endDate=request.getEndDate();
			
			EligibilityDetails entity=new EligibilityDetails();
			
			if(planName!=null && !planName.equals("")) {
				entity.setPlanName(planName);
			}
			
			if(planStatus!=null && !planStatus.equals("")) {
					entity.setPlanStatus(planStatus);
				}
			if(startDate!=null && endDate!=null) {
				entity.setStartDate(startDate);
				entity.setEndDate(endDate);
				}
			Example<EligibilityDetails> of=Example.of(entity);
			eligibleRecords=repository.findAll(of);
			}
		List<SearchResponse> response=new ArrayList<>();
		for(EligibilityDetails eligibleRecord:eligibleRecords) {
			SearchResponse sr=new SearchResponse();
			BeanUtils.copyProperties(eligibleRecord, sr);
			response.add(sr);
		}
			return response;
	}

}
