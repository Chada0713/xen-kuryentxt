package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.BillingStatementModel;
import com.xenenergy.projects.entities.Du;
import com.xenenergy.projects.services.interfaces.BillsService;
import com.xenenergy.projects.services.interfaces.DuService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Created by xenuser on 5/17/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/reports")
public class BillingStatementController {
    @Autowired
    ServletContext servletContext;
    @Autowired
    private DuService duService;

    @Autowired
    private BillsService billsService;
    private InputStream reportStream;

    @RequestMapping(method = RequestMethod.GET)
    public String loadSurveyPg() {
        return "bills/reports";
    }

    @RequestMapping(value = "/bill-statement", method = RequestMethod.GET)
    public void generateReport(@RequestParam("periodFrm") String periodFrm, @RequestParam("periodTo") String periodTo,
                               HttpServletRequest request, HttpServletResponse response)
            throws ParseException, IOException {

        ServletOutputStream servletOutputStream = response.getOutputStream();
        reportStream = BillingStatementController.class.getClassLoader().getResourceAsStream("static/jasper/BillingStatement.jasper");
        List<BillingStatementModel> statementModels = new ArrayList<>();
        BillingStatementModel statementModel = new BillingStatementModel();
        List<Du> duModels = duService.getDU();
        for (Du duModel : duModels) {
            statementModel.setDuName(duModel.getDuName());
            statementModel.setAddressLine1(duModel.getAddressLn1());
            statementModel.setAddressLine2(duModel.getAddressLn2());
            statementModel.setContactPerson(duModel.getContactPerson());
            statementModel.setContactNo(duModel.getContactNumber());
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        int billsCount = billsService.countBills(periodFrm, periodTo);
        statementModel.setBillsCount(billsCount);
        statementModel.setCurDate(dateFormat.format(date));
        double totalbills =
                Double.parseDouble(Integer.toString(billsCount)) * 1.00;
        /*NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String finalAmount = formatter.format(totalbills);*/
        DecimalFormat df = new DecimalFormat("#.00");
        statementModel.setTotalBill("Php " + df.format(totalbills));
        statementModel.setDescription("Reading from " + periodFrm + " to " + periodTo);
        statementModel.setLogoPath("static/images/xesi_logo.png");
        statementModel.setSignatoryPath("static/images/signatory.png");
        statementModels.add(statementModel);
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("SUBREPORT_DIR", request.getSession().getServletContext()
                    .getRealPath("/") + "static\\jasper\\");
            params.put("IMAGE_DIR", request.getSession().getServletContext()
                    .getRealPath("/") + "static\\images\\");

            JRDataSource billingStatement = new JRBeanCollectionDataSource(statementModels);
            JasperRunManager.runReportToPdfStream(reportStream,
                    servletOutputStream, params, billingStatement);
            response.setContentType("application/pdf");
            servletOutputStream.flush();
            servletOutputStream.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            response.setContentType("text/plain");
            response.getOutputStream().print(stringWriter.toString());
        }
    }
}
