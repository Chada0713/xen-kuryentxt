/**
 * Created by xenuser on 5/16/2017.
 */
$(document).ready( function () {
    var table = $('#accountsTable').DataTable({
        "sAjaxSource": "/api/accounts",
        "sAjaxDataProp": "",
        responsive: true,
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "seqNo" },
            { "mData": "accountName" },
            { "mData": "accountNo" },
            { "mData": "meterNo" },
            { "mData": "curRdg" }
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
        "sAjaxSource": "/api/bills",
        "sAjaxDataProp": "",
        responsive: true,
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "runDate", "sType": 'date' },
            { "mData": "billNo" },
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