package com.nit.saif.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.saif.report.ExcelGenerator;
import com.nit.saif.report.PdfGenerator;
import com.nit.saif.request.SearchRequest;
import com.nit.saif.response.SearchResponse;
import com.nit.saif.service.IReportService;

@RestController
@RequestMapping("/api")
public class ReportRestController {
	
	@Autowired
	private IReportService service;
	
	@GetMapping("/plan-name")
	public List<String> getPlanNames(){
		return service.getPalnNames();
	}
	
	@GetMapping("/plan-status")
	public List<String> getPlanStatus(){
		return service.getPlanStatus();
	}
	
	@GetMapping("/search")
	public List<SearchResponse> searchResponse(@RequestBody SearchRequest reuquest){
		return service.searchPlans(reuquest);
	}
	
	@GetMapping("/excel")
	  public void generateExcel(HttpServletResponse response) throws Exception {

	    response.setContentType("application/octet-stream");
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=Plans.xls";
	    response.setHeader(headerKey, headerValue);

	    List<SearchResponse> records = service.searchPlans(null);
	    ExcelGenerator excel = new ExcelGenerator();
	    excel.generateExcel(records, response);
	  }
	
	@GetMapping("/pdf")
	  public void generatePdf(HttpServletResponse httpResponse) throws Exception {

	    httpResponse.setContentType("application/pdf");
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=Plans.pdf";
	    httpResponse.setHeader(headerKey, headerValue);

	    List<SearchResponse> records = service.searchPlans(null);
	    PdfGenerator pdfGen = new PdfGenerator();
	    pdfGen.generatePdf(records, httpResponse);
	  }
	
	
	
}
