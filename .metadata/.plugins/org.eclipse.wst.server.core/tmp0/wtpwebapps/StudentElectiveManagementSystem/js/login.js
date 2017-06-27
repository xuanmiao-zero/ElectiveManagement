/**
 * @author: xuanmiao
 * @description:
 * @Date: 2017/3/28 17:30
 */
$(function () {
    //管理员帐号判断验证
    $('.student_username').validatebox({
        required : true,
        missingMessage : '请输入管理员帐号',
        invalidMessage : '管理员帐号不得为空',
    });
    //管理员密码验证
    $('.student_password').validatebox({
        required : true,
        validType : 'length[6,30]',
        missingMessage : '请输入管理员密码',
        invalidMessage : '管理员密码不符合要求',
    });
    //学号判断验证
    $('.student_id').validatebox({
        required : true,
        validType : 'length[6,6]',
        missingMessage : '请输入学号',
        invalidMessage : '学号为6位',
    });
    //学生姓名判断验证
    $('.manager_username').validatebox({
        required : true,
        missingMessage : '请输入姓名',
        invalidMessage : '姓名不得为空',
    });
    //学生密码验证
    $('.manager_password').validatebox({
        required : true,
        validType : 'length[6,30]',
        missingMessage : '请输入学生密码',
        invalidMessage : '学生密码不符合要求',
    });

    //加载时判断验证
    function judgeValid(){
        if (!$('.login .student_username').validatebox('isValid')) {
            $('.login .student_username').focus();
        } else if (!$('.login .student_password').validatebox('isValid')) {
            $('.login .student_password').focus();
        }
        if (!$('.login .manager_username').validatebox('isValid')) {
            $('.login .manager_username').focus();
        } else if (!$('.login .manager_password').validatebox('isValid')) {
            $('.login .manager_password').focus();
        }
        if (!$('.register .student_id').validatebox('isValid')) {
            $('.register .student_id').focus();
        } else if (!$('.register .student_password').validatebox('isValid')) {
            $('.register .student_password').focus();
        }
        if (!$('.register .student_username').validatebox('isValid')) {
            $('.register .student_username').focus();
        } else if (!$('.register .student_password').validatebox('isValid')) {
            $('.register .student_password').focus();
        }
        if (!$('.register .manager_username').validatebox('isValid')) {
            $('.register .manager_username').focus();
        } else if (!$('.register .manager_password').validatebox('isValid')) {
            $('.register .manager_password').focus();
        }
    }
    judgeValid();
    //切换按钮时验证
    //问题focus只能
    $('#main button').click(function () {
        judgeValid()
    });
    //单击登录
});


function choice(Btn,Div){
    var i = 0;
    for (i = 0; i < Btn.length; i++) {
        Btn[i].index = i;
        Btn[i].onclick = function () {
            for (var j = 0; j < Btn.length; j++) {
                Btn[j].className = '';
                Div[j].style.display = 'none';
            }
            this.className = 'active';
            Div[this.index].style.display = 'block';
        }
    }
}

window.onload=function(){
    var mtBtn = document.getElementById('method_choice_button').getElementsByTagName('button');
    var mtDiv = document.getElementById('method_choice').getElementsByClassName('method_form');
    var sBtn = document.getElementById('student').getElementsByTagName('button');
    var sDiv = document.getElementById('student').getElementsByClassName('form');
    var mBtn = document.getElementById('manager').getElementsByTagName('button');
    var mDiv = document.getElementById('manager').getElementsByClassName('form');

    choice(mtBtn, mtDiv);
    choice(sBtn, sDiv);
    choice(mBtn, mDiv);



    // var logBtn = document.getElementById('login');
    // var regBtn = document.getElementById('register');
    // logBtn.onclick = function () {
    //     document.form1.method="post";
    //     document.form1.action="login";
    //     document.form1.submit();
    //  }
    // regBtn.onclick = function(){
    //     document.form2.method="post";
    //     document.form2.action="register"
    //     document.form2.submit();
    //  }
}

//function submitFun(obj){
//    if(obj.getElementByName('xm')===''){
//    	alert("用户名为空！");
//    	return false;
//    }
//    if(obj.getElementByName('pwd')===''){
//    	alert("密码为空！");
//    	return false;
//    }
//    
//    
//}
//function check(){  
//    document.getElementbyId("username").innerHTML="";  
//    document.getElementById("password").innerHTML="";  
//    var flag=true;  
//    var username=document.getElementById("username").value;  
//    if(username.length==0){  
//        document.getElementById("username").innerHTML="用户名不能为空";  
//        flag=false;  
//    }  
//    var password=document.getElementById("password").value;  
//    if(password.length==0){  
//       document.getElementById("password").innerHTML="密码不能为空";  
//       flag=false;
//    }  
//    return flag;  
// }