$(document).ready(function() {
	$('.newBtn, .table .editBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		
		if(text == 'Edit') {
			$('.myForm #exampleModalLabel').text("Update");
			$('.myForm #saveBtn').val("Update");
			
			$.get(href, function(country, status) {
				$('.myForm #name').val(country.name);
				$('.myForm #capital').val(country.capital);
			});
		} else {
			$('.myForm #exampleModalLabel').text("Create");
			$('.myForm #saveBtn').val("Save");
			$('.myForm #name').val('');
			$('.myForm #capital').val('');
		}
		
		$('.myForm #exampleModal').modal();
	});
	
	$('.table .deleteBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #deleteRef').attr('href', href);
		$('#deleteModal').modal();
	});
});
