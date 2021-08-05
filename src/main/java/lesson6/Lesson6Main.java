package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Lesson6Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        String apiKey = loadKey();
        String urlStr = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/296478?apikey=" + apiKey;
        HttpUrl url = HttpUrl.parse(urlStr).newBuilder().build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.headers());
        //System.out.println(request.body().toString());

        String body = response.body().string();
        System.out.println(body);
    }

    private static String loadKey() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(Lesson6Main.class.getClassLoader().getResourceAsStream("apikey.secret")))) {
            return bufferedReader.readLine();
        }
    }
}
