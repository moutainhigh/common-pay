package com.developcollect.commonpay.pay;

/**
 * 支付抽象接口
 *
 * @author zak
 * @since 1.0.0
 */
public interface Pay {

    /**
     * 支付
     * 通过付款二维码支付
     *
     * @param order 支付订单
     * @return String 二维码值
     * @author zak
     * @since 1.0.0
     */
    String payQrCode(IOrder order);


    /**
     * 通过跳转到第三方的支付表单实现支付
     *
     * @param order 支付订单
     * @return String html代码片段
     * @author zak
     * @since 1.0.0
     */
    String payForm(IOrder order);

    /**
     * 同步调用支付
     * 直接返回支付结果，不使用异步通知的方式
     *
     * @author zak
     * @since 1.0.0
     */
    PayResponse paySync(IOrder order);


    /**
     * 支付结果查询
     *
     * @author zak
     * @since 1.0.0
     */
    PayResponse payQuery(IOrder order);

    /**
     * 退款
     *
     * @param refund 退款信息
     * @return 退款结果
     * @author zak
     * @since 1.0.0
     */
    RefundResponse refundSync(IOrder order, IRefund refund);


    /**
     * 转账
     *
     * @param transfer 转账信息
     * @return 转账结果
     * @author zak
     * @since 1.0.0
     */
    TransferResponse transferSync(ITransfer transfer);

}