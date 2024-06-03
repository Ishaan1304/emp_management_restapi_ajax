var baseUrl= "";
function setBaseUrl(url){
	//swal(url);
	baseUrl = url;
}

//for Save Employee
function submitForm(){
	this.event.preventDefault();
	
	let employee = {};
	
	employee["name"] = $("#name").val();
	employee["email"] = $("#email").val();
	employee["contact"] = $("#contact").val();
	employee["address"] = $("#address").val();
	employee["department"] = $("#department").val();
	
	submitFormToServer(employee);
	
	
}

function submitFormToServer(employee){
	
	let url = baseUrl + '/api/save-employee';
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: url,
		data: JSON.stringify(employee),
		dataType: "json",
		success: function(result){
			console.log(result);
			swal(`${result.message}`);
			setTimeout(function(){
				window.location.href = '/';
			}, 2000);
			
			
		},
		error:function(e){
			console.log("ERROR: ", e);
			swal(`${e}`);
		}
		
	});
	
}

// end of save Employee



//for Edit Employee
function submitEditForm(){
	this.event.preventDefault();
	
	let employee = {};
	let id = $("#id").val();
	//alert("submitEditForm :"+id);
	employee["id"] = id;
	employee["name"] = $("#name").val();
	employee["email"] = $("#email").val();
	employee["contact"] = $("#contact").val();
	employee["address"] = $("#address").val();
	employee["department"] = $("#department").val();
	
	submitEditFormToServer(employee, id);
	
	
	
	
}

function submitEditFormToServer(employee, id){
	//alert("submitEditFormToServer "+id);
	let url = baseUrl + '/api/update-employee/'+id;
	//alert(url);
	$.ajax({
		type: "PUT",
		contentType: "application/json",
		url: url,
		data: JSON.stringify(employee),
		dataType: "json",
		success: function(result){
			console.log(result);
			swal(`${result.message}`);
			setTimeout(function(){
				window.location.href = '/';
			}, 2000);
			
			if(result.statusCode==500){
				swal(`${result.message}`);
			}
			
			
		},
		error:function(e){
			console.log("ERROR: ", e);
			swal(`${e}`);
		}
		
	});
	
}
// end of Edit Employee


// Delete Employee
function deleteEntry(id) {
let url = baseUrl+"/api/employee-delete/"+id;

//alert("id id is :" +id);
swal({
    title: "Are you sure you want to Delete?",
    text: "You will not be able to recover this data!",
    icon: "warning",
    buttons: [
      'No, cancel it!',
      'Yes, I am sure!'
    ],
    dangerMode: true,
  }).then(function(isConfirm) {
    if (isConfirm) {
      swal({
        title: 'Yes!',
        text: 'Delete Successful!!',
        icon: 'success'
      }).then(function() {
      	 $.ajax({
               type: "DELETE",
               url: url,
               contentType: 'application/json; charset=utf-8',
               dataType: "JSON",
               success: function (response) {
             	  window.location.reload();
               },
               error: function () {
                   Swal.fire('error')
               }
           }); 
        
      });
    } else {
      swal("Cancelled", "Your data is safe :)", "error");
    }
  });
}
// end of Delete Employee

