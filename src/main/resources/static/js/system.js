function toggleFinished(id){
			$.ajax({
				type:'POST',
				url:"/user/toggleFinished",
				data: {'id' : id}
			});
		}