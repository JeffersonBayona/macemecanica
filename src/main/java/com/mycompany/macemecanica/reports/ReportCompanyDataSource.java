package com.mycompany.macemecanica.reports;

import com.mycompany.macemecanica.entitys.Empresa;
import com.mycompany.macemecanica.entitys.TiposDoc;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ReportCompanyDataSource implements JRDataSource{
    private Empresa e = new Empresa();
    private List<Empresa> empresa;
    private int indice;
    
    public ReportCompanyDataSource(List<Empresa> empresa){
        this.empresa = empresa;
        indice = -1;
    }

    @Override
    public boolean next() throws JRException {
        indice ++;
        return indice < empresa.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Empresa em = empresa.get(indice);
        if(jrf.getName().equals("idempresa")){
            return em.getIdempresa();
        } else if (jrf.getName().equals("tipoDocumento")){
            return em.getTipoDocumento().toString();
        } else if (jrf.getName().equals("numDocumento")){
            return em.getNumDocumento();
        } else if (jrf.getName().equals("nombreRazonSocial")){
            return em.getNombreRazonSocial();
        } else if (jrf.getName().equals("direccionEmpresa")){
            return em.getDireccionEmpresa();
        } else if (jrf.getName().equals("telEmpresa")){
            return em.getTelEmpresa();
        } else if (jrf.getName().equals("mailEmpresa")){
            return em.getMailEmpresa();
        } else{
            return null;  
        }
        
    }
    
}
