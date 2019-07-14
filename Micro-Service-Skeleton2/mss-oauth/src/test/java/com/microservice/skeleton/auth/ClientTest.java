package com.microservice.skeleton.auth;

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

public class ClientTest {
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
	
	public static void main(String[] args) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("grant_type", "client_credentials");
		param.put("client_id", "webApp");
		param.put("username", "admin");
		param.put("password", "admin");
		
		String post = doPost("http://localhost:9030/uaa/oauth/token",param);
		System.out.println("==>"+post);
	}
}
