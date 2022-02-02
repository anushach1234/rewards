package com.retailer.app.rewards.service;

import com.retailer.app.rewards.dto.CustomerRewardsResponse;

public interface CustomerService {

    CustomerRewardsResponse getCustomerRewardPoints(Integer id);

}