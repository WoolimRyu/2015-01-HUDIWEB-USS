$(document).ready(function(){

    var i = 1;
    var interval = setInterval( increment, 2000);
    var headertext = "I am"
    
    function increment(){
        i = i + 1;
        if(i>6) {i = 1;}
        
          if(i==1){headertext = "Web / Mobile Business Card"}
          if(i==2){headertext = "이제는 웹으로 명함을 관리하세요!"}
          if(i==3){headertext = "나만의 개성있는 프로필"}
          if(i==4){headertext = "관리가 훨씬 편한 웹/모바일 명함!"}
          if(i==5){headertext = "Create a Profile Right now!"}
          // if(i==6){headertext = "A good relationship!"}
          if(i==6){headertext = "Sign up Now !"}

          $('.tochange').animate({'opacity': 0}, 1000, function () {
              $('.tochange').text(headertext);
          }).animate({'opacity': 1}, 1000);

        }   
});


$(document).ready(function(){
  var mouseX, mouseY;
  var ww = $( window ).width();
  var wh = $( window ).height();
  var traX, traY;
  $(document).mousemove(function(e){
     mouseX = e.pageX;
     mouseY = e.pageY;
    traX = ((4 * mouseX) / 350) + 10;
    traY = ((4 * mouseY) / 350) + 20;
    $(".title ").css({"background-position": traX + "%" + traY + "%"});
    $(".title span").css({"background-position": traY + "%" + traX + "%"});

  });
});