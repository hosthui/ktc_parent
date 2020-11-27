package com.ktc.sms.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {
	
	
	
	@RabbitHandler
	public void sendSms(Map<String,String> map){
		String code = map.get("code");
		String mobile = map.get("mobile");
		
		
		System.out.println(code);
		System.out.println(mobile);
		
	}
}
