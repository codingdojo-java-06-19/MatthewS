package com.banjo.driversLicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banjo.driversLicense.models.License;
import com.banjo.driversLicense.models.Person;
import com.banjo.driversLicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	//Retrieving all licenses
	public List<License> findAll(){
		return licenseRepository.findAll();
	}
	
	public void createLicense(License license) {
		Long licenseNum = licenseRepository.count();
		license.setNumber(String.format("%06d", licenseNum));
		licenseRepository.save(license);
	}
	
}
