/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.crudJPA.servico;

import com.claudio.crudJPA.entities.Produto;
import com.claudio.crudJPA.utils.GenericService;
import java.util.List;

/**
 *
 * @author claudio
 */

public class ProdutoServico extends GenericService<Produto>{

    public ProdutoServico(Class<Produto> clazz) {
        super(clazz);
    }

    
}
