//package com.calc.review.leet3code;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Collections;
///**
// * 4 尝试用java编写一个转账接口，
// * 传入主要业务参数包括
// * 转出账号，
// * 转入账号，
// * 转账金额，完成转出和转入账号的资金处理，该服务要确保在资金处理时转出账户的
// * 余额不会透支，金额计算准确。
// *
// * @since 2021/7/2
// */
//@Slf4j
//public class Question4 {
//
//    private static final String LOCK_SUCCESS = "OK";
//    private static final String SET_IF_NOT_EXIST = "NX";
//    private static final String SET_WITH_EXPIRE_TIME = "PX";
//    private static final Long RELEASE_SUCCESS = 1L;
//
//    private static final Integer ADD_MONEY = 1;
//    private static final Integer SUB_MONEY = 0;
//
//    /**
//     * 幂等性
//     * 转账时对各个账户的锁
//     *
//     * @param transferFromAccount 转出账户
//     * @param transferToAccount   转入账户
//     * @param money               转账金额
//     * @return true 转账成功，false 转账失败
//     */
//    @Transactional
//    public boolean transferMoney(String transferFromAccount, String transferToAccount, Double money) {
//
//        // 校验: token校验
//        // 校验当前用户是否是app或网站用户
//
//        // 校验: 账户合法性
//        if (!(validAccount(transferFromAccount) && validAccount(transferToAccount))) {
//            log.info("当前项目名称转账账户非法，转出账户为:{},转入账户为:{}", transferFromAccount, transferToAccount);
//            return false;
//        }
//        // 校验: 转账金额
//        if (money < 0) {
//            log.info("当前项目名称转账金额不合理，转出账户为:{},转入账户为:{},转账金额为:{}", transferFromAccount, transferToAccount, money);
//            return false;
//        }
//
//        // 转账账户加锁
//        String transferFromAccountKey = "transferDisTriLock:" + transferFromAccount;
//
//        String requestId = "requestId:" + transferFromAccount + transferToAccount;
//
//        try {
//            if (tryGetDistributedLock(transferFromAccountKey, requestId, 500)) {
//                // 查询: 转出账户余额
//                Double transferFromAccountLeft = accountLeftMoney(transferFromAccount);
//                if (transferFromAccountLeft < money) {
//                    log.info("当前项目名称转出账户余额不足，转出账户为:{},需转账金额为:{},转出账户余额为:{}", transferFromAccount, money, transferFromAccountLeft);
//                    return false;
//                }
//                // 转账操作
//                operateAccountMoney(transferFromAccountKey, money, SUB_MONEY);
//                operateAccountMoney(transferToAccount, money, ADD_MONEY);
//            }
//        } finally {
//            releaseDistributedLock(transferFromAccountKey, requestId);
//        }
//        return true;
//    }
//
//    /**
//     * @param accountNum 待查询账户
//     * @return 账户余额
//     */
//    public Double accountLeftMoney(String accountNum) {
//        return 0.0;
//    }
//
//    /**
//     * @param accountNum 账户
//     * @param operate    operate: 1: 增加金额 0: 扣减金额
//     * @return 账户余额
//     */
//    public Double operateAccountMoney(String accountNum, Double money, int operate) {
//        return 0.0;
//    }
//
//    /**
//     * 校验账户合法性
//     * @param account 待校验账户
//     */
//    public boolean validAccount(String account) {
//
//        return true;
//    }
//
//    /**
//     * 尝试获取分布式锁
//     *
//     * @param lockKey    锁
//     * @param requestId  请求标识
//     * @param expireTime 超期时间
//     * @return 是否获取成功
//     */
//    static boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {
//
//        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
//
//        if (LOCK_SUCCESS.equals(result)) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 释放分布式锁
//     *
//     * @param jedis     Redis客户端
//     * @param lockKey   锁
//     * @param requestId 请求标识
//     * @return 是否释放成功
//     */
//    public static boolean releaseDistributedLock(String lockKey, String requestId) {
//
//        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
//
//        if (RELEASE_SUCCESS.equals(result)) {
//            return true;
//        }
//        return false;
//    }
//}
