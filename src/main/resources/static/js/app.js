/**
 * Created by xenuser on 5/9/2017.
 */
$(document).ready(function () {
    changePageAndSizeAccts();
});
function changePageAndSizeAccts() {
    $('#pageSizeSelect').change(function (evt) {
        window.location.replace("/accounts/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeArea();
});
function changePageAndSizeArea() {
    $('#pageSizeSelectArea').change(function (evt) {
        window.location.replace("/du-area/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeProperties();
});
function changePageAndSizeProperties() {
    $('#pageSizeSelectProperty').change(function (evt) {
        window.location.replace("/properties/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeActivation();
});
function changePageAndSizeActivation() {
    $('#pageSizeSelectActivation').change(function (evt) {
        window.location.replace("/activation-code/?pageSize=" + this.value + "&page=1");
    });
}

$(document).ready(function () {
    changePageAndSizeCutoff();
});
function changePageAndSizeCutoff() {
    $('#pageSizeSelectCutoff').change(function (evt) {
        window.location.replace("/cut-off/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeReader();
});
function changePageAndSizeReader() {
    $('#pageSizeSelectReader').change(function (evt) {
        window.location.replace("/readers/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeRDM();
});
function changePageAndSizeRDM() {
    $('#pageSizeSelectRDM').change(function (evt) {
        window.location.replace("/rdm/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeRemarks();
});
function changePageAndSizeRemarks() {
    $('#pageSizeSelectRemarks').change(function (evt) {
        window.location.replace("/remarks/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeRateMaster();
});
function changePageAndSizeRateMaster() {
    $('#pageSizeRateMaster').change(function (evt) {
        window.location.replace("ratemaster/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeCoreLoss();
});
function changePageAndSizeCoreLoss() {
    $('#pageSizecoreloss').change(function (evt) {
        window.location.replace("coreloss/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeLifeLine();
});
function changePageAndSizeLifeLine() {
    $('#pageSizeLifeLine').change(function (evt) {
        window.location.replace("/lifeline/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeSeniorCitizen();
});
function changePageAndSizeSeniorCitizen() {
    $('#pageSizeSeniorCitizen').change(function (evt) {
        window.location.replace("/seniorcitizen/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeAddOnCharge();
});
function changePageAndSizeAddOnCharge() {
    $('#pageSizeAddOnCharge').change(function (evt) {
        window.location.replace("/addoncharge/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeAddOnKwh();
});
function changePageAndSizeAddOnKwh() {
    $('#pageSizeAddOnKwh').change(function (evt) {
        window.location.replace("/addonkwh/?pageSize=" + this.value + "&page=1");
    });
}

$(document).ready(function () {
    changePageAndSizePerKwCharge();
});
function changePageAndSizePerKwCharge() {
    $('#pageSizeSelectPerKwChargeMaster').change(function (evt) {
        window.location.replace("/addonkwh/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeChargeType();
});
function changePageAndSizeChargeType() {
    $('#pageSizeSelectChargeType').change(function (evt) {
        window.location.replace("/charge-type/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeFixedCharge();
});
function changePageAndSizeFixedCharge() {
    $('#pageSizeFixedCharge').change(function (evt) {
        window.location.replace("fixedcharge/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeFixedChargeDetail();
});
function changePageAndSizeFixedChargeDetail() {
    $('#pageSizeFixedChargeDetail').change(function (evt) {
        window.location.replace("fixedchargedetails/?pageSize=" + this.value + "&page=1");
    });
}

/* #######################         pagination end            ##############################*/

/* FROM Layout*/
$(document).ready(function () {
    $("#dateSelectModal").modal('show');

    $("#generateCode").click(function () {
        generator();
    });
});

function generator() {
    $("#activationCode").val(Math.floor(Math.random() * 900000 + 100000));
}

$(function () {
    $("#periodFrm").datepicker({
        numberOfMonths: 2,
        dateFormat: 'yy-mm-dd',
        maxDate: 0,
        onSelect: function (selected) {
            var dt = new Date(selected);
            dt.setDate(dt.getDate() + 1);
            $("#periodTo").datepicker("option", "minDate", dt);
        }
    });
    $("#periodTo").datepicker({
        numberOfMonths: 2,
        dateFormat: 'yy-mm-dd',
        maxDate: 0,
        onSelect: function (selected) {
            var dt = new Date(selected);
            dt.setDate(dt.getDate() - 1);
            $("#periodFrm").datepicker("option", "maxDate", dt);
        }
    });
});

$(function () {
    $("#datepick").datepicker({
        numberOfMonths: 1,
        dateFormat: 'yy-mm-dd',
        minDate: 0
        /*  onSelect: function (selected) {
         var dt = new Date(selected);
         dt.setDate(dt.getDate() + 1);
         $("#effectivityDate").datepicker("option", "minDate", dt);
         }*/
    });
});

$(document).ready(function () {

    $('#genericModal').on('show.bs.modal', function (e) {
        $url = $(e.relatedTarget).attr('data-url');
        $message = $(e.relatedTarget).attr('data-message');
        $title = $(e.relatedTarget).attr('data-title');
        $btnValue = $(e.relatedTarget).attr('data-btn-value');
        $btnClass = $(e.relatedTarget).attr('data-class');
        $('#title').text($title);
        $('#msgs').text($message);
        $("#btnSubmit").attr("href", $url).addClass($btnClass);
        $("#btnSubmit").text($btnValue);
    });

    <!-- Form confirm (yes/ok) handler, submits form -->
    $('#btnSubmit').find('.modal-footer #confirm').on('click', function () {
        $(this).data('form').submit();
    });

    /* Cascading Dropdown*/
    $("#idArea").change(function () {
        $.ajax({
            type: "GET",
            url: "/Kuryentxt/api/route",
            dataType: 'json',
            data: {"idarea": $("#idArea").val()},
            success: function (result) {
                console.log(result);
                $('#idRoute').empty();
                $.each(result, function (index, value) {
                    $('#idRoute').append($("<option></option>").attr("value", value.id).text(value.routeCode+' - '+value.routeName));
                    $('#idRoute').trigger("chosen:updated");
                });
            },
            error: function () {
                alert("error");
            }
        });
    });

    $('#viewaccount').on('show.bs.modal', function (e) {
        $url = $(e.relatedTarget).attr('data-url');
        $param = $(e.relatedTarget).attr('data-param');
        // $message = $(e.relatedTarget).attr('data-message');
        //$('#url').text($url);
        $("#deleteBtn").attr("href", $url); // #deleteBtn(ito po yung id ng hyperlink)
        var infoModal = $('#url');
        //alert($param);
        $.ajax({
            type: "GET",
            url:  $url,
            dataType: 'json',
            data: {"oldaccountno": $param},
            success: function (result) {   /*<ul><li>id: '+result.id+'</li><li>seqNo: '+result.seqNo+'</li></ul>*/
                console.log(result);
                var ip='', sc='', dowload='';
                if(result.isDownloaded == "Y"){ dowload = "Yes" } else if (result.isDownloaded == "N"){ dowload = "No" }
                if(result.isSeniorCitizen == "Y"){ cs = "Yes"; } else if(result.isSeniorCitizen == "N"){ cs = "No" }
                if(result.isPrivate == "Y"){ ip = "Yes"; } else if(result.isPrivate == "N"){ ip = "No" }
                htmlData = "<table class='table table-striped'>" +
                    "<tbody><tr><td>ID</td><td>"+ result.id +"</td></tr>" +
                    "<tr><td>Date Rec Created</td><td>"+ result.dateRecCreated +"</td></tr>"+
                    "<tr><td>Time Rec Created</td><td>"+ result.timeRecCreated +"</td></tr>"+
                    "<tr><td>Area</td><td>"+ result.idArea +"</td></tr>"+
                    "<tr><td>RDM</td><td>"+ result.idRdm +"</td></tr>"+
                    "<tr><td>Route Name</td><td>"+ result.idRoute +"</td></tr>"+
                    "<tr><td>Route Code</td><td>"+ result.routeCode +"</td></tr>"+
                    "<tr><td>Account No</td><td>"+ result.accountNo +"</td></tr>"+
                    "<tr><td>Old Account No</td><td>"+ result.oldAccountNo +"</td></tr>"+
                    "<tr><td>Sequence No</td><td>"+ result.seqNo +"</td></tr>"+
                    "<tr><td>Meter No.</td><td>"+ result.meterNo +"</td></tr>"+
                    "<tr><td>Meter Multiplier</td><td>"+ result.meterMultiplier +"</td></tr>"+
                    "<tr><td>Serial No</td><td>"+ result.serialNo +"</td></tr>"+
                    "<tr><td>Account Name</td><td>"+ result.accountName +"</td></tr>"+
                    "<tr><td>Address</td><td>"+ result.addressLn1 + " " + result.addressLn2 +"</td></tr>"+
                    "<tr><td>Previous Reading 2</td><td>"+ result.prev02Reading +"</td></tr>"+
                    "<tr><td>Previous Reading 1</td><td>"+ result.prev01Reading +"</td></tr>"+
                    "<tr><td>Current Reading</td><td>"+ result.curRdg +"</td></tr>"+
                    "<tr><td>Rate Master</td><td>"+ result.idRateMaster +"</td></tr>"+
                    "<tr><td>Senior Citizen</td><td>"+ sc +"</td></tr>"+
                    "<tr><td>Private</td><td>"+ ip +"</td></tr>"+
                    "<tr><td>Is Downloaded</td><td>"+ dowload +"</td></tr>"+
                    "</tbody></table>";
                infoModal.html(htmlData);
            },
            error: function () {
                htmlData = 'Error!';
                infoModal.html(htmlData);
            }
        });
    });

    /*For Popover*/
    $(document).ready(function(){
        $('[data-toggle="popover"]').popover({
            placement : 'right',
            trigger: 'hover'
        });
    });
});