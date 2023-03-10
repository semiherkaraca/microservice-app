package com.haydikodlayalim.client;

import com.haydikodlayalim.contract.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account-service")
public interface AccountServiceClient {

    @GetMapping("/account/{id}")
    ResponseEntity<AccountDto> get(@PathVariable("id") String id);
}
