//span点击事件
$("#labDiv p").children().click(function () {
    if ($(this).attr("id") == "schoolSpan") {
        delSelAndSpanObj("xueyuan");
        delSelAndSpanObj("zhuanye");
        showSelAndSpanObj("school");
    } else if ($(this).attr("id") == "xueyuanSpan") {
        delSelAndSpanObj("zhuanye");
        showSelAndSpanObj("xueyuan");
    } else {
        showSelAndSpanObj("zhuanye");
    }
})

//select更改事件
$("select").change(function () {
        var objName = $(this).attr("name");
        var objId = $(this).val();
        var spanObj = $("#" + objName + "Span");
        spanObj.text($(this).children("option:selected").text()).attr("class", "w3-tag w3-blue");
        $(this).hide();
        if ($(this).attr("name") != "zhuanye") {
            $(this).next().html(getSubClass(objId));
            $(this).next().show();
            spanObj.next().show();
        }
    }
)

function delSelAndSpanObj(objName) {
    var selObj = $("#" + objName + "Sel");
    var spanObj = $("#" + objName + "Span");
    selObj.hide();
    selObj.val("kong");
    spanObj.hide();
    if (objName == "school") {
        spanObj.text("选择学校").attr("class", "w3-tag w3-pale-blue");
    } else if (objName == "xueyuan") {
        spanObj.text("选择学院").attr("class", "w3-tag w3-pale-blue");
    } else {
        spanObj.text("选择专业").attr("class", "w3-tag w3-pale-blue");
    }
}

function showSelAndSpanObj(objName) {
    var selObj = $("#" + objName + "Sel");
    var spanObj = $("#" + objName + "Span");
    if (objName == "school") {
        spanObj.text("选择学校").attr("class", "w3-tag w3-pale-blue");
    } else if (objName == "xueyuan") {
        spanObj.text("选择学院").attr("class", "w3-tag w3-pale-blue");
    } else {
        spanObj.text("选择专业").attr("class", "w3-tag w3-pale-blue");
    }
    selObj.show();
    selObj.val("kong");
}

//获取下级菜单
function getSubClass(objId) {
    var backData = "<option value='two'>2</option><option value='three'>3</option><option value = 'four' >4</option>";
    return backData;
}

//TODO 正则表达式过滤特殊字符
$("#searchTeacherForm").validate({
    submitHandler: function (form) {
        console.log($(form).attr("id"));
        var submitForm = $(form).serialize();
        $.ajax({
            type: "POST",
            url: "teacher/searchTeacherByCondition.do",
            data: submitForm,
//            dataType:"json",
            success: function (ret) {
                alert(ret);
                if (ret.result == "true") {
                    $("#searchResultContent").html(ret.data);
                } else {
//                        alert("sfsf");
//                        alert(ret.failedReason);
                    $("#errorModalContent").html(ret.failedReason);
                    $("#errorModal").show();
                }
            },
            error: function (request, errorMessage, exception) {
//                    console.log(request);
//                    console.log(errorMessage);
//                    console.log(exception);
                $("#errorModalContent").html(exception);
                $("#errorModal").show();
            }
        });
    },
    rules: {
        teacherName: {}
    }
});

