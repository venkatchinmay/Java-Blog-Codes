package com.artofcoding.java9features;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {

	public static void main(String[] args) {
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest req =
				HttpRequest.newBuilder(URI.create("http://www.google.com"))
				.header("User-Agent","Java")
				.GET()
				.build();

		HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandler.asString());	
	}  
}

}
