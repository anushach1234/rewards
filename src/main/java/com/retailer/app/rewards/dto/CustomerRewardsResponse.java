package com.retailer.app.rewards.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CustomerRewardsResponse {

    private Map<String, Integer> customerRewardPointsPerMonth;
    private Integer totalRewardPoints;

}