package com.codegate01.weatherapi.rapidapi;

import com.codegate01.weatherapi.entity.Location;
import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import okhttp3.*;


import java.io.IOException;
import java.io.StringReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WeatherApiPayload {

    public Location getLocationData(String endPointUrl, String key, String host) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(endPointUrl)
                .addHeader("X-RapidAPI-Key", key)
                .addHeader("X-RapidAPI-Host", host)
                .build();

        System.out.println(request.toString());

        Response call = client.newCall(request).execute();
        ResponseBody responseBody = call.body();

        if (call.code() != 200) {
            return null;
        } else {
            String jsonString  = responseBody.string();
            //System.out.println(jsonString );
            JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
            JsonObject jsonObj = jsonReader.readObject();
            System.out.println(jsonObj);
            jsonReader.close();

            JsonObject jsonLocationObject = jsonObj.getJsonObject("location");
            String name = jsonLocationObject.getString("name");
            String region = jsonLocationObject.getString("region");
            String country = jsonLocationObject.getString("country");
            String tzone = jsonLocationObject.getString("tz_id");

            JsonNumber latitude = jsonLocationObject.getJsonNumber("lat");
            JsonNumber longitude = jsonLocationObject.getJsonNumber("lon");
            String localTimeString = jsonLocationObject.getString("localtime");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalTime localTime = LocalTime.parse(localTimeString,formatter);


            return null;
            //return new Location(0L,name,region,country, latitude.doubleValue(), longitude.doubleValue(),tzone,localTime);

        }


    }
}
