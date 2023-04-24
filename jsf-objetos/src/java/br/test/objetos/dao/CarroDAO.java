package br.test.objetos.dao;

import br.test.objetos.entidade.Carro;
import br.test.objetos.util.FabricaConexao;
import br.test.objetos.util.exception.ErroSistema;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




public class CarroDAO {
    public void salvar(Carro carro) throws ErroSistema{
        try{
        Connection conexao=FabricaConexao.getConexao();
        PreparedStatement ps = null;
        if(carro.getId()==null){        
        ps = conexao.prepareStatement("INSERT INTO `carro`(`modelo`,`fabricante`,`cor`,`ano`)VALUES(?,?,?,?);");  
        }else{
            ps=conexao.prepareStatement("update carro set modeo=?,fabricante=?,cor=?,ano=? where id=?");
            ps.setInt(5, carro.getId());
        }
        
        
       
        ps.setString(1, carro.getModelo());
        ps.setString(2, carro.getFabricante());
        ps.setString(3, carro.getCor());
        ps.setDate(4, new Date(carro.getAno().getTime()));
        ps.execute();
        FabricaConexao.fecharConexao();
        }catch(SQLException ex){
            throw new ErroSistema("Erro - Ao Salvar carro!",ex);       
        }
    }
    public void deletar(Integer idCarro) throws ErroSistema{
        try {
            Connection conexao= FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from carro where idtable1 = ?");
            ps.setInt(1, idCarro);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro - Ao deletar o carro!",ex);
        }
    }
    public List<Carro> buscar() throws ErroSistema{
        
        try {
            Connection conexao= FabricaConexao.getConexao();
            PreparedStatement ps=conexao.prepareStatement("select * from carro");
            ResultSet resultSet=ps.executeQuery();
            List<Carro> carros=new ArrayList<>();
            while(resultSet.next()){
                Carro carro=new Carro();
                carro.setId(resultSet.getInt("idtable1"));
                carro.setModelo(resultSet.getString("modelo"));
                carro.setFabricante(resultSet.getString("fabricante"));
                carro.setCor(resultSet.getString("cor"));
                carro.setAno(resultSet.getDate("ano"));
                carros.add(carro);     
            }
            FabricaConexao.fecharConexao();
            return carros;
        } catch (SQLException ex) {
            throw new ErroSistema("Erro - Ao Buscar o carro!",ex);
        }
        
    }
    
}
