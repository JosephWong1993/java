package com.itheima.canal.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.ListenPoint;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author ZJ
 */
@CanalEventListener
public class BusinessListener {

    private final RabbitTemplate rabbitTemplate;

    public BusinessListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @ListenPoint(schema = "changgou_business", table = {"tb_ad"})
    public void adUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        System.err.println("广告数据发生变化");

//        //修改前数据
//        for(CanalEntry.Column column: rowData.getBeforeColumnsList()) {
//            if(column.getName().equals("position")){
//                System.out.println("发送消息到mq  ad_update_queue:"+column.getValue());
//                rabbitTemplate.convertAndSend("","ad_update_queue",column.getValue());  //发送消息到mq
//                break;
//            }
//        }

        //修改后数据
        for (CanalEntry.Column column : rowData.getAfterColumnsList()) {
            if (column.getName().equals("position")) {
                System.out.println("发送消息到mq  ad_update_queue:" + column.getValue());
                rabbitTemplate.convertAndSend("", "ad_update_queue", column.getValue());  //发送消息到mq
                break;
            }
        }
    }
}