/**
 * Created by xenuser on 5/16/2017.
 */
$(document).ready( function () {
    //noinspection JSAnnotator
    var table = $('#accountsTable').DataTable({
        "sAjaxSource": "api/accounts",
        "sAjaxDataProp": "",
        responsive: true,
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "seqNo" },
            { "mData": "routeCode" },
            { "mData": "accountName" },
            { "mData": "oldAccountNo",
                render: function ( data, type, row, meta ) {
                    return "<a href='#' data-url='/Kuryentxt/api/account' data-param='"+data+"' data-target='#viewaccount' data-toggle='modal' >" + data + "</a>";
            }},
            { "mData": "meterNo" },
            { "mData": "prev01Reading" },
            { "mData": "curRdg" },
        ],
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
