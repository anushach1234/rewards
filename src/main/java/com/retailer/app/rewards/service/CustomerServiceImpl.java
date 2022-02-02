package com.retailer.app.rewards.service;

import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retailer.app.rewards.dataloader.CustomerDataProvider;
import com.retailer.app.rewards.dto.CustomerRewardsResponse;
import com.retailer.app.rewards.dto.CustomerTransaction;
import com.retailer.app.rewards.service.CustomerService;
import com.retailer.app.rewards.util.CustomerRewardsUil;

@Component
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDataProvider customerDataProvider;

    @Override
    public CustomerRewardsResponse getCustomerRewardPoints(Integer id) {
        log.debug("Retrieving rewards point for customer id: {}", id);
        CustomerRewardsResponse response = new CustomerRewardsResponse();
        List<CustomerTransaction> customerTransactions = customerDataProvider.getCustomerDataById(id);

        if (customerTransactions != null && customerTransactions.size() > 0) {

            Map<String, Integer> rewardPointsByMonth = CustomerRewardsUil
                    .getCustomerRewardPointsByMonth(customerTransactions);
            response.setCustomerRewardPointsPerMonth(rewardPointsByMonth);
            response.setTotalRewardPoints(rewardPointsByMonth.values().stream().reduce(0, Integer::sum));
        }

        return response;
    }

}