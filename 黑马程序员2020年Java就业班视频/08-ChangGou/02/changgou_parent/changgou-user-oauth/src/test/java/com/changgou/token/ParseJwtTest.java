package com.changgou.token;

import org.junit.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;


public class ParseJwtTest {

    /***
     * 校验令牌
     */
    @Test
    public void testParseToken(){
        //令牌
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlcyI6IlJPTEVfVklQLFJPTEVfVVNFUiIsIm5hbWUiOiJpdGhlaW1hIiwiaWQiOiIxIn0.iErEE1FdMCd5z30Jo_oAvQfLyV1QW6vP-pjvNXPgGo98RUndhcoxqPjUOCgkdDmvhmbPreviNuRqmDzeow4p-vBLDvqBsD_XbxJyogPPWXyfua-Y-AQMjyilTgKj2pCa0zTwV3vkCA34_NehpiibeSEkkm-HWvwG7LYqSDgbXLMirVwkvG8pyhMxNfj0gY-lPT6SrGwxtzgurcZStc1AdEkX50Z8Qx31Yr1a-wLgiOH3R6A6vpI61UnmYLJhN1PT0EYeS-SBHmlDintH61YA82ULNbqri3UlTXfjuhGG-rf0VFtfagWRa1xgeVUeiD_q0-4poJfAyvJqWJyjsF81_Q";

        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiueV0Dhd/wyml4Cv8RG6" +
                "a3O6V5w6qwzrkU9ekuWTUwecsWpzHoOT0ywyjJth2bdTqeChXKxBj0MCe1QWeWN5" +
                "evc8wfLn5vOloYGzQmgBE9+MZ293N52Hehmvk348Hbu/z/9m1+vmt29ZbZP7rjFZ" +
                "i6yIV39bJcOiJbIuSagG4w1DxOarVdHQiDV5K8RwzDO2WkveYhJU+fNaYbJQcOkr" +
                "G1E8vAuSQsIVVdJkPyfguIh9ZKNEppBtmdSnoujkIlHdz3kf9FURXIpZnY4UwLr0" +
                "809mHff3lbBAimTDfRLDHBKmq1D1pwGWLbcCiaHS3/ui1odhHpTmR5jPALkwaXiv" +
                "kwIDAQAB" +
                "-----END PUBLIC KEY-----";

        //校验Jwt
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));

        //获取Jwt原始内容
        String claims = jwt.getClaims();
        System.out.println(claims);

        //jwt令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }
}
