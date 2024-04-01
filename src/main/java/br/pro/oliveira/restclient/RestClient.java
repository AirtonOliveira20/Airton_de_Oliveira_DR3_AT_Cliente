package br.pro.oliveira.restclient;

import br.pro.oliveira.services.CarroService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private Retrofit retrofit = null;

    private static RestClient instance = null;

    //instanciar retrofit
    private RestClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static RestClient getInstance(){
        if(instance ==null) {
            instance = new RestClient();

        }
        return instance;
    }

    public CarroService getCarroService() {
        return this.retrofit.create(CarroService.class);
    }

}
