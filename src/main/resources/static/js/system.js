function toggleFinished(id) {

	// Setting the csrf token in the header
	var csrf_token = $("meta[name='_csrf']").attr("content");
	var csrf_header = $("meta[name='_csrf_header']").attr("content");

	var headers = {};
	headers[csrf_header] = csrf_token;

	$.ajax({
		type : 'POST',
		url : "/user/toggleFinished",
		data : {
			'id' : id
		},
		headers : headers
	});

	location.reload();
}