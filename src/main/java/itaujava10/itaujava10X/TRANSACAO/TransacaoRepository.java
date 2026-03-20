package itaujava10.itaujava10X.TRANSACAO;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TransacaoRepository {
List<TransaçaoRequest> ListaDeTransaçao= new ArrayList<>();
    //Salvar dados em uma lista
    public void salvarDados(TransaçaoRequest transaçaoRequest){
        ListaDeTransaçao.add(transaçaoRequest );
    }

    //Apagar dados em 60 segundos
    public void LimparDados(TransaçaoRequest transaçaoRequest){

    }

    //Apagar todoas as transaçaoes
    public void ApagarTodosDados() {
        ListaDeTransaçao.clear();
    }

    /**
     * Retorna uma cópia da lista de transações.
     * Usamos cópia para evitar que alguém modifique a lista interna.
     */
    public List<TransaçaoRequest> listarTodas() {
        return new ArrayList<>(ListaDeTransaçao);
    }
}
