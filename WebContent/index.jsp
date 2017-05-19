<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<ul id="goodsTree">
		
	</ul>
	<script>
		$(function(){
			$('#goodsTree').tree({
				url:'getMenu?pid=-1',
				lines : true,
		        onBeforeExpand:function(row){
					//处理tree的显示
					//动态设置展开查询的url  
				        var url = 'getMenu?pid='+row.id; 
				        $("#goodsTree").tree("options").url = url;  
				        return true; 
				}
			});
		});
	</script>
</body>
</html>