package com.retailer.app.rewards.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class CustomerTransaction {
    private final Integer id;
    private final Integer customerId;
    private final LocalDate transactionDate;
    private final Integer transactionAmount;

}