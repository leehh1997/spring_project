var arr = [
			["10%","20%","30%"],
			["30","40","50"]
		];

//숙제 데이터
var basket = [
	{"seq":"1", "product":"냉장고", "price":"195000"},
	{"seq":"2", "product":"세탁기", "price":"287000"},
	{"seq":"10", "product":"에어프라이어", "price":"97000"}
];			
		
$(function(){
	
	//숙제 data
	$("#btn4").click(function(){
		$.ajax({
			url : "./ajaxok4.do",
			type:"post",
			cache:false,
			dataType:"text",
			contentType:"application/json",
			data : JSON.stringify(basket),
			success:function($result){
				console.log($result);
			},
			error:function(){
				console.log("error");
			}
		});
	});
	
	//Front 배열값 응용편
	$("#btn3").click(function(){
		$.ajax({
			url : "./ajaxok3.do",
			type:"post",
			cache:false,
			dataType:"text",
			contentType:"application/json",
			data : JSON.stringify(arr),
			success:function($result){
				console.log($result);
			},
			error:function(){
				console.log("error");
			}
		});
	});
	
	$("#btn2").click(function(){
		var $data = new Array();
		$data[0] = "홍길동";
		$data[1] = "강감찬";
		$data[2] = "이순신";
		
		//JSON.stringfy : Object 형태로 전달
		$.ajax({
			url : "./ajaxok2.do",
			type:"post",
			cache:false,
			dataType:"json",
			contentType:"application/json",
			data:JSON.stringify({
				"all_data":$data
			}),
			success:function($result){
				console.log($result);
			},
			error:function(){
				console.log("error");
			}
						
		});
		
	});
	
	$("#btn").click(function(){
		var $data = new Array();
		$data[0] = "20";
		$data[1] = "30";
		$data[2] = "40";
		//join -> JSON.stringfy 형태로 변화
		//console.log($data.join(","));
		
		$.ajax({
			url:"./ajaxok.do",
			cache:false,
			dataType:"json",
			contentType:"application/json",
			type:"get",
			data:{
				"all_data":$data.join(",")
			},
			success:function($result){
				console.log($result);
			},
			error:function(){
				console.log("error");				
			}
										
		});
	});
	
});