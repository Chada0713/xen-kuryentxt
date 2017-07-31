package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.BillingStatementModel;
import com.xenenergy.projects.services.interfaces.BillsService;
import com.xenenergy.projects.services.interfaces.PropertyService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private BillsService billsService;
    private InputStream reportStream;

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loadSurveyPg() {
        ModelAndView modelAndView = new ModelAndView("bills/reports");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -30);

        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(new Date()); // Now use today date.

        modelAndView.addObject("date", sdf.format(c.getTime()));
        modelAndView.addObject("currentDate", sdf.format(currentDate.getTime()));
        return modelAndView;
    }

    @RequestMapping(value = "/bill-statement", method = RequestMethod.GET)
    public void generateReport(@RequestParam("periodFrm") String periodFrm, @RequestParam("periodTo") String periodTo,
                               HttpServletRequest request, HttpServletResponse response)
            throws ParseException, IOException {

        ServletOutputStream servletOutputStream = response.getOutputStream();
        reportStream = BillingStatementController.class.getClassLoader().getResourceAsStream("static/jasper/BillingStatement.jasper");
        List<BillingStatementModel> statementModels = new ArrayList<>();
        BillingStatementModel statementModel = new BillingStatementModel();

        statementModel.setDuName(propertyService.findByPropertyName("DU_NAME").getPropertyValue());
        statementModel.setAddressLine1(propertyService.findByPropertyName("DU_ADDRESSLN1").getPropertyValue());
        statementModel.setAddressLine2(propertyService.findByPropertyName("DU_ADDRESSLN2").getPropertyValue());
        statementModel.setContactPerson(propertyService.findByPropertyName("DU_CONTACT_PERSON").getPropertyValue());
        statementModel.setContactNo(propertyService.findByPropertyName("DU_CONTACT_NO").getPropertyValue());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        int billsCount = billsService.countBills(periodFrm, periodTo);
        statementModel.setBillsCount(billsCount);
        statementModel.setCurDate(dateFormat.format(date));
        double totalbills =
                Double.parseDouble(Integer.toString(billsCount)) * 1.00;
        /*NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String finalAmount = formatter.format(totalbills);*/
        DecimalFormat df = new DecimalFormat("#,###.00");
        statementModel.setTotalBill("Php " + df.format(totalbills));
        statementModel.setDescription("Reading from " + periodFrm + " to " + periodTo);
        Path path = Paths.get("C:/Kuryentxtweb/ext/");
        statementModel.setLogoPath(path.toString() + "/xesi_logo.png");
        statementModel.setSignatoryPath(path.toString() + "/signatory.png");
        statementModels.add(statementModel);
        try {
            Map<String, Object> params = new HashMap<String, Object>();

            JRDataSource billingStatement = new JRBeanCollectionDataSource(statementModels);
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, params, billingStatement);
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
