//span点击事件
$("#labDiv span").click(function () {
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
        var selObj = $("#" + objName + "Sel");
        spanObj.text($(this).children("option:selected").text()).attr("class", "w3-tag w3-blue");
        $(this).hide();
        if (objName != "zhuanye") {
            //获取下级菜单
            $.ajax({
                type: "POST",
                url: "/dic/classMap/getSubClassMap.do",
                data:"supId="+objId,
                success: function (ret) {
                    var backHtml = "";
                    if(objName == "school"){
                        backHtml += "<option value='kong'>请选择学院</option>";
                    }else{
                        backHtml += "<option value='kong'>请选择专业</option>";
                    }
                    for(var o in ret){
                        backHtml+="<option value='"+ret[o].id+"'>"+ret[o].name+"</option>";
                        // console.log(ret[o]);
                    }
                    selObj.next().html(backHtml);
                    selObj.next().show();
                    spanObj.next().show();
                }

            })
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
                console.log(ret);
                if (ret!="[]") {
                    // console.log(ret);
                    var backHtml = "";
                    for(var o in ret){
                        backHtml += "<li value='"+ret[o].id+"'>"+ret[o].nickName+"</li>"
                    }
                    $("#searchResultContent p").hide();
                    $("#searchResultContent ul").html(backHtml);
                    //li点击事件
                    $("#searchResultContent ul li").bind("click",function(){
                        location.href = "/teacher/toInfo/"+$(this).val();
                    })
                } else {
//                        alert("sfsf");
//                        alert(ret.failedReason);
                    $("#searchResultContent ul").html("<li>zhei个结构木有老师啊</li>");
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

//li点击事件
$("#searchResultContent ul li").bind("click",function(){
    location.href = "/teacher/toInfo/"+$(this).val();
})

