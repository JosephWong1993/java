package com.changgou.pay;

import com.github.wxpay.sdk.WeChatPayConfig;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WXPay {
    public WXPay(WeChatPayConfig config) {
    }

    public Map<String, String> unifiedOrder(Map<String, String> paramMap) {
        return null;
    }

    public Map<String, String> orderQuery(Map<String, String> paramMap) {
        return null;
    }

    public Map<String, String> closeOrder(Map<String, String> paramMap) {
        return null;
    }
}
