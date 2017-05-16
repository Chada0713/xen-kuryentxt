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
