function get_data() {
	//$('#dataTable').destroy();
	var d = $("#date").val();
	alert(d);
	$('#dataTable')
			.dataTable(
					{
						"ajax" : {
							"url" : "/ajax/getsessionsasyncbydate",
							"type" : "POST",
							"data" : {
								"d" : d
							},
							"datatype" : "json",
							"dataSrc" : "",
						},
						destroy : true,
						"columns" : [
								{
									"data" : "tsEntry",
									render : function(data) {
										return new Date(data)
												.toLocaleDateString("it-IT");
									}
								},
								{
									"data" : "tsEntry",
									render : function(data) {
										if (data == 0)
											return "";
										else
											return new Date(data)
													.toLocaleTimeString("it-IT");
									}
								},
								{
									"data" : "name"
								},
								{
									"data" : "surname"
								},
								{
									"data" : "tsExit",
									render : function(data) {
										if (data == 0)
											return "";
										else
											return new Date(data)
													.toLocaleDateString("it-IT");
									}
								},
								{
									"data" : "tsExit",
									render : function(data) {
										if (data == 0)
											return "";
										else
											return new Date(data)
													.toLocaleTimeString("it-IT");
									}
								},
								{
									"data" : "tsEntry",
									render : function(data) {
										return '<button value='
												+ data
												+ ' class="btn btn-primary" >See photo</button>';
									}
								//defaultContent: '<button class="btn btn-primary" >See photo</button>'
								},
								{
									"data" : "tsEntry",
									render : function(data) {
										return '<a href="images/'
												+ data
												+ '.jpg" data-lightbox='
												+ data
												+ ' data-title="My caption"> <img id='
												+ data
												+ ' width=50 heigth=50> </a>';
									}

								}

						],
						"language" : {
							"lengthMenu" : "Mostra _MENU_ records per pagina",
							"zeroRecords" : "Nessun elemento",
							"info" : "Mostra pagina _PAGE_ di _PAGES_",
							"infoEmpty" : "Nessun record disponibile",
							"infoFiltered" : "(filtrato da _MAX_ records totali)",
							"search" : "Cerca:",
							"paginate" : {
								"first" : "Primo",
								"last" : "Ultimo",
								"next" : "Precedente",
								"previous" : "Successivo"
							}
						}
					});
	return false;
}

$(document).ready(function() {

	$('#dataTable').DataTable({

		"language" : {
			"lengthMenu" : "Mostra _MENU_ records per pagina",
			"zeroRecords" : "Nessun elemento",
			"info" : "Mostra pagina _PAGE_ di _PAGES_",
			"infoEmpty" : "Nessun record disponibile",
			"infoFiltered" : "(filtrato da _MAX_ records totali)",
			"search" : "Cerca:",
			"paginate" : {
				"first" : "Primo",
				"last" : "Ultimo",
				"next" : "Precedente",
				"previous" : "Successivo"
			}
		}

	});
})

$(document).ready(
		function() {
			$("#dataTable").on(
					'click',
					'button',
					function() {
						var id = $(this).val();
						alert(id);
						document.getElementById(id).setAttribute('src',
								'images/' + id + '.jpg');
					});
		})

		