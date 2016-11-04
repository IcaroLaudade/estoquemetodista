/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.DAO;

import br.com.estoque.objeto.Funcionario;
import java.util.HashMap;
import java.util.Map;

 
public class FuncionarioDAO {
    private final static Map<String, Funcionario> FUNCIONARIOS = new HashMap();
	static {
		FUNCIONARIOS.put("usuario", new Funcionario("user","user1","usuario"));
		FUNCIONARIOS.put("admin", new Funcionario("admin","admin","admin"));
                FUNCIONARIOS.put("icaro@metodista.br", new Funcionario("icaro@metodista.br","icaro","Icaro Alcantara"));
                FUNCIONARIOS.put("teste", new Funcionario("teste","teste2","teste"));
        }

	public Funcionario buscaPorUsuarioESenha(String usuario, String senha) {
		if (!FUNCIONARIOS.containsKey(usuario))
			return null;

		Funcionario funcionario = FUNCIONARIOS.get(usuario);
		if (funcionario.getPassword().equals(senha))
			return funcionario;
		
		return null;
	}
        
        public Funcionario buscaPorUsuario(String usuario) {
		if (!FUNCIONARIOS.containsKey(usuario)){
			return null;
                }else{
                Funcionario funcionario = FUNCIONARIOS.get(usuario);
                return funcionario;
                }
	}
          public Funcionario buscaPorSenha(String senha) {

                Funcionario funcionario = new Funcionario();
		if (funcionario.getPassword().equals(senha))
			return funcionario;
		
		return null;
	}
}
