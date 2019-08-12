package com.ai.tide.common.rocketmq;

import com.ai.tide.common.exception.TideMQException;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/12 16:03
 **/
public class TideMQProducer  {

    private static final Logger LOGGER = LoggerFactory.getLogger(TideMQProducer.class);

    private static DefaultMQProducer producer;

    private  String ProducerGroupName;

    private  String namesrvAddr;

    private  int maxMessageSize = 4194304;

    private  int sendMsgTimeout = 10000;

    public void setProducerGroupName(String producerGroupName) {
        ProducerGroupName = producerGroupName;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public void setMaxMessageSize(int maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
    }

    public void setSendMsgTimeout(int sendMsgTimeout) {
        this.sendMsgTimeout = sendMsgTimeout;
    }

    /**
     * init rocketmq producer
     * @throws TideMQException
     */
    public void init() throws TideMQException {

        if(StringUtils.isBlank(this.ProducerGroupName))
            throw new TideMQException("rocketmq groupName is blank.");
        if(StringUtils.isBlank(this.namesrvAddr))
            throw new TideMQException("rocketmq namesrvAddr is blank.");
        this.producer = new DefaultMQProducer(this.ProducerGroupName);
        this.producer.setNamesrvAddr(this.namesrvAddr);
        this.producer.setMaxMessageSize(this.maxMessageSize);
        this.producer.setSendMsgTimeout(this.sendMsgTimeout);
        try {
            this.producer.start();
            LOGGER.info(String.format("rocketmq producer is start. GroupName: [%s], NameSrvAddr: [%s]", this.ProducerGroupName, this.namesrvAddr));
        } catch (MQClientException e) {
            LOGGER.error(String.format("rocketmq producer start error. GroupName: [%s], NameSrvAddr: [%s]", this.ProducerGroupName, this.namesrvAddr), e);
            throw new TideMQException(e);
        }
    }

    /**
     *
     * @param topic
     * @param tags
     * @param keys
     * @param messageText
     * @return
     * @throws UnsupportedEncodingException
     * @throws TideMQException
     */
    public SendResult sendMessage (String topic, String tags, String keys, String messageText, long timeout ) throws TideMQException {
        if(StringUtils.isBlank(topic))
            throw new TideMQException("rocketmq topic is blank.");
        if(StringUtils.isBlank(messageText))
            throw new TideMQException("rocketmq messageText is blank.");

        Message msg = new Message(topic, tags, keys, messageText.getBytes());
        try {
            SendResult sendResult = producer.send(msg, timeout);
            return sendResult;
        } catch (Exception e) {
            LOGGER.error("rocketmq send message exception: ", e.getMessage(), e);
            throw new TideMQException(e);
        }
    }

}
