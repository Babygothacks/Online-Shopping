$(function() {
	switch (Menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
	case 'Products':
		$('#productlist').addClass('active');
		break;
	default:
		$('#productlist').addClass('active');
		$('#a_' + Menu).addClass('active');
		break;
	}
});