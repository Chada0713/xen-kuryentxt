package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.BillingStatementModel;
import com.xenenergy.projects.entities.Du;
import com.xenenergy.projects.services.DuServiceImpl;
import com.xenenergy.projects.services.impl.BillsServiceImpl;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xenuser on 5/17/2017.
 */
@Controller
@RequestMapping("/reports")
public class BillingStatementController {
    @Autowired
    ServletContext servletContext;
    @Autowired
    private DuServiceImpl duService;

    @Autowired
    private BillsServiceImpl billsService;
    private InputStream reportStream;

    @RequestMapping(method = RequestMethod.GET)
    public String loadSurveyPg() {
        return "bills/reports";
    }

    @RequestMapping(value = "/bill-statement", method = RequestMethod.GET)
    public void generateReport(@RequestParam("periodFrm") String periodFrm, @RequestParam("periodTo") String periodTo,
                               HttpServletRequest request, HttpServletResponse response)
            throws ParseException, IOException {

        URL jasperFile = BillingStatementController.class
                .getClassLoader().getResource("static/jasper/BillingStatement.jasper");

        ServletOutputStream servletOutputStream = response.getOutputStream();
        File file;
        try {
            file = new File(jasperFile.toURI());
            reportStream = new BufferedInputStream(new FileInputStream(file));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
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
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String finalAmount = formatter.format(totalbills);
        statementModel.setTotalBill(finalAmount);
        statementModel.setDescription("Reading from " + periodFrm + " to " + periodTo);
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
