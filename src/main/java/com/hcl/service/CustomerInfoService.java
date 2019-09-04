package com.hcl.service;

import org.springframework.stereotype.Service;

import com.hcl.dto.InfoDetails;
import com.hcl.dto.InfoDto;

@Service
public interface CustomerInfoService {

	InfoDetails custInfo(InfoDto infoDto);

}
