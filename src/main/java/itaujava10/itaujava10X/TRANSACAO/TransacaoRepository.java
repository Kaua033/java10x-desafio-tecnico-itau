package itaujava10.itaujava10X.TRANSACAO;

import itaujava10.itaujava10X.ESTATISTICAS.estatisticaDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
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




    //Gerar estatisticas
 public estatisticaDTO GetEstatisticas(OffsetDateTime HoraInical){

        if (ListaDeTransaçao.isEmpty()){
            return  new  estatisticaDTO(0 ,0.0, 0.0, 0.0, 0.0);

        }
        //T == TransacaoRequest
        final  var sumary = ListaDeTransaçao.stream()
                .filter(T ->
                        //Na linha Abaixo e uma condicional, que tem que ser depois da hora inical ou igaul a hora inical
                            // "||" siginifica "OU"
                                T.getDataHora().isAfter(HoraInical) ||  T.getDataHora().isEqual(HoraInical)
                )
                //mapaea os numeros e transforma em double
                .mapToDouble(T -> T.getValor().doubleValue())
               //com o sumary e feito todos os calculos< maximo,minimo,suma etc..
                .summaryStatistics();
        return new estatisticaDTO(
                (int) sumary.getCount(),
                sumary.getAverage(),
                sumary.getMax(),
                sumary.getMin(),
                sumary.getSum()

        );
 }

}
