var content = $('main');
$('button').click(function() {
    ($('i').hasClass('fa-bars')) ? $('i').removeClass('fa-bars').addClass('fa-times') : $('i').removeClass('fa-times').addClass('fa-bars');
    $('abc').toggleClass('cc-visible');
    content.toggleClass('active');
});