
function changeContent(content_id,index_id) {
    $("#content1").hide();
    $("#content2").hide();
    $("#content3").hide();
    $("#content4").hide();
    $("#content5").hide();

    $("#content6").hide();
    $("#content7").hide();
    $("#content8").hide();
    $("#content9").hide();

    $("#index1").attr("class","list-group-item");
    $("#index2").attr("class","list-group-item");
    $("#index3").attr("class","list-group-item");
    $("#index4").attr("class","list-group-item");
    $("#index5").attr("class","list-group-item");
    $("#index6").attr("class","list-group-item");
    $("#index7").attr("class","list-group-item");
    $("#index8").attr("class","list-group-item");
    $("#index9").attr("class","list-group-item");


    $("#"+content_id).fadeIn(500);
    $("#"+index_id).attr("class","list-group-item active");

    if(content_id=="content1"){
        $.ajax({
            type : "post",
            url : "pet/findAllPet",
            data:{
            },
            complete : function(data) {
                var msg = JSON.stringify(data);
                var json1 = JSON.parse(msg);

                $("#content1").html(json1.responseText);
                $("#content1").fadeIn(500);
            },
            error:function(){
                alert("查询失败！");
            }
        });
    }
    else if(content_id=="content2"){

    }
    else if(content_id=="content3"){

    }
    else if(content_id=="content4"){
        $.ajax({
            type : "post",
            url : "manager/findAllUser",
            data:{
            },
            complete : function(data) {
                var msg = JSON.stringify(data);
                var json1 = JSON.parse(msg);

                $("#content4").html(json1.responseText);
                $("#content4").fadeIn(500);
            },
            error:function(){
                alert("查询失败！");
            }
        });
    }

    else if(content_id=="content5"){

    }else if(content_id=="content6"){
        $.ajax({
            type : "post",
            url : "manager/getApplies",
            data:{
            },
            complete : function(data) {
                var msg = JSON.stringify(data);
                var json1 = JSON.parse(msg);

                $("#content6").html(json1.responseText);
                $("#content6").fadeIn(500);
            },
            error:function(){
                alert("fail");
            }
        });
    }else if(content_id=="content7"){
        $.ajax({
            type : "post",
            url : "pet/findAllAdoptPet",
            data:{
            },
            complete : function(data) {
                var msg = JSON.stringify(data);
                var json1 = JSON.parse(msg);

                $("#content7").html(json1.responseText);
                $("#content7").fadeIn(500);
            },
            error:function(){
                alert("fail");
            }
        });
    }else if(content_id=="content8"){
        $.ajax({
            type : "post",
            url : "manager/getMyApplies",
            data:{
            },
            complete : function(data) {
                var msg = JSON.stringify(data);
                var json1 = JSON.parse(msg);

                $("#content8").html(json1.responseText);
                $("#content8").fadeIn(500);
            },
            error:function(){
                alert("fail");
            }
        });

    }else if(content_id=="content9"){
        $.ajax({
            type : "post",
            url : "manager/getMyAdopts",
            data:{
            },
            complete : function(data) {
                var msg = JSON.stringify(data);
                var json1 = JSON.parse(msg);

                $("#content9").html(json1.responseText);
                $("#content9").fadeIn(500);
            },
            error:function(){
                alert("fail");
            }
        });
    }
}

function alterPetBtn(){
    var pno=$("#pno").text();
    var name=$("#name").val();
    var age=$("#age").val();
    var birth=$("#birth").val();
    var sex=$("#sex").val();
    var brief=$("#describe").val();
    $.ajax({
        type : "post",
        url : "manager/alterPetInfo",
        data:{
            pno:pno,
            name:name,
            age:age,
            birth:birth,
            sex:sex,
            brief:brief
        },
        complete : function(data) {
            alert("success");
        },
        error:function(){
            alert("fail");
        }
    });
}

function addPet(){
    var data_submit = new FormData($("#addPet")[0]);
    $.ajax({
        type : "post", //传输方式为post
        url : "manager/addPet", //这就是使用的url
        //contentType : "application/json",//上传内容格式为json结构
        processData : false, //必须false才会避开jQuery对 formdata 的默认处理
        contentType : false,
        data : data_submit,
        complete : function(data) {
            alert(data.responseText);
        },
        error:function(){
            alert("fail");
        }
    });
}

function deletePet(pno) {
    $.ajax({
        type : "post",
        url : "manager/delPet",
        data:{
            pno:pno
        },
        complete : function(data) {
            alert(data.responseText);
            $("#"+pno).fadeOut("500");
        },
        error:function(){
            alert("fail");
        }
    });
}

function PetInfo(pno) {
    $.ajax({
        type : "post",
        url : "/pet/getPetInfo",
        data:{
            pno:pno
        },
        complete : function(data) {
            if(data==null) alert("error");
            else {
                console.log(data.responseText);
                var json1=$.parseJSON(data.responseText); //jQuery.parseJSON(jsonstr),可以将json字符串转换
               //console.log(json1["picture"]);
                changeContent("content2","index2");
                $("#picture").attr("src",json1["picture"]);
                $("#pno").text(json1["pno"]);
                $("#name").val(json1["name"]);
                $("#age").val(json1["age"]);
                $("#birth").val(json1["birth"]);
                $("#sex").val(json1["sex"]);
                $("#describe").val(json1["brief"]);

            }
        },
        error:function(){
            alert("fail");
        }
    });
}

function alterUser(){
    var id=$("#userid").val();
    var username=$("#username").val();
    var password=$("#password").val();
    var role=$("#role").val();
    $.ajax({
        type : "post",
        url : "manager/updateUser",
        data:{
            id:id,
            username:username,
            password:password,
            role:role,
        },
        complete : function(data) {
            alert("success");
            changeContent("content4","index4");
        },
        error:function(){
            alert("fail");
        }
    });
}

function addKind() {
    var kind=$("#kind").val();
    $.ajax({
        type : "post", //传输方式为post
        url : "manager/addKind", //这就是使用的url

        data : {
            kind:kind
        },
        complete : function(data) {
            alert(data.responseText);
        },
        error:function(){
            alert("fail");
        }
    });
}

function applyAdopt(pet_id) {
    $.ajax({
        type : "post",
        url : "manager/applyAdopt",
        data:{
            pet_id:pet_id
        },
        complete : function(data) {

            alert(data.responseText);

            $("#"+pet_id).val("申请中");
            $("#"+pet_id).fadeOut("500");
        },
        error:function(){
            alert("fail");
        }
    });
}

function agreeAdopt(id,user_id,pet_id) {
    $.ajax({
        type : "post", //传输方式为post
        url : "manager/handleRequest", //这就是使用的url
        data : {
            id:id,
            user_id:user_id,
            pet_id:pet_id,
            state:"agree"
        },
        complete : function(data) {
            alert(data.responseText);
            $("#"+id).fadeOut("500");
        },
        error:function(){
            alert("fail");
        }
    });
}

function refuseAdopt(id,user_id,pet_id) {
    $.ajax({
        type : "post", //传输方式为post
        url : "manager/handleRequest", //这就是使用的url
        data : {
            id:id,
            user_id:user_id,
            pet_id:pet_id,
            state:"refuse"
        },
        complete : function(data) {
            alert(data.responseText);
            $("#"+id).fadeOut("500");
        },
        error:function(){
            alert("fail");
        }
    });
}


