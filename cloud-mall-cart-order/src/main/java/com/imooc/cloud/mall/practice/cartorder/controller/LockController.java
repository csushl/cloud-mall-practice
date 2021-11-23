package com.imooc.cloud.mall.practice.cartorder.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：     TODO
 */
@RestController
public class LockController {
    @Autowired
    RedissonClient redissonClient;

    @GetMapping("/redissonLock")
    public void redissonLock() throws InterruptedException {
        RLock redissonLock = redissonClient.getLock("redissonLock");
        boolean b = redissonLock.tryLock();
        if (b) {
            try{
                System.out.println("redisson锁+1");
                Thread.sleep(5000);
            }finally {
                redissonLock.unlock();
                System.out.println("redisson锁已释放");
            }
        } else {
            System.out.println("redisson锁未获取到");
        }
    }

}
