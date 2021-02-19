function $(selector){
    return document.querySelector(selector)
}


var text = $('#text-com');
var username = $('#UN');
var btn = $('.subm');
var comm = $('.commuts-list');

btn.addEventListener('click',function(){
	//判断用户名是否为空
	if(username.value == '') {
        alert('请先进行登陆');
        return false; 
       }

    //判断评论内容是否为空
    if(text.value == '') {
        alert('请输入评论内容');
        return false; 
       }
       //创建li标签
       var newli = document.createElement('li'); 
       //li标签中的内容
       newli.innerHTML = '<img src="img/por01.jpg" class="com-list-img clearfix" alt=""><div class="con-user clearfix"><a href="#">username</a><p>'+text.value +'</p></br><p>2018年7月3日</p></div><span class="hf"><a href="#">回复 </a><a href="#"> 举报</a></span>';

       var lis = comm.childNodes; 
       comm.insertBefore(newli, lis[0]);  //将创建的标签添加到最前面
       text.value = '';
  })