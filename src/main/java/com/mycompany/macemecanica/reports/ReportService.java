package com.mycompany.macemecanica.reports;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ReportService {
    
    public JasperPrint generateCompanyReport(ReportCompanyDataSource dataSource) throws JRException{
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "Reporte de empresas");
        System.out.println("ruta: " + Paths.get("empresasMace.jasper").toAbsolutePath().toString());
        JasperPrint jp = JasperFillManager.fillReport(Paths.get("empresasMace.jasper").toAbsolutePath().toString(), parameters, dataSource);
        return jp;
    }
}
