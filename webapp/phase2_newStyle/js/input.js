$(document).ready(function() {
  $('.input--name .input__field').keyup(function() {
    if ($(this).val()) {
      $('.input--name').addClass('input--filled');
    } else {
      $('.input--name').removeClass('input--filled');
    }
  });
  $('.input--location .input__field').keyup(function() {
    if ($(this).val()) {
      $('.input--location').addClass('input--filled');
    } else {
      $('.input--location').removeClass('input--filled');
    }
  });
  $('.input--phone .input__field').keyup(function() {
    if ($(this).val()) {
      $('.input--phone').addClass('input--filled');
    } else {
      $('.input--phone').removeClass('input--filled');
    }
  });
  $('.input--email .input__field').keyup(function() {
    if ($(this).val()) {
      $('.input--email').addClass('input--filled');
    } else {
      $('.input--email').removeClass('input--filled');
    }
  });
  $('.input--address .input__field').keyup(function() {
    if ($(this).val()) {
      $('.input--address').addClass('input--filled');
    } else {
      $('.input--address').removeClass('input--filled');
    }
  });
});