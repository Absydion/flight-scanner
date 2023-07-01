package com.app.service;

import com.app.entity.Flight;
import com.app.repository.FlightRepository;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        Flight flightToUpdate = flightRepository.findById(id).orElse(null);
        if (flightToUpdate != null) {
            flightToUpdate.setDeparturePlace(flight.getDeparturePlace());
            flightToUpdate.setArrivalPlace(flight.getArrivalPlace());
            flightToUpdate.setArrivalTime(flight.getArrivalTime());
            flightToUpdate.setDepartureDate(flight.getDepartureDate());
            flightRepository.save(flightToUpdate);
        }
        return flightToUpdate;
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> searchFlights(String departure, String destination, LocalDate date) {
        return flightRepository.findByDeparturePlaceAndArrivalPlaceAndDepartureDate(departure, destination, date);
    }
    public double getCurrentFlightPrice(String flightNumber) {
        // Twój kod do komunikacji z API linii lotniczych i pobrania aktualnej ceny lotu
        // Możesz użyć odpowiednich klas i metod dostępnych w wybranej bibliotece HTTP lub kliencie API

        // Przykładowy kod użycia Apache HttpClient:
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://api.airlines.com/flights/" + flightNumber);
        CloseableHttpResponse response = httpClient.execute(request);

        try {
            if (response.getStatusLine().getStatusCode() == 200) {
                // Pobranie odpowiedzi z API i odczytanie aktualnej ceny lotu
                String responseBody = EntityUtils.toString(response.getEntity());
                double currentPrice = parseFlightPriceFromResponse(responseBody);
                return currentPrice;
            } else {
                // Obsługa błędu w przypadku niepowodzenia zapytania do API
                // Możesz rzucać wyjątki lub zwracać wartość domyślną w zależności od potrzeb
                throw new RuntimeException("Błąd podczas pobierania ceny lotu.");
            }
        } finally {
            response.close();
            httpClient.close();
        }
    }

    private double parseFlightPriceFromResponse(String responseBody) {

        // Analiza odpowiedzi z API i odczytanie aktualnej ceny lotu
        // W zależności od struktury odpowiedzi i formatu ceny, możesz użyć odpowiednich narzędzi takich jak JSON parser lub regularne wyrażenia

        // Przykładowa implementacja dla odpowiedzi w formacie JSON
        try {
            JSONObject responseJson = new JSONObject(responseBody);
            double currentPrice = responseJson.getDouble("price");
            return currentPrice;
        } catch (JSONException e) {
            throw new RuntimeException("Błąd podczas analizowania odpowiedzi API.");
        }
    }

}
