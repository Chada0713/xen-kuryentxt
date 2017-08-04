package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.*;
import com.xenenergy.projects.services.interfaces.*;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xesi on 17/05/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("")
public class BillsController {

    @Autowired
    private BillsService billsService;

    @Autowired
    private BillChargeGroupService billChargeGroupService;

    @Autowired
    private BillChargeDetailService billChargeDetailService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BillAddOnChargeService billAddOnChargeService;

    private InputStream reportStream;

    @RequestMapping(value = "/bills", method = RequestMethod.GET)
    public String getBills(){
        return "bills/index";
    }

    @GetMapping("/bills/viewbill")
    public String showbillForm(@RequestParam("billno") String billno, Model model) throws Exception {
        /*Bill Header*/
        Bills bill = billsService.findByBillNo(billno);
        model.addAttribute("bill", bill);

        List<ChargeGroupDetails> chargeGroupDetailsList = new ArrayList<>();
        for(BillChargeGroup billChargeGroupList : billChargeGroupService.findByBillNo(billno)){
            ChargeGroupDetails chargeGroup = new ChargeGroupDetails();
            chargeGroup.setChargeGroupName(billChargeGroupList.getChargeGroupName());
            chargeGroup.setChargeSum(billChargeGroupList.getChargeSum());
            chargeGroup.setChargeTotalgroup(billChargeGroupList.getChargeTotal());
            chargeGroupDetailsList.add(chargeGroup);
            for(BillChargeDetail billChargeDetailList : billChargeDetailService.findByPrintOrderMasterAndBillNo((int)billChargeGroupList.getPrintOrder(), billno)){
                ChargeGroupDetails chargeDetails = new ChargeGroupDetails();
                chargeDetails.setChargeName(billChargeDetailList.getChargeLongName());
                chargeDetails.setChargeAmount(billChargeDetailList.getChargeAmount());
                chargeDetails.setChargeTotal(billChargeDetailList.getChargeTotal());
                chargeGroupDetailsList.add(chargeDetails);
            }
        }

        String[] du = new String[7];
        if(propertyService.findByPropertyName("DU_CODE") != null){
            du[0] = propertyService.findByPropertyName("DU_CODE").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_NAME") != null){
            du[1] = propertyService.findByPropertyName("DU_NAME").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN1") != null){
            du[2] = propertyService.findByPropertyName("DU_ADDRESSLN1").getPropertyValue();
        }else{
            du[2] = "";
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN2") != null){
            du[3] = propertyService.findByPropertyName("DU_ADDRESSLN2").getPropertyValue();
        }else{
            du[3] = "";
        }
        if(propertyService.findByPropertyName("DU_VAT_NO") != null){
            du[4] = propertyService.findByPropertyName("DU_VAT_NO").getPropertyValue();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(bill.getDueDate()); // Now use today date.
        c.add(Calendar.DATE, 10); // Adding 5 days
        model.addAttribute("discDate",sdf.format(c.getTime()));
        Date runDate = new SimpleDateFormat("yyyy-MM-dd").parse(bill.getRunDate());
        model.addAttribute("runDate", sdf.format(runDate));

        model.addAttribute("billgroupLists", chargeGroupDetailsList);
        model.addAttribute("du", du);
        model.addAttribute("account", accountService.getByOldAccountNo(billsService.findByBillNo(billno).getOldAcctNo()));
        model.addAttribute("billAddOnChargeLists", billAddOnChargeService.findByBillNo(billno));
        model.addAttribute("backButton", "/Kuryentxt/bills");
        return "bills/viewbill";
    }

    @RequestMapping(value = "/bills/bill-report", method = RequestMethod.GET)
    public void generateBill(@RequestParam("billNo") String billNo, HttpServletResponse response) throws Exception {
        ServletOutputStream servletOutputStream = response.getOutputStream();
        DecimalFormat myFormatter = new DecimalFormat("0.0000");
        DecimalFormat myFormatter2 = new DecimalFormat("0.00");

        reportStream = BillingStatementController.class.getClassLoader().getResourceAsStream("static/jasper/BillReports.jasper");

        Account account = accountService.getByOldAccountNo(billsService.findByBillNo(billNo).getOldAcctNo());

        List<BillReportModel> billReportModelList = new ArrayList<>();
        BillReportModel billReportModel = new BillReportModel();

        billReportModel.setOldAcctNo(account.getOldAccountNo());
        billReportModel.setAccountName(account.getAccountName());
        billReportModel.setAddressLn1(account.getAddressLn1());
        billReportModel.setAddressLn2(account.getAddressLn2());

        //[] du = new String[7];
        billReportModel.setDuCode(propertyService.findByPropertyName("DU_CODE").getPropertyValue());
        billReportModel.setDuName(propertyService.findByPropertyName("DU_NAME").getPropertyValue());
        billReportModel.setAddrLn1(propertyService.findByPropertyName("DU_ADDRESSLN1").getPropertyValue());
        billReportModel.setAddrLn2(propertyService.findByPropertyName("DU_ADDRESSLN2").getPropertyValue());
        billReportModel.setContactPerson(propertyService.findByPropertyName("DU_CONTACT_PERSON").getPropertyValue());
        billReportModel.setContactNumber(propertyService.findByPropertyName("DU_CONTACT_NO").getPropertyValue());

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");

        Bills bill = billsService.findByBillNo(billNo);
        billReportModel.setBillNo(bill.getBillNo());
        billReportModel.setConsumerType(bill.getConsumerType());
        billReportModel.setPeriodFrom(sdf.format(bill.getPeriodFrom()));
        billReportModel.setPeriodTo(sdf.format(bill.getPeriodTo()));
        billReportModel.setDueDate(sdf.format(bill.getDueDate()));
        billReportModel.setMeterNo(bill.getMeterNo());
        billReportModel.setAccountNo(bill.getAccountNo());
        billReportModel.setRouteCode(bill.getRouteCode());
        billReportModel.setSequenceNo(Integer.toString(bill.getSequenceNo()));
        billReportModel.setCurrentReading(String.valueOf(bill.getCurrentReading()));
        billReportModel.setPreviousReading(String.valueOf(bill.getPreviousReading()));
        billReportModel.setConsumption(String.valueOf(bill.getConsumption()));
        billReportModel.setMultiplier(String.valueOf(bill.getMultiplier()));
        billReportModel.setTotalOfMultiplierCon(String.valueOf(bill.getConsumption() * bill.getMultiplier()));
        billReportModel.setCoreloss(String.valueOf(bill.getCoreloss()));
        billReportModel.setAddOnKwhTotal(String.valueOf(bill.getAddOnKwhTotal()));
        billReportModel.setTotalConsumption(String.valueOf(bill.getTotalConsumption()));
        billReportModel.setCurrentBill(Double.toString(bill.getCurrentBill()));
        billReportModel.setTotalAmountDue(Double.toString(bill.getTotalAmountDue()));

        String addOnC = "", addOnVal = "";
        if(!billAddOnChargeService.findByBillNo(billNo).isEmpty()){
            billReportModel.setAddOnChargeHeader("ADD ON CHARGE");
            for(BillAddOnCharge billAddOnChargeList : billAddOnChargeService.findByBillNo(billNo)){
                addOnC += billAddOnChargeList.getAddOnCharge() + System.lineSeparator();
                addOnVal += myFormatter2.format(billAddOnChargeList.getValueCharge()) + System.lineSeparator();
            }
            billReportModel.setAddOnCharge(addOnC);
            billReportModel.setValueCharge(addOnVal);
        }

        Calendar c = Calendar.getInstance();
        c.setTime(bill.getDueDate());
        c.add(Calendar.DATE, 10);
        billReportModel.setDisconnectionDate(sdf.format(c.getTime()));
        Date runDate = new SimpleDateFormat("yyyy-MM-dd").parse(bill.getRunDate());
        billReportModel.setRunDate(sdf.format(runDate));

        String chargeN = "", chargeA = "", chargeT = "";
        for(BillChargeGroup billChargeGroupList : billChargeGroupService.findByBillNo(billNo)){
            chargeN=chargeN+billChargeGroupList.getChargeGroupName().toUpperCase() + System.lineSeparator();
            chargeA=chargeA+myFormatter.format(billChargeGroupList.getChargeSum()) + System.lineSeparator();
            chargeT=chargeT+myFormatter2.format(billChargeGroupList.getChargeTotal()) + System.lineSeparator();
            for(BillChargeDetail billChargeDetailList : billChargeDetailService.findByPrintOrderMasterAndBillNo((int)billChargeGroupList.getPrintOrder(), billNo)){
                chargeN=chargeN+"    "+billChargeDetailList.getChargeLongName() + System.lineSeparator();
                chargeA=chargeA+"    "+myFormatter.format(billChargeDetailList.getChargeAmount()) + System.lineSeparator();
                chargeT=chargeT+"    "+myFormatter2.format(billChargeDetailList.getChargeTotal()) + System.lineSeparator();
            }
        }
        billReportModel.setChargeName(chargeN);
        billReportModel.setChargeAmount(chargeA);
        billReportModel.setChargeTotal(chargeT);

        billReportModelList.add(billReportModel);

        /*Connection conn;
        Class.forName(jdbcDriver);
        conn = DriverManager.getConnection(sdriver + url + ":" + port + "/" + dbname, username, password);*/
        try{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("billNo", billNo);

            JRDataSource billingDetails = new JRBeanCollectionDataSource(billReportModelList);
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, params, billingDetails);
            response.setContentType("application/pdf");
            servletOutputStream.flush();
            servletOutputStream.close();
        }catch (Exception e){
            System.out.println(e.toString());
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            response.setContentType("text/plain");
            response.getOutputStream().print(stringWriter.toString());
        }
    }

    /*By Old_Account_No*/
    @RequestMapping(value = "/bills/viewbillbyaccountno", method = RequestMethod.GET)
    public String showbillFormAcct(@RequestParam("oldaccountno") String oldacctno, Model model) throws Exception {
        List<Bills> billsList = billsService.findByOldAcctNo(oldacctno);
        if(!billsList.isEmpty()){
            String billno = "";
            Bills bills = new Bills();
            for(Bills bill : billsList){
                billno = bill.getBillNo();
                bills = bill;
            }
            model.addAttribute("bill", bills);

            List<ChargeGroupDetails> chargeGroupDetailsList = new ArrayList<>();
            for(BillChargeGroup billChargeGroupList : billChargeGroupService.findByBillNo(billno)){
                ChargeGroupDetails chargeGroup = new ChargeGroupDetails();
                chargeGroup.setChargeGroupName(billChargeGroupList.getChargeGroupName());
                chargeGroup.setChargeSum(billChargeGroupList.getChargeSum());
                chargeGroup.setChargeTotalgroup(billChargeGroupList.getChargeTotal());
                chargeGroupDetailsList.add(chargeGroup);
                for(BillChargeDetail billChargeDetailList : billChargeDetailService.findByPrintOrderMasterAndBillNo((int)billChargeGroupList.getPrintOrder(), billno)){
                    ChargeGroupDetails chargeDetails = new ChargeGroupDetails();
                    chargeDetails.setChargeName(billChargeDetailList.getChargeName());
                    chargeDetails.setChargeAmount(billChargeDetailList.getChargeAmount());
                    chargeDetails.setChargeTotal(billChargeDetailList.getChargeTotal());
                    chargeGroupDetailsList.add(chargeDetails);
                }
            }

            String[] du = new String[7];
            du[0] = propertyService.findByPropertyName("DU_CODE").getPropertyValue();
            du[1] = propertyService.findByPropertyName("DU_NAME").getPropertyValue();
            du[2] = propertyService.findByPropertyName("DU_ADDRESSLN1").getPropertyValue();
            du[3] = propertyService.findByPropertyName("DU_ADDRESSLN2").getPropertyValue();
            du[4] = propertyService.findByPropertyName("DU_VAT_NO").getPropertyValue();

            SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(bills.getDueDate()); // Now use today date.
            c.add(Calendar.DATE, 10); // Adding 5 days
            model.addAttribute("discDate",sdf.format(c.getTime()));
            Date runDate = new SimpleDateFormat("yyyy-MM-dd").parse(bills.getRunDate());
            model.addAttribute("runDate", sdf.format(runDate));

            model.addAttribute("billgroupLists", chargeGroupDetailsList);
            model.addAttribute("du", du);
            model.addAttribute("account", accountService.getByOldAccountNo(billsService.findByBillNo(billno).getOldAcctNo()));
            model.addAttribute("billAddOnChargeLists", billAddOnChargeService.findByBillNo(billno));
        }
        model.addAttribute("backButton", "/Kuryentxt/accounts");

        return "bills/viewbill";
    }
    @RequestMapping(value = "/bills/{billno}", method = RequestMethod.GET)
    public String showBilByBillAcct(@PathVariable("billno") String billno, Model model) throws Exception {
        Bills bill = billsService.findByBillNo(billno);
        model.addAttribute("bill", bill);

        List<ChargeGroupDetails> chargeGroupDetailsList = new ArrayList<>();
        for(BillChargeGroup billChargeGroupList : billChargeGroupService.findByBillNo(billno)){
            ChargeGroupDetails chargeGroup = new ChargeGroupDetails();
            chargeGroup.setChargeGroupName(billChargeGroupList.getChargeGroupName());
            chargeGroup.setChargeSum(billChargeGroupList.getChargeSum());
            chargeGroup.setChargeTotalgroup(billChargeGroupList.getChargeTotal());
            chargeGroupDetailsList.add(chargeGroup);
            for(BillChargeDetail billChargeDetailList : billChargeDetailService.findByPrintOrderMasterAndBillNo((int)billChargeGroupList.getPrintOrder(), billno)){
                ChargeGroupDetails chargeDetails = new ChargeGroupDetails();
                chargeDetails.setChargeName(billChargeDetailList.getChargeLongName());
                chargeDetails.setChargeAmount(billChargeDetailList.getChargeAmount());
                chargeDetails.setChargeTotal(billChargeDetailList.getChargeTotal());
                chargeGroupDetailsList.add(chargeDetails);
            }
        }

        String[] du = new String[7];
        if(propertyService.findByPropertyName("DU_CODE") != null){
            du[0] = propertyService.findByPropertyName("DU_CODE").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_NAME") != null){
            du[1] = propertyService.findByPropertyName("DU_NAME").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN1") != null){
            du[2] = propertyService.findByPropertyName("DU_ADDRESSLN1").getPropertyValue();
        }else{
            du[2] = "";
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN2") != null){
            du[3] = propertyService.findByPropertyName("DU_ADDRESSLN2").getPropertyValue();
        }else{
            du[3] = "";
        }
        if(propertyService.findByPropertyName("DU_VAT_NO") != null){
            du[4] = propertyService.findByPropertyName("DU_VAT_NO").getPropertyValue();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(bill.getDueDate()); // Now use today date.
        c.add(Calendar.DATE, 10); // Adding 5 days
        model.addAttribute("discDate",sdf.format(c.getTime()));
        Date runDate = new SimpleDateFormat("yyyy-MM-dd").parse(bill.getRunDate());
        model.addAttribute("runDate", sdf.format(runDate));

        model.addAttribute("billgroupLists", chargeGroupDetailsList);
        model.addAttribute("du", du);
        model.addAttribute("account", accountService.getByOldAccountNo(billsService.findByBillNo(billno).getOldAcctNo()));
        model.addAttribute("billAddOnChargeLists", billAddOnChargeService.findByBillNo(billno));
        model.addAttribute("backButton", "/Kuryentxt/accounts/account/"+accountService.getByOldAccountNo(bill.getOldAcctNo()).getAccountNo());
        return "bills/viewaccountbill";
    }

    @GetMapping("/ercviewbill")
    public String showbillFormERC(@RequestParam("billno") String billno, Model model) throws Exception {
        /*Bill Header*/
        Bills bill = billsService.findByBillNo(billno);
        model.addAttribute("bill", bill);

        List<ChargeGroupDetails> chargeGroupDetailsList = new ArrayList<>();
        for(BillChargeGroup billChargeGroupList : billChargeGroupService.findByBillNo(billno)){
            ChargeGroupDetails chargeGroup = new ChargeGroupDetails();
            chargeGroup.setChargeGroupName(billChargeGroupList.getChargeGroupName());
            chargeGroup.setChargeSum(billChargeGroupList.getChargeSum());
            chargeGroup.setChargeTotalgroup(billChargeGroupList.getChargeTotal());
            chargeGroupDetailsList.add(chargeGroup);
            for(BillChargeDetail billChargeDetailList : billChargeDetailService.findByPrintOrderMasterAndBillNo((int)billChargeGroupList.getPrintOrder(), billno)){
                ChargeGroupDetails chargeDetails = new ChargeGroupDetails();
                chargeDetails.setChargeName(billChargeDetailList.getChargeLongName());
                chargeDetails.setChargeAmount(billChargeDetailList.getChargeAmount());
                chargeDetails.setChargeTotal(billChargeDetailList.getChargeTotal());
                chargeGroupDetailsList.add(chargeDetails);
            }
        }

        String[] du = new String[7];
        if(propertyService.findByPropertyName("DU_CODE") != null){
            du[0] = propertyService.findByPropertyName("DU_CODE").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_NAME") != null){
            du[1] = propertyService.findByPropertyName("DU_NAME").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN1") != null){
            du[2] = propertyService.findByPropertyName("DU_ADDRESSLN1").getPropertyValue();
        }else{
            du[2] = "";
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN2") != null){
            du[3] = propertyService.findByPropertyName("DU_ADDRESSLN2").getPropertyValue();
        }else{
            du[3] = "";
        }
        if(propertyService.findByPropertyName("DU_VAT_NO") != null){
            du[4] = propertyService.findByPropertyName("DU_VAT_NO").getPropertyValue();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(bill.getDueDate()); // Now use today date.
        c.add(Calendar.DATE, 10); // Adding 5 days
        model.addAttribute("discDate",sdf.format(c.getTime()));
        Date runDate = new SimpleDateFormat("yyyy-MM-dd").parse(bill.getRunDate());
        model.addAttribute("runDate", sdf.format(runDate));

        model.addAttribute("billgroupLists", chargeGroupDetailsList);
        model.addAttribute("du", du);
        model.addAttribute("account", accountService.getByOldAccountNo(billsService.findByBillNo(billno).getOldAcctNo()));
        model.addAttribute("billAddOnChargeLists", billAddOnChargeService.findByBillNo(billno));
        model.addAttribute("backButton", "http://116.93.97.197:85/KuryentxtAdmin/ercportal");
        return "bills/viewaccountbill";
    }
}
