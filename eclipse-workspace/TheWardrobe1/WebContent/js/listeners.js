$(document).ready(function() {

	// when clicked on a product, redirect to product detail page
	$(".item_img").click(function() {
		$("#product_id").val($(this).attr('name')); // get it fixed by tanuj
		$("#getProduct").submit();
	})
	$(".action_img").click(function() {
		$("#action_id").val($(this).attr('name')); // get it fixed by tanuj
		$("#getForm").submit();
	})

	$(".btn_filter").click(function() {
		$("#product_id").val($(this).attr('name')); // get it fixed by tanuj
		$("#getProduct").submit();
	})
	// when remove item from cart is clicked, redirect to product detail page
	$(".remove_item").click(function() {
		$("#item_id").val($(this).attr('name')); // get it fixed by tanuj
		$("#getCart").submit();
	})
	
	

})
