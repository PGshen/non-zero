package space.zero.common.jsonLib.dataBind;

import com.fasterxml.jackson.databind.JsonNode;

public class NullableJsonNodeParser{
	
	public static JsonNode getJsonNode(String key, JsonNode jsonNode){
		 String[] keys = splitKeys(key);
		 JsonNode temp=jsonNode;
		 for(String keyItem:keys){
			 temp=temp.get(keyItem);
			 if(temp==null){
				 break;
			 }
		 }
		 return temp;
	}
	
	public static String getString(String key, JsonNode jsonNode){
		 String[] keys = splitKeys(key);
		 JsonNode temp=jsonNode;
		 for(String keyItem:keys){
			 temp=temp.get(keyItem);
			 if(temp==null){
				 break;
			 }
		 }
		 
		 return temp!=null?temp.asText():null;
	}
	
    public static Double getDouble(String key,JsonNode jsonNode){
    	 String[] keys = splitKeys(key);
		 JsonNode temp=jsonNode;
		 for(String keyItem:keys){
			 temp=temp.get(keyItem);
			 if(temp==null){
				 break;
			 }
		 }
		 return temp!=null?temp.asDouble():null;
	}
    
    protected static String[] splitKeys(String key){
    	if(key.contains(".")){
    		return key.split("\\.");
    	}else{
    		return new String[]{key};
    	}
    	
    }
    
	
}
