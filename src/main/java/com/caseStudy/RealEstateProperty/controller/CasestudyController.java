package com.caseStudy.RealEstateProperty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import com.caseStudy.RealEstateProperty.service.UploadingService;
import com.caseStudy.RealEstateProperty.model.Realestate;

@RestController
@RequestMapping(value = "/casestudy")
@CrossOrigin(origins = {"http://localhost:6127", "http://localhost:4202"})
@Transactional( propagation = Propagation.REQUIRED)
public class CasestudyController {
		@Autowired
		UploadingService serivce;
		
		 @RequestMapping(value = "/upload/{pageNo}/{pageSize}/{sortBy}", method = RequestMethod.POST)
		 @ResponseStatus(HttpStatus.OK)
		  public List<Realestate> uploadFile(@RequestParam("file") MultipartFile file,  @PathVariable  int pageNo, 
				  @PathVariable  int pageSize, @PathVariable String sortBy)  {
		    	  serivce.save(file);
		    	  
		    	  List<Realestate> realestate_data = serivce.getCustomers(pageNo, pageSize, sortBy);
		    	  return realestate_data;
		 } 
		 @RequestMapping(value = "/customers/{pageNo}/{pageSize}/{sortBy}", method = RequestMethod.GET)
		 public List<Realestate> getSortedCustomers(@PathVariable  int pageNo, 
				  @PathVariable  int pageSize, @PathVariable String sortBy)  {
		    	  
		    	  List<Realestate> realestate_data = serivce.getCustomers(pageNo, pageSize, sortBy);
		    	  return realestate_data;
		 } 
}
 
