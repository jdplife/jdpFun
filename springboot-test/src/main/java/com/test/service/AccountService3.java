package com.test.service;

/**
 * @ClassName AccountService3
 * @Description TODO
 * @Author jdp
 * @Date 16:39 2022/5/6
 * @Version 1.0
 **/

import com.google.common.base.Optional;
import com.test.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author wenchao.ren
 *         2015/1/5.
 */
@Service
public class AccountService3 {

    private final Logger logger = LoggerFactory.getLogger(AccountService3.class);

    // 使用了一个缓存名叫 accountCache
    @Cacheable(value="accountCache")
    public Account getAccountByName(String accountName) {

        // 方法内部实现不考虑缓存逻辑，直接实现业务
        logger.info("real querying account... {}", accountName);
        Optional<Account> accountOptional = getFromDB(accountName);
        if (!accountOptional.isPresent()) {
            throw new IllegalStateException(String.format("can not find account by account name : [%s]", accountName));
        }

        return accountOptional.get();
    }

    @CacheEvict(value="accountCache",key="#account.getName()")
    public void updateAccount(Account account) {
        updateDB(account);
    }

    @CacheEvict(value="accountCache",allEntries=true)
    public void reload() {
    }

    private void updateDB(Account account) {
        logger.info("real update db...{}", account.getName());
    }

    private Optional<Account> getFromDB(String accountName) {
        logger.info("real querying db... {}", accountName);
        //Todo query data from database
        return Optional.fromNullable(new Account(accountName));
    }
}
