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
        window.location.replace("/ratemaster/?pageSize=" + this.value + "&page=1");
    });
}
$(document).ready(function () {
    changePageAndSizeCoreLoss();
});
function changePageAndSizeCoreLoss() {
    $('#pageSizecoreloss').change(function (evt) {
        window.location.replace("/coreloss/?pageSize=" + this.value + "&page=1");
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
    $('#confirmDelete').on('show.bs.modal', function (e) {
        $url = $(e.relatedTarget).attr('data-url');
        $message = $(e.relatedTarget).attr('data-message');
        $('#msg').text($message);
        $("#deleteBtn").attr("href", $url); // #deleteBtn(ito po yung id ng hyperlink)
    });

    <!-- Form confirm (yes/ok) handler, submits form -->
    $('#confirmDelete').find('.modal-footer #confirm').on('click', function () {
        $(this).data('form').submit();
    });
});