package eshopServlet;

import java.io.IOException;

import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.client.fluent.Request;

public class HttpClientHelper {
	// Méthodes fetch les données (req;get) et qui repond sous forme de string
	public static String fetch(String url) throws IOException {
		// Requete get avec l'api httpcomponents Fluent
		Response response = Request.Get(url).execute();

		return response.returnContent().asString();
	}

	// envoie de sdonnées
	public static String send(String url, String body) throws IOException {
		Response response = Request.Post(url).bodyString(body, ContentType.APPLICATION_JSON).execute();
		return response.returnContent().asString();
	}

}
