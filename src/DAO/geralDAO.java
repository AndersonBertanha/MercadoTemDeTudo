package DAO;

import DTO.ClassePaiDTO;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import utils.CRUDUtil;
import utils.campo;
import utils.StringUtil;

public class geralDAO {

    private bancoDAO banco;

    public geralDAO() {
        banco = new bancoDAO();

    }

    public String atualizaRegistro(ClassePaiDTO objDTO) {
        ArrayList<campo> listadeCampos = objDTO.retornaCampos();
        StringUtil trataSTR = new StringUtil();
        String comando = " UPDATE " + objDTO.nomeDaTabela + " SET ";
        //String campos = "";
        String valores = "";
        for (int i = 0; i < listadeCampos.size(); i++) {

            if (!listadeCampos.get(i).chavePrimaria) {

                valores += listadeCampos.get(i).nomeDoCampo;
                if (listadeCampos.get(i).valorCampo.getClass() == String.class) {
                    valores += " = " + trataSTR.colocaAspasSimples(listadeCampos.get(i).valorCampo.toString());
                } else {
                    valores += " = " + listadeCampos.get(i).valorCampo.toString();
                }
                if (i < listadeCampos.size() - 1) {

                    valores += ",";
                }

            }
        }

        String comandoWhere = " WHERE ";
        for (int i = 0; i < listadeCampos.size(); i++) {
            if (listadeCampos.get(i).chavePrimaria) {
                comandoWhere += listadeCampos.get(i).nomeDoCampo + " = " + listadeCampos.get(i).valorCampo.toString();

            }
        }

        String comandoFinal = comando + valores + comandoWhere;
        banco.executaComando(comandoFinal);
        return comandoFinal;
    }

    public TableModel retornaConsulta(ClassePaiDTO objDTO, String filtro) {
        String comando = "";
        
        if (filtro == "") {
            comando = "select *from " + objDTO.nomeDaTabela;
        } else {
            comando = "select *from " + objDTO.nomeDaTabela + " where " + filtro;
        }
        return CRUDUtil.resultSetToTableModel(banco.retornaDados(comando));

    }

    public String apagaRegistro(ClassePaiDTO objDTO) {
        ArrayList<campo> listadeCampos = objDTO.retornaCampos();
        String comando = "delete from " + objDTO.nomeDaTabela + " where ";
        String comandoWhere = "";
        for (int i = 0; i < listadeCampos.size(); i++) {
            if (listadeCampos.get(i).chavePrimaria) {
                comandoWhere = listadeCampos.get(i).nomeDoCampo + " = " + listadeCampos.get(i).valorCampo.toString();

            }
        }
        banco.executaComando(comando + comandoWhere);
        return comando + comandoWhere;
    }

    public String insereRegistro(ClassePaiDTO objDTO) {
        ArrayList<campo> listadeCampos = objDTO.retornaCampos();
        StringUtil trataSTR = new StringUtil();
        String comando = "Insert into " + objDTO.nomeDaTabela;
        String campos = "";
        String valores = "";
        for (int i = 0; i < listadeCampos.size(); i++) {

            if (!listadeCampos.get(i).chavePrimaria) {
                campos += listadeCampos.get(i).nomeDoCampo;
                if (listadeCampos.get(i).valorCampo.getClass() == String.class) {
                    valores += trataSTR.colocaAspasSimples(listadeCampos.get(i).valorCampo.toString());
                } else {
                    valores += listadeCampos.get(i).valorCampo.toString();
                }
                if (i < listadeCampos.size() - 1) {
                    campos += ",";
                    valores += ",";
                }

            }
        }
        comando += "(" + campos + ")" + "values(" + valores + ")";
        banco.executaComando(comando);
        return comando;
    }

}
