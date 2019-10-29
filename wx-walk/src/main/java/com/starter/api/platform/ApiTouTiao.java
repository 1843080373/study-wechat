package com.starter.api.platform;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.starter.api.enums.ApiManifest;
import com.starter.api.strategy.ApiStrategy;
import com.starter.config.PlatformAPIConfig;

@Component
public class ApiTouTiao extends ApiStrategy {
	@Autowired
	private PlatformAPIConfig platformAPIConfig;

	@Override
	public String buildURL(String content) {
		/**
		 * 类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
		 */
		String[] types = new String[] { "top", "shehui", "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing",
				"shishang" };
		int index=(int)(Math.random()*types.length);
		String apiUrl = String.format(platformAPIConfig.getToutiaoAPI(), types[index],
				platformAPIConfig.getToutiaoKey());
		return apiUrl;
	}

	@Override
	public ApiManifest support() {
		return ApiManifest.TOUTIAO;
	}

	@Override
	public String handleSuccess(JSONObject resultJson) {
		JSONObject result = resultJson.getJSONObject("result");
		StringBuffer buffer = new StringBuffer();
		JSONArray data = createRandomList(result.getJSONArray("data"),5);
		if (data != null && data.size() > 0) {
			buffer.append("----------------------------\n");
			for (int i = 0; i < data.size(); i++) {
				JSONObject item = data.getJSONObject(i);
				buffer.append("<a href='" + item.getString("url") + "'>" + item.getString("title") + "</a>")
						.append("\n");
				buffer.append(item.getString("date") + "(" + item.getString("author_name") + ")").append("\n");
				if (i != data.size() - 1) {
					buffer.append("----------------------------\n");
				}
			}
		}
		return buffer.toString();
	}

	/**从list中随机抽取元素
	 * @return  
	 * @Title: createRandomList 
	 * @Description: TODO
	 * @param list
	 * @param i 
	 * @return void  
	 * @throws 
	 */ 
	private static JSONArray createRandomList(JSONArray  list, int n) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		JSONArray listNew = new JSONArray();
		if(list.size()<=n){
			return list;
		}else{
			while(map.size()<n){
				int random = (int) (Math.random() * list.size());
				if (!map.containsKey(random)) {
					map.put(random, "");
					listNew.add(list.get(random));
				}
			}
			return listNew;
		}
	}
	
	@Override
	public Boolean isJuheAPI() {
		return Boolean.TRUE;
	}
}