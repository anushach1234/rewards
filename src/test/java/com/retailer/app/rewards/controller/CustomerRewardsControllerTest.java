package com.retailer.app.rewards.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import com.retailer.app.rewards.dto.CustomerRewardsResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerRewardsControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testByCustomerId1() {
        URI targetUrl= UriComponentsBuilder.fromUriString("/api/customer/getRewardPoints/1")
                .build()
                .encode()
                .toUri();

        CustomerRewardsResponse response = this.restTemplate.getForObject(targetUrl, CustomerRewardsResponse.class);
        assertEquals(response.getTotalRewardPoints(), 180);
    }


    @Test
    public void testByCustomerId2() {
        URI targetUrl= UriComponentsBuilder.fromUriString("/api/customer/getRewardPoints/2")
                .build()
                .encode()
                .toUri();

        CustomerRewardsResponse response = this.restTemplate.getForObject(targetUrl, CustomerRewardsResponse.class);
        assertEquals(response.getTotalRewardPoints(), 20);
        assertEquals(response.getCustomerRewardPointsPerMonth().size(), 1);
        assertTrue(response.getCustomerRewardPointsPerMonth().containsKey("NOVEMBER"));
    }

}