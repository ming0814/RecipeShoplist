package csce361.util;

import java.util.UUID;

public class CommonUtil{
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
