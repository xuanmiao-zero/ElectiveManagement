//存放所有用户
var users = users || {};
//操作类型
var operateType = "";
//存放搜索对象
var searchUsers = searchUsers || {};
//用户构造方法
var User = {
    Create:function(code,userName,passWord){
        this.code = code;
        this.userName = userName;
        this.passWord = passWord;
    },
    //添加用户
    addUserData:function(){
        if(this.code != ""){
            users[this.code] = this;
        }        
//      将数据提交给后台    
        $.ajax({
        	type:'post',
        	url:'studentInfoAdd',
        	data:{
      		studentId:  this.code,
      		name:  this.userName,
      		passWord:  this.passWord
        }
        });  
    },
    //删除用户
    deleteUserData:function (){
        for(var i in users){
            if(this.code == users[i].code){
                delete users[i];

//              将数据提交给后台    
                $.ajax({
                	type:'post',
                	url:'studentInfoDelete',
                	data:{
	              		studentId: this.code,
	              		name: this.userName,
	              		passWord: this.passWord
	                }
                });
            }
        }
    },
    //编辑用户
    editUserData:function(){
        for(var i in users){
            if(this.code == users[i].code){
                users[i].userName = this.userName;
                users[i].passWord = this.passWord;
	//          将数据提交给后台    
	            $.ajax({
	            	type:'post',
	            	url:'studentInfoModify',
	            	data:{
	              		studentId: this.code,
	              		name: this.userName,
	              		passWord: this.passWord
	                }
	            });
            }
        }
        
    },
    //查找用户
    findUserData:function(data){
        for(var i in users){
            if(data.code.indexOf(users[i].code) >= 0 ||
                data.userName.indexOf(users[i].userName) >= 0){
                searchUsers[users[i].code] = users[i];
                refreshDatas(searchUsers);
            }
        }
    }
};

function New(aClass,aParams){
    function new_(){
        aClass.Create.apply(this,aParams);
    }
    new_.prototype = aClass;
    return new new_();
}

//bootstrap模态框事件
$('#myModal').on('hide.bs.modal', function () {
    // 执行一些动作...
    var inputElements = this.getElementsByTagName("input");
    var userArr = [];
    for(var i=0;i<inputElements.length;i++){
        userArr[i] = inputElements[i].value;
    }
    var user = New(User,userArr);
    //添加操作    
    if(operateType == "add"){
        user.addUserData();
        refreshDatas(users);   
        
////      将数据提交给后台    
////      alert('测试');
//        $.ajax({
//        	type:'post',
//        	url:'studentInfoAdd',
//        	data:{
//      		studentId: user.code,
//      		name: user.userName,
//      		passWord: user.passWord
//        }
//        }); 
        //编辑操作
    }else if(operateType == "edit"){
        user.editUserData();
        refreshDatas(users);
    }
});

/**
 * 首次加载页面执行方法
 */
function loadUserDatas(){
    var userArray = initUserDatas();
    addRowData(userArray);
    refreshDatas(users);
}
/**
 * 初始化用户数据
 */
function initUserDatas(){
//    var initUser1 = New(User,["1001","轩邈","1234"]);
//    var initUser2 = New(User,["1002","阿杰","1234"]);
//    var initUser3 = New(User,["1003","小轩","1234"]);
//    var initUser4 = New(User,["1004","欣儿","1234"]);
//    users[initUser1.code] = initUser1;
//    users[initUser2.code] = initUser2;
//    users[initUser3.code] = initUser3;
//    users[initUser4.code] = initUser4;
//	$.ajax({
//		url:URL,
//		type:'POST',
//		data:{
//			pagesize:page_size,
//			position:Position,
//			page:Page
//		},
//		success:function(response,status){
//			var json_content=$.parseJSON(response);
//		}
//	)};
	 $.ajax({
     	type:'post',
     	url:'studentInfoInquire',
     	async:false,//取消异步加载
     	success:function(response,status){
			var json_content=$.parseJSON(response)
//			alert(json_content.length);
//			alert(json_content[0].student_id);
			for(var i =0; i< json_content.length; i++){
//				alert(json_content[i].student_id);
//				alert(json_content[i].name);
//				alert(json_content[i].password);
				 var initUser = New(User,[json_content[i].student_id,json_content[i].name,json_content[i].password]);
//				 alert(initUser.code);
				 users[initUser.code] = initUser;			 
			}
 		}
     }); 

//		alert(users[1002]);
	 return users;
}

/**
 * 往表格添加一行html数据
 */
function addRowData(datas){
    var tbodyElement = document.getElementById("tbody");
    var html = "";
    var color = "warning";
    var flag = true;
    for(var i in datas){
        if(flag){
            color = "info";
        }else{
            color = "warning";
        }
        html = html +  "<tr class='"+ color +"'><td style='width:30px;'><input type='checkbox'></td><td id='code'>"
            + datas[i].code +"</td><td id='userName'>"
            + datas[i].userName +"</td><td id='passWord'>"
            + datas[i].passWord +"</td>"
            +"</tr>";
        
        flag = !flag;//颜色转换 
    }
    tbodyElement.innerHTML = html;
}
/**
 * 刷新用户数据
 */
function refreshDatas(datas){
    addRowData(datas);
};

/**
 * 收集一行数据
 */
function collectionRowData(param){
    var tdElement = param.getElementsByTagName("td");
    var userArr = [];
    for(var i=1;i<tdElement.length;i++){
        var temp =  tdElement[i].textContent;
        userArr[i-1] = temp;
    }
    var user = New(User,userArr);
    return user;
}
/**
 * 用户操作方法
 */
function optionUserData(param){
    //获得操作类别
    var optionType = param.getAttribute("id");
    if(optionType == "user_add"){
        operateType = "add";
    }else if(optionType == "user_delete"){
        var checkRowData = isCheckedData();
        var user = collectionRowData(checkRowData);
        user.deleteUserData();
        refreshDatas(users);
    }else if(optionType == "user_edit"){
        operateType = "edit";
        var checkRowData = isCheckedData();
        var user = collectionRowData(checkRowData);
        var modal_body = document.getElementById("modal-body");
        var inputElements=  modal_body.getElementsByTagName("input");
        for(var i=0;i<inputElements.length;i++){
            var temp = inputElements[i].id.substring(2,inputElements[i].id.length)
            inputElements[i].value = user[temp];
        }
    }else if(optionType == "user_find"){
        var s_code =  document.getElementById("s_code").value;
        var s_userName =  document.getElementById("s_userName").value;
        var s_all=  document.getElementById("s_all").value;
        //搜索数据
        var s_data = s_data || {};
        s_data.code = s_code;
        s_data.userName = s_userName;
        s_data.all = s_all;
        var user = New(User,[]);
        user.findUserData(s_data);
    }else{

    }
}

/**
 * 是否选中数据,返回选中行
 */
function isCheckedData(){
    var tbodyElement =document.getElementById("tbody");
    var trElements = tbodyElement.getElementsByTagName("tr");
    var flag = false;
    for(var i=0;i<trElements.length;i++){
        var inputElement = trElements[i].getElementsByTagName("input")[0];
        if(inputElement.checked){
            flag = true;
            return trElements[i];
        }
    }
    if(!flag){
        alert("请选择一条记录！");
        $('#myModal').unbind("on");
    }
}



//document.getElementById('save').onclick=function () {
////		alert('测试');
//        $.ajax({
//        	type:'post',
//            url:'studentInfoAdd',
//            data:{
//                studentId: $('#m_code').val(),
//                name: $('#m_userName').val(),
//                passWord: $('#m_passWord').val()
//            },
////            beforeSend:function() {
////            	$.messager.progress({
////            		text:'正在保存...',
////            	});
////            },
////            success:function(data,response,status){
////            	$.messager.progress('close');
////            }
//        });
//}
