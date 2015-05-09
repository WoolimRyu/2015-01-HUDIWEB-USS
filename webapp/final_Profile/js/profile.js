/*! viewportSize | Author: Tyson Matanich, 2013 | License: MIT */
(function(e){e.viewportSize={},e.viewportSize.getHeight=function(){return t("Height")},e.viewportSize.getWidth=function(){return t("Width")};var t=function(t){var r,i=t.toLowerCase(),s=e.document,o=s.documentElement,u,a;return e["inner"+t]===undefined?r=o["client"+t]:e["inner"+t]!=o["client"+t]?(u=s.createElement("body"),u.id="vpw-test-b",u.style.cssText="overflow:scroll",a=s.createElement("div"),a.id="vpw-test-d",a.style.cssText="position:absolute;top:-1000px",a.innerHTML="<style>@media("+i+":"+o["client"+t]+"px){body#vpw-test-b div#vpw-test-d{"+i+":7px!important}}</style>",u.appendChild(a),o.insertBefore(u,s.head),r=a["offset"+t]==7?o["client"+t]:e["inner"+t],o.removeChild(u)):r=e["inner"+t],r}})(this)

jQuery(document).ready(function ($) {
	/*Responsive Font bug fix(also need to add the in css viewport font size ):
	http://css-tricks.com/viewport-sized-typography/
	*/
	causeRepaintsOn = $("h1, h2, h3, p");

	$(window).resize(function () {
		causeRepaintsOn.css("z-index", 1);
	});

	var $wrapper = $("#profileWrapper");
	var $window = $(window);
	var $whitebox = $(".whitebox");

	function $center() {
		var $width = viewportSize.getWidth();
		var $height = viewportSize.getHeight();
		var $pos = '-' + $whitebox.outerHeight() / 2 + 'px';

		$wrapper.css({
			position: 'absolute',
			left: ($width - $wrapper.outerWidth()) / 2,
			top: ($height - $wrapper.outerHeight()) / 2
		});

		$whitebox.css({
			'bottom': $pos
		});
	}
	$center();
	$window.resize(function () {
		$center();
	});
	$window.load(function(){

	});
});