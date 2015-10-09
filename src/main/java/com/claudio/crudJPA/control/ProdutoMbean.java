/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.crudJPA.control;

import com.claudio.crudJPA.entities.Produto;
import com.claudio.crudJPA.servico.ProdutoServico;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author claudio
 */

@ManagedBean
@ViewScoped
public class ProdutoMbean extends ManagedBeanGenerico{
    
    private ProdutoServico ps;
    private Produto p;
    
    public void salvar(Produto p) {
        ps.salvar(p);
        ServicoUtilsMbean.update("rsrsrs");
    }
    
    public void excluir(Produto p) {
        ps.excluir(p);
    }

    @Override
    public void init() {
        super.init(); 
    }
    
    
    

}
