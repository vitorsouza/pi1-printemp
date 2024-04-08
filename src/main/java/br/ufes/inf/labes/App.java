package br.ufes.inf.labes;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class App {
    private static final String URL = "https://api.open-meteo.com/v1/forecast?latitude=-20.27&longitude=-40.31&current_weather=true&forecast_days=1&timezone=America%2FSao_Paulo";

    public static void main( String[] args ) throws Exception {
        String jsonContent = null;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(URL);
            try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
                HttpEntity httpEntity = httpResponse.getEntity();
                jsonContent = EntityUtils.toString(httpEntity);
            }
        }

        System.out.println(jsonContent);
    }
}
