/**
 * Created by M on 2016/11/14.
 */
var $caroUl = $('.caro-ul');
var $caroLi = $('.caro-li');
var $btnLi = $('.btn-li');
var $prev = $("#prev");
var $next = $("#next");

var timer = null;
var $index = 0;
var $liWid = $caroLi.outerWidth();
var $len = $caroLi.length;
console.log($len);
autoPlay();
$next.click(function () {
    $index++;
    if($index == $len){
        $index = 0;
        $caroUl.css({'left':0 + 'px'});
    }
    changeView()
});
$prev.click(function(){
    if($index == 0){
        $index = $len;
        $caroUl.css({"left":-$len*$liWid})
    }
    $index--;
    changeView()
})
$btnLi.click(function(){
    $index = $(this).index();
    changeView();
});
function changeView() {
    $caroUl.stop().animate({"left": -$liWid*$index+"px"});
    $btnLi.eq($index%$len).addClass("btn-style").siblings().removeClass("btn-style");
}
function autoPlay(){
    timer = setInterval(function(){
        $next.click();
    },2000)
}
