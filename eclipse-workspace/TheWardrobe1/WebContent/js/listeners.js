
$(document).ready(function()
		{
			$(".item_img").click(function()
			{	    
			    $("#product_id").val($(this).attr('name')); //get it fixed by tanuj
			    $("#getProduct").submit();
			})
			$(".action_img").click(function()
			{	    
			    $("#action_id").val($(this).attr('name')); //get it fixed by tanuj
			    $("#getForm").submit();
			})
			
			$(".btn_filter").click(function()
			{	    
			    $("#product_id").val($(this).attr('name')); //get it fixed by tanuj
			    $("#getProduct").submit();
			})
		
			$(".addtoCart").click(function(){
				
				$("#productId").val($(this).attr('name'));	
				alert($("#productId").val($(this).attr('name'))	);
				$("#getCart").submit();
			})
		})

