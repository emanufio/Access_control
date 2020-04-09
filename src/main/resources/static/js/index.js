$(document).ready(function() {
				
				var table = $('#dataTable').DataTable({
					"ajax" : {
						"url" : "ajax/getsessionsasync",
						"type": "POST",
						"datatype": "json",
						"dataSrc": "",
			        },
			        "columns": [
			            { "data": "tsEntry",
			               render:function(data){
			            	   return new Date(data).toLocaleDateString("it-IT");
			               } 	
			            },
			            { "data": "tsEntry",
				               render:function(data){
				            	   if(data==0)
				            		   return "";
				            	    else
				            		   return new Date(data).toLocaleTimeString("it-IT");
				               } 	
				            },
			            { "data": "name" },
			            { "data": "surname" },
			            { "data": "tsExit",
			              render:function(data){
			            	  if(data==0)
			            		   return "";
			            	  else
			            	   	   return new Date(data).toLocaleDateString("it-IT");
			               } 
			            },
			            { "data": "tsExit",
			              render:function(data){
			            	  if(data==0)
			            		   return "";
			            	  else
			            	   	   return new Date(data).toLocaleTimeString("it-IT");
			               }
			            },
			            {  "data": "tsEntry",
			                render:function(data){
			                	return '<a href="images/'+data+'.jpg" data-lightbox=' + data + ' data-title="My caption"> <img id='+data+' src=images/' + data + '.jpg width=50 heigth=50> </a>';
				               }
			            	
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
				
				/*
				$("#dataTable").on('click', 'button', function (){
				    var id = $(this).val();
				    alert(id);
					/*
					$.ajax({
			            url: "images/"+id+".jpg",
			            type: "POST",
			            success: function(data){
			            	alert(data);
			               	encoded=data;
			               	//$("#image").attr('src', 'data:image/jpeg;base64,' + atob(encoded));
			               	
			               	document.getElementById('img')
			                .setAttribute(
			                    'src', 'data:image/jpeg;base64,'+data
			                );
			               	document.getElementById("img").style.display = "block";
			            }
			        });
					
					document.getElementById(id)
	                .setAttribute(
	                    'src', 'images/'+id+'.jpg'
	                );
				
				} );

			*/
})
