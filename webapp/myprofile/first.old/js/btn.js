$('.ripple').on('mousedown', function(event) {
    event.preventDefault();

    $(this).append('<div class="rippleEffect"/>');

    var $rippleEffect = $('.rippleEffect');

    var btnOffset = $(this).offset();
    var top = event.pageY - btnOffset.top;
    var left = event.pageX - btnOffset.left;

    $rippleEffect.css({
        'top': top - 19,
        'left': left - 19
    });

    $(this).addClass('pressed');
});

$('.ripple').on('mouseup, mouseout', function() {
    var $rippleEffect = $('.rippleEffect');
    $rippleEffect.css({
        'opacity' : 0,
        'transition' : 'opacity 1s linear'
    });
    setTimeout(function(){
        $rippleEffect.remove();
        $('.ripple').removeClass('pressed');
    }, 600);
});