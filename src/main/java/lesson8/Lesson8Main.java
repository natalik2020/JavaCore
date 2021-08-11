package lesson8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.Lesson7Main;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Lesson8Main {
    private static final boolean REALPROGNOZ = true;

    public static void main(String[] args) throws IOException {
        List<Object> list = zaprosPrognoza();
        String city = (String) list.get(0);
        String localDate = (String) list.get(1);
        Double temperature = (Double) list.get(2);
        String weatherText = (String) list.get(3);
        Repository.saveWeather(city, localDate, temperature, weatherText);

        Repository.printAllWeather("Череповец");
    }

    private static List<Object> zaprosPrognoza() throws IOException {
        String prognozData;
        if (REALPROGNOZ) {
            prognozData = prognoz();
        } else {
            prognozData = "{\"Headline\":{\"EffectiveDate\":\"2021-08-11T01:00:00+03:00\",\"EffectiveEpochDate\":1628632800,\"Severity\":5,\"Text\":\"Вторник, поздняя ночь - Среда, вечер: ливни и гроза\",\"Category\":\"thunderstorm\",\"EndDate\":\"2021-08-12T01:00:00+03:00\",\"EndEpochDate\":1628719200,\"MobileLink\":\"http://www.accuweather.com/ru/ru/cherepovets/296478/extended-weather-forecast/296478?unit=c\",\"Link\":\"http://www.accuweather.com/ru/ru/cherepovets/296478/daily-weather-forecast/296478?unit=c\"},\"DailyForecasts\":[{\"Date\":\"2021-08-09T07:00:00+03:00\",\"EpochDate\":1628481600,\"Sun\":{\"Rise\":\"2021-08-09T04:32:00+03:00\",\"EpochRise\":1628472720,\"Set\":\"2021-08-09T20:35:00+03:00\",\"EpochSet\":1628530500},\"Moon\":{\"Rise\":\"2021-08-09T04:49:00+03:00\",\"EpochRise\":1628473740,\"Set\":\"2021-08-09T21:27:00+03:00\",\"EpochSet\":1628533620,\"Phase\":\"WaxingCrescent\",\"Age\":1},\"Temperature\":{\"Minimum\":{\"Value\":16.4,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":25.9,\"Unit\":\"C\",\"UnitType\":17}},\"RealFeelTemperature\":{\"Minimum\":{\"Value\":17.0,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":27.7,\"Unit\":\"C\",\"UnitType\":17}},\"RealFeelTemperatureShade\":{\"Minimum\":{\"Value\":17.0,\"Unit\":\"C\",\"UnitType\":17},\"Maximum\":{\"Value\":25.0,\"Unit\":\"C\",\"UnitType\":17}},\"HoursOfSun\":8.4,\"DegreeDaySummary\":{\"Heating\":{\"Value\":0.0,\"Unit\":\"C\",\"UnitType\":17},\"Cooling\":{\"Value\":3.0,\"Unit\":\"C\",\"UnitType\":17}},\"AirAndPollen\":[{\"Name\":\"AirQuality\",\"Value\":0,\"Category\":\"Хорошая\",\"CategoryValue\":1,\"Type\":\"Озон\"},{\"Name\":\"Grass\",\"Value\":0,\"Category\":\"Низк.\",\"CategoryValue\":1},{\"Name\":\"Mold\",\"Value\":0,\"Category\":\"Низк.\",\"CategoryValue\":1},{\"Name\":\"Ragweed\",\"Value\":0,\"Category\":\"Низк.\",\"CategoryValue\":1},{\"Name\":\"Tree\",\"Value\":0,\"Category\":\"Низк.\",\"CategoryValue\":1},{\"Name\":\"UVIndex\",\"Value\":4,\"Category\":\"Умерен.\",\"CategoryValue\":2}],\"Day\":{\"Icon\":4,\"IconPhrase\":\"Переменная облачность\",\"HasPrecipitation\":false,\"ShortPhrase\":\"Переменная облачность\",\"LongPhrase\":\"Переменная облачность\",\"PrecipitationProbability\":4,\"ThunderstormProbability\":0,\"RainProbability\":4,\"SnowProbability\":0,\"IceProbability\":0,\"Wind\":{\"Speed\":{\"Value\":7.4,\"Unit\":\"km/h\",\"UnitType\":7},\"Direction\":{\"Degrees\":193,\"Localized\":\"ЮЮЗ\",\"English\":\"SSW\"}},\"WindGust\":{\"Speed\":{\"Value\":11.1,\"Unit\":\"km/h\",\"UnitType\":7},\"Direction\":{\"Degrees\":189,\"Localized\":\"Ю\",\"English\":\"S\"}},\"TotalLiquid\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Rain\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Snow\":{\"Value\":0.0,\"Unit\":\"cm\",\"UnitType\":4},\"Ice\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"HoursOfPrecipitation\":0.0,\"HoursOfRain\":0.0,\"HoursOfSnow\":0.0,\"HoursOfIce\":0.0,\"CloudCover\":51,\"Evapotranspiration\":{\"Value\":0.1,\"Unit\":\"mm\",\"UnitType\":3},\"SolarIrradiance\":{\"Value\":36.1,\"Unit\":\"W/m²\",\"UnitType\":33}},\"Night\":{\"Icon\":35,\"IconPhrase\":\"Облачно с прояснениями\",\"HasPrecipitation\":false,\"ShortPhrase\":\"Облачно с прояснениями\",\"LongPhrase\":\"Облачно с прояснениями\",\"PrecipitationProbability\":12,\"ThunderstormProbability\":0,\"RainProbability\":12,\"SnowProbability\":0,\"IceProbability\":0,\"Wind\":{\"Speed\":{\"Value\":5.6,\"Unit\":\"km/h\",\"UnitType\":7},\"Direction\":{\"Degrees\":191,\"Localized\":\"Ю\",\"English\":\"S\"}},\"WindGust\":{\"Speed\":{\"Value\":11.1,\"Unit\":\"km/h\",\"UnitType\":7},\"Direction\":{\"Degrees\":177,\"Localized\":\"Ю\",\"English\":\"S\"}},\"TotalLiquid\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Rain\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"Snow\":{\"Value\":0.0,\"Unit\":\"cm\",\"UnitType\":4},\"Ice\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"HoursOfPrecipitation\":0.0,\"HoursOfRain\":0.0,\"HoursOfSnow\":0.0,\"HoursOfIce\":0.0,\"CloudCover\":33,\"Evapotranspiration\":{\"Value\":0.0,\"Unit\":\"mm\",\"UnitType\":3},\"SolarIrradiance\":{\"Value\":4.8,\"Unit\":\"W/m²\",\"UnitType\":33}},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/ru/ru/cherepovets/296478/daily-weather-forecast/296478?day=1&unit=c\",\"Link\":\"http://www.accuweather.com/ru/ru/cherepovets/296478/daily-weather-forecast/296478?day=1&unit=c\"}]}";
        }

        List<Object> list = parsePrognoz(prognozData);
        return list;
    }

    private static List<Object> parsePrognoz(String prognozData) throws JsonProcessingException {
        //System.out.println(prognozData);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(prognozData, Map.class);
        // System.out.println(map);

        Map headlineMap = (Map) map.get("Headline");
        String textZagolovka = (String) headlineMap.get("Text");
        //System.out.println(textZagolovka);

        List dailyForecasts = (List) map.get("DailyForecasts");
        Map forecast = (Map) dailyForecasts.get(0);
        Map temperatures = (Map) forecast.get("Temperature");
        Map minimumTemp = (Map) temperatures.get("Minimum");
        Double minValueTemp = (Double) minimumTemp.get("Value");
        String minUnit = (String) minimumTemp.get("Unit");
        //System.out.println(minValueTemp + " " + minUnit);

        Map maxTemp = (Map) temperatures.get("Maximum");
        Double maxValueTemp = (Double) maxTemp.get("Value");
        String maxUnit = (String) maxTemp.get("Unit");
        //System.out.println(maxValueTemp + " " + maxUnit);

        String datestr = (String) forecast.get("Date");

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(datestr);
        int den = zonedDateTime.getDayOfMonth();
        String month = zonedDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());

        //   System.out.println(den + " " + month);
        String result = String.format("Погода в Череповце на %s: %s температура от %s до %s.",
                den + " " + month,
                textZagolovka,
                minValueTemp + " " + minUnit,
                maxValueTemp + " " + maxUnit
        );
        return Arrays.asList("Череповец", den + " " + month, maxValueTemp, result);
    }

    private static String prognoz() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        String apiKey = loadKey();
        String urlStr = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/296478?details=true&metric=true&language=ru-ru&apikey=" + apiKey;
        HttpUrl url = HttpUrl.parse(urlStr).newBuilder().build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.code());
        // System.out.println(response.headers());

        String body = response.body().string();
        //  System.System.out.println(body);
        return body;
    }

    private static String loadKey() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(Lesson7Main.class.getClassLoader().getResourceAsStream("apikey.secret")))) {
            return bufferedReader.readLine();
        }
    }
}
