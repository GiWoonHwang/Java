package com.mysite.sbb.BlockChain;

import com.mysite.sbb.BlockChain.BlockChainService;
import io.rigo.sdk.domain.account.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/blockChain")
@RequiredArgsConstructor
@RestController
public class BlockChainController {
    private final BlockChainService blockChainService;

    @PostMapping("/test/{address}")
    public Account queryAccount(@PathVariable("address") String address){
        return this.blockChainService.queryAccount(address);
//        System.out.println(this.blockChainService.queryAccount(address));
    }
}
