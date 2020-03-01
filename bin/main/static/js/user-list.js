$(document).ready(function() {
				
				var table = $('#dataTable').DataTable({
					"ajax" : {
						"url" : "/ajax/getusersasync",
						"type": "POST",
						"datatype": "json",
						"dataSrc": "",
			        },
			        "columns": [
			            { "data": "name" },
			            { "data": "surname" },
			            { "data": "email" },
			            { "data": "password" },
			            { "data": "number" },
			            {
			                data: null,
			                defaultContent: '<button class="btn btn-danger" >Delete</button>'
			            }
			    	],
			    	"language": {
			            "lengthMenu": "Mostra _MENU_ records per pagina",
			            "zeroRecords": "Nessun elemento",
			            "info": "Mostra pagina _PAGE_ di _PAGES_",
			            "infoEmpty": "Nessun record disponibile",
			            "infoFiltered": "(filtrato da _MAX_ records totali)",
			            "search": "Cerca:",
			            "paginate": {
			                "first":      "Primo",
			                "last":       "Ultimo",
			                "next":       "Precedente",
			                "previous":   "Successivo"
			            }
			        }
				});
				
				
				$("#dataTable").on('click', 'button', function (){
				    //var testo = $("#testo").val();
				    //var $tr = $(this).closest('tr');
				    var data = table.row( $(this).closest('tr') ).data();
				    var psw = data.psw;
				    $.ajax({
				        type: "POST",
				        url: "/delete",
				        data: "psw=" + psw ,
				        dataType: "html",
				      });
				    window.location.reload();
				} );
			
			})