package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.models.EmpresaFacade;
import com.mycompany.macemecanica.reports.ReportCompanyDataSource;
import com.mycompany.macemecanica.reports.ReportService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Named(value = "reportesController")
@RequestScoped
public class ReportesController {

    @EJB 
    private EmpresaFacade empresaFacade;
    private ReportService reportService = new ReportService();
    
    public ReportesController() {
    }
    
    public void download(){
        try{
            JasperPrint jp = reportService.generateCompanyReport(new ReportCompanyDataSource(empresaFacade.findAll()));
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.addHeader("Content-disposition", "attachment; filename=empresasMace.pdf");
            ServletOutputStream sos = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp,sos);
            sos.flush();
            sos.close();
            FacesContext.getCurrentInstance().responseComplete();
            System.out.println("sos:" + sos.toString());
        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}