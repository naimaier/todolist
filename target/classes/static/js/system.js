function toggleFinished(id){
			$.ajax({
				type:'POST',
				url:"toggleFinished",
				data: {'id' : id}
			});
		}