
package br.test.objetos.dao;

import br.test.objetos.entidade.Paciente;
import br.test.objetos.entidade.Dentista;
import br.test.objetos.util.FabricaConexao;
import br.test.objetos.util.exception.ErroSistema;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DentistaDAO implements CrudDAO<Dentista>{

    @Override
    public void salvar(Dentista entidade) throws ErroSistema {
  try{
        Connection conexao=FabricaConexao.getConexao();
        PreparedStatement ps = null;
        if(entidade.getId()==null){        
        ps = conexao.prepareStatement("INSERT INTO `dentistas`(`login`,`senha`)VALUES(?,?);");  
        }else{
            ps=conexao.prepareStatement("update dentistas set login=?,senha=? where id = ?");
            ps.setInt(3, entidade.getId());
        }
        
        
       
        ps.setString(1, entidade.getLogin());
        ps.setString(2, entidade.getSenha());
        ps.execute();
        FabricaConexao.fecharConexao();
        }catch(SQLException ex){
            throw new ErroSistema("Erro - Ao Salvar dentista!",ex);       
        }
    }

    @Override
    public void deletar(Dentista entidade) throws ErroSistema {
          try {
            Connection conexao= FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from dentistas where id = ?");
            ps.setInt(1, entidade.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro - Ao deletar o dentista!",ex);
        }
    }

    @Override
    public List<Dentista> buscar() throws ErroSistema {
        try {
            Connection conexao= FabricaConexao.getConexao();
            PreparedStatement ps=conexao.prepareStatement("select * from dentistas");
            ResultSet resultSet=ps.executeQuery();
            List<Dentista> dentistas=new ArrayList<>();
            while(resultSet.next()){
                Dentista dentista=new Dentista();
                dentista.setId(resultSet.getInt("id"));
                dentista.setLogin(resultSet.getString("login"));
                dentista.setSenha(resultSet.getString("senha"));
                dentistas.add(dentista);     
            }
            FabricaConexao.fecharConexao();
            return dentistas;
        } catch (SQLException ex) {
            throw new ErroSistema("Erro - Ao Buscar o dentistas!",ex);
        }
    }
    
}
