package itaujava10.itaujava10X;

import java.util.ArrayList;
import java.util.List;

public class  transacaoRepository {
List<TransaçaoRequest> ListaDeTransaçao= new ArrayList<>();
    //Salvar dados em uma lista
    public void salvarDados(TransaçaoRequest transaçaoRequest){
        ListaDeTransaçao.add(transaçaoRequest );
    }

    //Apagar dados em 60 segundos
    public void LimparDados(TransaçaoRequest transaçaoRequest){

    }

    //Apagar todoas as transaçaoes
    public void ApagarTodosDados(TransaçaoRequest transaçaoRequest) {
        ListaDeTransaçao.clear();
    }
}
