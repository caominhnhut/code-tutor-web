package com.gls.gs.integrationtest.rest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class RestClient<T>
{
	private Logger logger = LoggerFactory.getLogger(RestClient.class);

	private HttpClient httpClient;
	private String uri = "http://localhost:8181/%s";
	private Gson gson;
	private T response;
	private Class<T> responseClass;

	public RestClient(String uri, Class<T> responseClass)
	{
		this.uri = String.format(this.uri, uri);
		this.responseClass = responseClass;
		httpClient = HttpClientBuilder.create().build();
		gson = new Gson();
	}

	public <T> T post(Object data) throws IOException
	{
		logger.info(String.format("Calling the api: %s", this.uri));

		String json = gson.toJson(data);
		StringEntity entity = new StringEntity(json);

		HttpPost httpPost = new HttpPost(this.uri);
		httpPost.setEntity(entity);
		httpPost.setHeader("Content-type", "application/json");

		HttpResponse httpResponse = httpClient.execute(httpPost);

		response = gson.fromJson(EntityUtils.toString(httpResponse.getEntity()), responseClass);

		return (T) response;
	}

	public T getResponse()
	{
		return response;
	}
}
