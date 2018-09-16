package com.protocol.setprotocol;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.protocol.redis.RedisConfig;
import com.protocol.redis.RedisService;

@Component
public class RunCreateA implements ApplicationRunner{	
	
	@Autowired
	private RedisService redisService;
	
	public void setType() {
		
		String keyType="ProtocolA:Type";
		Map<String, String> type=new HashMap<>();
		type.put("01", "SmokeSensor");
		type.put("02", "TemperatureSensor");
		redisService.setInfo(keyType, type);
		System.out.println("#######--Done With Write--#########");

		redisService.get(keyType);
		System.out.println("------------"+redisService.get(keyType)+"---------");
	}
	
	public void setNo() {
		
		String keyNo="ProtocolA:No";
		Map<String, String> No=new HashMap<>();
		No.put("AA", "1# equipment");
		No.put("AB", "2# equipment");
		No.put("BC", "5# equipment");
		redisService.setInfo(keyNo, No);
		redisService.get(keyNo);
	}
	
	public void setChannal() {
		
		String keyChannal="ProtocolA:Channal";
		Map<String, String> channal=new HashMap<>();
		channal.put("01", "channal:1");
		channal.put("02", "channal:2");
		redisService.setInfo(keyChannal, channal);
		redisService.get(keyChannal);
	}
	
	public void setTem() {
		
		String keyTem="ProtocolA:Temperature";
		Map<String, String> temperature=new HashMap<>();
		temperature.put("0A", "Normal");
		temperature.put("0B", "Risk:normal, little high");
		temperature.put("1A", "Big Risk,too high");
		temperature.put("1B", "Fire!");
		redisService.setInfo(keyTem, temperature);
		redisService.get(keyTem);
	}
	
	public void setAlarm() {
		
		String keyAlarm="ProtocolA:Alarm";
		Map<String, String> alarm=new HashMap<>();
		alarm.put("AA", "Normal");
		alarm.put("AB", "Risk");
		alarm.put("BA", "FireAlarm!");
		redisService.setInfo(keyAlarm, alarm);
		redisService.get(keyAlarm);
	}
	
	public void run(ApplicationArguments args) throws Exception{
		setType();
		setNo();
		setChannal();
		setTem();
		setAlarm();
		System.out.println("start write!");
	}

}
