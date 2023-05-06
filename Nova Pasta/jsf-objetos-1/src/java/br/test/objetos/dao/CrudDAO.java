
package br.test.objetos.dao;

import br.test.objetos.util.exception.ErroSistema;
import java.util.List;

public interface CrudDAO <E>{
    public void salvar(E entidade) throws ErroSistema;
    public void deletar(E entidade) throws ErroSistema;
    public List<E> buscar() throws ErroSistema;
}
