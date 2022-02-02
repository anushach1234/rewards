 package com.retailer.app.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.retailer.app.rewards.dto.CustomerRewardsResponse;
import com.retailer.app.rewards.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRewardsController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getRewardPoints/{id}")
    public ResponseEntity<CustomerRewardsResponse> getCustomerRewardpoints(@PathVariable("id") Integer id) {
        CustomerRewardsResponse response = customerService.getCustomerRewardPoints(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}