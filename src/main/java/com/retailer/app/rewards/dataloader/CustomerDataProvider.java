package com.retailer.app.rewards.dataloader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.retailer.app.rewards.dto.CustomerTransaction;

@Component
public class CustomerDataProvider {
    private List<CustomerTransaction> customerTransactions = new ArrayList<>();

    @PostConstruct
    public void dataLoader() {
        CustomerTransaction transaction1 = new CustomerTransaction(1, 1, LocalDate.of(2021, 12, 12), 120);
        CustomerTransaction transaction2 = new CustomerTransaction(2, 1, LocalDate.of(2021, 11, 26), 70);
        CustomerTransaction transaction3 = new CustomerTransaction(3, 1, LocalDate.of(2021, 10, 27), 100);
        CustomerTransaction transaction4 = new CustomerTransaction(4, 1, LocalDate.of(2021, 10, 30), 70);
        CustomerTransaction transaction5 = new CustomerTransaction(5, 2, LocalDate.of(2021, 11, 12), 70);
        customerTransactions.add(transaction2);
        customerTransactions.add(transaction1);
        customerTransactions.add(transaction3);
        customerTransactions.add(transaction4);
        customerTransactions.add(transaction5);
    }

    public List<CustomerTransaction> getAllCustomerData() {
        return customerTransactions;
    }

    public List<CustomerTransaction> getCustomerDataById(Integer id) {
        return customerTransactions.stream().filter(e -> id.equals(e.getCustomerId())).collect(Collectors.toList());
    }

}