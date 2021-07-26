package com.example.malllearning.service;

import com.example.malllearning.common.api.CommonResult;

/**
 * 会员管理service
 * Created by chenhao on 2021/7/16
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     * @param telephone 手机号
     * @return 验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断手机号和验证码是否匹配
     * @param telephone 手机号
     * @param authCode 验证码
     * @return 匹配结果
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
