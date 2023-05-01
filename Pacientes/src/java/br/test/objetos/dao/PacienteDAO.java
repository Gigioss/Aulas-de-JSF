package br.test.objetos.dao;

import br.test.objetos.entidade.Paciente;
import br.test.objetos.util.FabricaConexao;
import br.test.objetos.util.exception.ErroSistema;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




public class PacienteDAO implements CrudDAO<Paciente>{
    
    @Override
    public void salvar(Paciente paciente) throws ErroSistema{
        try{
        Connection conexao=FabricaConexao.getConexao();
        PreparedStatement ps = null;
        if(paciente.getId()==null){        
        ps = conexao.prepareStatement("INSERT INTO `paciente`(`nome`,`telefone`,`email`)VALUES(?,?,?);");  
        }else{
            ps=conexao.prepareStatement("update paciente set nome=?,telefone=?,email=? where id = ?");
            ps.setInt(4, paciente.getId());
        }
        
        
       
        ps.setString(1, paciente.getNome());
        ps.setString(2, paciente.getTelefone());
        ps.setString(3, paciente.getEmail());
        ps.execute();
        FabricaConexao.fecharConexao();
        }catch(SQLException ex){
            throw new ErroSistema("Erro - Ao Salvar paciente!",ex);       
        }
    }
    public void deletar(Paciente paciente) throws ErroSistema{
        try {
            Connection conexao= FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from carro where id = ?");
            ps.setInt(1, paciente.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro - Ao deletar o paciente!",ex);
        }
    }  
    @Override
    public List<Paciente> buscar() throws ErroSistema{
        
        try {
            Connection conexao= FabricaConexao.getConexao();
            PreparedStatement ps=conexao.prepareStatement("select * from paciente");
            ResultSet resultSet=ps.executeQuery();
            List<Paciente> pacientes=new ArrayList<>();
            while(resultSet.next()){
                Paciente paciente= new Paciente();                        
                paciente.setId(resultSet.getInt("id"));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setTelefone(resultSet.getString("telefone"));
                paciente.setEmail(resultSet.getString("email"));
                pacientes.add(paciente);     
            }
            FabricaConexao.fecharConexao();
            return pacientes;
        } catch (SQLException ex) {
            throw new ErroSistema("Erro - Ao Buscar o paciente!",ex);
        }
        
    }
    
}
