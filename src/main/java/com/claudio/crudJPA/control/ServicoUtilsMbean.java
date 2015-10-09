/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.crudJPA.control;

import org.primefaces.context.RequestContext;

/**
 *
 * @author claudio
 */
public class ServicoUtilsMbean {

    public static void update(String idComponente) {
        RequestContext.getCurrentInstance().update(idComponente);
    }
}
