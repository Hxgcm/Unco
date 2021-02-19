function $(selector) {
    return document.querySelector(selector)
}
function upload1(f) {
    var str = "";
    for (var i = 0; i < f.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function (e) {
            str += "<img height='168px' width='250px' src='" + e.target.result + "' />";
            $(".hid1").innerHTML = str;
        }
    }
}
function upload2(f) {
    var str = "";
    for (var i = 0; i < f.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function (e) {
            str += "<img height='168px' width='250px' src='" + e.target.result + "' />";
            $(".hid2").innerHTML = str;
        }
    }
}
function upload3(f) {
    var str = "";
    for (var i = 0; i < f.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function (e) {
            str += "<img height='168px' width='250px' src='" + e.target.result + "' />";
            $(".hid3").innerHTML = str;
        }
    }
}
function upload4(f) {
    var str = "";
    for (var i = 0; i < f.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function (e) {
            str += "<img height='168px' width='250px' src='" + e.target.result + "' />";
            $(".hid4").innerHTML = str;
        }
    }
}
function upload5(f) {
    var str = "";
    for (var i = 0; i < f.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function (e) {
            str += "<img height='168px' width='250px' src='" + e.target.result + "' />";
            $(".hid5").innerHTML = str;
        }
    }
}
function upload6(f) {
    var str = "";
    for (var i = 0; i < f.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function (e) {
            str += "<img height='168px' width='250px' src='" + e.target.result + "' />";
            $(".hid6").innerHTML = str;
        }
    }
}
function upload7(f) {
    var str = "";
    for (var i = 0; i < f.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function (e) {
            str += "<img height='168px' width='250px' src='" + e.target.result + "' />";
            $(".hid7").innerHTML = str;
        }
    }
}
function upload8(f) {
    var str = "";
    for (var i = 0; i < f.length; i++) {
        var reader = new FileReader();
        reader.readAsDataURL(f[i]);
        reader.onload = function (e) {
            str += "<img height='168px' width='250px' src='" + e.target.result + "' />";
            $(".hid8").innerHTML = str;
        }
    }
}