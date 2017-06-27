//存放所有用户
var users = users || {};
//操作类型
var operateType = "";
//存放搜索对象
var searchUsers = searchUsers || {};
//用户构造方法
var User = {
    Create:function(code,userName,passWord,class_credit,class_intro){
        this.code = code;
        this.userName = userName;
        this.passWord = passWord;
        this.class_credit = class_credit;
        this.class_intro = class_intro;
    },
    //添加用户
    addUserData:function(){
        if(this.code != ""){
            users[this.code] = this;
        }        
//      将数据提交给后台    
        $.ajax({
        	type:'post',
        	url:'ClassInfoAdd',
        	data:{
      		studentId:  this.code,
      		name:  this.userName,
      		passWord:  this.passWord,
      		class_credit: this.class_credit,
      		class_intro: this.class_intro
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
                	url:'ClassInfoDelete',
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
                users[i].class_credit = this.class_credit;
                users[i].class_intro = this.calss_intro;
	//          将数据提交给后台    
	            $.ajax({
	            	type:'post',
	            	url:'ClassInfoModify',
	            	data:{
	            		studentId:  this.code,
	              		name:  this.userName,
	              		passWord:  this.passWord,
	              		class_credit: this.class_credit,
	              		class_intro: this.class_intro
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
	 $.ajax({
     	type:'post',
     	url:'ClassInfoInquire',
     	async:false,//取消异步加载
     	success:function(response,status){
			var json_content=$.parseJSON(response)
			for(var i =0; i< json_content.length; i++){
				 var initUser = New(User,[json_content[i].class_id,json_content[i].class_name,json_content[i].class_hours,json_content[i].class_credit,json_content[i].class_intro]);
				 users[initUser.code] = initUser;			 
			}
 		}
     }); 
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
            + datas[i].passWord +"</td><td id='class_credit'>"
            + datas[i].class_credit +"</td><td id='class_intro'>"
            + datas[i].class_intro +"</td>"
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
