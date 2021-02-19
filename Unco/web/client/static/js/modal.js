function $(selector){
  return document.querySelector(selector)
}

// 登录按钮
var loginButton = $('#nav-login');
var closeButton = $('.close');
var modal = $('.modal');

loginButton.addEventListener('click',function(){
  modal.classList.add('modal-show')
});

closeButton.addEventListener('click',function(){
  modal.classList.remove('modal-show')
});

// 注册按钮
var enrollButton = $('#nav-enroll');
var closeButton2 = $('.close2');
var modal2 = $('.modal2');

enrollButton.addEventListener('click',function(){
  modal2.classList.add('modal-show2')
});

closeButton2.addEventListener('click',function(){
  modal2.classList.remove('modal-show2')
});

var eroll = $('.modal-eroll');
var modallog = $('.modal-log');

eroll.addEventListener('click',function(){
  modal.classList.remove('modal-show');
  modal2.classList.add('modal-show2')
});
modallog.addEventListener('click',function(){
  modal2.classList.remove('modal-show2');
  modal.classList.add('modal-show');
});

