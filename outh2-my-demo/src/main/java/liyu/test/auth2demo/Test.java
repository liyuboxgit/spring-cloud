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
	
	//db:outh2demo
	//scema:
		/*CREATE TABLE `oauth_client_details` (
			  `client_id` varchar(48) NOT NULL,
			  `resource_ids` varchar(256) DEFAULT NULL,
			  `client_secret` varchar(256) DEFAULT NULL,
			  `scope` varchar(256) DEFAULT NULL,
			  `authorized_grant_types` varchar(256) DEFAULT NULL,
			  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
			  `authorities` varchar(256) DEFAULT NULL,
			  `access_token_validity` int(11) DEFAULT NULL,
			  `refresh_token_validity` int(11) DEFAULT NULL,
			  `additional_information` varchar(4096) DEFAULT NULL,
			  `autoapprove` varchar(256) DEFAULT NULL,
			  PRIMARY KEY (`client_id`)
			) ENGINE=InnoDB DEFAULT CHARSET=utf8*/
		/*CREATE TABLE `sys_user` (
			  `id` int(11) NOT NULL AUTO_INCREMENT,
			  `avatar` varchar(255) DEFAULT NULL,
			  `username` varchar(45) DEFAULT NULL,
			  `password` varchar(96) DEFAULT NULL,
			  `salt` varchar(45) DEFAULT NULL,
			  `name` varchar(45) DEFAULT NULL,
			  `birthday` datetime DEFAULT NULL,
			  `sex` int(11) DEFAULT NULL,
			  `email` varchar(45) DEFAULT NULL,
			  `phone` varchar(45) DEFAULT NULL,
			  `status` int(11) DEFAULT NULL,
			  `create_time` datetime DEFAULT NULL,
			  `update_time` datetime DEFAULT NULL,
			  PRIMARY KEY (`id`),
			  UNIQUE KEY `unique_user_username` (`username`)
			) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8*/
	//data:
		//insert into oauth_client_details (client_id,client_secret,scope,authorized_grant_types) values('test','test','test','authorization_code,password,refresh_token,client_credentials');
		//insert into sys_user (username,password) values('admin','admin');
	public static void main(String[] args) {
		/*Map<String, Object> param = new EnhanrenceMap().init()
				.set("grant_type","client_credentials")
				.set("scope","test")
				.set("client_id","test")
				.set("client_secret","test")
				.get();*/
		
		Map<String, Object> param = new EnhanrenceMap().init()
				.set("grant_type","password")
				.set("scope","test")
				.set("client_id","test")
				.set("client_secret","test")
				.set("username", "admin")
				.set("password", "admin")
				.get();
		
		HashMap<String,String> map = new HashMap<String,String>();
		param.forEach((k,v) -> {
			map.put(k, (String) v);
		});
		String ret = doPost("http://localhost/oauth/token", map);
		System.out.println(map);		
		System.out.println(ret);
	}

}
