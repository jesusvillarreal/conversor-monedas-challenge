package com.jesus.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    private static final String API_KEY = "7232879af137a049be0d07ab";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    private Moneda usdToArs;
    private Moneda usdToBrl;
    private Moneda usdToCop;

    public ConsultarMoneda() {
        obtenerTasasDeCambio();
    }

    private void obtenerTasasDeCambio() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(API_URL))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

            usdToArs = new Moneda("ARS", conversionRates.get("ARS").getAsDouble());
            usdToBrl = new Moneda("BRL", conversionRates.get("BRL").getAsDouble());
            usdToCop = new Moneda("COP", conversionRates.get("COP").getAsDouble());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Moneda getUsdToArs() {
        return usdToArs;
    }

    public Moneda getUsdToBrl() {
        return usdToBrl;
    }

    public Moneda getUsdToCop() {
        return usdToCop;
    }
}
