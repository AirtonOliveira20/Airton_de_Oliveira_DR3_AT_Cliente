package br.pro.oliveira.CallBack;

import br.pro.oliveira.models.Carro;
import br.pro.oliveira.services.CarroService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class CallBackCarros implements Callback<List<Carro>> {

    @Override
    public void onResponse(Call<List<Carro>> call, Response<List<Carro>> response){
        List<Carro> carros = response.body();

        if(carros != null){
            for (Carro carro : carros){
                System.out.println(carro);
            }
        } else {
            System.out.println("Lista vazia");
        }
    }
    public void onFailure(Call<List<Carro>> call,Throwable t){
        System.out.println(t.getMessage());

    }
}
