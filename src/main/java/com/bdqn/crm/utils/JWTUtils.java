package com.bdqn.crm.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bdqn.crm.model.bo.PayloadBo;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.HashMap;

/**
 * @author 忍
 * @title: JWTUtils
 * @projectName JWTDdemo
 * @description: TODO
 * @date 2019/9/2014:46
 */
public class JWTUtils {
    //    jwt密钥
    private static final String TOKEN_SECRET = "zhou123456";
    //    jwt过期时间
    private static final long EXPIRE_TIM = 6000 * 15;

    //    创建token方法
    public static String creatToken(PayloadBo payloadBo) {
        try {
//        设置token过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIM);
            //设置私钥及加密算法
            Algorithm algorithm =
                    Algorithm.HMAC256(TOKEN_SECRET);             //设置头部信息
            HashMap<String, Object> header = new HashMap<>
                    (2);
            //表示令牌的类型
            header.put("typ", "JWT");             //签名使用的算法
            header.put("alg", "HS256");
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userName", payloadBo.getUserName())
                    .withClaim("userId", payloadBo.getUserId())
                    .withClaim("roleId", payloadBo.getRoleId())
                    .withClaim("header", payloadBo.getHeader())
                    .withExpiresAt(date)//token到期时间
                    .withIssuedAt(new
                            Date(System.currentTimeMillis()))//设置token签发时间
                    .sign(algorithm);
        } catch (
                UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;

        }
    }
//    验证token是否有效
    public static String verify(String token){
        try {
            Algorithm algorithm =
                    Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            //验证token 诺验证不通过则抛出TokenExpiredException
            DecodedJWT jwt = verifier.verify(token);
            String payload = jwt.getPayload();
            return payload;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("token验证不通过");
            return null;
        }

    }
    /**
     *	解密 token
     *	@param payLoad
     *	@return 解密后的字符串
     *	@throws UnsupportedEncodingException
     */
    public static String baseCode(String payLoad) throws UnsupportedEncodingException {
        return new String(new Base64().decode(payLoad),"utf-8");

    }
    public PayloadBo getPlayLoad(String token) throws UnsupportedEncodingException {
        if (token != null) {
            String verify = verify(token);
            if (verify!=null){
                String s = baseCode(verify);
                if (s != null) {
                    PayloadBo payload = JSON.parseObject(s, PayloadBo.class);
                    return payload;
                }
            }
        }
        return null;
    }

}
