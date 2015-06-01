var links = Array.prototype.slice
		.call(document.querySelectorAll('[data-link]')), sections = Array.prototype.slice
		.call(document.querySelectorAll('[data-section]'));

//var menu = d('.menu').querySelector('ul'), menuBtn = d('.toggle_menu');

window.addEventListener('load', init, false);

function d(el) {
	if (el)
		return document.querySelector(el);
}

function init() {
	// first time active home
	d('[data-section="home"]').classList.add('show-section');
	d('[data-link="home"]').classList.add('active');

	try {
		// loader();
		navigation();
		// lightModal();
		toggleSections();
	} catch (e) {
		alert(e);
	}
}

function toggleSections() {
	Array.prototype.forEach.call(links, function(o, i) {
		o.addEventListener('click', function(e) {
			var section = d('[data-section="' + this.getAttribute('data-link')
					+ '"]');
			e.preventDefault();
			removeLinks(function() {
				o.classList.add('active');
				section.classList.add('show-section');
				menu.classList.toggle('show_menu');
				if (menu.classList.contains('show_menu')) {
					menuBtn.innerHTML = '<i class="fa fa-close"></i>';
				} else {
					menuBtn.innerHTML = '<i class="fa fa-navicon"></i>';
				}
			});
		});
	});
}

function removeLinks(_success) {
	Array.prototype.forEach.call(links, function(o, i) {
		o.classList.remove('active');
	});
	Array.prototype.forEach.call(sections, function(o, i) {
		o.classList.remove('show-section');
	});
	if (_success())
		return _success();
}

function navigation() {
	menuBtn.addEventListener('click', function() {
		menu.classList.toggle('show_menu');
		if (menu.classList.contains('show_menu')) {
			menuBtn.innerHTML = '<i class="fa fa-close"></i>';
		} else {
			menuBtn.innerHTML = '<i class="fa fa-navicon"></i>';
		}
	});
}

function sendTemplateReq() {
	$.ajax({
		url : "/api/card?template=" + $('.active-img').attr('id').substring(1),
		method : "put",
		success : function(response) {

			var reponseType = {
				ERROR : 0,
				ERROR_USER_ALERT : 1,
				SUCCESS : 2,
				SUCCESS_USER_ALERT : 3
			};

			switch (response.code) {
			case reponseType.ERROR:
				return;
			case reponseType.ERROR_USER_ALERT:
				alert(response.message);
				return;
			case reponseType.SUCCESS:
				break;
			case reponseType.SUCCESS_USER_ALERT:
				alert(response.message);
				break;
			}
			location.href = "/myprofile/phase2/";
			return;
		}
	});
}