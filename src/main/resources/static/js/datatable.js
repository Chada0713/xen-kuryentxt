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
