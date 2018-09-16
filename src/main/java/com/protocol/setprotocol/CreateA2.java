//package com.protocol.setprotocol;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.stereotype.Component;
//
//import com.protocol.redis.RedisConfig;
//
//@Component
//public class CreateA2 {	
//	
//	private redis.clients.jedis.Jedis jedis;
//	
//	public void connectRedis() {
//		
//		jedis=RedisConfig.getJedis();
//		jedis.select(15);	
//	}
//	
//	public void setType() {
//		
//		String keyType="ProtocolA:Type";
//		
//		Map<String, String> type=new HashMap<>();
//		type.put("01", "SmokeSensor");
//		type.put("02", "TemperatureSensor");
//		jedis.hmset(keyType, type);		
//		
//	}
//	
//	public void setNo() {
//		
//		String keyNo="ProtocolA:No";
//		Map<String, String> No=new HashMap<>();
//		No.put("AA", "1# equipment");
//		No.put("AB", "2# equipment");
//		No.put("BC", "5# equipment");
//		jedis.hmset(keyNo, No);	
//		
//	}
//	
//	public void setChannal() {
//		
//		String keyChannal="ProtocolA:Channal";
//		Map<String, String> channal=new HashMap<>();
//		channal.put("01", "channal:1");
//		channal.put("02", "channal:2");
//		jedis.hmset(keyChannal, channal);	
//		
//	}
//	
//	public void setTem() {
//		
//		String keyTem="ProtocolA:Temperature";
//		Map<String, String> temperature=new HashMap<>();
//		temperature.put("0A", "Normal");
//		temperature.put("0B", "Risk:normal, little high");
//		temperature.put("1A", "Big Risk,too high");
//		temperature.put("1B", "Fire!");
//		jedis.hmset(keyTem, temperature);	
//		
//	}
//	
//	public void setAlarm() {
//		
//		String keyAlarm="ProtocolA:Alarm";
//		Map<String, String> alarm=new HashMap<>();
//		alarm.put("AA", "Normal");
//		alarm.put("AB", "Risk");
//		alarm.put("BA", "FireAlarm!");
//		jedis.hmset(keyAlarm, alarm);	
//		
//	}
//	
//
//}
