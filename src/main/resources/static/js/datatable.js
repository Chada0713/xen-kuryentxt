/**
 * Created by xenuser on 5/16/2017.
 */
$(document).ready( function () {
    //noinspection JSAnnotator
    var table = $('#accountsTable').DataTable({
        "bDeferRender": true,
        "sAjaxSource": "api/accounts",
        "sAjaxDataProp": "",
        responsive: true,
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "oldAccountNo",
                render: function ( data, type, row, meta ) {
                    /*return "<a href='#' data-url='/Kuryentxt/api/account' data-param='"+data+"' data-target='#viewaccount' data-toggle='modal' >" + data + "</a>";*/
                    return "<a href='#' onclick='return false;' data-toggle='popover' " +
                        "data-content='"+ "<a href="+'#'+" data-url="+'/Kuryentxt/api/account'+" data-param="+data+" data-target="+'#viewaccount'+" data-toggle="+'modal'+"> View Account </a> " +
                        "<br/><a href="+'bills/viewbillbyaccountno?oldaccountno='+data+"> View Current Bill </a>"
                        +"'>" + data + "</a>";
            }},
            { "mData": "seqNo" },
            { "mData": "routeCode" },
            { "mData": "accountName" },
            { "mData": "meterNo" },
            { "mData": "prev01Reading" },
            { "mData": "curRdg" },
        ],
        drawCallback: function() {
            $('[data-toggle="popover"]').popover({html:true});
            $('[data-toggle="popover"]').on('click', function (e) {
                $('[data-toggle="popover"]').not(this).popover('hide');
            });
        },
        dom: "<'row'<'col-sm-12'f>>" +
        "<'row'<'col-sm-12'tr>>" +
        "<'row'<'col-sm-4'i><'col-sm-8'p>>",
        "lengthMenu": [20],
        "sPaginationType": "full_numbers"
    })
});



/*Bills Report Table*/
$(document).ready( function () {
    var table = $('#billsTable').DataTable({
        "bDeferRender": true,
        "sAjaxSource": "api/bills",
        "sAjaxDataProp": "",
        responsive: true,
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "runDate" },
            { "mData": "billNo",
                render: function (data) {
                    return "<a href='bills/viewbill?billno="+data+"'>" + data + "</a>";
            }},
            { "mData": "oldAcctNo" },
            { "mData": "accountName" },
            { "mData": "meterNo" },
            { "mData": "accountNo" },
            { "mData": "totalConsumption" }
        ],
        dom: "<'row'<'col-sm-12'f>>" +
        "<'row'<'col-sm-12'tr>>" +
        "<'row'<'col-sm-4'i><'col-sm-8'p>>",
        "lengthMenu": [20],
        "sPaginationType": "full_numbers"
    })
});
/*

$(document).ready( function () {
    /!*$('#viewId').click(function(){
        var id = $('#idRoute').val();
        alert(id);
        //do something
    }),*!/
    var table = $('#viewaccountsTable').DataTable({
        "sAjaxSource": "api/viewaccounts/" + id,
        "sAjaxDataProp": "",
        responsive: true,
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "seqNo" },
            { "mData": "routeCode" },
            { "mData": "accountName" },
            { "mData": "oldAccountNo" },
            { "mData": "meterNo" },
            { "mData": "curRdg" },
        ],
        dom: "<'row'<'col-sm-12'f>>" +
        "<'row'<'col-sm-12'tr>>" +
        "<'row'<'col-sm-4'i><'col-sm-8'p>>",
        "lengthMenu": [20],
        "sPaginationType": "full_numbers"
    })
});*/
