/*
* The MIT License
* 
* Copyright: Copyright (C) 2014 T2Ti.COM
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
* 
* The author may be contacted at: t2ti.com@gmail.com
*
* @author Claudio de Barros (T2Ti.com)
* @version 2.0
*/
package com.t2tierp.model.bean.compras;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "COMPRA_COTACAO")
public class CompraCotacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_COTACAO")
    private Date dataCotacao;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "SITUACAO")
    private String situacao;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "compraCotacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompraFornecedorCotacao> listaCompraFornecedorCotacao;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "compraCotacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CompraReqCotacaoDetalhe> listaCompraReqCotacaoDetalhe;

    public CompraCotacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(Date dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "com.t2tierp.model.bean.compras.CompraCotacao[id=" + id + "]";
    }

	public Set<CompraFornecedorCotacao> getListaCompraFornecedorCotacao() {
		return listaCompraFornecedorCotacao;
	}

	public void setListaCompraFornecedorCotacao(Set<CompraFornecedorCotacao> listaCompraFornecedorCotacao) {
		this.listaCompraFornecedorCotacao = listaCompraFornecedorCotacao;
	}

	public Set<CompraReqCotacaoDetalhe> getListaCompraReqCotacaoDetalhe() {
		return listaCompraReqCotacaoDetalhe;
	}

	public void setListaCompraReqCotacaoDetalhe(Set<CompraReqCotacaoDetalhe> listaCompraReqCotacaoDetalhe) {
		this.listaCompraReqCotacaoDetalhe = listaCompraReqCotacaoDetalhe;
	}

}
