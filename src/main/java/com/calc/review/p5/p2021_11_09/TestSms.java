package com.calc.review.p5.p2021_11_09;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 徐恩晗 xshlxx@126.com
 * @since 2021/11/11
 */
public class TestSms {

    @Data
    static class ResponseDTO{
        Integer result;
        List<SmsStatus> rpts;
    }

    @Data
    static class SmsStatus{
        Long msgid;
        String mobile;
        Integer status;
        String rtime;
        String errdesc;
    }
    public static void main(String[] args) {

        String res = "{\"result\":0,\"desc\":\"\",\"rpts\":[]}";
//        String res = "{\"result\":0,\"desc\":\"\",\"rpts\":[{\"msgid\":-5351637002655462463,\"custid\":\"-5351637002655462463\",\"pknum\":1,\"pktotal\":1,\"mobile\":\"13975368289\",\"countrycode\":86,\"spno\":\"106907087165540\",\"exno\":\"\",\"stime\":\"2021-11-11 14:50:42\",\"rtime\":\"2021-11-11 14:50:45\",\"status\":0,\"errcode\":\"DELIVRD\",\"errdesc\":\"success\",\"exdata\":\"\"}]}";

        ResponseDTO response = JSON.parseObject(res, ResponseDTO.class);
        List<SmsStatus> statuses = response.getRpts();

        if (CollectionUtils.isEmpty(statuses)) {
            System.out.println("执行到1-1");
        }
        if (response.getRpts() == null || response.getRpts().get(0) == null) {
            System.out.println("执行到1");
        }
        List<SmsStatus> smsStatuses = Lists.newArrayList();
        smsStatuses.addAll(statuses);
        while (statuses.get(0) != null) {
            statuses = response.getRpts();
            smsStatuses.addAll(statuses);
        }
    }

}
