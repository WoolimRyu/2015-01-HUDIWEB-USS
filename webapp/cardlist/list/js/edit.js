function theFunction($param1, $param2) {
    $param1.toggleClass('hidden');
    setTimeout(function() {
        $param1.css('display','none');
        $param2.css('display','inline-block');
    },100);
    setTimeout(function(){
        $param2.toggleClass('hidden');
    },200);
    setTimeout(function() {
        $param2.focus();
    },250);
};

$('.button-text').click(function() {
    theFunction($(this), $('#project-name'));
});

$('#project-name').focusout(function() {
    theFunction($(this), $('.button-text'));
    setTimeout(function() {
        $('#project-name').val('');
    },100);
});