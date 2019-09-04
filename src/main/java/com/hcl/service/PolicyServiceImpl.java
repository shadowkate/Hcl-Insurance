package com.hcl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hcl.dto.LatestTrendDTO;
import com.hcl.dto.LatestTrendsResDTO;
import com.hcl.dto.TrendDto;
import com.hcl.repository.OrderDetailsRepository;

/***
 * 
 * @author Pradeep,dhanashekar
 * @param trendRange
 * @retun List<trendDto>
 */
@Service
public class PolicyServiceImpl implements PolicyService {
	@Autowired
	private OrderDetailsRepository orderRepo;

	@Override
	public Object getLatestTrend(String trendRange) {

		Pageable pageable = PageRequest.of(0, 10);
		List<LatestTrendDTO> list = orderRepo.getLatestTrend(pageable);
		ConcurrentHashMap<String, Double> latestRecords = new ConcurrentHashMap<>();
		list.forEach(item -> {
			if (!latestRecords.containsKey(item.getPolicyName())) {
				latestRecords.put(item.getPolicyName(), 1.0);
			} else {
				latestRecords.put(item.getPolicyName(), latestRecords.get(item.getPolicyName()) + 1);
			}
		});

		List<LatestTrendsResDTO> responseDTO = new ArrayList<>();

		latestRecords.forEach((k, v) -> {
			LatestTrendsResDTO resDto = new LatestTrendsResDTO();
			resDto.setPolicyName(k);
			resDto.setPercentage((v / 10) * 100);
			responseDTO.add(resDto);
		});
		List<LatestTrendDTO> unique = list.stream().distinct().collect(Collectors.toList());

		if (trendRange.equalsIgnoreCase("suggest")) {
			return unique;
		} else if (trendRange.equalsIgnoreCase("latest")) {
			return responseDTO;
		}
		return null;
	}
	@Override
    public List<TrendDto> trendAnalysis() {
        return orderRepo.findAnalysis();
        
    }
}