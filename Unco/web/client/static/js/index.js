
function $(querySelector) {
    return document.querySelector(querySelector)
}
function $$(querySelectorAll) {
    return document.querySelectorAll(querySelectorAll)
}
/*  导航栏滑动变色   */
var top = $('.static-nav');
var static_nav = $('.static-nav');
top.addEventListener('scroll', function () {
    //获取top的高度
    var oh = $('.top').offsetHeight;
    //获取body滑动的高度    
    var s = document.body.scrollTop || document.documentElement.scrollTop;
    if (s >= oh)
        $('.static-nav').style.backgroundColor = 'black';
    else
        $('.static-nav').style.backgroundColor = ''
    //console.log(oh)
    //console.log(s)
});
var category = $$('.img_column li');
var content = $$('.img_content li');

        //    单击后改变颜色
for(var i = 0 ; i < category.length ; i++){

    category[i].addEventListener('click',function(){
        for(var j = 0 ; j < category.length ; j++){
            category[j].style.backgroundColor='';
        }
        this.style.backgroundColor='pink'
    })
}
       // li分栏
category.forEach(function (li) {

    li.addEventListener('click', function () {
        category.forEach(function (type) {
            type.classList.remove('active')

        });
        content.forEach(function (imgs) {
            imgs.classList.remove('active')
        });
        li.classList.add('active');
        var unc;
        for (var i = 0; i < category.length; i++) {
            if (category[i] === li) {
                unc = i;
            }
        }
        content[unc].classList.add('active');
    });
});
