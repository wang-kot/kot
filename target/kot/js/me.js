$("#meEditBtn").click(function () {
        var id = $("#meId").text();
        // location.href = "student/toEdit.do?id="+id;
        location.href = "/index/me/studentEdit";
    }
)
$("#meExitBtn").click(function () {
        // var id = $("#meId").text();
        // location.href = "student/toEdit.do?id="+id;
        $.cookie("studentId", null);
        $.cookie("studentNName", null);
        location.href = "/index";
    }
)