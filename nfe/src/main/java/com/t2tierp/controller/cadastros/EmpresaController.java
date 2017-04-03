package com.t2tierp.controller.cadastros;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.t2tierp.controller.AbstractController;
import com.t2tierp.model.bean.cadastros.Empresa;
import com.t2tierp.model.bean.cadastros.EmpresaEndereco;
import com.t2tierp.model.dao.InterfaceDAO;
import com.t2tierp.util.FacesContextUtil;

@ManagedBean
@ViewScoped
public class EmpresaController extends AbstractController<Empresa> implements Serializable {	
	
	
		private static final long serialVersionUID = 1L;
		
		private EmpresaEndereco empresaEnderecoSelecionado;
		private EmpresaEndereco empresaEndereco;
		
		@EJB
		private InterfaceDAO<EmpresaEndereco> empresaEnderecoDao;

		
		@Override
		public Class<Empresa> getClazz() {
			return Empresa.class;
		}

		@Override
		public String getFuncaoBase() {
			return "EMPRESA";
		}

		@Override
		public void incluir() {
			super.incluir();
		
		}

		@Override
		public void salvar(String mensagem) {		
			super.salvar(mensagem);
		}
		
		public void incluirEndereco() {
			empresaEndereco = new EmpresaEndereco();
			empresaEndereco.setEmpresa(getObjeto());
		}
		
		public void alterarEndereco() {
			empresaEndereco = empresaEnderecoSelecionado;
		}
		
		public void salvarEndereco() {
			if (empresaEndereco.getCep() != null) {
				empresaEndereco.setCep(empresaEndereco.getCep().replaceAll("\\D", ""));
			}
			if (empresaEndereco.getId() == null) {
				getObjeto().getListaEndereco().add(empresaEndereco);
			}
			salvar("Endereço salvo com sucesso!");
		}
		
		public void excluirEndereco() {
			if (empresaEnderecoSelecionado == null || empresaEnderecoSelecionado.getId() == null) {
				FacesContextUtil.adiconaMensagem(FacesMessage.SEVERITY_INFO, "Nenhum registro selecionado!", null);
			} else {
				getObjeto().getListaEndereco().remove(empresaEnderecoSelecionado);
				salvar("Endereço excluído com sucesso!");
			}
		}
		

		public EmpresaEndereco getEmpresaEnderecoSelecionado() {
			return empresaEnderecoSelecionado;
		}

		public void setEmpresaEnderecoSelecionado(EmpresaEndereco empresaEnderecoSelecionado) {
			this.empresaEnderecoSelecionado = empresaEnderecoSelecionado;
		}

		public EmpresaEndereco getEmpresaEndereco() {
			return empresaEndereco;
		}

		public void setEmpresaEndereco(EmpresaEndereco empresaEndereco) {
			this.empresaEndereco = empresaEndereco;
		}
		
		
				

	

}
