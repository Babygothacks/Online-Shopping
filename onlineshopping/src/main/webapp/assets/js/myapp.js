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
		if (Menu == "Home")
			break;
		$('#productlist').addClass('active');
		$('#a_' + Menu).addClass('active');
		break;
	}

	// Code for jquery dataTable

	var productList = [ [ "1", "ASD" ], [ "2", "CFG" ], [ "3", "CVB" ],
			[ "4", "LOF" ], [ "5", "PRU" ], [ "6", "JUD" ]

	];

	var $table = $('#tblProductList');

	if ($table.length) {
		$table.DataTable({
			lengthMenu: [[3,5,10,-1],["3 Records","5 Records","10 Records","All"]],
			pageLength: 10,
			data: productList
		});
	}

});