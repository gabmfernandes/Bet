package Modelos;


import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Baralho {

    public boolean success;
    public String deck_id;
    public Carta[] cards;
    public int remaining;

    public void criarBaralho() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        Baralho baralhoAux = gson.fromJson(json, Baralho.class);
        this.deck_id = baralhoAux.deck_id;
        this.remaining = baralhoAux.remaining;


    }

    public void puxarCarta() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://deckofcardsapi.com/api/deck/"+this.deck_id+"/draw/?count=1")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();


        Gson gson = new Gson();
        Baralho baralho = gson.fromJson(json, Baralho.class);

        System.out.println(json);

        System.out.println(baralho.cards[0].value);
        System.out.println(baralho.cards[0].suit);



    }



}

