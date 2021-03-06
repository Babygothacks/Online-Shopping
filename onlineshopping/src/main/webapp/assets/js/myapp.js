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

	var jsonURL = '';
	if (window.categoryId == '') {
		jsonURL = window.contextRoot + '/json/data/all/products';
	} else {
		jsonURL = window.contextRoot + '/json/data/category/'
				+ window.categoryId + '/products';
	}

	var $table = $('#tblProductList');

	if ($table.length) {
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ "3 Records", "5 Records", "10 Records", "All" ] ],
			pageLength : 10,
			ajax : {
				url : jsonURL,
				dataSrc : ''
			},
			columns: [	
				{data: "code",
					bSortable:false, 
					mRender: function(data, type, row){
						return '<image class="dataTableImg" src="' + window.contextRoot + '/resources/images/' + data + '.jpg" alt ="image is missing"/>';
					}},
				{data : "name"},
				{data : "brand"},
				{data : "unitPrice",
					mRender : function(data, type, row){
						//return '&#8377; '+data;
						return '&#x20b9; ' +data;
					}},
				{data : "quantity",
						mRender : function(data, type,row){
							if(data < 1){
								return '<span style="color:red">Out of Stock!</span>';
							}
							return data;
						}},
				{data : "id",
					bSortable:false, 
				mRender: function(data, type, row){
					console.log(row['quantity']);
					var str = "";
					str += '<a class="btn btn-primary"  href="' + window.contextRoot + '/show/'+data+'/product"><span class="glyphicon glyphicon-eye-open"></span></a> ';
					if(row['quantity'] == 0 || row['quantity'] == '0'){
						str+= '<a class="btn btn-success disabled"  href="' + window.contextRoot + '/cart/add/'+data+'/product"><span class="glyphicon glyphicon-shopping-cart"></span></a>';	
					}
					else{
						str+= '<a class="btn btn-success"  href="' + window.contextRoot + '/cart/add/'+data+'/product"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					}		
					return str;
				}	
				},
				
			]
		});
	}
});