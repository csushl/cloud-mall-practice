package com.imooc.cloud.mall.practice.cartorder.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述：     发送消息
 */
@Component
public class MsgSender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send(Integer productId, Integer stock) {
//        UpdateProductStockDTO dto = new UpdateProductStockDTO(productId, stock);
//        System.out.println("发送了："+dto.toString());
//        byte[] bytes = SerializationUtils.serialize(dto);
//        this.rabbitmqTemplate.convertAndSend("bootExchange", "productStock", bytes);
            String message = "This is message 1";
            System.out.println("发送了："+message);
            this.rabbitmqTemplate.convertAndSend("bootExchange", "productStock", productId+","+stock);
//        byte[] message2 = new byte[2];
//        message2[0] = 1;
//        message2[1] = 100;
//            this.rabbitmqTemplate.convertAndSend("bootExchange", "productStock", message2);
    }




}
