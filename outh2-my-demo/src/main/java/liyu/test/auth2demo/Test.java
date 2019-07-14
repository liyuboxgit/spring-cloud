package liyu.test.auth2demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Test {
	public static int CONNECT_TIMEOUT = 12000;
	public static String doPost(String url, Map<String, String> params) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httppost = new HttpPost(url);

			RequestConfig config = RequestConfig.custom()
					.setConnectTimeout(CONNECT_TIMEOUT)
					.setConnectionRequestTimeout(CONNECT_TIMEOUT)
					.setSocketTimeout(CONNECT_TIMEOUT).build();

			httppost.setConfig(config);

			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue() + ""));
				}
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
			httppost.setEntity(entity);

			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				return EntityUtils.toString(response.getEntity());
			} finally {
				response.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static class EnhanrenceMap{
		private Map<String,Object> _map;
		public EnhanrenceMap init() {
			this._map = new HashMap<String,Object>();
			return this;
		}
		
		public EnhanrenceMap set(String key,Object value) {
			this._map.put(key, value);
			return this;
		}
		
		public Map<String,Object> get(){
			return this._map;
		}
	}
	
	public static void main(String[] args) {
		/*Map<String, Object> param = new EnhanrenceMap().init()
			.set("username", "user_1")
			.set("password","123456")
			.set("grant_type","password")
			.set("scope","select")
			.set("client_id","client_2")
			.set("client_secret","123456")
			.get();*/
		
		Map<String, Object> param = new EnhanrenceMap().init()
				.set("grant_type","client_credentials")
				.set("scope","select")
				.set("client_id","client_1")
				.set("client_secret","123456")
				.get();
		
		HashMap<String,String> map = new HashMap<String,String>();
		param.forEach((k,v) -> {
			map.put(k, (String) v);
		});
		System.out.println(map);
		String ret = doPost("http://localhost:8080/oauth/token", map);
		
		System.out.println(ret);
	}

}
