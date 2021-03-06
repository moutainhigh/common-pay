package com.developcollect.commonpay.config;

import com.developcollect.commonpay.pay.IPayDTO;
import com.developcollect.commonpay.pay.IRefundDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;


/**
 * 支付配置基类
 *
 * @author zak
 * @since 1.0.0
 */
@Data
@Accessors(chain = true)
public abstract class AbstractPayConfig {

    /**
     * 是否启用debug模式
     * 有些支付平台会提供测试环境， 比如支付宝有提供沙箱环境
     * 如果支付平台本身不支持测试环境， 那么这个值设置了也没用
     */
    private boolean debug = false;

    /**
     * 退款结果异步通知地址生成器
     */
    protected BiFunction<IPayDTO, IRefundDTO, String> refundNotifyUrlGenerator;

    /**
     * 支付结果异步通知地址生成器
     */
    protected Function<IPayDTO, String> payNotifyUrlGenerator;


    /**
     * 支付二维码访问链接生成器
     */
    protected BiFunction<IPayDTO, String, String> payQrCodeAccessUrlGenerator;

    /**
     * PC支付页面访问链接生成器
     */
    protected BiFunction<IPayDTO, String, String> pcPayFormHtmlAccessUrlGenerator;

    /**
     * PC支付完成跳转地址生成器
     */
    protected Function<IPayDTO, String> pcReturnUrlGenerator;

    /**
     * WAP支付页面访问链接生成器
     */
    protected BiFunction<IPayDTO, String, String> wapPayFormHtmlAccessUrlGenerator;

    /**
     * WAP支付完成跳转地址生成器
     */
    protected Function<IPayDTO, String> wapReturnUrlGenerator;

    /**
     * 扩展Map
     * 方便其他自定义配置放到这里
     */
    protected Map<String, Object> extendMap = new HashMap<>();

    /**
     * 二维码宽度
     */
    protected int qrCodeWidth = 300;

    /**
     * 二维码高度
     */
    protected int qrCodeHeight = 300;

    /**
     * 获取自定义配置
     *
     * @param key key
     * @return java.lang.Object
     */
    public <T> T getExt(String key) {
        return (T) extendMap.get(key);
    }

    /**
     * 设置自定义配置
     *
     * @param key    key
     * @param extend 自定义配置值
     * @return java.lang.Object
     */
    public Object putExt(String key, Object extend) {
        extendMap.put(key, extend);
        return this;
    }
}
