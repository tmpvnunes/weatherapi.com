package com.codegate01.weatherapi.rapidapi;

import com.codegate01.weatherapi.entity.Location;
import com.codegate01.weatherapi.model.Current;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.*;
import okhttp3.*;


import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class WeatherApiPayload {

    public Location getLocationData(String endPointUrl, String key, String host) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(endPointUrl)
                .addHeader("X-RapidAPI-Key", key)
                .addHeader("X-RapidAPI-Host", host)
                .build();


        Response call = client.newCall(request).execute();
        ResponseBody responseBody = call.body();

        if (call.code() != 200) {
            return null;
        } else {
            assert responseBody != null;
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

            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            //LocalTime localTime = LocalTime.parse(localTimeString,formatter);


            JsonObject jsonArray = jsonObj.getJsonObject("current");
            ObjectMapper objectMapper = new ObjectMapper();

            List<Current> currentList = objectMapper.readValue(jsonArray.toString(), new TypeReference<>() {
            });


            return new Location(name,region,country, latitude.doubleValue(), longitude.doubleValue(),tzone,localTimeString, currentList);

        }


    }
}
